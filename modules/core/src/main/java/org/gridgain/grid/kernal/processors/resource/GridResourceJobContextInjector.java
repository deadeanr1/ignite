/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gridgain.grid.kernal.processors.resource;

import org.apache.ignite.*;
import org.apache.ignite.compute.*;
import org.gridgain.grid.kernal.managers.deployment.*;

/**
 * Simple injector which wraps GridComputeJobContext resource object.
 */
public class GridResourceJobContextInjector extends GridResourceBasicInjector<ComputeJobContext> {
    /**
     * Creates GridComputeJobContext injector.
     *
     * @param rsrc GridComputeJobContext resource to inject.
     */
    GridResourceJobContextInjector(ComputeJobContext rsrc) {
        super(rsrc);
    }

    /** {@inheritDoc} */
    @Override public void inject(GridResourceField field, Object target, Class<?> depCls, GridDeployment dep)
        throws IgniteCheckedException {
        assert target != null;

        if (!(target instanceof ComputeTask))
            super.inject(field, target, depCls, dep);
    }

    /** {@inheritDoc} */
    @Override public void inject(GridResourceMethod mtd, Object target, Class<?> depCls, GridDeployment dep)
        throws IgniteCheckedException {
        assert target != null;

        if (!(target instanceof ComputeTask))
            super.inject(mtd, target, depCls, dep);
    }
}
