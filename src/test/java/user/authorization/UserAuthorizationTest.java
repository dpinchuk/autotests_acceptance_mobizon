package user.authorization;

import org.junit.*;
import org.openqa.selenium.By;
import services.MainService;
import services.authorizationService.AuthorizationService;

import static org.junit.Assert.assertTrue;
import static utils.Constants.USER_2688;

/**
 * @Author Pinchuk Dmitry (QA) (Mobizon GMBH)
 * @Project: 'autotests_gui_mobizon'
 * Test class for check user authorization
 */
public class UserAuthorizationTest {

    /**
     * Подготовить тестовую среду
     */
    @BeforeClass
    public static void initEnvironment() {
        /*  */
    }

    /* Инициализировать тестовое окрыжение */
    @Before
    public void setUp() {
        /* Метод инициализирует окружение (ОС, браузер) */
        MainService.initTestEnvironment();
    }

    /**
     * Закрыть текущее окно браузера
     */
    @After
    public void tearDown() {
        /* Метод закрывает текущее окно браузера */
        MainService.driver.close();
    }

    /**
     * Завершить работу
     */
    @AfterClass
    public static void closeEnvironment() {
        /* Метод завершает работу всех процессов */
        MainService.driver.quit();
    }

    /**
     * @Negative #000
     * Description: Тест проверяет, что авторизация со всеми пустыми полями неуспешна.
     * <p>
     * Expected: отображено сообщение об ошибке с текстом: "Некоторые обязательные поля формы не заполнены."
     */
    @Test
    public void authorisationWithEmptyFieldsNegative() {
        System.out.println("#000. The test checks that the authorization with empty fields is unsuccessful.");
        // Выполненеие степов 1 - 5
        AuthorizationService.authorizationForm("", "", "empty");
        // 6. Клик на кнопку [Войти]
        System.out.println("Step 6. Click the button [Enter]");
        MainService.driver.findElement(By.xpath("//*[@id=\'btn-login\']")).click();
        // 7. Проверить, что настранице отображено сообщение об ошибке "Некоторые обязательные поля формы не заполнены."
        System.out.println("Step 7. Check that the page displays an error message 'Some required form fields are not filled.'");
        String id = MainService.driver.findElement(By.xpath("//*[@id=\"form_login\"]/div[1]/div[1]/div")).getText();
        assertTrue(id.equals("Поле должно быть заполнено."));
    }

    /**
     * @Positive #001
     * Description: Тест проверяет успешную авторизацию с логином типа mobilePhone
     * <p>
     * Expected: Открыта стартовая страница панели, на которой отображен id текущего пользователя
     */
    @Test
    public void authorisationLoginMobilePositive() {
        System.out.println("#001. The test checks the successful authorization with a login such as mobilePhone.");
        // Выполненеие степов 1 - 5
        AuthorizationService.authorizationForm(USER_2688[1], USER_2688[3], "mobile");
        // 6. Клик на кнопку [Войти]
        System.out.println("Step 6. Click the button [Enter]");
        MainService.driver.findElement(By.xpath("//*[@id=\'btn-login\']")).click();
        // 7. Проверить, что тестовый id пользователя совпадает с id, отображенным на сайте
        System.out.println("Step 7. Check that the user's test id matches the id displayed on the site");
        String id = MainService.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/a[7]/span/span/span[1]/div[2]")).getText();
        assertTrue(id.contains(USER_2688[0]));
    }

    /**
     * @Positive #002
     * Description: Тест проверяет успешную авторизацию с логином типа email
     * <p>
     * Expected: Открыта стартовая страница панели, на которой отображен id текущего пользователя
     */
    @Test
    public void authorisationLoginEmailPositive() {
        System.out.println("#002. The test checks the successful authorization with the login of the type email.");
        // Выполненеие степов 1 - 5
        AuthorizationService.authorizationForm(USER_2688[2], USER_2688[3], "email");
        // 6. Клик на кнопку [Войти]
        System.out.println("Step 6. Click the button [Enter]");
        MainService.driver.findElement(By.xpath("//*[@id=\'btn-login\']")).click();
        // 7. Проверить, что тестовый id пользователя совпадает с id, отображенным на сайте
        System.out.println("Step 7. Check that the user's test id matches the id displayed on the site");
        String id = MainService.driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/a[7]/span/span/span[1]/div[2]")).getText();
        assertTrue(id.contains(USER_2688[0]));
    }

    /**
     * @Negative #003
     * Description: Тест проверяет неуспешную авторизацию с несущесвующим логином (mobile)
     * <p>
     * Expected: Открыта страница авторизации, на которой отображено сообщение:
     * "Личность пользователя неопределена"
     */
    @Test
    public void authorisationLoginMobileNegative() {
        System.out.println("#003. The test checks for unsuccessful authorization with a fake login (mobile).");
        // Выполненеие степов 1 - 5
        AuthorizationService.authorizationForm("70000000000", "123456", "mobile");
        // 6. Клик на кнопку [Войти]
        System.out.println("Step 6. Click the button [Enter]");
        MainService.driver.findElement(By.xpath("//*[@id=\'btn-login\']")).click();
        // 7. Проверить, что на странице отоюражено сообщение об ошибке "Личность пользователя неопределена"
        boolean isTextInContent = false;
        System.out.println("Step 7. Check that the page has an error message 'The identity of the user is undefined'");
        MainService.driver.findElement(By.xpath("//html")).getText().contains("Личность пользователя неопределена");
        isTextInContent = MainService.driver.findElement(By.xpath("//html")).getText().contains("Личность пользователя неопределена");
        assertTrue(isTextInContent);
    }

    /**
     * @Negative #004
     * Description: Тест проверяет неуспешную авторизацию с несущесвующим логином (mobile)
     * <p>
     * Expected: Открыта страница авторизации, на которой отображено сообщение:
     * "Личность пользователя неопределена"
     */
    @Test
    public void authorisationLoginEmailNegative() {
        System.out.println("#003. The test checks for unsuccessful authorization with a fake login (email).");
        // Выполненеие степов 1 - 5
        AuthorizationService.authorizationForm("fake_email@test.com", "123456", "email");
        // 6. Клик на кнопку [Войти]
        System.out.println("Step 6. Click the button [Enter]");
        MainService.driver.findElement(By.xpath("//*[@id=\'btn-login\']")).click();
        // 7. Проверить, что на странице отоюражено сообщение об ошибке "Личность пользователя неопределена"
        boolean isTextInContent = false;
        System.out.println("Step 7. Check that the page has an error message 'The identity of the user is undefined'");
        MainService.driver.findElement(By.xpath("//html")).getText().contains("Личность пользователя неопределена");
        isTextInContent = MainService.driver.findElement(By.xpath("//html")).getText().contains("Личность пользователя неопределена");
        assertTrue(isTextInContent);
    }

}