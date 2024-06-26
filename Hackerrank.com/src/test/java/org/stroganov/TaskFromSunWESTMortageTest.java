package org.stroganov;

import org.junit.jupiter.api.Test;
import org.stroganov.west_mortage.TaskFromSunWESTMortage;

import static org.junit.jupiter.api.Assertions.*;

class TaskFromSunWESTMortageTest {

    TaskFromSunWESTMortage taskFromSunWESTMortage = new TaskFromSunWESTMortage();
    @Test
    void createHTMLTableTest() {
        String result = taskFromSunWESTMortage.createHTMLTable(
                "1,100,2,200,3,303,4,400,5,500,6,600:column1;1,50,2,150,3,250,4,350,5,450,6,550: column2; 1, 10, 2, 20, 3,\n" +
                "30, 4, 40, 5, 50, 6, 60: column3");
        assertEquals("<table border=\"1\"><tr><th>-</th><th>column1</th><th> column2</th><th> column3</th></tr><tr><td>1</td><td>100</td><td>50</td><td>10</td></tr><tr><td>2</td><td>200</td><td>150</td><td>20</td></tr><tr><td>3</td><td>303</td><td>250</td><td>30</td></tr><tr><td>4</td><td>400</td><td>350</td><td>40</td></tr><tr><td>5</td><td>500</td><td>450</td><td>50</td></tr><tr><td>6</td><td>600</td><td>550</td><td>60</td></tr></table>", result);
    }
}