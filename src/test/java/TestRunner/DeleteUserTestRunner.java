package TestRunner;

import org.testng.annotations.Test;
import pages.DeleteAUser;

import java.io.IOException;

public class DeleteUserTestRunner {
    @Test
    public void deleteUser() throws IOException {
        DeleteAUser user=new DeleteAUser();
        user.callingDeleteUserAPI();
    }
}
