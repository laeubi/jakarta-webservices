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

import org.osgi.dto.DTO;
import org.osgi.framework.dto.ServiceReferenceDTO;

/**
 * Represents the state of a Jakarta Webservice Runtime.
 *
 * @author $Id$
 */
public class RuntimeDTO extends DTO {

    /**
     * Returns the current service reference under that the runtime is registered
     */
    public ServiceReferenceDTO serviceReference;

    /**
     * Returns the representations of the Web Services endpoints currently
     * registered, The returned array may be empty.
     */
    public EndpointDTO[] endpoints;

    /**
     * Returns the representations of the Web Services endpoints currently known but
     * failed to register, The returned array may be empty.
     */
    public FailedEndpointDTO[] failedEndpoints;

    /**
     * Returns all handlers that are known and bound to an endpoint, the returned
     * array may be empty.
     */
    public HandlerDTO[] handlers;

    /**
     * Returns all handlers that are known but not currently bound to an endpoint,
     * the returned array may be empty.
     */
    public FailedHandlerDTO[] failedHandlers;

}
