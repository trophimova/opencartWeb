package ru.opencart.appmanager;


import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import ru.opencart.model.RegData;

public class RegistrationHelper extends HelperBase {



    public RegistrationHelper(Page page) {
        super(page);
    }


    public void setValidRegistration(RegData regData) {
        fillRegForm(regData);
        confirmRegForm();
    }

    private void confirmRegForm() {
        submit.click();
    }

    private void fillRegForm(RegData regData) {
        inputFirstname.fill(regData.getUserFirstName());
        inputLastname.fill(regData.getUserLastName());
        inputEmail.fill(regData.getEmail());
        inputTelephone.fill(regData.getTelephone());
        inputPassword.fill(regData.getPassword());
        inputConfirm.fill(regData.getPasswordConfirm());
        checkbox.click();
    }

    public String getTitleName() {
        return title.textContent();
    }

    Locator inputFirstname = page.locator("xpath=.//input[@id='input-firstname']");
    Locator inputLastname = page.locator("xpath=.//input[@id='input-lastname']");
    Locator inputEmail = page.locator("xpath=.//input[@id='input-email']");
    Locator inputTelephone = page.locator("xpath=.//input[@id='input-telephone']");
    Locator inputPassword = page.locator("xpath=.//input[@id='input-password']");
    Locator inputConfirm = page.locator("xpath=.//input[@id='input-confirm']");
    Locator title = page.locator("xpath=.//div[@id='content']//h1");
    Locator submit = page.locator("xpath=.//input[@type='submit']");
    Locator checkbox = page.locator("xpath=.//input[@type='checkbox']");
    public static String successRegMessage = "Ваша учетная запись создана!";
}
