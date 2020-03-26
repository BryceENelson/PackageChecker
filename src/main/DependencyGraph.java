package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DependencyGraph {
	
	private Map<GraphNode, List<GraphNode>> adjacencyList;
	
	public DependencyGraph(Map<GraphNode, List<GraphNode>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	public Map<GraphNode, List<GraphNode>> getAdjacencyList() {
		return adjacencyList;
	}
	
	public void setAdjacencyList(Map<GraphNode, List<GraphNode>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjacencyList == null) ? 0 : adjacencyList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DependencyGraph other = (DependencyGraph) obj;
		if (adjacencyList == null) {
			if (other.adjacencyList != null)
				return false;
		} else if (!adjacencyList.equals(other.adjacencyList))
			return false;
		return true;
	}
	
	void addNode(String name) {
		adjacencyList.putIfAbsent(new GraphNode(name), new ArrayList<>());
	}
	
	void addAdjacency(String packageName, String dependencyName) {
		GraphNode parentPackage =  new GraphNode(packageName);
		GraphNode dependency =  new GraphNode(dependencyName);
		adjacencyList.get(parentPackage).add(dependency);
	}
	
	public void printTopologicalSortOfGraph() {
		/*Algorithm Ideas: 
		 * Build a tempGraph that is equal to the adjacencylist.
		 * For each node in TempGraph:
		 * If a node in the graph has no outward adjacencies, 
		 * add it to the set to be printed, then remove it from tempGraph. 
		 * Find all nodes in the graph that were dependent on that node and remove the 
		 * dependency since it has been added. Repeat as long as there are nodes in TempGraph */
	}

}
