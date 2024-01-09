package view;

import models.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Vector;


public class WestminsterShoppingCenter extends JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> productCategoryComboBox;
    private javax.swing.JLabel productCategoryLabel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane productScrollPane;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable productTable;

    public WestminsterShoppingCenter(ArrayList<Product> productList) {
        // Set Window
        setWindow(700,850,"Westminster Skin Consultation Manager");

        // Set Body
        try {
            GUIBody(productList);

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
        productScrollPane = new JScrollPane();
        productTable = new JTable();
        productCategoryLabel = new JLabel();
        productCategoryComboBox = new JComboBox<>();
        jButton1 = new JButton();
        jSeparator1 = new JSeparator();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jButton2 = new JButton();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel11 = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        jLabel14 = new JLabel();

        productTable.setModel(new DefaultTableModel(
                new Object [][] {
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String [] {"ID", "Name", "Category", "Price", "Info"}
        ) );//{
//            Class[] types = new Class [] {
//                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class
//            };
//            boolean[] canEdit = new boolean [] {
//                    false, false, false, false, false
//            };
//
//            public Class getColumnClass(int columnIndex) {
//                return types [columnIndex];
//            }
//
//            public boolean isCellEditable(int rowIndex, int columnIndex) {
//                return canEdit [columnIndex];
//            }
//        });
        productScrollPane.setViewportView(productTable);
        if (productTable.getColumnModel().getColumnCount() > 0) {
            productTable.getColumnModel().getColumn(0).setResizable(false);
            productTable.getColumnModel().getColumn(0).setPreferredWidth(50);

            productTable.getColumnModel().getColumn(1).setResizable(false);
            productTable.getColumnModel().getColumn(1).setPreferredWidth(100);

            productTable.getColumnModel().getColumn(2).setResizable(false);
            productTable.getColumnModel().getColumn(2).setPreferredWidth(100);

            productTable.getColumnModel().getColumn(3).setResizable(false);
            productTable.getColumnModel().getColumn(3).setPreferredWidth(50);

            productTable.getColumnModel().getColumn(4).setResizable(false);
            productTable.getColumnModel().getColumn(4).setPreferredWidth(150);
        }

        productCategoryLabel.setText("Select product category");

        productCategoryComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "All", "Electronics", "Clothing" }));
        productCategoryComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Shopping cart");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Scelected Product - Details");

        jLabel3.setText("Product ID: ");

        jLabel4.setText("Category:");

        jLabel5.setText(".");

        jLabel6.setText("Name:");

        jLabel7.setText("Items Avalabel:");

        jLabel8.setText(".");

        jButton2.setText("Add to Shoping Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText(".");

        jLabel10.setText(".");

        jLabel11.setText(".");

        jLabel12.setText(".");

        jLabel13.setText(".");

        jLabel14.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(productCategoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(productCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jButton1)
                                                                .addComponent(productScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 27, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton2)
                                                .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(productCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(productCategoryLabel))
                                .addGap(28, 28, 28)
                                .addComponent(productScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel13))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel14)
                                        .addComponent(jButton2))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

