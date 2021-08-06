/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storemanagerguiview;

import controller.Backend_DAO_List;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Customer;

/**
 *
 * @author student
 */
public class AddNewCustomerForm extends JFrame {

    private JButton jButtonOK;
    private JLabel jLabelID;
    private JLabel jLabelName;
    private JLabel jLabelAddress;
    private JTextField jTextFieldID;
    private JTextField jTextFieldName;
    private JTextField jTextFieldAddress;

    public AddNewCustomerForm() {
        jButtonOK = new JButton("אישור");
        jLabelID = new JLabel("מספר זהות:");
        jLabelName = new JLabel("שם:");
        jLabelAddress = new JLabel("כתובת:");
        jTextFieldID = new JTextField();
        jTextFieldName = new JTextField();
        jTextFieldAddress = new JTextField();

        getContentPane().add(jTextFieldID);
        getContentPane().add(jLabelID);

        getContentPane().add(jTextFieldName);
        getContentPane().add(jLabelName);

        getContentPane().add(jTextFieldAddress);
        getContentPane().add(jLabelAddress);

        getContentPane().add(jButtonOK);
        this.setPreferredSize(new Dimension(400, 200)); //גודל חלון
        getContentPane().setLayout(new GridLayout(0, 2, 10, 10)); //מנהל פרישה טבלאית
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();  // סידור הרכבים באופן פורפציונלי
        Font f = new Font("Calibri Light", 1, 18);

        jButtonOK.setFont(f);
        jLabelID.setFont(f);
        jLabelAddress.setFont(f);
        jLabelName.setFont(f);
        jTextFieldID.setFont(f);
        jTextFieldName.setFont(f);
        jTextFieldAddress.setFont(f);

        jButtonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    if (jTextFieldID.getText().isEmpty()) {
                        throw new Exception("מלא מספר זהות");
                    }

                    if (jTextFieldID.getText().length() != 9) {
                        throw new Exception("אורך מספר זהות לא תקין");
                    }
                    String tz = jTextFieldID.getText();
                    if (jTextFieldName.getText().isEmpty()) {
                        throw new Exception("מלא שם");
                    }
                    for (int i = 0; i < 9; i++) {
                        if (tz.charAt(i) < '0' || tz.charAt(i) > '9') {
                            throw new Exception("מספר זהות לא תקין");
                        }
                        //איך להשתמש בקיפרס
                    }
                    Customer c = new Customer(
                            Long.parseLong(jTextFieldID.getText()),
                            jTextFieldName.getText(),
                            jTextFieldAddress.getText());
                    Backend_DAO_List.GetBackend_DAO_List().AddCustomer(c);
                    jTextFieldAddress.setText("");
                    jTextFieldName.setText("");
                    jTextFieldName.setText("");
                    jTextFieldAddress.setText("");

                    JOptionPane.showMessageDialog(
                            AddNewCustomerForm.this, "הלקוח נוסף בהצלחה");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            AddNewCustomerForm.this, ex.getMessage());
                }
            }
        });

    }
}
