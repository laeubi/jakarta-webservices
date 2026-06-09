/*******************************************************************************
 * Copyright (c) 2026 Contributors to the Eclipse Foundation
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
package org.eclipse.osgi.technology.webservices.weaving;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.framework.hooks.weaving.WeavingHook;

/**
 * Registers the {@link WebserviceWeavingHook} as an OSGi {@link WeavingHook}
 * service so that bundles requiring the webservice whiteboard implementation
 * automatically receive the dynamic imports they need.
 */
public class WebserviceWeavingActivator implements BundleActivator {

    private ServiceRegistration<WeavingHook> hookRegistration;

    @Override
    public void start(BundleContext context) throws Exception {
        hookRegistration = context.registerService(WeavingHook.class, new WebserviceWeavingHook(), null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        if (hookRegistration != null) {
            hookRegistration.unregister();
            hookRegistration = null;
        }
    }
}
