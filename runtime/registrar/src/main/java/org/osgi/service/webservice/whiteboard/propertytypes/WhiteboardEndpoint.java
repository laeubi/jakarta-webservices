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
 * should be considered by the SOPA Whiteboard Extender specifying a default
 * address
 */
@ComponentPropertyType
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
@RequireWebserviceWhiteboard
public @interface WhiteboardEndpoint {

    /**
     * prefix used for component properties
     */
    String PREFIX_ = WebserviceWhiteboardConstants.WEBSERVICE_ENDPOINT_PREFIX;

    /**
     * @return <code>true</code> if this is an implementor for the soap whiteboard,
     *         <code>false</code> otherwise, can be used to switch an implementation
     *         on/off
     */
    boolean implementor() default true;

    /**
     * A URI specifying the address and transport/protocol to use, this will be
     * passed to the {@link jakarta.xml.ws.Endpoint#publish(String)}, if the address
     * is empty, it is assumed that there is some other way of specify the address
     * for example using {@link HttpWhiteboardEndpoint} annotation
     *
     * @return the address under which this endpoint should be registered
     */
    String address() default "";

}
