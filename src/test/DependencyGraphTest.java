package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import main.DependencyGraph;
import main.PackageParser;

public class DependencyGraphTest {

	String[] packages;
	PackageParser packageParser;
	Map<String, String> testMap;
	DependencyGraph dependencyGraph;
	
	public DependencyGraphTest() {
		
	}
	
    @Before public void initializeObjects(){
        packages = new String[]{
        		"KittenService: ", 
        		"Leetmeme: Cyberportal", 
        		"Cyberportal: Ice", 
        		"CamelCaser: KittenService", 
        		"Fraudstream: Leetmeme", 
        		"Ice: "};
        packageParser = new PackageParser(packages);
        testMap = packageParser.getPackageDependencyMap();    
    }
    @Test
    public void testGraphCreation() {
    	dependencyGraph = new DependencyGraph(testMap);
    	assertEquals("KittenService", dependencyGraph.getAdjacencyList().get("CamelCaser").get(0));
    }
    
    @Test
    public void testAddNode() {
    	dependencyGraph = new DependencyGraph(testMap);
    	int initialSize = dependencyGraph.getAdjacencyList().size();
    	dependencyGraph.addNode("Zebra");
    	int newSize = dependencyGraph.getAdjacencyList().size();
    	assertEquals(newSize, initialSize + 1);
    }
    @Test
    public void testAddEdge() {
    	dependencyGraph = new DependencyGraph(testMap);
    	List<String> dependencies = dependencyGraph.getPackageDependnecies("Leetmeme");
    	int initialSize = dependencies.size();
    	dependencyGraph.addEdge("Leetmeme", "Zebra");
    	int newSize = dependencies.size();
    	assertEquals(newSize, initialSize + 1);
    }
}
