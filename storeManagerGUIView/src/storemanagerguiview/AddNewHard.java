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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.HardwareProduct;

/**
 *
 * @author user1
 */
public class AddNewHard extends JFrame {

    private JButton jButtonOK;
    private JLabel jLabelID;
    private JLabel jLabelName;
    private JLabel jLabelDescription;
    private JLabel jLabelPricePerUnit;
    private JLabel jLYears;

    private JTextField jTextFieldID;
    private JTextField jTextFieldName;
    private JTextField JTdescription;
    private JTextField jTPricePerUnit;//parse to float
    private JTextField jTYears;
    ManageCatalogForm manageCatalogForm;

    public AddNewHard(ManageCatalogForm m) {
        manageCatalogForm = m;

        jButtonOK = new JButton("אישור");
        jLabelID = new JLabel("קוד מוצר:");
        jLabelName = new JLabel("שם:");
        jLabelDescription = new JLabel("תיאור:");
        jLabelPricePerUnit = new JLabel("מחיר ליחידה:");
        jLYears = new JLabel("שנות אחריות:");
        jTextFieldID = new JTextField();
        jTextFieldName = new JTextField();
        JTdescription = new JTextField();
        jTPricePerUnit = new JTextField();
        jTYears = new JTextField();

        Font f = new Font("Calibri Light", 1, 18);
        jButtonOK.setFont(f);
        jLabelID.setFont(f);
        jLabelName.setFont(f);
        jLabelDescription.setFont(f);
        jLabelPricePerUnit.setFont(f);
        jLYears.setFont(f);
        jTextFieldID.setFont(f);
        jTextFieldName.setFont(f);
        JTdescription.setFont(f);
        jTPricePerUnit.setFont(f);
        jTYears.setFont(f);

        getContentPane().add(jTextFieldID);
        getContentPane().add(jLabelID);
        getContentPane().add(jTextFieldName);
        getContentPane().add(jLabelName);
        getContentPane().add(JTdescription);
        getContentPane().add(jLabelDescription);
        getContentPane().add(jTPricePerUnit);
        getContentPane().add(jLabelPricePerUnit);
        getContentPane().add(jTYears);
        getContentPane().add(jLYears);

        getContentPane().add(jButtonOK);

        this.setPreferredSize(new Dimension(800, 400)); //גודל חלון
        getContentPane().setLayout(new GridLayout(0, 2, 10, 10)); //מנהל פרישה טבלאית
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();  // סידור הרכבים באופן פורפציונלי

        jButtonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    if (jTextFieldID.getText().isEmpty()) {
                        throw new Exception("מלא קוד מוצר");
                    }
                    if (jTextFieldName.getText().isEmpty()) {
                        throw new Exception("מלא שם מוצר");
                    }

                    if (JTdescription.getText().isEmpty()) {
                        throw new Exception("מלא תאור מוצר");
                    }
                    if (jTPricePerUnit.getText().isEmpty()) {
                        throw new Exception("מלא מחיר ליחידה");
                    }
                    float price = Float.parseFloat(
                            jTPricePerUnit.getText());
                    if (price <= 0) {
                        throw new Exception("מחיר לא חוקי");
                    }
                    HardwareProduct hard = new HardwareProduct(
                            Long.parseLong(jTextFieldID.getText()),
                            jTextFieldName.getText(),
                            JTdescription.getText(),
                            price,
                            Integer.parseInt(jTYears.getText())
                    );
                    // HardwareProduct(long id, String name, String description, float pricePerUnit, int intWarrantyPeriod)     
                    Backend_DAO_List.GetBackend_DAO_List().AddProduct(hard);
                    JTdescription.setText("");
                    jTPricePerUnit.setText("");
                    jTextFieldID.setText("");
                    jTextFieldName.setText("");
                    jTYears.setText("");

                    JOptionPane.showMessageDialog(
                            AddNewHard.this, "המוצר נוסף בהצלחה");
                    m.RefreshProductList();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(
                            AddNewHard.this, ex.getMessage());
                }
            }
        });

    }
}
