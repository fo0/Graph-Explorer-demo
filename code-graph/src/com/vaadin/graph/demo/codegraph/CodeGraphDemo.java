package com.vaadin.graph.demo.codegraph;

import javax.servlet.ServletContext;

import com.vaadin.annotations.Theme;
import com.vaadin.graph.DefaultGraphLoader;
import com.vaadin.graph.GraphExplorer;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServletRequest;
import com.vaadin.ui.UI;

@Theme("codeGraph")
public class CodeGraphDemo extends UI {
    private static final long serialVersionUID = 1L;
    public static final String CODE_GRAPH_DATA = "code-graph-data";

    @Override
    public void init(VaadinRequest request) {
        ServletContext servletContext = ((VaadinServletRequest)request).getHttpServletRequest().getSession().getServletContext();
        servletContext.getAttribute(CODE_GRAPH_DATA);

        GraphExplorer graph = new GraphExplorer(new DefaultGraphLoader(new CodeGraphProvider()));
        setContent(graph);
        Page.getCurrent().setTitle("Graph Explorer demo");        
    }
}
