package PageObjects;

public class Order_lastPage {

                                                //                "Всплывающие окна"

    public static final String CONFIRM_ORDER_BUTTON = "//button[contains(text(), 'Да') and contains(@class, 'Button_Button__ra12g') and contains(@class, 'Button_Middle__1CSJM')]\n"; // Кнопка "Да" для подтверждения заказа во всплывающем окне "Хотите оформить заказ?"
    public static final String CONFIRMED_ORDER_WINDOW = "//div[contains(@class,'Order_Modal') and .//button[contains(@class, 'Button_Middle__1CSJM') and text()='Посмотреть статус']]"; // Всплывающее окно с текстом, указывающее на то, что заказ оформлен
    public static final String TITLE_ORDER_CONFIRMED = "//div[@class='Order_ModalHeader__3FDaJ']"; // Заголовок "Заказ подтвержден"
}
