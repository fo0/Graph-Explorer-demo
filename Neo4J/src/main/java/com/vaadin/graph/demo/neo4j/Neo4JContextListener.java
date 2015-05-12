package com.vaadin.graph.demo.neo4j;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

public class Neo4JContextListener implements ServletContextListener {
    private final String path;
    private GraphDatabaseService graphdb;

    public Neo4JContextListener() throws IOException {
        path = new File(System.getProperty("user.home"), "graphdb").getCanonicalPath();
//      path = getClass().getResource("/sampleDB/drwho").getPath();       
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        graphdb.shutdown();
        graphdb = null;
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        graphdb = new GraphDatabaseFactory().newEmbeddedDatabase(path);
        event.getServletContext().setAttribute(Neo4JDemo.GRAPHDB, graphdb);
    }
}
