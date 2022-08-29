package TestRunner;

import org.testng.annotations.Test;
import pages.GetUserListIfUserDoesnotInputToken;

import java.io.IOException;

@Test
public class GetUserListIfUserDoesNotInputTokenTestRunner {

    public void callingGetUserListWithoutToken() throws IOException {
        GetUserListIfUserDoesnotInputToken getUserListIfUserDoesnotInputToken=new GetUserListIfUserDoesnotInputToken();
        getUserListIfUserDoesnotInputToken.callingGetUserListAPIWithoutInputtingToken();
    }
}
