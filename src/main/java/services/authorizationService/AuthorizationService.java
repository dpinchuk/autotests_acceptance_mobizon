package services.authorizationService;

import org.openqa.selenium.By;
import services.MainService;

/**
 * @Author Pinchuk Dmitry (QA) (Mobizon GMBH)
 * @Project: 'autotests_gui_mobizon'
 * Service class for user authorization
 */
public class AuthorizationService {

    /**
     * Метод выполняет заполнение полей формы авторизации данными и сабмит
     * @param login
     * @param password
     * @param loginType
     */
    public static void authorizationForm(String login, String password, String loginType) {
        // Preconditions: заполнение формы авторизации тестовыми данными
        System.out.println("[Preconditions] - filling out the authorization form with test data: login = " + loginType);
        // 1. Клик на кнопку [Вход]
        System.out.println("Step 1. Click the [Login] button");
        MainService.driver.findElement(By.xpath("//*[@id=\'btn-log\']")).click();
        // 2. Очистить поле ввода логина (номер или email)
        System.out.println("Step 2. Clear login field");
        MainService.driver.findElement(By.xpath("//*[@id=\'email\']")).clear();
        // 3. Ввести тестовый логин
        System.out.println("Step 3. Enter test login: " + login);
        MainService.driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys(login);
        // 4. Очистить поле ввода пароля
        System.out.println("Step 4. Clear password field");
        MainService.driver.findElement(By.xpath("//*[@id=\'password\']")).clear();
        // 5. Ввести пароль
        System.out.println("Step 5. Enter password: " + password);
        MainService.driver.findElement(By.xpath("//*[@id=\'password\']")).sendKeys(password);
    }

}