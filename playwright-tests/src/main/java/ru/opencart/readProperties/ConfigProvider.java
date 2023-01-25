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

    String MAINPAGE = readConfig().getString("mainPage");
    String USER_EMAIL = readConfig().getString("userParams.email");
    String USER_PASSWORD = readConfig().getString("userParams.password");



}
