package Selenium.Domaci.domaci_21_01.Test;

import Selenium.Domaci.domaci_21_01.Base.BasePageStore;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Tests extends BasePageStore {

    @BeforeMethod
    public void setUpPage() {
        driver.navigate().to("https://www.demoblaze.com/index.html#");
        driver.manage().window().maximize();
    }

    @Test (priority = 10)
    public void printAndPrice() throws InterruptedException {

        for (WebElement we : categoriespage.getNizCategories()) {

            we.click();
            System.out.println();
            System.out.println("*** " + we.getText() + ": ");
            System.out.println("_______________");
            Thread.sleep(2000);
            System.out.print(categoriespage);
            System.out.println("------------------------------------------------");
            System.out.println("Ukupno stavki iz " + we.getText() + " = " + categoriespage.totalItems());
            System.out.println("------------------------------------------------");
            System.out.println("Ukupna cena svih proizvoda iz " + we.getText() + " = " + "$" + categoriespage.totalPrice());
            System.out.println("------------------------------------------------");
        }
    }

    @Test (priority = 20)
    public void addToCart() throws InterruptedException {

        int Phones = 0;
        int Laptops = 1;
        int Monitors = 2;

        categoriespage.selectCategory(Phones);
        Thread.sleep(2000);
        categoriespage.selectItem(5);
        Thread.sleep(2000);
        addtocartpage.addToCartButton();
        Thread.sleep(2000);
        addtocartpage.confirmAddition();
        driver.findElement(By.cssSelector(".nav-item.active")).click();

        categoriespage.selectCategory(Laptops);
        Thread.sleep(2000);
        categoriespage.selectItem(1);
        Thread.sleep(2000);
        addtocartpage.addToCartButton();
        Thread.sleep(2000);
        addtocartpage.confirmAddition();
        driver.findElement(By.cssSelector(".nav-item.active")).click();

        categoriespage.selectCategory(Monitors);
        Thread.sleep(2000);
        categoriespage.selectItem(0);
        Thread.sleep(2000);
        addtocartpage.addToCartButton();
        Thread.sleep(2000);
        addtocartpage.confirmAddition();
        driver.findElement(By.cssSelector(".nav-item.active")).click();
    }

    @Test (priority = 30)
    public void cartTest() throws InterruptedException {

        cartpage.goToCartPage();
        Thread.sleep(2000);

        int actualSize = cartpage.getNizAddProducts().size();
        int expectedSize = 3;

        Assert.assertEquals(actualSize, expectedSize);
    }
}
