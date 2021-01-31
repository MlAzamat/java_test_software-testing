package ru.stqa.pft.addressbookTest4;

import org.testng.annotations.Test;

public class CreateGroup extends TestBase{


    @Test
    public void testUntitledTestCase() throws Exception {
        clickGroup();
        newGroup();
        fillNewGroup(new GroupDate("111", "1112", "1113"));
        saveNewGroup();
        returnGroup();
    }


}
