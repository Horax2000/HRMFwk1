package org.HRMFwk.Utils;

import org.HRMFwk.Setup.Config;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.List;

public class CommandLineRunner {
    public static void main(String[] args) {
        String browser = args.length > 0 ? args[0] : Config.BROWSER.getValue(); // Default to Chrome
        String testDataFile = args.length > 1 ? args[1] : "path/to/excel/file.xlsx"; // Default test data file

        TestNG testng = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("DataDrivenSuite");

        // Configure the suite based on parameters

        testng.setXmlSuites(List.of(suite));

        testng.run();
    }
}