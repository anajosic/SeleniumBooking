package org.example;

import comwell.demoqa.DemoQATextBox;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {
       // System.setProperty("webdriver.chrome.driver", "C:/Program Files (x86)/Google");
        WebDriver driver = new ChromeDriver();



        DemoQATextBox demoQATextBox = new DemoQATextBox();
        demoQATextBox.launchDemoQATextBox(driver);


        // pozovi metodu koja testira login stranu - scenario A
        // pozovi metodu koja testira login stranu - scenario B

        // pozovi metodu koja testira stranu sa proizvodima - scenario A
    }
}