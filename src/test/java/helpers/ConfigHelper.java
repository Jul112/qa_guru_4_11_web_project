package helpers;

import config.AuthorizationConfig;
import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    //рализуем из интерфейса AuthorizationConfig объект, через который можно будет обратиться к методам интерфейса AuthorizationConfig:
    private static AuthorizationConfig getAuthorizationConfig() {
        return ConfigFactory.newInstance().create(AuthorizationConfig.class, System.getProperties());
    }
    //рализуем из интерфейса WebConfig объект, через который можно будет обратиться к методам интерфейса WebConfig:
    private static WebConfig getWebConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }

    //AuthorizationConfig
    public static String getGoogleUsername() {
        return getAuthorizationConfig().googleUsername();
    }

    public static String getGooglePassword() {
        return getAuthorizationConfig().googlePassword();
    }

    //WebConfig
    public static String getWebRemoteDriver() { //"web.remote.driver" будем задавать через терминал или через jenkins, приходит в формате "https://%s:%s@selenoid.autotests.cloud"
        return String.format(System.getProperty("web.remote.driver"),
                getWebConfig().webRemoteDriverUser(),
                getWebConfig().webRemoteDriverPassword());
        //="https://user:password@selenoid.autotests.cloud"
    }

    public static boolean isRemoteWebDriver() {
        return System.getProperty("web.remote.driver")!=null; //уточняем наличие значения удаленного вебдрайвера
    }

    public static String getWebUrl() {
        return getWebConfig().webUrl();
    }

    //Video Storage
    public static String getWebVideoStorage() {
        return System.getProperty("video.storage");
    }

    public static boolean isVideoOn() {
        return getWebVideoStorage()!=null;
    }
}
