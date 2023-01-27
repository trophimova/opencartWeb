package ru.opencart.appmanager;


import com.microsoft.playwright.Browser;
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
        page.click(submit);
    }

    private void fillRegForm(RegData regData) {
        page.fill(inputFirstname, regData.getUserFirstName());
        page.fill(inputLastname, regData.getUserLastName());
        page.fill(inputEmail, regData.getEmail());
        page.fill(inputTelephone, regData.getTelephone());
        page.fill(inputPassword, regData.getPassword());
        page.fill(inputConfirm, regData.getPasswordConfirm());
        page.click(checkbox);
    }

    public String getTitleName() {
        return page.locator(title).textContent();
    }

    private final String inputFirstname = "xpath=.//input[@id='input-firstname']";
    private final String inputLastname = "xpath=.//input[@id='input-lastname']";
    private final String inputEmail = "xpath=.//input[@id='input-email']";
    private final String inputTelephone = "xpath=.//input[@id='input-telephone']";
    private final String inputPassword = "xpath=.//input[@id='input-password']";
    private final String inputConfirm = "xpath=.//input[@id='input-confirm']";

    private final String title = "xpath=.//div[@id='content']//h1";

    private final String submit = "xpath=.//input[@type='submit']";
    public static String successRegMessage = "Ваша учетная запись создана!";
    private String checkbox = "xpath=.//input[@type='checkbox']";
}
