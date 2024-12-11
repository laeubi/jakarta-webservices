/*******************************************************************************
 * Copyright (c) 2024 Contributors to the Eclipse Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 *******************************************************************************/
package org.eclipse.osgi.technology.webservices.registrar;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.osgi.framework.Bundle;

import jakarta.xml.ws.Endpoint;
import jakarta.xml.ws.EndpointContext;

class BundleEndpointContext extends EndpointContext {

	private Set<Endpoint> endpoints = ConcurrentHashMap.newKeySet();
	private Set<Endpoint> endpointsView = Collections.unmodifiableSet(endpoints);
	private Bundle bundle;

	BundleEndpointContext(Bundle bundle) {
		this.bundle = bundle;
	}

	@Override
	public Set<Endpoint> getEndpoints() {
		return endpointsView;
	}

	@Override
	public String toString() {
		Set<Endpoint> ep = getEndpoints();
		return "Endpoints for bundle " + bundle.getSymbolicName() + " " + bundle.getVersion() + ": "
				+ ep.stream().map(Endpoint::getImplementor).map(String::valueOf).collect(
						Collectors.joining(System.lineSeparator(), System.lineSeparator(), "Total: " + ep.size()));
	}

	void addEndpoint(Endpoint endpoint) {
		endpoints.add(endpoint);
	}

	void removeEndpoint(Endpoint endpoint) {
		endpoints.remove(endpoint);
	}

}
