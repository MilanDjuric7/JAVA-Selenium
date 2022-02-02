package Selenium.Domaci.domaci_21_01.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoriesPage {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public List<WebElement> nizCategories;
    public List<WebElement> nizItems;

    public CategoriesPage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public List<WebElement> getNizCategories() {
        return driver.findElements(By.id("itemc"));
    }

    public List<WebElement> getNizItems() {
        return driver.findElements(By.cssSelector(".col-lg-4.col-md-6.mb-4"));
    }


    //-----------------------------------------------------------------------------------------------


    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (WebElement i : getNizItems()) {
            sb.append("Stavka: ");
            sb.append(getNizItems().indexOf(i) + 1);
            sb.append("\n");

            sb.append(" Naziv: ");
            sb.append(i.findElement(By.className("hrefch")).getText());
            sb.append("\n");

            sb.append(" Opis: ");
            sb.append(i.findElement(By.className("card-text")).getText());
            sb.append("\n");

            sb.append(" Cena: ");
            sb.append(i.findElement(By.tagName("h5")).getText());
            sb.append("\n");

            sb.append("\n");
        }

        return sb.toString();
    }

    public int totalItems() {
        return getNizItems().size();
    }

    public int totalPrice() {

        int suma = 0;
        for (WebElement we : getNizItems()) {
            suma += Integer.parseInt(we.findElement(By.tagName("h5")).getText().substring(1));
        }
        return suma;
    }

    public void selectCategory(int x) {
        getNizCategories().get(x).click();
    }

    public void selectItem(int y) {
        getNizItems().get(y).click();
    }
}
