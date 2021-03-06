package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DependencyGraph {
	
	private Map<String, ArrayList<String>> adjacencyList;
	
	private Map<String, String> packages;
	
	public DependencyGraph(Map<String, String> packages) {
		this.packages = packages;
		this.adjacencyList =  new HashMap<String, ArrayList<String>>();
		buildAdjacencies(packages);
	}
	
	private void buildAdjacencies(Map<String, String> packages) {
		for(Map.Entry<String, String> entry : packages.entrySet()) {
			addNode(entry.getKey());
			addEdge(entry.getKey(), entry.getValue());
		}
	}
	
	public ArrayList<String> getPackageDependnecies(String packageName){
		return adjacencyList.get(packageName);
	}
	
	public Map<String, ArrayList<String>> getAdjacencyList(){
		return adjacencyList;
	}
	
	public void addNode(String name) {
		this.adjacencyList.put(name, new ArrayList<String>());
	}
	
	public void addEdge(String packageName, String dependencyName) {
		if("".equalsIgnoreCase(dependencyName.trim())) {
			return;
		}
		adjacencyList.get(packageName).add(dependencyName);
	}
	
	private void removeEdge(String packageName, String dependencyName) {
	    List<String> dependencies = adjacencyList.get(packageName);
	    if (dependencies != null)
	    	dependencies.remove(dependencyName);
	}
	
	public ArrayList<String> topologicalSortOfGraph() {
		/*Algorithm Ideas: 
		 * Build a tempGraph that is equal to the current graph.*/
		DependencyGraph tempGraph = new DependencyGraph(this.packages);
		
		ArrayList<String> printOrder = new ArrayList<String>();
		/*
		 * For each node in TempGraph:*/
		
		while(!tempGraph.adjacencyList.isEmpty()) {
			Iterator<Map.Entry<String, ArrayList<String>>> iterator = tempGraph.adjacencyList.entrySet().iterator();
			while(iterator.hasNext()) {
				Map.Entry<String, ArrayList<String>> entry = iterator.next();
				if(entry.getValue().isEmpty()) {
					String nodeName = entry.getKey();
					printOrder.add(nodeName);
					iterator.remove();
					for(Map.Entry<String, ArrayList<String>> innerEntry: tempGraph.adjacencyList.entrySet()) {
						if(innerEntry.getValue().contains(nodeName)) {
							tempGraph.removeEdge(innerEntry.getKey(), nodeName);
						}
					}
				}
			}
		}
		return printOrder;
		/*
		 * If a node in the graph has no outward adjacency, 
		 * add it to the set to be printed, then remove it from tempGraph. 
		 * Find all nodes in the graph that were dependent on that node and remove the 
		 * dependency since it has been added. Repeat as long as there are nodes in TempGraph */
	}

}
