package view;

import models.Product;
import models.Electronics;
import models.Clothing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Vector;


public class WestminsterShoppingCenter extends JFrame {

    JTable productTable;
    JComboBox<String> productCategoryComboBox;
    JLabel productIdShowLabel;
    JLabel categoryShowLabel;
    JLabel nameShowLabel;
    JLabel sizeOrBrandShowLabel;
    JLabel colourOrWarrantyShowLabel;
    JLabel availableItemsShowLabel;
    JLabel sizeOrBrandLabel;
    JLabel colourOrWarrantyLabel;


    ArrayList<Product> productList;
    ArrayList<Product> productCartList = new ArrayList<>();

    public WestminsterShoppingCenter(ArrayList<Product> productList) {
        // Set product list
        this.productList = productList;

        // Set Window
        setWindow(700,850,"Westminster Shopping Center");

        // Set Body
        try {
            GUIBody();

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

    private void GUIBody() throws ParseException {
        // Create table model with column names and 0 rows initially
        DefaultTableModel tableModel = new DefaultTableModel(
                new String[]{"ID", "Name", "Category", "Price", "Info"}, 0);

        // Create JTable with the populated table model
        productTable = new JTable(tableModel) {
            final Class[] types = new Class[]{String.class, String.class, String.class, Double.class, String.class};
            final boolean[] canEdit = new boolean[]{false, false, false, false, false};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        loadDataIntoTable(0);
        productTable.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                try {
                    selectTableRow(evt);

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        // Create scroll pane for table
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

        productCategoryComboBox = new JComboBox<>(new DefaultComboBoxModel<>(
                new String[] { "All", "Electronics", "Clothing" }));
        productCategoryComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    productCategoryComboBoxActionPerformed(evt);

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
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

        sizeOrBrandLabel = new JLabel("");

        colourOrWarrantyLabel = new JLabel("");

        JLabel availableItemsLabel = new JLabel("Items Available:");

        JButton addShoppingCartButton = new JButton("Add to Shopping Cart");
        addShoppingCartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addShoppingCartButtonActionPerformed(evt);
            }
        });

        productIdShowLabel = new JLabel("");

        categoryShowLabel = new JLabel("");

        nameShowLabel = new JLabel("");

        sizeOrBrandShowLabel = new JLabel("");

        colourOrWarrantyShowLabel = new JLabel("");

        availableItemsShowLabel = new JLabel("");

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

    private void loadDataIntoTable(int category) throws ParseException {
        // Category
        // 0 = all
        // 1 = Electronics
        // 2 = Clothing

        // Get table model
        DefaultTableModel tableModel = (DefaultTableModel) productTable.getModel();

        for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }

        // Populate table model with product data
        for (Product product : productList) {

            String productInfo;

            if (product.getClass().getName().substring(product.getClass().getName().
                    lastIndexOf('.')+1).equalsIgnoreCase("electronics")) {
                Electronics e = (Electronics) product;
                productInfo = "Brand name: " + e.getBrand() + "\nWarranty: " +
                        new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat(
                                "E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).parse(
                                String.valueOf(e.getWarranty())));
            } else {
                Clothing c = (Clothing) product;
                productInfo = "Size: " + c.getSize() + "\nColour: " + c.getColour();
            }

            Object[] rowData = {
                    product.getProductId(),
                    product.getProductName(),
                    product.getClass().getName().substring(product.getClass().getName()
                            .lastIndexOf('.')+1).equalsIgnoreCase("electronics") ?
                            "Electronics" : "Clothing",
                    product.getPrice(),
                    productInfo
            };

            switch (category) {
                case 0:
                    tableModel.addRow(rowData);
                    break;

                case 1:
                    if(product.getClass().getName().substring(product.getClass().getName()
                            .lastIndexOf('.')+1).equalsIgnoreCase("electronics")) {
                        tableModel.addRow(rowData);
                    }
                    break;

                case 2:
                    if(product.getClass().getName().substring(product.getClass().getName()
                            .lastIndexOf('.')+1).equalsIgnoreCase("clothing")) {
                        tableModel.addRow(rowData);
                    }
                    break;
            }
        }
    }

    private void selectTableRow(MouseEvent e) throws ParseException {
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        int selectedRow = productTable.getSelectedRow();

        productIdShowLabel.setText(model.getValueAt(selectedRow, 0).toString());
        categoryShowLabel.setText(model.getValueAt(selectedRow, 1).toString());
        nameShowLabel.setText(model.getValueAt(selectedRow, 2).toString());

        for (Product p : productList) {
            if(p.getProductId().equalsIgnoreCase(model.getValueAt(selectedRow, 0).toString().toLowerCase())) {
                if(model.getValueAt(selectedRow, 2).toString().equalsIgnoreCase("electronics")) {
                    Electronics ele = (Electronics) p;
                    sizeOrBrandLabel.setText("Brand:");
                    sizeOrBrandShowLabel.setText(ele.getBrand());
                    colourOrWarrantyLabel.setText("Warranty:");
                    colourOrWarrantyShowLabel.setText(new SimpleDateFormat("yyyy-MM-dd").
                            format(new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.ENGLISH).
                                    parse(String.valueOf(ele.getWarranty()))));
                    availableItemsShowLabel.setText(String.valueOf(ele.getAvailableItems()));

                } else {
                    Clothing c = (Clothing) p;
                    sizeOrBrandLabel.setText("Size:");
                    sizeOrBrandShowLabel.setText(c.getSize());
                    colourOrWarrantyLabel.setText("Colour:");
                    colourOrWarrantyShowLabel.setText(c.getColour());
                    availableItemsShowLabel.setText(String.valueOf(c.getAvailableItems()));
                }
            }
        }
    }

    private void productCategoryComboBoxActionPerformed(ActionEvent e) throws ParseException {
        if(e.getSource() == productCategoryComboBox) {
            switch (Objects.requireNonNull(productCategoryComboBox.getSelectedItem()).toString().toLowerCase()) {
                case "all":
                    loadDataIntoTable(0);
                    break;

                case "electronics":
                    loadDataIntoTable(1);
                    break;

                case "clothing":
                    loadDataIntoTable(2);
                    break;
            }
        }
    }

    private void shoppingCartActionPerformed(ActionEvent e) {
        
    }

    private void addShoppingCartButtonActionPerformed(ActionEvent e) {
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        int selectedRow = productTable.getSelectedRow();

        for (Product p : productList) {
            if(model.getValueAt(selectedRow, 0).toString().equalsIgnoreCase(p.getProductId().toLowerCase())) {
                productCartList.add(p);
            }
        }
    }
}
