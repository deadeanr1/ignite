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

package org.gridgain.grid.kernal.processors.hadoop.v1;

import org.apache.hadoop.conf.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.util.*;
import org.gridgain.grid.hadoop.*;

/**
 * Hadoop partitioner adapter for v1 API.
 */
public class GridHadoopV1Partitioner implements GridHadoopPartitioner {
    /** Partitioner instance. */
    private Partitioner<Object, Object> part;

    /**
     * @param cls Hadoop partitioner class.
     * @param conf Job configuration.
     */
    public GridHadoopV1Partitioner(Class<? extends Partitioner> cls, Configuration conf) {
        part = (Partitioner<Object, Object>) ReflectionUtils.newInstance(cls, conf);
    }

    /** {@inheritDoc} */
    @Override public int partition(Object key, Object val, int parts) {
        return part.getPartition(key, val, parts);
    }
}
