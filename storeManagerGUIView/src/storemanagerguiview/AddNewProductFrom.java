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
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Customer;
import model.Product;
import model.SoftwareProduct;

/**
 *
 * @author user1
 */
//הוספת מוצר
//כפתור ראשון תוכנה
//כפתור שני חומרה
public class AddNewProductFrom extends JFrame {

    private JButton SoftBtn;
    private JButton HardBtn;
    private AddNewHard hard;
    private AddNewSoft soft;

    public AddNewProductFrom(ManageCatalogForm m) throws HeadlessException {

        hard = new AddNewHard(m);
        soft = new AddNewSoft(m);
        SoftBtn = new JButton("תוכנה");
        HardBtn = new JButton("חומרה");

        getContentPane().add(HardBtn);
        getContentPane().add(SoftBtn);

        Font f = new Font("Calibri Light", 1, 18);
        SoftBtn.setFont(f);
        HardBtn.setFont(f);

        this.setPreferredSize(new Dimension(400, 200)); //גודל חלון
        getContentPane().setLayout(new GridLayout(0, 2, 10, 10)); //מנהל פרישה טבלאית
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.pack();  // סידור הרכבים באופן פורפציונלי

        HardBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hard.setVisible(true);
            }
        });

        SoftBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                soft.setVisible(true);
            }
        });

    }

}
