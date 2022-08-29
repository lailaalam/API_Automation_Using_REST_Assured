package TestRunner;

import org.testng.annotations.Test;
import pages.SearchUserWithoutPWKey;

import java.io.IOException;

@Test
public class SearchUserwithoutPWKeyTestRunner {
    public void callingSearchUserAPI() throws IOException {
        SearchUserWithoutPWKey searchUser=new SearchUserWithoutPWKey();
        searchUser.callingSearchUserAPI();
    }
}
