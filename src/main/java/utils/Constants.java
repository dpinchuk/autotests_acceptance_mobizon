package utils;

/**
 * @Author Pinchuk Dmitry (QA) (Mobizon GMBH)
 * @Project: 'autotests_gui_mobizon'
 * Interface with constants
 */
public interface Constants {

    String SB_URL = "http://kz.z.mobizon.net.ua/";

    String PROPERTY_CHROM_DRIVER = "webdriver.chrome.driver";
    String PROPERTY_FIREFOX_DRIVER = "webdriver.gecko.driver";

    String WEB_DRIVER = "Chrom"; // "Chrom", "Firefox", "Phantom"
    String OS = "Windows"; // "Windows", "Linux"

    String PATH_TO_CHROM_DRIVER_LINUX = "src/main/resources/webDrivers/chromedriver";
    String PATH_TO_PHANTOM_DRIVER_LINUX = "src/main/resources/webDrivers/phantomjs";
    String PATH_TO_FIREFOX_DRIVER_LINUX = "src/main/resources/webDrivers/geckodriver";
    String PATH_TO_CHROM_DRIVER_WINDOWS = "src/main/resources/webDrivers/chromedriver.exe";
    String PATH_TO_PHANTOM_DRIVER_WINDOWS = "src/main/resources/webDrivers/phantomjs.exe";
    String PATH_TO_FIREFOX_DRIVER_WINDOWS = "src/main/resources/webDrivers/geckodriver.exe";

    /* Активные пользователи */
    // id=2688
    String[] USER_2688 = {
            "2688", //0
            "380968353340", //1
            "dmss.dndz.dap@mail.ru", //2
            "01010888", //3
            "active", //4
            "Базовая KZ 1M+", //5
            "user(global)", //6
            "kzad6725571c36348be5744b3579b1d8cbebcdd040b32df7fff16e9d80ba1220636527" //7
    };

}