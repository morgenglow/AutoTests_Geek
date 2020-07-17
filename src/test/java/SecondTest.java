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

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SecondTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Администратор\\IdeaProjects\\AutoTests\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://geekbrains.ru/");
    }

    @Test
    public void searchCheck() throws InterruptedException {
//    Перейти на сайт https://geekbrains.ru/courses
        driver.get("https://geekbrains.ru/courses");
        driver.findElement(By.cssSelector("button [class=\"svg-icon icon-popup-close-button \"]")).click();
        //    Нажать на кнопку Поиск
        driver.findElement(By.cssSelector("[class=\"show-search-form\"] [class=\"svg-icon icon-search \"]")).click();
//    В поле Поиск ввести текст: java
        driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]")).sendKeys("java");
        Thread.sleep(15000);
//    Проверить что на странице:
//    Профессий не менее чем 2
        int prof = Integer.parseInt(driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[8]/div[1]/div[1]/div[1]/ul[1]/li[2]/a[1]/span[1]")).getText());
        Assertions.assertTrue(prof >= 2);
//    Курсов более 15
        int course = Integer.parseInt(driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[8]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/span[1]")).getText());
        Assertions.assertTrue(course >= 15);
//    Вебинаров больше чем 180, но меньше 300
        int webinar = Integer.parseInt(driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[8]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[1]/span[1]")).getText());
        Assertions.assertTrue(webinar >= 180 & webinar <= 300);
//    В вебинарах отображается первым “Java Junior. Что нужно знать для успешного собеседования?”
        Assertions.assertEquals(driver.findElement(By.xpath("(//a[contains(@class,'event__title h3')])[1]")).getText(), "Java Junior. Что нужно знать для успешного собеседования?");
//    Блогов более 300
        int blog = Integer.parseInt(driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[8]/div[1]/div[1]/div[1]/ul[1]/li[5]/a[1]/span[1]")).getText());
        Assertions.assertTrue(blog >= 300);
//    Форумов не 350
        int forum = Integer.parseInt(driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[8]/div[1]/div[1]/div[1]/ul[1]/li[6]/a[1]/span[1]")).getText());
        Assertions.assertFalse(forum == 300);
//    Тестов не 0
        int test = Integer.parseInt(driver.findElement(By.xpath("html[1]/body[1]/div[1]/div[8]/div[1]/div[1]/div[1]/ul[1]/li[7]/a[1]/span[1]")).getText());
        Assertions.assertFalse(test == 0);
//    В Проектах и компаниях отображается GeekBrains
        Assertions.assertTrue(driver.findElement(By.linkText("Образовательный портал GeekBrains")).isDisplayed());
    }

    @AfterAll
    public void tearDown() {
        driver.quit();
    }
}
