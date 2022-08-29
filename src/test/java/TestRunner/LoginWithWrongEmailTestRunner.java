package TestRunner;

import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;
import pages.LoginWithWrongEmail;

import java.io.IOException;

@Test
public class LoginWithWrongEmailTestRunner {
    public void callingLoginWithWrongEmailAPI() throws ConfigurationException, IOException {
        LoginWithWrongEmail loginWithWrongEmail=new LoginWithWrongEmail();
        loginWithWrongEmail.callingLoginWithWrongEmailAPI();
    }
}
