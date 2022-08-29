package TestRunner;

import org.testng.annotations.Test;
import pages.SearchUser;

import java.io.IOException;

@Test
public class SearchUserTestRunner {
    public void callingSearchUserAPI() throws IOException {
        SearchUser searchUser=new SearchUser();
        searchUser.callingSearchUserAPI();
    }
}
