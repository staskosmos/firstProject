import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverAPIBasics {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.seleniumhq.org/");

        new WebDriverWait(driver,10)
                .until(CustomConditions.jQueryAJAXsCompleted());

        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("q")));

        //WebElement searchInput =  driver.findElement(By.id("q"));
        WebElement searchInput = waitForElementLocatedBy(driver);
        searchInput.sendKeys("selenium java");
        WebElement searchBtn =  driver.findElement(By.xpath("//*[@id=\"submit\"]"));
        searchBtn.click();

        Thread.sleep(3000);
        driver.quit();
    }

    private static WebElement waitForElementLocatedBy(WebDriver driver) {
        return new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("q")));
    }
}
