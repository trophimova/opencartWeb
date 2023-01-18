package ru.opencart.tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import ru.opencart.appmanager.RegistrationHelper;
import ru.opencart.model.RegData;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class RegistrationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validRegistration() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/regdata.csv")));
        //BufferedReader reader = new BufferedReader(new FileReader("src/resources/regdata.csv"));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(";");
            list.add(new Object[]{ new RegData()
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

    @AfterMethod
    public void signOut() {
        app.goTo().signOut();
    }

    @Test(dataProvider = "validRegistration")
    public void testPositiveRegistration(RegData reg) throws InterruptedException {

        app.goTo().gotoMainPage();
        app.goTo().gotoRegPage();
        int count = app.registration().count(By.className("form-control"));
        app.registration().setValidRegistration(reg);
        assertThat(6, equalTo(count - 1));

        app.registration().title();
        String nameTitle = app.registration().getNameTitle();
        assertThat(nameTitle, equalTo(RegistrationHelper.successRegMessage));
    }


}
