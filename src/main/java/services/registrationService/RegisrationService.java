package services.registrationService;

import org.openqa.selenium.By;
import services.MainService;

/**
 * @Author Pinchuk Dmitry (QA) (Mobizon GMBH)
 * @Project: 'autotests_gui_mobizon'
 * Service class for user registration
 */
public class RegisrationService {

    public static void registrationForm(String name, String lastname, String email, String phone, String password, String confirm, boolean checkbox) {
        // Preconditions: заполнение формы регистрации тестовыми данными
        System.out.println("[Preconditions] - filling out the registration form with test data");
        // 1. Клик на кнопку [Вход]
        System.out.println("Step 1. Click the [Login] button");
        MainService.driver.findElement(By.xpath("//*[@id=\'btn-log\']")).click();
        // 2. Очистить поле ввода имени
        System.out.println("Step 2. Clear name input field");
        MainService.driver.findElement(By.xpath("//*[@id=\'registration_name\']")).clear();
        // 3. Заполнить поле имени тестовым значением
        System.out.println("Step 3. Enter test login: " + name);
        MainService.driver.findElement(By.xpath("//*[@id=\'email\']")).sendKeys(name);
    }

}