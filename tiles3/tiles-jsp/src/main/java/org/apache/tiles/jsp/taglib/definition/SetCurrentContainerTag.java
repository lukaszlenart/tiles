/*
 * $Id$
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.tiles.jsp.taglib.definition;

import org.apache.tiles.jsp.taglib.BodylessTag;
import org.apache.tiles.request.Request;
import org.apache.tiles.template.SetCurrentContainerModel;

/**
 * Sets the current container, to be used by Tiles tags.
 *
 * @version $Rev$ $Date$
 * @since 2.1.0
 */
public class SetCurrentContainerTag extends BodylessTag {

    private SetCurrentContainerModel model = new SetCurrentContainerModel();

    /**
     * The key under which the container is stored.
     */
    private String containerKey;

    /**
     * Returns the key under which the container is stored.
     *
     * @return the containerKey The container key.
     * @since 2.1.0
     */
    public String getContainerKey() {
        return containerKey;
    }

    /**
     * Sets the key under which the container is stored.
     *
     * @param containerKey the containerKey The container key.
     * @since 2.1.0
     */
    public void setContainerKey(String containerKey) {
        this.containerKey = containerKey;
    }

    /** {@inheritDoc} */
    @Override
    public void execute(Request request) {
        model.execute(containerKey, request);
    }
}
