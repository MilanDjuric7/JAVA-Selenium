package Selenium.Domaci.domaci_21_01.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartPage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public WebElement addToCartButton;

    public AddToCartPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getAddToCartButton() {
        return driver.findElement(By.cssSelector(".btn.btn-success.btn-lg"));
    }


    //--------------------------------------------------------------------------------------


    public void addToCartButton() {
        getAddToCartButton().click();
    }

    public void confirmAddition() {
        driver.switchTo().alert().accept();
    }
}
