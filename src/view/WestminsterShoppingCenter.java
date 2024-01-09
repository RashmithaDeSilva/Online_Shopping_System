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
        JTable productTable = new JTable(new DefaultTableModel(
                new Object [][] {
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String [] {"ID", "Name", "Category", "Price", "Info"})
            {
                final Class[] types = new Class [] { String.class, String.class, String.class, Double.class, String.class };
                final boolean[] canEdit = new boolean [] { false, false, false, false, false };
                public Class getColumnClass(int columnIndex) { return types [columnIndex]; }
                public boolean isCellEditable(int rowIndex, int columnIndex) { return canEdit [columnIndex]; }
            });

        JScrollPane productScrollPane = new JScrollPane();
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

        JLabel productCategoryLabel = new JLabel("Select product category");

        JComboBox<String> productCategoryComboBox = new JComboBox<>(new DefaultComboBoxModel<>(
                new String[] { "All", "Electronics", "Clothing" }));
        productCategoryComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                productCategoryComboBoxActionPerformed(evt);
            }
        });

        JButton shoppingCartButton = new JButton("Shopping cart");
        shoppingCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                shoppingCartActionPerformed(evt);
            }
        });

        JLabel selectedProductDetailsLabel = new JLabel("Selected Product - Details");

        JLabel productIdLabel = new JLabel("Product ID: ");

        JLabel categoryLabel = new JLabel("Category:");

        JLabel nameLabel = new JLabel("Name:");

        JLabel sizeOrBrandLabel = new JLabel(".");

        JLabel colourOrWarrantyLabel = new JLabel(".");

        JLabel availableItemsLabel = new JLabel("Items Available:");

        JButton addShoppingCartButton = new JButton("Add to Shopping Cart");
        addShoppingCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addShoppingCartButtonActionPerformed(evt);
            }
        });

        JLabel productIdShowLabel = new JLabel("1");

        JLabel categoryShowLabel = new JLabel("2");

        JLabel nameShowLabel = new JLabel("3");

        JLabel sizeOrBrandShowLabel = new JLabel("4");

        JLabel colourOrWarrantyShowLabel = new JLabel("5");

        JLabel availableItemsShowLabel = new JLabel("6");

        JSeparator separator = new JSeparator();

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(separator))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(productCategoryLabel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(productCategoryComboBox, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(shoppingCartButton)
                                                                .addComponent(productScrollPane, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 27, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(selectedProductDetailsLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(availableItemsLabel, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                                        .addComponent(productIdLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(categoryLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nameLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sizeOrBrandLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(colourOrWarrantyLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(productIdShowLabel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(categoryShowLabel, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nameShowLabel, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sizeOrBrandShowLabel, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(colourOrWarrantyShowLabel, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(availableItemsShowLabel, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(addShoppingCartButton)
                                                .addGap(39, 39, 39))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(shoppingCartButton)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(productCategoryComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(productCategoryLabel))
                                .addGap(28, 28, 28)
                                .addComponent(productScrollPane, GroupLayout.PREFERRED_SIZE, 404, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(selectedProductDetailsLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(productIdLabel)
                                        .addComponent(productIdShowLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(categoryLabel)
                                        .addComponent(categoryShowLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameLabel)
                                        .addComponent(nameShowLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(sizeOrBrandLabel)
                                        .addComponent(sizeOrBrandShowLabel))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(colourOrWarrantyLabel)
                                        .addComponent(colourOrWarrantyShowLabel))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(availableItemsLabel)
                                        .addComponent(availableItemsShowLabel)
                                        .addComponent(addShoppingCartButton))
                                .addContainerGap(20, Short.MAX_VALUE))
        );
    }

    private void shoppingCartActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void productCategoryComboBoxActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addShoppingCartButtonActionPerformed(ActionEvent evt) {
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
