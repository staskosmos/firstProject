import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver1.exe");
        driver = new ChromeDriver();
        driver.get("http://*******");
    }

    @Test
    public void userLogin() {
        WebElement loginField = driver.findElement(By.id("id_username")).sendKeys("*****"); //  Заполняет имя пользователя


        WebElement passwordField = driver.findElement(By.id("id_password")).sendKeys("super_password"); // Заполняет пароль

        WebElement loginButton = driver.findElement(By.className("submit-row")).click(); //Нажимает кнопку Войти

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Администрирование сайта | Панель управления")); // Проверяет что на новой станице присутствует заголовок

        // Нажимает кнопку “Добавить” в разделе Blog/Entries

        WebElement blogButton  = driver.findElement(By.xpath('//*[@id="module_2"]/div/ul[1]/li[1]/ul/li[1]/a’)).click ();

                String title2 = driver.getTitle();
        Assert.assertTrue(title2.equals("Добавить entry | Панель управления")); // Проверяет что на новой станице присутствует заголовок - “Добавить entry”


        String myTitle = "ForzaJuve";

        WebElement titleField = driver.findElement(By.id("id_title")).sendKeys(myTitle); // Заполняет поле title - случайной строкой


        WebElement slugField = driver.findElement(By.id("id_slug")).sendKeys("justdoit"); //Заполняет поле Slug - случайной строкой


        WebElement textMarkDown = driver.findElement(By.id("id_text_markdown")).sendKeys("nan"); // Заполняет поле Text markdown - случайной строкой

        WebElement text = driver.findElement(By.id("id_text")).sendKeys("nan"); //Заполняет поле Text - случайной строкой



        WebElement saveButton = driver.findElement(By.className("submit-row")).click(); //Нажимает кнопку Сохранить


        driver.get("http://*******");  //Переходит на страницу: http://*******


                WebElement myEntry = driver.findElement(By.linkText("ForzaJuve"));
        Assert.assertTrue(myEntry.getText().equals(myTitle)); //Удостоверяется что ранее созданная запись отображается на сайте.



        //Удаляет созданную запись

        driver.get("http://*******");
        WebElement blogButton2 = driver.findElement(By.className("action-checkbox")).click();

        WebElement selectElem = driver.findElement(By.tagName("select"));

        // Выбор из выпадающего списка
        Select select = new Select(selectElem);
        select.selectByVisibleText("Удалить выбранные Entries");

        WebElement blogButton3 = driver.findElement(By.className("actions")).click();

        WebElement blogButton4 = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/input[4]")).click();


        @AfterClass
                driver.quit();
    }
}
