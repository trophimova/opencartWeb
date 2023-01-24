package ru.opencart.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.opencart.appmanager.RegistrationHelper;
import ru.opencart.model.RegData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class RegistrationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validRegistrationFromJson() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/regdata.json")))) {
            String json = "";
            String line = reader.readLine();
            while (line != null) {
                json += line;
                line = reader.readLine();
            }
            Gson gson = new Gson();

            List<RegData> regs = gson.fromJson(json, new TypeToken<List<RegData>>() {
            }.getType());
            return regs.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }


    @DataProvider
    public Iterator<Object[]> validRegistrationFromCsv() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/main/resources/regdata.csv")))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(";");
                list.add(new Object[]{new RegData()
                        .withUserFirstname(split[0])
                        .withUserLastname(split[1])
                        .withEmail(split[2])
                        .withTelephone(split[3])
                        .withPassword(split[4])
                        .withConfirmPassword(split[5])
                });
                line = reader.readLine();
            }
            return list.iterator();
        }
    }

    @AfterMethod
    public void signOut() {
        app.goTo().signOut();
    }

    @Test(dataProvider = "validRegistrationFromJson")
    @Owner("Анна Трофимова")
    @Description("Тест проверяет, что после ввода пользователем валидных данных и подтверждения регистрации, пользователь видит сообщение об успешной регистрации")
    @Link("https://github.com/trophimova/opencartWeb")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Проверка успешной регистрации")
    public void testPositiveRegistration(RegData reg) throws InterruptedException {

        app.goTo().goToMainPage();
        app.goTo().goToRegPage();
        int count = app.registration().count(By.className("form-control"));
        app.registration().setValidRegistration(reg);
        assertThat(6, equalTo(count - 1));

        app.registration().title();
        String nameTitle = app.registration().getNameTitle();
        assertThat(nameTitle, equalTo(RegistrationHelper.successRegMessage));
    }


}
