package TestRunner;

import org.testng.annotations.Test;
import pages.GetUserList;

import java.io.IOException;


@Test
public class GetUserListTestRunner {
    public void getUserList() throws IOException {
        GetUserList list=new GetUserList();
        list.callingGetUserListAPI();
    }
}
