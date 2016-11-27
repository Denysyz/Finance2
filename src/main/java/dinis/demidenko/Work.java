package dinis.demidenko;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Created by dende on 25.11.2016.
 */
public class Work {
    DataBase db = new DataBase();

    public void add(JTextField t1, JTextField t2, String table){
        String g = t2.getText();
        int c = Integer.parseInt(t1.getText());
        String query = ("INSERT INTO " + table + "(count, good) Values(" + c + ", '" + g + "');");
        db.addBD(query);

    }


}
