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
package org.apache.tiles.request.freemarker.render;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.apache.tiles.request.ApplicationContext;
import org.apache.tiles.request.collection.IteratorEnumeration;

/**
 * Implements {@link ServletConfig} to initialize the internal servlet using parameters
 * set through {@link FreemarkerRenderer#setParameter(String, String)}.
 *
 * @version $Rev$ $Date$
 * @since 2.2.0
 */
public class InitParamsServletConfig implements ServletConfig {

    /**
     * The initialization parameters.
     */
    private Map<String, String> params = new HashMap<String, String>();

    /**
     * The application context.
     *
     * @since 3.0.0
     */
    private ApplicationContext applicationContext;

    /**
     * Constructor.
     *
     * @param params Configuration parameters.
     * @param applicationContext The application context.
     */
    public InitParamsServletConfig(Map<String, String> params, ApplicationContext applicationContext) {
        this.params = params;
        this.applicationContext = applicationContext;
    }

    /** {@inheritDoc} */
    public String getInitParameter(String name) {
        return params.get(name);
    }

    /** {@inheritDoc} */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Enumeration getInitParameterNames() {
        return new IteratorEnumeration(params.keySet().iterator());
    }

    /** {@inheritDoc} */
    public ServletContext getServletContext() {
        return org.apache.tiles.request.servlet.ServletUtil.getServletContext(applicationContext);
    }

    /** {@inheritDoc} */
    public String getServletName() {
        return "FreeMarker Attribute Renderer";
    }
}
