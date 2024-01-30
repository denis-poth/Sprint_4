package tests;

import org.junit.After;
import org.junit.Test;
import PageObjects.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FAQtest {

    @Test
    public void testDropdownFunctionality() {
        driver = getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        WebElement currentQuestion = driver.findElement(By.xpath(questionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currentQuestion);
        currentQuestion.click();

        WebElement currentAnswer = driver.findElement(By.xpath(answerLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", currentAnswer);

        String actualText = currentAnswer.getText();
        assertEquals("Текст ответа не соответствует ожидаемому", expectedText, actualText);

        System.out.println("Текст ответа на вопрос соответствует ожидаемому");
    }
    private WebDriver driver;
    private final String questionLocator;
    private final String answerLocator;
    private final String expectedText;

    public FAQtest(String questionLocator, String answerLocator, String expectedText) {
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.expectedText = expectedText;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {StartPage.FIRST_QUESTION, StartPage.FIRST_ANSWER, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {StartPage.SECOND_QUESTION, StartPage.SECOND_ANSWER, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {StartPage.THIRD_QUESTION, StartPage.THIRD_ANSWER, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {StartPage.FOURTH_QUESTION, StartPage.FOURTH_ANSWER, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {StartPage.FIFTH_QUESTION, StartPage.FIFTH_ANSWER, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {StartPage.SIXTH_QUESTION, StartPage.SIXTH_ANSWER, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {StartPage.SEVENTH_QUESTION, StartPage.SEVENTH_ANSWER, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {StartPage.EIGHTH_QUESTION, StartPage.EIGHTH_ANSWER, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        });
    }

    private WebDriver getDriver() {
        String driverType = System.getenv("BROWSER");
        switch (driverType.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                return driver;
            case "firefox":
                driver = new FirefoxDriver();
                driver.manage().window().setSize(new Dimension(1920, 1080)); // Измените размеры по необходимости
                return driver;
            default:
                throw new IllegalArgumentException("Неподдерживаемый браузер. Поддерживаются только 'chrome' и 'firefox'");
        }
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
