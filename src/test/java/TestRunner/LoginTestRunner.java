package TestRunner;

import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;
import pages.LoginCustomer;

import java.io.IOException;

public class LoginTestRunner {
    @Test
    public void doLogin() throws ConfigurationException, IOException {
        LoginCustomer customer=new LoginCustomer();
        customer.callingLoginAPI();
    }
}
