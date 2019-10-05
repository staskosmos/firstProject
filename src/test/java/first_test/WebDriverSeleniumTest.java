package first_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import wait.CustomConditions;

import java.util.List;

public class WebDriverSeleniumTest {


    @Test
    public  void commonSearchTermReRsultsNotEmpty() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumhq.org/");

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("q")));

        WebElement searchInput = waitForElementLocatedBy(driver);
        searchInput.sendKeys("selenium java");

        List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@value='Go']"));
        searchBtn.get(0).click();

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'gsc-webResult') and contains(.,'selenium') and contains(.,'java')]")));

        List<WebElement> searchResults = driver
                .findElements(By.xpath("//div[contains(@class,'gsc-webResult') and contains(.,'selenium') and contains(.,'java')]"));
        System.out.printf("Search results number for requested term: " + searchResults.size());

        Assert.assertTrue(searchResults.size()>0,"Search results are empty");

        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver) {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("q")));
    }
}
