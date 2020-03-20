package test;

import main.PackageParser;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PackageCheckerTest {
    @Test
            public void testParsePackages(){
        String[] packages ={"KittenService: ", "Leetmeme: Cyberportal", "Cyberportal: Ice", "CamelCaser: KittenService", "Fraudstream: Leetmeme", "Ice: "};
        PackageParser packageParser = new PackageParser(packages);
        Map<String, String> testMap = packageParser.getPackageDependencyMap();
        assertEquals("Ice", testMap.get("CyberPortal"));
    }
}