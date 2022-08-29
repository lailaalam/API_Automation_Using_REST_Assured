package TestRunner;

import org.testng.annotations.Test;
import pages.DeletedUserSearch;

import java.io.IOException;

@Test
public class DeletedUserSearchTestRunner {
    public void searchDeletedAPI() throws IOException {
        DeletedUserSearch deletedUserSearch=new DeletedUserSearch();
        deletedUserSearch.searchDeletedAPI();
    }
}
