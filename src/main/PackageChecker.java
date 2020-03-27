package main;

import java.util.ArrayList;

public class PackageChecker {

	private PackageParser packageParser;
	private DependencyChecker dependencyChecker;
	private DependencyGraph dependencyGraph;
	public PackageChecker(String[] packages) {
		packageParser = new PackageParser(packages);
         
        dependencyChecker =  new DependencyChecker(packageParser.getPackageDependencyMap());
        
        if(!dependencyChecker.detectCircularDependency()) {
        	  dependencyGraph = new DependencyGraph(packageParser.getPackageDependencyMap());
        	  ArrayList<String> printOrder =  dependencyGraph.topologicalSortOfGraph();
        	  String outputString = "";
        	  for(String packageName : printOrder) {
        		  outputString += packageName + ", ";
        	  }
        	  outputString = outputString.substring(0, outputString.length() - 2);
        	  System.out.println(outputString);
        }
        else {
        	System.out.println("Invalid input: Circular Dependency detected.");
        }
	}

}
