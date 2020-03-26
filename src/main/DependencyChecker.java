package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DependencyChecker {
	
	private Map<String, String> allPackages;
	
	private Map<String, String> packagesWithDependencies;
	
	private Map<String, String> packagesWithoutDependencies;
	
	private boolean hasCircularDependency;
	
	public DependencyChecker(Map<String, String> allPackages) {
		this.allPackages = allPackages;
		this.packagesWithDependencies =  new HashMap<String, String>();
		this.packagesWithoutDependencies =  new HashMap<String, String>();
		this.hasCircularDependency = false;
		
	}

	public Map<String, String> getAllPackages() {
		return allPackages;
	}



	public Map<String, String> getPackagesWithDependencies() {
		return packagesWithDependencies;
	}

	public Map<String, String> getPackagesWithoutDependencies() {
		return packagesWithoutDependencies;
	}

//	public void sortPackages() {
//		for(Map.Entry<String, String> entry : allPackages.entrySet()) {
//			if("".equalsIgnoreCase(entry.getValue().trim())){
//				packagesWithoutDependencies.put(entry.getKey(), entry.getValue());
//			}
//			else {
//				packagesWithDependencies.put(entry.getKey(), entry.getValue());
//			}
//		}
//	}
	
	public boolean detectCircularDependency() {
		ArrayList<String> dependencyChain = new ArrayList<String>();
		for(Map.Entry<String, String> entry : allPackages.entrySet()) {
			checkForCircularDependency(dependencyChain, entry.getKey());
			dependencyChain.clear();
		}
		
		return this.hasCircularDependency;
	}
	
	private void checkForCircularDependency(ArrayList<String> dependencyChain, String currentKey) {
		if(dependencyChain.contains(currentKey)) {
			this.hasCircularDependency = true;
			System.out.println("Circular Dependency detected");
			return;
		}
		if("".equalsIgnoreCase(currentKey)) {
			System.out.println("Reached an end of the chain without hitting a circular dependency.");
			return;
		}
		dependencyChain.add(currentKey);
		checkForCircularDependency(dependencyChain, this.allPackages.get(currentKey));
		
	}
}
