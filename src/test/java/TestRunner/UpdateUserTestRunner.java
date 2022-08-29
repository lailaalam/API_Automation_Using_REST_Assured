package TestRunner;

import org.testng.annotations.Test;
import pages.UpdateUser;

import java.io.IOException;

public class UpdateUserTestRunner {

   @Test
    public void updateUser() throws IOException {
        UpdateUser updateUser=new UpdateUser();
        updateUser.callingUpdateUserAPI();
    }
}
