package com.vaadin.graph.demo.codegraph;

import com.vaadin.annotations.Theme;
import com.vaadin.graph.GraphExplorer;
import com.vaadin.graph.GraphRepository;
import com.vaadin.server.Page;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("codeGraph")
public class CodeGraphDemo extends UI {
    private static final long serialVersionUID = 1L;

    @Override
    public void init(VaadinRequest request) {
        GraphExplorer graph = new GraphExplorer(createGraph());
        setContent(graph);
        Page.getCurrent().setTitle("Graph Explorer demo");        
    }
    
    private GraphRepository createGraph() {
    	GraphRepositoryImpl repo = new GraphRepositoryImpl();
    	repo.addNode("node1", "Node 1").setStyle("root");;
    	repo.setHomeNodeId("node1");
    	
    	repo.addNode("node2", "Node 2").setStyle("blue");
    	repo.addNode("node3", "Node 3");
    	repo.addNode("node4", "Node 4").setIcon(new ThemeResource("icons/48x48/cat_1.png"));

    	repo.joinNodes("node1", "node2", "edge12", "Edge 1-2").setStyle("thick-blue");
    	repo.joinNodes("node1", "node3", "edge13", "Edge 1-3").setStyle("thin-red");
    	repo.joinNodes("node2", "node4", "edge24", "Edge 2-4");
    	repo.joinNodes("node3", "node4", "edge34", "Edge 3-4");

    	repo.addNode("node10", "Node 10");
    	repo.addNode("node11", "Node 11");
    	repo.addNode("node12", "Node 12").setIcon(new ThemeResource("icons/48x48/cat_2.png"));
    	repo.addNode("node13", "Node 13");
    	repo.addNode("node14", "Node 14").setIcon(new ThemeResource("icons/48x48/cat_3.png"));
    	repo.addNode("node15", "Node 15");
    	repo.addNode("node16", "Node 16").setIcon(new ThemeResource("icons/64x64/cat_4.png"));
    	repo.addNode("node17", "Node 17");
    	repo.addNode("node18", "Node 18").setIcon(new ThemeResource("icons/64x64/cat_5.png"));
    	repo.addNode("node19", "Node 19");
    	repo.addNode("node20", "Node 20");
    	repo.addNode("node21", "Node 21");
    	repo.addNode("node22", "Node 22");
    	repo.addNode("node23", "Node 23");

    	repo.joinNodes("node2", "node10", "edge210", "Edge 2-10");
    	repo.joinNodes("node2", "node11", "edge211", "Edge 2-11");
    	repo.joinNodes("node2", "node12", "edge212", "Edge 2-12");
    	repo.joinNodes("node2", "node13", "edge213", "Edge 2-13");
    	repo.joinNodes("node2", "node14", "edge214", "Edge 2-14");
    	repo.joinNodes("node2", "node15", "edge215", "Edge 2-15");
    	repo.joinNodes("node2", "node16", "edge216", "Edge 2-16");
    	repo.joinNodes("node2", "node17", "edge217", "Edge 2-17");
    	repo.joinNodes("node2", "node18", "edge218", "Edge 2-18");
    	repo.joinNodes("node2", "node19", "edge219", "Edge 2-19");
    	repo.joinNodes("node2", "node20", "edge220", "Edge 2-20");
    	repo.joinNodes("node2", "node21", "edge221", "Edge 2-21");
    	repo.joinNodes("node2", "node22", "edge222", "Edge 2-22");
    	repo.joinNodes("node2", "node23", "edge223", "Edge 2-23");
    	
    	return repo;
    }
}
