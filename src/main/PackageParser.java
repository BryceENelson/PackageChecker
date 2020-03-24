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
            String[] splitString = iterator.split(":");
            this.packageDependencyMap.put(splitString[0], splitString[1].trim());
            //System.out.println("Package Name: " + splitString[0] + " Dependency: " + splitString[1]);
        }
    }

    public Map<String, String> getPackageDependencyMap() {
        return packageDependencyMap;
    }
}
