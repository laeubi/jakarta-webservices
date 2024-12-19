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

package org.osgi.service.webservice.runtime;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.webservice.runtime.dto.RuntimeDTO;

/**
 * The JakartarsServiceRuntime service represents the runtime information of a
 * Jakarta RESTful Web Services Whiteboard implementation, it provides access to
 * DTOs representing the current state of the service.
 *
 * @author $Id$
 */
@ProviderType
public interface WebserviceServiceRuntime {

    /**
     * Return the runtime DTO representing the current state.
     *
     * @return The runtime DTO.
     */
    public RuntimeDTO getRuntimeDTO();
}
