package test;

import main.PackageParser;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PackageCheckerTest {
	
	String[] packages  = {"KittenService: ", "Leetmeme: Cyberportal", "Cyberportal: Ice", "CamelCaser: KittenService", "Fraudstream: Leetmeme", "Ice: "};;
	PackageParser packageParser;
	
	public PackageCheckerTest() {
		 packageParser = new PackageParser(packages);
	}
	
    @Test
            public void testParsePackages(){
       
        Map<String, String> testMap = packageParser.getPackageDependencyMap();
        assertEquals("Ice", testMap.get("Cyberportal"));
    }
}