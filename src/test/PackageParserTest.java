package test;

import main.PackageParser;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PackageParserTest {
	
	String[] packages;
	PackageParser packageParser;
	Map<String, String> testMap;
	
	public PackageParserTest() {
	
	}
	
    @Before public void initializeObjects(){
        packages = new String[]{"KittenService: ", "Leetmeme: Cyberportal", "Cyberportal: Ice", "CamelCaser: KittenService", "Fraudstream: Leetmeme", "Ice: "};
        packageParser = new PackageParser(packages);
        
    }
    @Test
    public void testPackageParserCreation(){
    	Map<String, String> testMap = packageParser.getPackageDependencyMap();
        assertEquals("Ice", testMap.get("Cyberportal"));
    }
    public void testPackageWithBlankDependency() {
    	Map<String, String> testMap = packageParser.getPackageDependencyMap();
    	assertEquals("", testMap.get("KittenService"));
    }
    public void testPackageParserSize(){
    	Map<String, String> testMap = packageParser.getPackageDependencyMap();
        assertEquals(7, testMap.size());
    }
}