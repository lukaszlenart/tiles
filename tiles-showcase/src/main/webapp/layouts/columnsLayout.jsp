<%--
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
 *
 */
--%>
<%@ page import="org.apache.struts.tiles.ComponentContext"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%-- Multi-columns Layout
  This layout render lists of tiles in multi-columns. Each column renders its tiles
  vertically stacked. 
  The number of columns passed in parameter must correspond to the number of list passed.
  Each list contains tiles. List are named list0, list1, list2, ...
  parameters : numCols, list0, list1, list2, list3, ... 
  @param numCols Number of columns to render and passed as parameter
  @param list1 First list of tiles (url or definition name)
  @param list2 Second list of tiles (url or definition name) [optional]
  @param list3 Third list of tiles (url or definition name) [optional]
  @param listn Niene list of tiles (url or definition name), where n is replaced by column index.
--%>


<tiles:useAttribute id="numColsStr" name="numCols" classname="java.lang.String" />

<table>
<tr>
<%
int numCols = Integer.parseInt(numColsStr);
ComponentContext context = ComponentContext.getContext( request );
for( int i=0; i<numCols; i++ )
  {
  java.util.List list=(java.util.List)context.getAttribute( "list" + i );
  pageContext.setAttribute("list", list );
  if(list==null)
    System.out.println( "list is null for " + i  );
%>
<td valign="top">
  <tiles:insertTemplate template="/layouts/vboxLayout.jsp" flush="true" >
    <tiles:put name="list" value="${pageContext.list}" />
  </tiles:insertTemplate>
</td>
<%
  } // end loop
%>
</tr>
</table>






