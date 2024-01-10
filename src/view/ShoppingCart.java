package view;

import models.Clothing;
import models.Electronics;
import models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ShoppingCart extends JFrame {
    JTable cartTbl;
    private static ArrayList<Product> productCartList = new ArrayList<>();


    public ShoppingCart(ArrayList<Product> productCartList) {
        ShoppingCart.productCartList = productCartList;

        // Set Window
        setWindow(700,480,"Shopping Cart");

        // Set Body
        try {
            GUIBody(productCartList);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void setWindow(int width, int height, String name) {
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 2
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(2, 1));
    }

    private void GUIBody(ArrayList<Product> productList) throws ParseException {

        // Create table model with column names and 0 rows initially
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"Product", "Quantity", "Price"}, 0);


        JScrollPane jScrollPane1 = new JScrollPane();

        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        JLabel jLabel6 = new JLabel();
        JLabel jLabel7 = new JLabel();
        JLabel jLabel8 = new JLabel();

        // Create JTable with the populated table model

        cartTbl = new JTable(tableModel) {
            Class[] types = new Class[] { String.class, Integer.class, String.class };
            boolean[] canEdit = new boolean [] {false, true, false};
            public Class getColumnClass(int columnIndex) {return types [columnIndex];}
            public boolean isCellEditable(int rowIndex, int columnIndex) {return canEdit [columnIndex];}
        };
        loadDataIntoTable();
        jScrollPane1.setViewportView(cartTbl);

        jLabel1.setText("Total");

        jLabel2.setText("First Purchase Discount (10%)");

        jLabel3.setText("Three Items in Same Category Discount (20%)");

        jLabel4.setText("Final Total");

        jLabel5.setText("");

        jLabel6.setText("");

        jLabel7.setText("");

        jLabel8.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(31, Short.MAX_VALUE)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(layout.createSequentialGroup().addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))).addGap(27, 27, 27).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)).addGap(57, 57, 57))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel1).addComponent(jLabel5))
                .addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel2).addComponent(jLabel6))
                .addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel3).addComponent(jLabel7))
                .addGap(18, 18, 18).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel4).addComponent(jLabel8)).addContainerGap(27, Short.MAX_VALUE))
        );
    }

    private void loadDataIntoTable() throws ParseException {

        // Get table model
        DefaultTableModel tableModel = (DefaultTableModel) cartTbl.getModel();

        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }

        // Populate table model with product data
        for (Product product : productCartList) {

            String productInfo;

            if (product.getClass().getName().substring(product.getClass().getName().
                    lastIndexOf('.')+1).equalsIgnoreCase("electronics")) {
                Electronics e = (Electronics) product;
                productInfo = e.getBrand() + " " + new SimpleDateFormat("yyyy-MM-dd").
                        format(new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy",
                                Locale.ENGLISH).parse(String.valueOf(e.getWarranty())));
            } else {
                Clothing c = (Clothing) product;
                productInfo = c.getSize() + " " + c.getColour();
            }

            Object[] rowData = {
                    product.getProductId()  + "\n" + product.getProductName() + "\n" + productInfo,
                    1,
                    product.getPrice()
            };

            tableModel.addRow(rowData);
        }
    }

}
