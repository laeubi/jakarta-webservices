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
import org.osgi.service.webservice.whiteboard.WebserviceWhiteboardConstants;

/**
 * Represents a handler currently known to the webservice runtime but can't be
 * used to a failure
 */
public class FailedHandlerDTO extends FailedDTO {

    /**
     * No matching endpoint.
     **/
    public static final int FAILURE_REASON_NO_MATCHING_ENDPOINT = 100;

    /**
     * The registered service specifies an invalid filter
     * {@value WebserviceWhiteboardConstants#WEBSERVICE_HANDLER_FILTER} property,
     * this includes:
     * <ul>
     * <li>The property is not of type String</li>
     * <li>The property can not be parsed as a valid OSGi Filter</li>
     * </ul>
     */
    public static final int FAILURE_REASON_INVALID_FILTER = 101;

    /**
     * The service reference of the handler, is never {@code null}.
     */
    public ServiceReferenceDTO serviceReference;

}
