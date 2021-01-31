package ru.stqa.pft.addressbookTest4.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbookTest4.model.GroupDate;

public class CreateGroup extends TestBase{


    @Test
    public void testUntitledTestCase() throws Exception {
        app.clickGroup();
        app.newGroup();
        app.fillNewGroup(new GroupDate("111", "1112", "1113"));
        app.saveNewGroup();
        app.returnGroup();
    }


}
