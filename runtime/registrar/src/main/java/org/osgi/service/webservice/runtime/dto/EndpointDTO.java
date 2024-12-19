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
 * The EndpointDTO describes the current state of an endoint implementor known
 * to the service runtime
 */
public class EndpointDTO extends DTO {
    /**
     * The DTO for the corresponding implementor that created this endpoint. This
     * value is never {@code null}.
     */
    public ServiceReferenceDTO implementor;

    /**
     * The full resolved address this endpoint is published to This value is never
     * {@code null}.
     */
    public String address;

    /**
     * Returns all handlers that are bound to this endpoint, the returned array may
     * be empty.
     */
    public HandlerDTO[] handlers;
}
