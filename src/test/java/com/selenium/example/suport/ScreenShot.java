package com.selenium.example.suport;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class ScreenShot {

	public static void tirar(WebDriver navegador, String arquivo) {
		
		try {
			File screenshot = ((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File(arquivo));
		} catch (IOException e) {
			System.out.println("Houve problema ao coíar aquivo para a pasta: " + e.getMessage());
		}
	}
}
