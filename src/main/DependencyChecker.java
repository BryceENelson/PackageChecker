package main;

import java.util.Map;

public class DependencyChecker {
	
	Map<String, String> allPackages;
	
	Map<String, String> packagesWithDependencies;
	
	Map<String, String> packagesWithoutDependencies;
	
	public void DependencyChecker() {
		
	}
	
	public void DependencyChecker(Map<String, String> allPackages) {
		this.allPackages = allPackages;
	}

	public Map<String, String> getAllPackacges() {
		return allPackages;
	}

	public void setAllPackacges(Map<String, String> allPackages) {
		this.allPackages = allPackages;
	}

	public Map<String, String> getPackagesWithDependencies() {
		return packagesWithDependencies;
	}

	public void setPackagesWithDependencies(Map<String, String> packagesWithDependencies) {
		this.packagesWithDependencies = packagesWithDependencies;
	}

	public Map<String, String> getPackagesWithoutDependencies() {
		return packagesWithoutDependencies;
	}

	public void setPackagesWithoutDependencies(Map<String, String> packagesWithoutDependencies) {
		this.packagesWithoutDependencies = packagesWithoutDependencies;
	}
	
	public void sortPackages() {
		for(Map.Entry<String, String> entry : allPackages.entrySet()) {
			if("".equalsIgnoreCase(entry.getValue())){
				packagesWithoutDependencies.put(entry.getKey(), entry.getValue());
			}
			else {
				packagesWithDependencies.put(entry.getKey(), entry.getValue());
			}
		}
	}
	
	public boolean hasCircularDependency() {
		boolean circularDependency = false;
		
		return circularDependency;
	}
}
