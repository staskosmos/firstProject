package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SeleniumHomePage {
    driver.get("https://www.seleniumhq.org/");

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("q")));

    WebElement searchInput = waitForElementLocatedBy(driver);
        searchInput.sendKeys("selenium java");

    List<WebElement> searchBtn = driver.findElements(By.xpath("//*[@value='Go']"));
        searchBtn.get(0).click();
}
