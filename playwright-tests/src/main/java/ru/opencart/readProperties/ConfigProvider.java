package ru.opencart.readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String MAINPAGE = config.getString("mainPage");
    String USER_EMAIL = config.getString("userParams.email");
    String USER_PASSWORD = config.getString("userParams.password");

    String BROWSER = config.getString("browser");
    int REG_DATA_COUNT = config.getInt("regDataCount");


}
