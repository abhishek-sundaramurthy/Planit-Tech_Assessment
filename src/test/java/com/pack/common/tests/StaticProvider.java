package com.pack.common.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.testng.annotations.DataProvider;

import com.pack.report.SimpleReport;
import com.relevantcodes.extentreports.ExtentReports;



public class StaticProvider {
	static Path path = Paths.get(new File("").getAbsolutePath());
	static String parent = path.getParent().toString();

	public static ExtentReports reporter = SimpleReport.getReporter(parent + "\\PlanIt_Technical_Assesment.html");

	@DataProvider(name = "createreport")
	public static Object[][] createData() throws IOException {
		Object[][] obj = new Object[1][1];
		obj[0][0] = StaticProvider.reporter;
		return obj;
	}
}
