package dinis.demidenko;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dende on 25.11.2016.
 */
public class Face {
    Work w = new Work();
    DataBase db = new DataBase();

    JFrame frame = new JFrame("Finance");
    JFrame frameSetting = new JFrame("setting");

    JTextField textCountGood = new JTextField();
    JTextField textNameGood = new JTextField();
    JTextField textCountProfit = new JTextField();
    JTextField textNameProfit = new JTextField();

    JLabel labelTextCountOne = new JLabel("Сума:");
    JLabel labelTextCountTwo = new JLabel("Сума:");
    JLabel labelTextNameOne = new JLabel("Затрата:");
    JLabel labelTextNameTwo = new JLabel("Прибуток:");
    JLabel labelTextCardOne = new JLabel("З картки");
    JLabel labelTextCardTwo = new JLabel("На картку");
    JLabel labelOnHand = new JLabel("На руках ???");
    JLabel labelOnline = new JLabel("Онлай ???");
    JLabel labelTogether = new JLabel("Разом ???");

    JButton buttonOkGood = new JButton("OK!");
    JButton buttonOkProfit = new JButton("OK!");

    JCheckBox checkBoxCardGood = new JCheckBox();
    JCheckBox checkBoxCardProfit = new JCheckBox();



    
    public void face(){
        frame.setSize(550, 200);
        frame.setLayout(null);

        frameSetting.setLayout(null);

        /////

        textCountGood.setBounds(50, 10, 50, 20);
        frame.add(textCountGood);

        textNameGood.setBounds(180, 10, 150, 20);
        frame.add(textNameGood);

        textCountProfit.setBounds(50, 40, 50, 20);
        frame.add(textCountProfit);

        textNameProfit.setBounds(180, 40, 150, 20);
        frame.add(textNameProfit);

        ///////

        labelTextCountOne.setBounds(10,8,40,20);
        frame.add(labelTextCountOne);

        labelTextNameOne.setBounds(120,8,60,20);
        frame.add(labelTextNameOne);

        labelTextCountTwo.setBounds(10,38,40,20);
        frame.add(labelTextCountTwo);

        labelTextNameTwo.setBounds(115,38,60,20);
        frame.add(labelTextNameTwo);

        labelTextCardOne.setBounds(340, 8, 60, 20);
        frame.add(labelTextCardOne);

        labelTextCardTwo.setBounds(340, 38, 60, 20);
        frame.add(labelTextCardTwo);


        labelOnHand.setBounds(10,70, 150, 20);
        labelOnHand.setText("На руках: " + String.valueOf(db.up("profit") - db.up("fin")) + " грн.");
        frame.add(labelOnHand);

        labelOnline.setBounds(10,100, 150, 20);
        labelOnline.setText("Онлайн: " + String.valueOf(db.up("profitCard") - db.up("finCard")) + " грн.");
        frame.add(labelOnline);

        labelTogether. setBounds(10, 130, 150, 20);
        labelTogether.setText("Разом: " + String.valueOf(db.up("profit") - db.up("fin") + (db.up("profitCard")
                - db.up("finCard"))) + " грн.");
        frame.add(labelTogether);

        //////

        buttonOkGood.setBounds(430, 10, 60, 20);
        frame.add(buttonOkGood);

        buttonOkProfit.setBounds(430, 40, 60, 20);
        frame.add(buttonOkProfit);

        //////

        checkBoxCardGood.setBounds(400, 10, 20, 20);
        frame.add(checkBoxCardGood);

        checkBoxCardProfit.setBounds(400, 40, 20, 20);
        frame.add(checkBoxCardProfit);

        ///

        buttonOkGood.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(checkBoxCardGood.isSelected()){
                    w.add(textCountGood, textNameGood, "finCard");
                    labelOnline.setText("Онлайн: " + String.valueOf(db.up("profitCard") - db.up("finCard")) + " грн.");
                }else{
                    w.add(textCountGood, textNameGood, "fin");
                    labelOnHand.setText("На руках: " + String.valueOf(db.up("profit") - db.up("fin")) + " грн.");
                }
                labelTogether.setText("Разом: " + String.valueOf(db.up("profit") - db.up("fin") + (db.up("profitCard")
                        - db.up("finCard"))) + " грн.");
                textCountGood.setText("");
                textNameGood.setText("");
                textCountProfit.setText("");
                textNameProfit.setText("");
            }
        });

        buttonOkProfit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(checkBoxCardProfit.isSelected()){
                    w.add(textCountProfit, textNameProfit, "profitCard");
                    labelOnline.setText("Онлайн: " + String.valueOf(db.up("profitCard") - db.up("finCard")) + " грн.");
                }else {
                    w.add(textCountProfit, textNameProfit, "profit");
                    labelOnHand.setText("На руках: " + String.valueOf(db.up("profit") - db.up("fin")) + " грн.");
                }
                labelTogether.setText("Разом: " + String.valueOf(db.up("profit") - db.up("fin") + (db.up("profitCard")
                        - db.up("finCard"))) + " грн.");
                textCountGood.setText("");
                textNameGood.setText("");
                textCountProfit.setText("");
                textNameProfit.setText("");
            }
        });
        frame.setVisible(true);

    }

}
