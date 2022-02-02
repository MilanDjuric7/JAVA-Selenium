package Selenium.Domaci.domaci_21_01.Base;

import Selenium.Domaci.domaci_21_01.Pages.AddToCartPage;
import Selenium.Domaci.domaci_21_01.Pages.CartPage;
import Selenium.Domaci.domaci_21_01.Pages.CategoriesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BasePageStore {

    public WebDriver driver;
    public WebDriverWait wdwait;
    public CategoriesPage categoriespage;
    public AddToCartPage addtocartpage;
    public CartPage cartpage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(15));
        categoriespage = new CategoriesPage(driver, wdwait);
        addtocartpage = new AddToCartPage(driver, wdwait);
        cartpage = new CartPage(driver, wdwait);
    }

    @AfterClass
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
