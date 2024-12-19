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
 * Jakarta Web Services Whiteboard Package Version 1.0.
 * <p>
 * This package contains annotations that can be used to require the Jakarta
 * RESTful Web Services Whiteboard implementation.
 * <p>
 * Bundles should not normally need to import this package as the annotations
 * are only used at build-time.
 *
 * @author $Id$
 */

@Version(WEBSERVICE_SPECIFICATION_VERSION)
@org.osgi.annotation.bundle.Export(substitution = org.osgi.annotation.bundle.Export.Substitution.PROVIDER)
package org.osgi.service.webservice.whiteboard.propertytypes;

import static org.osgi.service.webservice.whiteboard.WebserviceWhiteboardConstants.WEBSERVICE_SPECIFICATION_VERSION;

import org.osgi.annotation.versioning.Version;
