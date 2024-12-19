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
package org.osgi.service.webservice.whiteboard.propertytypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.osgi.service.component.annotations.ComponentPropertyType;
import org.osgi.service.webservice.whiteboard.WebserviceWhiteboardConstants;
import org.osgi.service.webservice.whiteboard.annotations.RequireWebserviceWhiteboard;

/**
 * Annotation that can be used to mark a service component as an object that
 * should be considered by the SOAP Whiteboard Extender using http on the
 * transport level.
 */
@ComponentPropertyType
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@RequireWebserviceWhiteboard
public @interface HttpWhiteboardEndpoint {

    /**
     * prefix used for component properties
     */
    String PREFIX_ = WebserviceWhiteboardConstants.WEBSERVICE_HTTP_ENDPOINT_PREFIX;

    /**
     * @return the http contextpath under that the endpoint should be registered
     *         where / represents the context root
     */
    String contextpath();

}
