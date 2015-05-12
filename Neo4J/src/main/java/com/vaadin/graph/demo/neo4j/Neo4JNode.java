package com.vaadin.graph.demo.neo4j;

import java.util.Map;

import com.vaadin.graph.Node;
import com.vaadin.server.Resource;

final class Neo4JNode implements Node {
    private static final String WORD = "word";
    private static final String TITLE = "title";
    private static final String NAME = "name";
    final org.neo4j.graphdb.Node inner;

    public Neo4JNode(org.neo4j.graphdb.Node inner) {
        this.inner = inner;
    }

    @Override
    public Map<String, Object> getProperties() {
        return new Neo4JPropertyMap(inner);
    }

    @Override
    public String getId() {
        return Long.toString(inner.getId());
    }

    @Override
    public String getLabel() {
        String property;
        if (inner.hasProperty(NAME)) {
            property = NAME;
        } else if (inner.hasProperty(TITLE)) {
            property = TITLE;
        } else if (inner.hasProperty(WORD)) {
            property = WORD;
        } else {
            return "Home";
        }
        return "" + inner.getProperty(property);
    }
    
    public Resource getIcon() {
    	return null;
    }

}
