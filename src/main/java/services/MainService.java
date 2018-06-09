package services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static utils.Constants.*;

/**
 * @Author Pinchuk Dmitry (QA) (Mobizon GMBH)
 * @Project: 'autotests_gui_mobizon'
 * Main service class
 */
public class MainService {

    public static WebDriver driver;
    public static DesiredCapabilities caps;

    /**
     * Метод подготавливает тестовое окружения к выполению очередного автотеста
     */
    public static void initTestEnvironment() {
        /* Настройка тестовой среды */
        caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        /* Выбрать тестовое окружение (драйвер, OS) */
        selectTestEnvironment();
        System.out.println("Configure the web driver [" + WEB_DRIVER + "] for OS [" + OS + "] - successful!");
        /* Выполнить настройки страницы браузера */
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /* В командную строку браузера ввести URL-сайта и нажать <Enter> */
        driver.get(SB_URL);
    }

    /**
     * Метод выполняет настройку web-драйвера и браузера
     */
    private static void selectTestEnvironment() {
        /* Chrom */
        if ("Chrom".equals(WEB_DRIVER)) {
            System.setProperty(PROPERTY_CHROM_DRIVER,
                    OS.equals("Windows") ? PATH_TO_CHROM_DRIVER_WINDOWS : PATH_TO_CHROM_DRIVER_LINUX);
            driver = new ChromeDriver();
            /* Firefox */
        } else if ("Firefox".equals(WEB_DRIVER)) {
            System.setProperty(PROPERTY_FIREFOX_DRIVER,
                    OS.equals("Windows") ? PATH_TO_FIREFOX_DRIVER_WINDOWS : PATH_TO_FIREFOX_DRIVER_LINUX);
            driver = new FirefoxDriver();
            /* Phantom */
        } else {
            caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    OS.equals("Windows") ? PATH_TO_PHANTOM_DRIVER_WINDOWS : PATH_TO_PHANTOM_DRIVER_LINUX);
            driver = new PhantomJSDriver(caps);
        }
    }

}