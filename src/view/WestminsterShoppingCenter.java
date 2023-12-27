package view;

import models.ShoppingManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WestminsterShoppingCenter extends JFrame {

    private JButton shoppingCartButton;
    private JComboBox<String> category;
    

    public WestminsterShoppingCenter() {
        // Set Window
        setWindow(650,800,"Westminster Skin Consultation Manager");

        // Set Body
        GUIBody();
    }

    private void setWindow(int width, int height, String name) {
        setSize(width,height);
        setTitle(name);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); // DISPOSE_ON_CLOSE or 2
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridLayout(2, 1));
    }

    private void GUIBody() {
        JPanel upPanel = new JPanel(new BorderLayout());
        JPanel downPanel = new JPanel(new GridLayout(8,1));

        JPanel upPanelTop = new JPanel(new GridLayout(4,3, 10, 10));
        upPanelTop.add(new JLabel(""));
        upPanelTop.add(new JLabel(""));
        upPanelTop.add(new JLabel(""));

        upPanelTop.add(new JLabel(""));
        upPanelTop.add(new JLabel(""));
        shoppingCartButton = new JButton("Shopping cart");
        upPanelTop.add(shoppingCartButton);

        JLabel categoryLabel = new JLabel("Select product category");
        categoryLabel.setHorizontalAlignment(JLabel.CENTER);
        categoryLabel.setVerticalAlignment(JLabel.CENTER);
        upPanelTop.add(categoryLabel);
        category = new JComboBox<>(new String[]{"All", "Electronics", "Clothing"});
        upPanelTop.add(category);
        upPanelTop.add(new JLabel(""));

        upPanelTop.add(new JLabel(""));
        upPanelTop.add(new JLabel(""));
        upPanelTop.add(new JLabel(""));

        category.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the event here
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                String selectedOption = (String) source.getSelectedItem();
                System.out.println(selectedOption);
            }
        });


        JPanel upPanelBottom = new JPanel(new GridLayout(4,3));

        // Create a JTable with a DefaultTableModel
        JTable productTable = new JTable(new DefaultTableModel(
                new Object[]{"ID", "Name", "Category", "Price", "Info"}, 0));

        // Add sample data to the table
//        addSampleData((DefaultTableModel) productTable.getModel());

        // Create JScrollPane to hold the table
        JScrollPane scrollPane = new JScrollPane(productTable);

        upPanelBottom.add(scrollPane);





        upPanel.add(upPanelTop, BorderLayout.NORTH);
        upPanel.add(new JLabel("     "), BorderLayout.WEST);
        upPanel.add(new JLabel("     "), BorderLayout.EAST);
        upPanel.add(upPanelBottom, BorderLayout.CENTER);










        add(upPanel);
        add(downPanel);
    }

    // Method to add sample data to the table
//    private static void addSampleData(DefaultTableModel model) {
//        Vector<Object> row1 = new Vector<>();
//        row1.add(1);  // ID
//        row1.add("Product A");  // Name
//        row1.add("Category 1");  // Category
//        row1.add(29.99);  // Price
//        row1.add("Product A info");  // Info
//        model.addRow(row1);
//
//        Vector<Object> row2 = new Vector<>();
//        row2.add(2);  // ID
//        row2.add("Product B");  // Name
//        row2.add("Category 2");  // Category
//        row2.add(19.99);  // Price
//        row2.add("Product B info");  // Info
//        model.addRow(row2);
//
//        // Add more rows as needed
//    }
}
