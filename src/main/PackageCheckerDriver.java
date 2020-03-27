package main;

import java.util.ArrayList;

public class PackageCheckerDriver {
    public static void main(String[] args) {
    	
    	String[] packages;
    	if(args.length == 0) {
    		packages = new String[]{"KittenService: ","Leetmeme: Cyberportal","Cyberportal: Ice","CamelCaser: KittenService","Fraudstream: Leetmeme","Ice: "};
    	}
    	else {
    		packages =  args;
    	}
    	
    	PackageChecker packageChecker =  new PackageChecker(packages);
    }
}
