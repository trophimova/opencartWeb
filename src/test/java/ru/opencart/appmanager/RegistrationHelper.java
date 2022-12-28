package ru.opencart.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.opencart.model.RegData;

import java.util.ArrayList;
import java.util.List;

public class RegistrationHelper extends HelperBase {

    public RegistrationHelper(WebDriver wd) {
        super(wd);
    }

    public void registration() {
        fillRegForm(new RegData()
                .withUserFirstname("Cthutq")
                .withUserLastname("sdfghjkl")
                .withEmail("tetggok9888st@mail.ru")
                .withTelephone("88888888")
                .withPassword("123456")
                .withConfirmPassword("123456"));
        confirmRegForm();
    }

    public void confirmRegForm() {
        click(By.cssSelector(".btn-primary"));
    }

    public void fillRegForm(RegData regData) {
        type(By.id("input-firstname"), regData.getUserFirstname());
        type(By.id("input-lastname"), regData.getUserLastname());
        type(By.id("input-email"), regData.getEmail());
        type(By.id("input-telephone"), regData.getTelephone());
        type(By.id("input-password"), regData.getPassword());
        type(By.id("input-confirm"), regData.getConfirmPassword());
        click(By.name("agree"));
    }


//    public List<RegData> getRegList() {
//        List<RegData> regs = new ArrayList<RegData>();
//        List<WebElement> elements = wd.findElements(By.className("form-control"));
//        for (WebElement element : elements) {
//            String name = element.getText();
//            RegData reg = new RegData(name, name, name, name, name, name);
//            regs.add(reg);
//        }
//        return regs;
//    }
}
