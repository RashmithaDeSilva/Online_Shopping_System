package view;

import javax.swing.*;
import java.awt.*;


public class WestminsterShoppingCenter extends JFrame {

    private JButton shoppingCartButton;
    private JComboBox<String> category;
    

    public WestminsterShoppingCenter (){
        // Set Window
        setWindow(650,800,"Westminster Skin Consultation Manager");

        // Set Body
        GUIBody();
    }

    private void setWindow(int width, int height, String name){
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





        upPanel.add(upPanelTop, BorderLayout.NORTH);










        add(upPanel);
        add(downPanel);
    }
}
