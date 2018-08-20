import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.Thread.sleep;

public class Main extends CookieClickerBot {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "/Users/georgexu/Desktop/libraries/geckodriver");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver();

        try {
            sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.get("http://orteil.dashnet.org/cookieclicker/");

        try {
            sleep(9000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("starting up the bot!");
        CookieClickerBot letsClick = new CookieClickerBot();
        letsClick.cyaCookieWarning();
        letsClick.cookieClick();
    }
}
