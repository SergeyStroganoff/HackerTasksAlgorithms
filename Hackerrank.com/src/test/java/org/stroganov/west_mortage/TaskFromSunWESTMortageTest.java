package org.stroganov.west_mortage;

import org.junit.jupiter.api.Test;

class TaskFromSunWESTMortageTest {

    private TaskFromSunWESTMortage taskFromSunWESTMortage = new TaskFromSunWESTMortage();

    @Test
    void createHTMLTable() {
        taskFromSunWESTMortage.createHTMLTable("1,100,2,200,3,303,4,400,5,500,6,600:column1;1,50,2,150,3,250,4,350,5,450,6,550: column2;1,10,2,20,3," +
                "30,4,40,5,50,6,60:column3");
    }
}