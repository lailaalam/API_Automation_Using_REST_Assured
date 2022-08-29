package TestRunner;

import org.testng.annotations.Test;
import pages.GetUserListIfInputWrongToken;

import java.io.IOException;

@Test
public class GetUserListIfInputWrongTokenTestRunner {
     public void callingGetUserListIfInputWrongToken() throws IOException {
         GetUserListIfInputWrongToken getUserListIfInputWrongToken=new GetUserListIfInputWrongToken();
         getUserListIfInputWrongToken.callingGetUserListIfInputWrongToken();
     }
}
