package PageObjects;

public class Order_secondPage {

                                            //           "Про Аренду"

    public static final String DATE_OF_DELIVERY = "//input[@placeholder='* Когда привезти самокат']\n";  // Поле ввода "Когда привезти самокат"
    public static final String RENTAL_PERIOD = "//div[@class='Dropdown-placeholder' and contains(text(), '* Срок аренды')]\n";  // Поле ввода "Срок аренды"

    public static final String SCOOTER_COLOUR_BLACK = "//label[@for='black']/input[@id='black' and @type='checkbox']"; // Чек-бокс, черный цвет
    public static final String SCOOTER_COLOUR_GREY = "//label[@for='grey']/input[@id='grey' and @type='checkbox']\n"; // Чек-бокс, серый цвет
    public static final String COMMENT = "//input[@placeholder='Комментарий для курьера']\n"; // Поле ввода "Комментарий для курьера"
    public static final String ORDER_BUTTON = "//button[contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM') and text()='Заказать']\n"; // Кнопка "Заказать" для завершения оформления заказа

}

