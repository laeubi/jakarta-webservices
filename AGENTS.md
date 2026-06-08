# Jakarta Web Services Whiteboard — Copilot Instructions

## Build, Test, and Lint

```bash
# Full build + integration tests
mvn verify

# Apply formatting before committing (required for PRs)
mvn editorconfig:format

# Check for Javadoc errors
mvn package -Pjavadoc-check
```

Integration tests run inside an OSGi container via `bnd-testing-maven-plugin`.
To run a single test class, set `tester.names` in the relevant `.bndrun` file (`tests/test.bndrun` or `tests/whiteboard.bndrun`), then run `mvn verify -pl tests`.

## Architecture

This is an **OSGi Whiteboard** implementation for JAX-WS SOAP endpoints.
The codebase has two runtime bundles and one integration test module.

### `runtime/registrar`

The core whiteboard engine (`EndpointRegistrar`).
It tracks three kinds of OSGi services:

- **Endpoint implementors** — services with `osgi.service.webservice.endpoint.implementor=true`
- **Handler extensions** — `jakarta.xml.ws.handler.Handler` services with `osgi.service.webservice.handler.extension=true`
- **EndpointPublisher** — SPI services that know how to publish a `jakarta.xml.ws.Endpoint`

When an implementor is registered, `EndpointInfo` creates the JAX-WS `Endpoint`, builds the handler chain (filtered by LDAP filter in `osgi.service.webservice.handler.filter`), selects the highest-ranked `EndpointPublisher`, and calls `publishEndpoint`.
The registrar also registers itself as `WebserviceServiceRuntime` for DTO-based introspection.

### `runtime/httpwhiteboard`

A higher-ranked `EndpointPublisher` that publishes endpoints as Jakarta Servlets through the OSGi HTTP Whiteboard.
It activates only when the endpoint's properties contain `osgi.service.webservice.endpoint.http.contextPath`.
It creates a `WhiteboardHttpContext` (adapts `com.sun.net.httpserver.HttpExchange` to the Servlet API) and registers it with the OSGi HTTP service.

### `tests`

OSGi integration tests using `osgi.test.junit5`.
Two `.bndrun` files select which test class to run:
- `test.bndrun` → `JakartaWebserviceWhiteboardTestCase` (generic publisher path)
- `whiteboard.bndrun` → `RegisterWithServletWhiteboardTestCase` (HTTP Whiteboard path)

`TestBase` provides shared helpers (`registerEchoEndpoint`, `waitForDTO`, `assertEndpointEcho`).

## Key Conventions

### Package structure

There are two distinct namespaces:
- `org.eclipse.osgi.technology.webservices.*` — implementation (private / internal)
- `org.osgi.service.webservice.*` — spec API (`whiteboard`, `runtime`, `runtime.dto`)

Implementation packages are **not exported**; only spec-API packages are.

### OSGi Declarative Services

All components use DS annotations (`@Component`, `@Reference`, `@Activate`).
Constructor injection is preferred — `@Activate` constructor receives `BundleContext` and `Logger`.

### Publisher selection

`EndpointInfo.publishEndpoint` iterates publishers sorted by `SERVICE_RANKING` ascending, calling `publishEndpoint` on each until one returns a non-null `PublishedEndpoint`.
A publisher that does not handle the endpoint returns `null`; one that fails throws a `RuntimeException` (recorded as `FAILURE_REASON_PUBLISH_FAILED`).

### Test class naming

The bnd test framework discovers test classes via:

```properties
Test-Cases: ${classes;CONCRETE;PUBLIC;NAMED;*TestCase*}
```

All test classes must match the `*TestCase` naming pattern.

### Service properties for endpoints and handlers

Use `WebserviceWhiteboardConstants` for all property name constants (never hard-code strings).
The `osgi.service.webservice.handler.extension` and `osgi.service.webservice.endpoint.implementor` properties accept both `Boolean.TRUE` and the string `"true"`.

### License headers

All Java source files require an EPL-2.0 header (enforced by CI).
Files under `httpwhiteboard/src/main/java/.../wsri/` are exempt (see `.licenserc.yaml`).
