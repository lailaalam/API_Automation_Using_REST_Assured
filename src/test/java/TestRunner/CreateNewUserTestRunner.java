package TestRunner;

import org.apache.commons.configuration.ConfigurationException;
import org.testng.annotations.Test;
import pages.CreateNewUser;

import java.io.IOException;

public class CreateNewUserTestRunner {
    @Test
    public void createNewUser() throws IOException, ConfigurationException {
        CreateNewUser createNewUser=new CreateNewUser();
        createNewUser.callingCreateNewUserAPI();
    }
}
