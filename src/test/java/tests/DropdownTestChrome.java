package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import PageObjects.StartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTestChrome {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();  // Для удобства открываем в полноэкранном режиме
    }

    @Test
    public void testDropdownFunctionality() {
        // Переход на сайт
        driver.get("https://qa-scooter.praktikum-services.ru/");

        // Локаторы кнопок и текстов ответов
        String[] questionLocators = {
                StartPage.FIRST_QUESTION,
                StartPage.SECOND_QUESTION,
                StartPage.THIRD_QUESTION,
                StartPage.FOURTH_QUESTION,
                StartPage.FIFTH_QUESTION,
                StartPage.SIXTH_QUESTION,
                StartPage.SEVENTH_QUESTION,
                StartPage.EIGHTH_QUESTION
        };

        String[] answerLocators = {
                StartPage.FIRST_ANSWER,
                StartPage.SECOND_ANSWER,
                StartPage.THIRD_ANSWER,
                StartPage.FOURTH_ANSWER,
                StartPage.FIFTH_ANSWER,
                StartPage.SIXTH_ANSWER,
                StartPage.SEVENTH_ANSWER,
                StartPage.EIGHTH_ANSWER
        };

        // Ожидаемые тексты ответов
        String[] expectedTexts = {
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",  // Первый текст
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", // Второй текст
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", // Третий текст
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.", // Четвертый текст
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", // Пятый текст
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", // Шестой текст
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", // Седьмой текст
                "Да, обязательно. Всем самокатов! И Москве, и Московской области." // Восьмой текст
        };

        for (int i = 0; i < questionLocators.length; i++) {
            // Прокручиваем страницу вниз до текущего вопроса
            WebElement currentQuestion = driver.findElement(By.xpath(questionLocators[i]));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", currentQuestion);

            // Нажимаем на текущий вопрос
            currentQuestion.click();

            WebDriverWait wait = new WebDriverWait(driver, 1); // Ждем не больше 1 секунды, после нажатия на кнопку вопроса, прежде чем искать текст
            WebElement currentAnswer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(answerLocators[i])));

            // Получаем текст ответа на текущий вопрос
            String actualText = currentAnswer.getText();
            assertEquals(expectedTexts[i], actualText, "Текст ответа на вопрос " + (i + 1) + " не соответствует ожидаемому");
        }

        System.out.println("Все тесты завершены");
    }

    @After
    public void tearDown() {
        // Завершение работы с WebDriver
        driver.quit();
    }
}
