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
package org.osgi.service.webservice.runtime.dto;

import org.osgi.framework.dto.ServiceReferenceDTO;

/**
 * The EndpointDTO describes the current state of an endoint implementor known
 * to the service runtime
 */
public class FailedEndpointDTO extends FailedDTO {

    /**
     * Transforming the endpoint implementor into a JAX-WS endpoint failed
     **/
    public static final int FAILURE_REASON_CREATE_FAILED = 200;

    /**
     * There are matching handlers for this endpoint but setting a handler chain is
     * not supported. This may be done to avoid any overriding of a pre-configured
     * handler chain.
     **/
    public static final int FAILURE_REASON_SET_HANDLER_NOT_SUPPORTED = 201;

    /**
     * There are matching handlers for this endpoint but an error in the
     * configuration of the handler chain occurred
     **/
    public static final int FAILURE_REASON_SET_HANDLER_FAILED = 202;

    /**
     * publishing then endpoint to the transport failed
     **/
    public static final int FAILURE_REASON_PUBLISH_FAILED = 203;

    /**
     * The DTO for the corresponding implementor that created this endpoint. This
     * value is never {@code null}.
     */
    public ServiceReferenceDTO implementor;
}
