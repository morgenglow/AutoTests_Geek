import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class FirstJava {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Администратор\\IdeaProjects\\AutoTests\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://geekbrains.ru/");
    }

//    Вынести проверку каждой страницы в отдельный тест
//    Реализовать проверку отображения блоков Header и Footer на каждой странице сайта (как минимум самого блока)
    //курсы
    @Test
    public void courses() {
        driver.get("https://geekbrains.ru/courses");
        String title = driver.getTitle();
        Assertions.assertEquals(
                "Курсы", driver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        Assertions.assertTrue(driver.findElement(By.id("top-menu")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("site-footer__content")).isDisplayed());
    }

    //форум
    @Test
    public void forum() {
        driver.get("https://geekbrains.ru/topics");
        String title = driver.getTitle();
        Assertions.assertEquals(
                "Форум", driver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        Assertions.assertTrue(driver.findElement(By.id("top-menu")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("site-footer__content")).isDisplayed());
    }


    //блог
    @Test
    public void blog() {
        driver.get("https://geekbrains.ru/posts");
        String title = driver.getTitle();
        Assertions.assertEquals(
                "Блог", driver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        Assertions.assertTrue(driver.findElement(By.id("top-menu")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("site-footer__content")).isDisplayed());
    }


    //вебинары
    @Test
    public void webinars() {
        driver.get("https://geekbrains.ru/events");
        String title = driver.getTitle();
        Assertions.assertEquals(
                "Вебинары", driver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        Assertions.assertTrue(driver.findElement(By.id("top-menu")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("site-footer__content")).isDisplayed());
    }


    //Тесты
    @Test
    public void tests() {
        driver.get("https://geekbrains.ru/tests");
        String title = driver.getTitle();
        Assertions.assertEquals(
                "Тесты", driver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        Assertions.assertTrue(driver.findElement(By.id("top-menu")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("site-footer__content")).isDisplayed());
    }

    //Карьера
    @Test
    public void career() {
        driver.get("https://geekbrains.ru/tests");
        String title = driver.getTitle();
        Assertions.assertEquals(
                "Карьера", driver.findElement(By.cssSelector("[id=\"top-menu\"] h2")).getText());
        Assertions.assertTrue(driver.findElement(By.id("top-menu")).isDisplayed());
        Assertions.assertTrue(driver.findElement(By.className("site-footer__content")).isDisplayed());
    }

    //закрытие всплывающего объявления
    // @Test
    // public void closePopUp() {
    //  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //   wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='popup_content special']")));
    //    driver.findElement(By.xpath("//a[@id='service_popup_close']//img[1]")).click();
    //    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='popup_content special']")));
    //    Assertions.assertFalse(driver.findElement(By.xpath("//div[@class='popup_content special']")).isDisplayed());
    // }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}
