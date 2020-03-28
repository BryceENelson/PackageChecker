package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DependencyChecker {
	
	private Map<String, String> allPackages;
	
	private boolean hasCircularDependency;
	
	public DependencyChecker(Map<String, String> allPackages) {
		this.allPackages = allPackages;
		this.hasCircularDependency = false;
	}

	public Map<String, String> getAllPackages() {
		return allPackages;
	}

	public boolean detectCircularDependency() {
		ArrayList<String> dependencyChain = new ArrayList<String>();
		for(Map.Entry<String, String> entry : allPackages.entrySet()) {
			checkForCircularDependency(dependencyChain, entry.getKey());
			if(this.hasCircularDependency) {
				break;
			}
			dependencyChain.clear();
		}
		return this.hasCircularDependency;
	}
	
	private void checkForCircularDependency(ArrayList<String> dependencyChain, String currentKey) {
		if(dependencyChain.contains(currentKey)) {
			this.hasCircularDependency = true;
			return;
		}
		if("".equalsIgnoreCase(currentKey)) {
			return;
		}
		dependencyChain.add(currentKey);
		checkForCircularDependency(dependencyChain, this.allPackages.get(currentKey));
		
	}
}
