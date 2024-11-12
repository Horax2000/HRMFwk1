package src;

import org.HRMFwk.Architecture.BaseTest;
import org.HRMFwk.Pages.LoginPage;
import org.HRMFwk.Setup.Config;
import org.testng.annotations.Test;

public class LoginSteps extends BaseTest {

    @Test
    public void LandingPage(){
        LoginPage loginPage = new LoginPage(this.driver);
        driver.get(Config.BASE_URL.getValue());
    }
}
