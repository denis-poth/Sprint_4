package tests;

import PageObjects.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderByBottomButtonFirefox {

    private static WebDriver driver;

    private final String nameInput;
    private final String surnameInput;
    private final String addressInput;
    private final String stationNameInput;
    private final String phoneNumberInput;
    private final String dateOfDelivery;
    private final int rentalPeriod;
    private final String scooterColour;
    private final String comment;

    public OrderByBottomButtonFirefox (String nameInput, String surnameInput, String addressInput, String stationNameInput, String phoneNumberInput, String dateOfDelivery, int rentalPeriod, String scooterColour, String comment) {
        this.nameInput = nameInput;
        this.surnameInput = surnameInput;
        this.addressInput = addressInput;
        this.stationNameInput = stationNameInput;
        this.phoneNumberInput = phoneNumberInput;
        this.dateOfDelivery = dateOfDelivery;
        this.rentalPeriod = rentalPeriod;
        this.scooterColour = scooterColour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Вика", "Забивная", "Митино, ул. Генерала Белобородова", "Митино", "11111111111", "03.03.2024", 7, "Черный", "Жду с нетерпением"},
                {"Александр", "неЗабивной", "Красногорская улица", "Черкизовская", "+375336203489", "04.04.2024", 6, "Серый", "Оставьте у двери"},
                {"Даниил", "Тонкий", "Живет на улице", "Кожуховская", "+11111111111", "05.05.2024", 1, "Все цвета", ""}
        });
    }

    private void selectColor(String scooterColour) {
        String checkboxLocator;

        if ("Черный".equals(scooterColour)) {
            checkboxLocator = Order_secondPage.SCOOTER_COLOUR_BLACK;
        } else if ("Серый".equals(scooterColour)) {
            checkboxLocator = Order_secondPage.SCOOTER_COLOUR_GREY;
        } else if ("Все цвета".equals(scooterColour)) {
            WebElement blackCheckbox = driver.findElement(By.xpath(Order_secondPage.SCOOTER_COLOUR_BLACK));
            WebElement greyCheckbox = driver.findElement(By.xpath(Order_secondPage.SCOOTER_COLOUR_GREY));
            {
                blackCheckbox.click();
            }
            {
                greyCheckbox.click();
            }

            return;
        } else {
            // Обработка неверного параметра или других случаев
            System.out.println("Некорректное значение параметра scooterColour");
            return;
        }

        WebElement checkbox = driver.findElement(By.xpath(checkboxLocator));
        checkbox.click();
    }



    private void selectRentDurationInDays(int rentalPeriod) {
        WebElement rentalPeriodDays = driver.findElement(By.xpath(Order_secondPage.RENTAL_PERIOD));
        rentalPeriodDays.click();

        String optionLocator = String.format("//div[@class='Dropdown-menu']/div[@class='Dropdown-option'][%d]", rentalPeriod);        WebElement specificOption = driver.findElement(By.xpath(optionLocator));
        specificOption.click();
    }

    private void selectMetroStation(String stationNameInput) {
        final String metroStationPattern = ".//div[@class='Order_Form__17u6u']/div/div[@class='select-search has-focus']/div[@class='select-search__select']//*[text()='%s']";
        final String metroStationSelected = String.format(metroStationPattern, stationNameInput);

        driver.findElement(By.xpath(Order_firstPage.METRO_STATION_INPUT)).click();

        WebElement searchStationFromList = driver.findElement(By.xpath(metroStationSelected));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", searchStationFromList);

        searchStationFromList.click();
    }


    @Before
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();  // Для удобства открываем в полноэкранном режиме
    }

    @Test
    public void fullOrderTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().window().maximize();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        WebElement bottomOrderButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(StartPage.BOTTOM_ORDER_BUTTON)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bottomOrderButton);
        bottomOrderButton.click();

        // Заполнение строковых полей ввода
        driver.findElement(By.xpath(Order_firstPage.NAME_INPUT)).sendKeys(nameInput);
        driver.findElement(By.xpath(Order_firstPage.SURNAME_INPUT)).sendKeys(surnameInput);
        driver.findElement(By.xpath(Order_firstPage.ADDRESS_INPUT)).sendKeys(addressInput);

        selectMetroStation(stationNameInput); // Вызываем метод, который инициализирован ранее.
        // Тестовые данные (Названия станций метро) переданы в параметризации

        driver.findElement(By.xpath(Order_firstPage.PHONE_NUMBER_INPUT)).sendKeys(phoneNumberInput);

        // Нажатие кнопки "Далее"
        WebElement nextButton = driver.findElement(By.xpath(Order_firstPage.NEXT_BUTTON));
        nextButton.click();

        System.out.println("Все данные заполнились без ошибок, выполнен переход на вторую страницу оформления заказа");

        // Ожидание загрузки элемента на второй странице
        WebElement orderButton = driver.findElement(By.xpath(Order_secondPage.ORDER_BUTTON));

        // Заполнение данных на второй странице
        driver.findElement(By.xpath(Order_secondPage.DATE_OF_DELIVERY)).sendKeys(dateOfDelivery);
        driver.findElement(By.xpath(Order_secondPage.DATE_OF_DELIVERY)).sendKeys(Keys.ENTER);

        selectColor(scooterColour); // Вызываем метод, который инициализирован ранее.
        // Если нужен цвет "Черный" / "Черный жемчуг", в тестовых параметрах необходимо вписать слово "Черный" (соблюдать регистр)
        // Если нужен цвет "Серый" / "Серая безысходность", в тестовых параметрах необходимо вписать слово "Серый" (соблюдать регистр)
        // Если нужны оба цвета, в тестовых параметрах необходимо вписать слова "Все цвета" (соблюдать регистр)

        selectRentDurationInDays(rentalPeriod); // Вызываем метод, который инициализирован ранее.
        // Тестовые данные (Количество дней аренды) переданы в параметризации.
        // Указывать нужно целым числом. "Сутки" = 1, "Семеро суток" = 7.
        driver.findElement(By.xpath(Order_secondPage.COMMENT)).sendKeys(comment);

        // Нажатие кнопки "Заказать" на второй странице
        orderButton.click();

        System.out.println("Все данные на второй странице заполнились без ошибок");

        WebElement daButton = driver.findElement(By.xpath(Order_lastPage.CONFIRM_ORDER_BUTTON));
        daButton.click();

        WebDriverWait SuccessfullOrderWindow = new WebDriverWait(driver, 3);
        SuccessfullOrderWindow.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Order_lastPage.CONFIRMED_ORDER_WINDOW)));

        WebElement titleOrder = driver.findElement(By.xpath(Order_lastPage.TITLE_ORDER_CONFIRMED));

        String expectedOrderConfirmedTitle = "Заказ оформлен";

        Assert.assertTrue(titleOrder.getText().contains(expectedOrderConfirmedTitle));

        System.out.println("Заказ выполнен успешно, никаких ошибок нет");

    }
    @After
    public void tearDown() {
        // Закрытие браузера после завершения всех тестов
        driver.quit();
    }
}