//    private void GUIBody(ArrayList<Product> productList) throws ParseException {
//        JPanel upPanel = new JPanel(new BorderLayout());
//        JPanel downPanel = new JPanel(new GridLayout(8, 1));
//
//        JPanel upPanelTop = new JPanel(new GridLayout(4, 3, 10, 10));
//        upPanelTop.add(new JLabel(""));
//        upPanelTop.add(new JLabel(""));
//        upPanelTop.add(new JLabel(""));
//
//        upPanelTop.add(new JLabel(""));
//        upPanelTop.add(new JLabel(""));
//        JButton shoppingCartButton = new JButton("Shopping cart");
//        upPanelTop.add(shoppingCartButton);
//
//        JLabel categoryLabel = new JLabel("Select product category");
//        categoryLabel.setHorizontalAlignment(JLabel.CENTER);
//        categoryLabel.setVerticalAlignment(JLabel.CENTER);
//        upPanelTop.add(categoryLabel);
//        JComboBox<String> category = new JComboBox<>(new String[]{"All", "Electronics", "Clothing"});
//        upPanelTop.add(category);
//        upPanelTop.add(new JLabel(""));
//
//        upPanelTop.add(new JLabel(""));
//        upPanelTop.add(new JLabel(""));
//        upPanelTop.add(new JLabel(""));
//
//        category.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                // Handle the event here
//                JComboBox<String> source = (JComboBox<String>) e.getSource();
//                String selectedOption = (String) source.getSelectedItem();
//                System.out.println(selectedOption);
//            }
//        });
//
//
//        JPanel upPanelBottom = new JPanel(new GridLayout(4,3));
//
////        // Create a JTable with a DefaultTableModel
////        JTable productTable = new JTable(new DefaultTableModel(
////                new Object[]{"ID", "Name", "Category", "Price", "Info"}, 0));
////
////        // Get the DefaultTableModel from the JTable
////        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();
////
////        // Convert ArrayList data to Vector
////        Vector<Product> rowData = new Vector<>(productList);
////
////        // Add the Vector to the DefaultTableModel
////        tableModel.addRow(rowData);
////
////        // Create JScrollPane to hold the table
////        JScrollPane scrollPane = new JScrollPane(productTable);
//
//
////        String[] columnNames = {"ID", "Name", "Category", "Price", "Info"};
////        String[][] productArray = new String[productList.size()][columnNames.length];
////
////
////        // Set Doctors Values In To 2D Array
////        for(int i=0;i<productList.size();i++){
////            for(int j=0;j<columnNames.length;j++){
////                if (j == 0) {
////                    productArray[i][j] = productList.get(i).getProductId();
////
////                } else if (j == 1) {
////                    productArray[i][j] = productList.get(i).getProductName();
////
////                } else if (j == 2) {
////                    productArray[i][j] = productList.get(i).getClass().getName().substring(
////                            productList.get(i).getClass().getName().lastIndexOf('.')+1).
////                            equalsIgnoreCase("electronics") ? "Electronics" : "Clothing";
////
////                } else if (j == 3) {
////                    productArray[i][j] = String.valueOf(productList.get(i).getPrice());
////
////                } else {
////                    if (productList.get(i).getClass().getName().substring(productList.get(i).
////                            getClass().getName().lastIndexOf('.')+1).equalsIgnoreCase("electronics")) {
////                        Electronics e = (Electronics) productList.get(i);
////                        productArray[i][j] = "Brand name: " + e.getBrand() + "\nWarranty: " +
////                                new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat(
////                                        "E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(
////                                                String.valueOf(e.getWarranty())));
////                    } else {
////                        Clothing c = (Clothing) productList.get(i);
////                        productArray[i][j] = "Size: " + c.getSize() + "\nColour: " + c.getColour();
////                    }
////                }
////            }
////        }
////
////        // Set Table
////        JTable productTable = new JTable(productArray, columnNames);
////
////        // Set Table Data Font
//////        productTable.setFont(new Font("SansSerif",1,15));
////
////        // Set Table Column Font
//////        productTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));
////
////        // Create JScrollPane to hold the table
////        JScrollPane scrollPane = new JScrollPane(productTable);
//
//        JTable productTable = new JTable();
//        JScrollPane scrollPane = new JScrollPane();
//
//        productTable.setModel(new javax.swing.table.DefaultTableModel(
//                new Object [][] {
//                        {null, null, null, null, null},
//                        {null, null, null, null, null},
//                        {null, null, null, null, null},
//                        {null, null, null, null, null}
//                },
//                new String [] {"ID", "Name", "Category", "Price", "Info"}
//        ));
//        scrollPane.setViewportView(productTable);
//
//
//
//
//        upPanelBottom.add(productTable);
//
//
//
//
//
//        upPanel.add(upPanelTop, BorderLayout.NORTH);
//        upPanel.add(new JLabel("     "), BorderLayout.WEST);
//        upPanel.add(new JLabel("     "), BorderLayout.EAST);
//        upPanel.add(upPanelBottom, BorderLayout.CENTER);
//
//
//
//
//
//
//
//
//
//
//        add(upPanel);
//        add(downPanel);
//    }

    // Method to add sample data to the table
    private void addSampleData(ArrayList<Product> productList) {
        Vector<Object> rowData = new Vector<>(productList);

    }


}
