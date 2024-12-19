/*******************************************************************************
 * Copyright (c) 2024 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Christoph Läubrich - initial API and implementation
 *******************************************************************************/
/**
 * Jakarta Web Services Runtime DTO Package Version 1.0.
 * <p>
 * Bundles wishing to use this package must list the package in the
 * Import-Package header of the bundle's manifest. This package has two types of
 * users: the consumers that use the API in this package and the providers that
 * implement the API in this package.
 * <p>
 * Example import for consumers using the API in this package:
 * <p>
 * {@code  Import-Package: org.osgi.service.webservice.runtime.dto; version="[1.0,2.0)"}
 * <p>
 * Example import for providers implementing the API in this package:
 * <p>
 * {@code  Import-Package: org.osgi.service.webservice.runtime.dto; version="[1.0,1.1)"}
 *
 * @author $Id$
 */

@Version(WEBSERVICE_SPECIFICATION_VERSION + ".1")
@org.osgi.annotation.bundle.Export(substitution = org.osgi.annotation.bundle.Export.Substitution.PROVIDER)
package org.osgi.service.webservice.runtime.dto;

import static org.osgi.service.webservice.whiteboard.WebserviceWhiteboardConstants.WEBSERVICE_SPECIFICATION_VERSION;

import org.osgi.annotation.versioning.Version;
