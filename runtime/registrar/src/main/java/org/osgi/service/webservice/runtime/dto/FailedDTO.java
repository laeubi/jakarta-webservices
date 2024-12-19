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

/**
 * Base class representing a failure with a code and optional message
 */
public class FailedDTO extends DTO {

    /**
     * Failure reason is unknown.
     */
    public static final int FAILURE_REASON_UNKNOWN = 0;

    /**
     * The service is registered in the service registry but getting the service
     * fails as it returns {@code null}.
     */
    public static final int FAILURE_REASON_SERVICE_NOT_GETTABLE = 1;

    /**
     * Contains a code to indicate why the handler failed
     */
    public int failureCode;

    /**
     * Contains a message that describes the failure further, might be
     * <code>null</code> in case there is no such message available
     */
    public String failureMessage;
}
