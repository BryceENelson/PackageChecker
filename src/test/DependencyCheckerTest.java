package test;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import main.DependencyChecker;
import main.PackageParser;

public class DependencyCheckerTest {
	
	String[] packages;
	PackageParser packageParser;
	Map<String, String> testMap;
	DependencyChecker dependencyChecker;
	
	String[] invalidPackages;
	PackageParser invalidPackageParser;
	Map<String, String> invalidTestMap;
	DependencyChecker invalidDependencyChecker;
	
	public DependencyCheckerTest() {
	
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
        
       invalidPackages = new String[]{
 			   "KittenService: ",
 			   "Leetmeme: Cyberportal",
 			   "Cyberportal: Ice",
 			   "CamelCaser: KittenService",
 			   "Fraudstream: ",
 			   "Ice: Leetmeme"};;
    	invalidPackageParser  = new PackageParser(invalidPackages);
    	invalidTestMap = invalidPackageParser.getPackageDependencyMap();
        
    }
    @Test
    public void testDependencyCheckerCreation(){
    	dependencyChecker = new DependencyChecker(testMap);
        assertEquals("Ice", dependencyChecker.getAllPackages().get("Cyberportal"));
    }
    
   @Test
   public void checkforCircularDependencies() {
	   dependencyChecker = new DependencyChecker(testMap);
	   assertEquals(false, dependencyChecker.detectCircularDependency());
   }
   
   @Test
   public void findExistingCircularDependencies() {
	   invalidDependencyChecker = new DependencyChecker(invalidTestMap);
	   assertEquals(true, invalidDependencyChecker.detectCircularDependency());
   }
}
