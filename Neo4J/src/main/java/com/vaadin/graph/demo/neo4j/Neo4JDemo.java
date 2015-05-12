/*
 * Copyright 2011 Vaadin Ltd.
 *
 * Licensed under the GNU Affero General Public License, Version 3.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.gnu.org/licenses/agpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.graph.demo.neo4j;

import javax.servlet.ServletContext;

import org.neo4j.kernel.EmbeddedGraphDatabase;

import com.vaadin.annotations.Theme;
import com.vaadin.graph.GraphExplorer;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.UI;

@Theme("neo4j")
public class Neo4JDemo extends UI {
    private static final long serialVersionUID = 1L;

    public static final String GRAPHDB = "graphdb";

    @Override
    public void init(VaadinRequest request) {
        ServletContext servletContext = ((VaadinServletRequest)request).getHttpServletRequest().getSession().getServletContext();
        EmbeddedGraphDatabase graphdb = (EmbeddedGraphDatabase) servletContext.getAttribute(GRAPHDB);

        CssLayout layout = new CssLayout();
        layout.setStyleName("neo4j-root");
        Neo4JRepository repo = new Neo4JRepository(graphdb);
        GraphExplorer<Neo4JNode, Neo4JArc> graph = new GraphExplorer<Neo4JNode, Neo4JArc>(repo);
        graph.setSizeFull();
        layout.addComponent(graph);
        layout.setSizeFull();
        setContent(layout);
        Page.getCurrent().setTitle("Graph Explorer demo");
    }
}
