package com.vaadin.graph.demo.neo4j;

import java.util.Map;

import com.vaadin.graph.Arc;

final class Neo4JArc implements Arc {
    final org.neo4j.graphdb.Relationship inner;

    public Neo4JArc(org.neo4j.graphdb.Relationship inner) {
        this.inner = inner;
    }

    @Override
    public String getId() {
        return Long.toString(inner.getId());
    }

    @Override
    public String getLabel() {
        return inner.getType().name();
    }

    @Override
    public Map<String, Object> getProperties() {
        return new Neo4JPropertyMap(inner);
    }
}
