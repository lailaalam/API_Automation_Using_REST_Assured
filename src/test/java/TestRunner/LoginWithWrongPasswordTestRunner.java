package TestRunner;

import org.testng.annotations.Test;
import pages.LoginWithWrongPassword;

import java.io.IOException;

@Test
public class LoginWithWrongPasswordTestRunner {
    public void callingLoginWithWrongPasswordAPI() throws IOException {
        LoginWithWrongPassword loginWithWrongPassword=new LoginWithWrongPassword();
        loginWithWrongPassword.callingLoginWithWrongPasswordAPI();
    }
}
