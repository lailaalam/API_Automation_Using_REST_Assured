package TestRunner;

import org.testng.annotations.Test;
import pages.UpdateSpecificInfo;
import pages.UpdateUser;

import java.io.IOException;

public class UpdateSpecificInfoTestRunner {
    @Test
    public void updateSpecificInfo() throws IOException {
       UpdateSpecificInfo info =new UpdateSpecificInfo();
       info.callingUpdateSpecificUserAPI();
    }
}
