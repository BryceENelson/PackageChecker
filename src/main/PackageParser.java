package main;

import java.util.HashMap;
import java.util.Map;

public class PackageParser {

    private String[] packagesInput;

    private Map<String, String> packageDependencyMap = new HashMap<String, String>();

    public PackageParser(String[] packagesInput) {
        this.packagesInput = packagesInput;
        parsePackagesInput(this.packagesInput);
    }
    
     

    private void parsePackagesInput(String[] packagesInput){

    	 for(String iterator : packagesInput){
    		removePunctuation(iterator);
         	if("[".equalsIgnoreCase(iterator) || "]".equalsIgnoreCase(iterator)) {
         		continue;
         	}
             String[] splitString = iterator.split(":");
             if(splitString.length < 2) {
            	 continue;
             }
             splitString[0].replace(",", "");
             splitString[1].replace(",", "");
             this.packageDependencyMap.put(splitString[0], splitString[1].trim());
             //System.out.println("Package Name: " + splitString[0] + " Dependency: " + splitString[1]);
         }
    }

    public Map<String, String> getPackageDependencyMap() {
        return packageDependencyMap;
    }
    private String removePunctuation(String parsedString) {
    	String cleanedString = "";
    	for(Character c : parsedString.toCharArray()) {
    		if(Character.isLetterOrDigit(c) || c == '=') {
    			cleanedString += c;
    		}
    	}
    	return cleanedString;
    }
}
