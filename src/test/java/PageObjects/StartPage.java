package PageObjects;

public class StartPage {
                                                                    // 1. Вопросы о важном
    public static final String FIRST_QUESTION = "//div[@id='accordion__heading-0' and @class='accordion__button' and text()='Сколько это стоит? И как оплатить?']\n"; // Первый вопрос
    public static final String SECOND_QUESTION = "//div[@id='accordion__heading-1' and @class='accordion__button' and text()='Хочу сразу несколько самокатов! Так можно?']\n";
    public static final String THIRD_QUESTION = "//div[@id='accordion__heading-2' and @class='accordion__button' and text()='Как рассчитывается время аренды?']\n";  // Третий вопрос
    public static final String FOURTH_QUESTION = "//div[@id='accordion__heading-3' and @class='accordion__button' and text()='Можно ли заказать самокат прямо на сегодня?']\n"; // Четвертый вопрос
    public static final String FIFTH_QUESTION = "//div[@id='accordion__heading-4' and @class='accordion__button' and text()='Можно ли продлить заказ или вернуть самокат раньше?']\n";  // Пятый вопрос
    public static final String SIXTH_QUESTION = "//div[@id='accordion__heading-5' and @class='accordion__button' and text()='Вы привозите зарядку вместе с самокатом?']\n";  // Шестой вопрос
    public static final String SEVENTH_QUESTION = "//div[@id='accordion__heading-6' and @class='accordion__button' and text()='Можно ли отменить заказ?']\n";  // Седьмой вопрос
    public static final String EIGHTH_QUESTION = "//div[@id='accordion__heading-7' and @class='accordion__button' and text()='Я жизу за МКАДом, привезёте?']\n";  // Восьмой вопрос

    public static final String FIRST_ANSWER = "//p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']\n";  // Ответ на первый вопрос
    public static final String SECOND_ANSWER = "//p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']\n";  // Ответ на второй вопрос
    public static final String THIRD_ANSWER = "//p[text()='Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.']\n";  // Ответ на третий вопрос
    public static final String FOURTH_ANSWER = "//p[text()='Только начиная с завтрашнего дня. Но скоро станем расторопнее.']\n";  // Ответ на четвертый вопрос
    public static final String FIFTH_ANSWER = "//p[text()='Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.']\n";  // Ответ на пятый вопрос
    public static final String SIXTH_ANSWER = "//p[text()='Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.']\n";  // Ответ на шестой вопрос
    public static final String SEVENTH_ANSWER = "//p[text()='Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.']\n";  // Ответ на седьмой вопрос
    public static final String EIGHTH_ANSWER = "//p[text()='Да, обязательно. Всем самокатов! И Москве, и Московской области.']\n";  // Ответ на восьмой вопрос

                                                                        // 2. Оформление заказа

    public static final String TOP_ORDER_BUTTON = "//button[@class='Button_Button__ra12g']\n";  // Кнопка "Заказать", расположенная вверху страницы
    public static final String BOTTOM_ORDER_BUTTON = "//button[@class='Button_Button__ra12g Button_UltraBig__UU3Lp']\n";  // Кнопка "Заказать", расположенная внизу экрана
}
