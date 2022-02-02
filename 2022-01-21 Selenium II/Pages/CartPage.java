package Selenium.Domaci.domaci_21_01.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public WebElement cartPageLink;
    public List<WebElement> nizAddProducts;

    public CartPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public List<WebElement> getNizAddProducts() {
        return driver.findElements(By.className("success"));
    }

    public WebElement getCartPageLink() {
        return driver.findElement(By.id("cartur"));
    }


    //------------------------------------------------------------------------------------


    public void goToCartPage() {
        getCartPageLink().click();
    }
}
