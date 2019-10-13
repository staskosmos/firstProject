package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SeleniumSearchResultsPage {

    new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'gsc-webResult') and contains(.,'selenium') and contains(.,'java')]")));

    List<WebElement> searchResults = driver
            .findElements(By.xpath("//div[contains(@class,'gsc-webResult') and contains(.,'selenium') and contains(.,'java')]"));
        System.out.printf("Search results number for requested term: " + searchResults.size());
}
