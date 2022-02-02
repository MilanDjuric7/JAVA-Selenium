package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Domaci_18_01 {
    public static void main(String[] args) throws InterruptedException {

        //Postoji pesma koja je himna ITBootcampa: https://www.youtube.com/watch?v=dQw4w9WgXcQ
        //Vas domaci zadatak je da otvorite pretrazivac, odete na youtube i pustite Rick Astley-a

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.youtube.com/");

        WebElement searchTextBox = driver.findElement(By.name("search_query"));
        searchTextBox.sendKeys("Rick Astley");

        WebElement searchButton = driver.findElement(By.id("search-icon-legacy"));
        searchButton.click();

        Thread.sleep(2000);
        WebElement playButton = driver.findElement(By.linkText("Rick Astley - Never Gonna Give You Up (Official Music Video)"));
        playButton.click();

    }
}
