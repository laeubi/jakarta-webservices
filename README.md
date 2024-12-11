# jakarta-webservices
Repository for the jakarta-webservices osgi implementation

## How to build   

Currently the OSGi specification is not officially release. Because of this you need to perform the following steps to build this project:

1. fetch github PR https://github.com/osgi/osgi/pull/659
2. run `./gradlew :build :publish`

This will publish the required artifacts into your local maven repository.

After that you can run the build with `mvn verify`
