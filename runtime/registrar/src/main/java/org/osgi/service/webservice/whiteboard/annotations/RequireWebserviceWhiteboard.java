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
package org.osgi.service.webservice.whiteboard.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.osgi.annotation.bundle.Requirement;
import org.osgi.namespace.implementation.ImplementationNamespace;
import org.osgi.service.webservice.whiteboard.WebserviceWhiteboardConstants;

/**
 * Annotation that can be added to a type or package to indicate it requires the
 * soap whiteboard extender
 */
@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.TYPE, ElementType.PACKAGE })
@Requirement(namespace = ImplementationNamespace.IMPLEMENTATION_NAMESPACE, //
        name = WebserviceWhiteboardConstants.WEBSERVICE, //
        version = WebserviceWhiteboardConstants.WEBSERVICE_SPECIFICATION_VERSION)
public @interface RequireWebserviceWhiteboard {
    // This is a marker annotation.
}
