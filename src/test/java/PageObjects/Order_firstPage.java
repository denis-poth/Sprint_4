package PageObjects;

public class Order_firstPage {

                                     //                     "Для кого самокат"

    public static final String NAME_INPUT = "//input[@placeholder='* Имя']\n";  // Поле ввода "Имя"
    public static final String SURNAME_INPUT = "//input[@placeholder='* Фамилия']\n";  // Поле ввода "Фамилия"
    public static final String ADDRESS_INPUT = "//input[@placeholder='* Адрес: куда привезти заказ']\n"; // Поле ввода "Адресс"
    public static final String METRO_STATION_INPUT = "//input[@class='select-search__input' and @placeholder='* Станция метро']\n"; // Поле ввода "Станция метро"
    public static final String PHONE_NUMBER_INPUT = "//input[@placeholder='* Телефон: на него позвонит курьер']\n"; // Поле ввода "Номер телефона"
    public static final String NEXT_BUTTON = "//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Далее']\n"; // Кнопка "Дальее" для перехода на вторую страницу оформления заказа
}
