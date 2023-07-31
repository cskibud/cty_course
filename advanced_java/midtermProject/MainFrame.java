package advanced_java.midtermProject;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.table.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.Date;
import java.util.List;
import java.util.*;

public class MainFrame {
    private static JScrollPane scrollPane;
    private static ArrayList<Product> arrayList = new ArrayList<>();
    private static Product[] productArray;
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Product Management System");
        mainFrame.setSize(600, 400);

        JPanel topMenuPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        JButton setupProductsButton = new JButton("Setup Products");
        setupProductsButton.setPreferredSize(new Dimension(250, 70));
        setupProductsButton.setFont(new Font("Arial", Font.BOLD, 16));
        JButton productReportButton = new JButton("Product Report");
        productReportButton.setPreferredSize(new Dimension(250, 70));
        productReportButton.setFont(new Font("Arial", Font.BOLD, 16));

        
        JPanel setupPanel = new JPanel(new GridBagLayout());
        JPanel reportPanel = new JPanel(new GridBagLayout());

        JLabel compErrorMsg = new JLabel();
        JLabel doubleErrorMsg = new JLabel();
        JLabel emptyErrorMsg = new JLabel();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(4,0,0,0);
        topMenuPanel.add(setupProductsButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridheight = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(15,0,0,0);
        topMenuPanel.add(productReportButton, constraints);

        mainFrame.add(topMenuPanel);
        mainFrame.setVisible(true);

        setupProductsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.remove(topMenuPanel);

                JLabel productNameLbl = new JLabel("Product Name:  ");
                JTextField productNameTxt = new JTextField(10);
                JLabel customerNameLbl = new JLabel("Customer Name:");
                JTextField customerNameTxt = new JTextField(10);
                JLabel warehouseNameLbl = new JLabel("Warehouse Name:");
                JTextField warehouseNameTxt = new JTextField(10);
                JLabel purchaseCostLbl = new JLabel("Purchase Cost:");
                JTextField purchaseCostTxt = new JTextField(10);
                JLabel stockingCostLbl = new JLabel("Stocking Cost:");
                JTextField stockingCostTxt = new JTextField(10);
                JLabel salePriceLbl = new JLabel("Sale Price:");
                JTextField salePriceTxt = new JTextField(10);

                JButton addProductButton = new JButton("Add Product");
                addProductButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if (setupPanel.isAncestorOf(compErrorMsg)) {
                            setupPanel.remove(compErrorMsg);
                        }
                        if (setupPanel.isAncestorOf(doubleErrorMsg)) {
                            setupPanel.remove(doubleErrorMsg);
                        }
                        if (setupPanel.isAncestorOf(emptyErrorMsg)) {
                            setupPanel.remove(emptyErrorMsg);
                        }
                        setupPanel.revalidate();
                        setupPanel.repaint();
                        // create products and add into array/list
                        Warehouse warehouse = new CoolWarehouse(validateBlank(warehouseNameTxt.getText()));
                        Customer customer = new HighVolumeCustomer(validateBlank(customerNameTxt.getText()));

                        String productName = validateBlank(productNameTxt.getText());
                        double purchaseCost = validateDouble(purchaseCostTxt.getText());
                        double stockingCost = validateDouble(stockingCostTxt.getText());
                        double salePrice = validateDouble(salePriceTxt.getText());

                        if (!setupPanel.isAncestorOf(compErrorMsg) && !setupPanel.isAncestorOf(emptyErrorMsg)) {
                            Product product = new Product(productName, purchaseCost, salePrice, stockingCost, warehouse, customer);
                            arrayList.add(product);

                            clear(productNameTxt);
                            clear(customerNameTxt);
                            clear(warehouseNameTxt);
                            clear(purchaseCostTxt);
                            clear(stockingCostTxt);
                            clear(salePriceTxt);
                        }
                    }
                });

                JButton returnButton = new JButton("Return");
                returnButton.setPreferredSize(new Dimension(30, 20));
                returnButton.setFont(new Font("Arial", Font.BOLD, 10));
                returnButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.remove(setupPanel);
                        mainFrame.add(topMenuPanel);

                        mainFrame.revalidate();
                        mainFrame.repaint();
                    }
                });


                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.insets = new Insets(4,0,0,0);
                setupPanel.add(productNameLbl, constraints);

                constraints.gridx = 1;
                constraints.gridy = 0;
                constraints.insets = new Insets(4,0,0,0);
                setupPanel.add(productNameTxt, constraints);

                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.insets = new Insets(4,0,0,0);
                setupPanel.add(customerNameLbl, constraints);

                constraints.gridx = 1;
                constraints.gridy = 1;
                constraints.insets = new Insets(4,0,0,0);
                setupPanel.add(customerNameTxt, constraints);

                constraints.gridx = 0;
                constraints.gridy = 2;
                constraints.insets = new Insets(4,0,0,10);
                setupPanel.add(warehouseNameLbl, constraints);

                constraints.gridx = 1;
                constraints.gridy = 2;
                constraints.insets = new Insets(4,0,0,0);
                setupPanel.add(warehouseNameTxt, constraints);

                constraints.gridx = 0;
                constraints.gridy = 3;
                constraints.insets = new Insets(4,0,0,10);
                setupPanel.add(purchaseCostLbl, constraints);

                constraints.gridx = 1;
                constraints.gridy = 3;
                constraints.insets = new Insets(4,0,0,0);
                setupPanel.add(purchaseCostTxt, constraints);

                constraints.gridx = 0;
                constraints.gridy = 4;
                constraints.insets = new Insets(4,0,0,10);
                setupPanel.add(stockingCostLbl, constraints);

                constraints.gridx = 1;
                constraints.gridy = 4;
                constraints.insets = new Insets(4,0,0,0);
                setupPanel.add(stockingCostTxt, constraints);

                constraints.gridx = 0;
                constraints.gridy = 5;
                constraints.insets = new Insets(4,0,0,10);
                setupPanel.add(salePriceLbl, constraints);

                constraints.gridx = 1;
                constraints.gridy = 5;
                constraints.insets = new Insets(4,0,0,0);
                setupPanel.add(salePriceTxt, constraints);

                constraints.gridx = 0;
                constraints.gridy = 6;
                constraints.gridwidth = 2;
                constraints.insets = new Insets(13,0,0,0);
                setupPanel.add(addProductButton, constraints);

                constraints.gridx = 0;
                constraints.gridy = 7;
                constraints.gridwidth = 1;
                constraints.insets = new Insets(13, 0, 0, 0);
                setupPanel.add(returnButton, constraints);

                mainFrame.add(setupPanel);

                mainFrame.revalidate();
                mainFrame.repaint();
            }
            private String validateBlank(String textInput) {
                if (textInput.isBlank()) {
                    emptyErrorMsg.setText("Please do not leave answers blank.");

                    constraints.gridx = 0;
                    constraints.gridy = 8;
                    constraints.gridwidth = 2;
                    constraints.insets = new Insets(13,0,0,0);
                    setupPanel.add(emptyErrorMsg, constraints);

                    setupPanel.revalidate();
                    setupPanel.repaint();
                } 
                return textInput;
            }
            private double validateDouble(String textInput) {
                double doubleValue = 0;
                try {
                    if (!setupPanel.isAncestorOf(compErrorMsg)) {
                        if (textInput.isBlank()) {
                            emptyErrorMsg.setText("Please do not leave answers blank.");

                            constraints.gridx = 0;
                            constraints.gridy = 8;
                            constraints.gridwidth = 2;
                            constraints.insets = new Insets(13,0,0,0);
                            setupPanel.add(emptyErrorMsg, constraints);

                            setupPanel.revalidate();
                            setupPanel.repaint();
                        } else {
                            doubleValue = Double.parseDouble(textInput);
                        }
                    }
                }
                catch (Exception e) {
                    if (!setupPanel.isAncestorOf(emptyErrorMsg)) {
                        compErrorMsg.setText(e.getMessage());
                        doubleErrorMsg.setText("Please enter a valid monetary value. Do not include the \"$\" symbol.");

                        constraints.gridx = 0;
                        constraints.gridy = 8;
                        constraints.gridwidth = 2;
                        constraints.insets = new Insets(13,0,0,0);
                        setupPanel.add(compErrorMsg, constraints);

                        constraints.gridx = 0;
                        constraints.gridy = 9;
                        constraints.gridwidth = 2;
                        constraints.insets = new Insets(13,0,0,0);
                        setupPanel.add(doubleErrorMsg, constraints);

                        setupPanel.revalidate();
                        setupPanel.repaint();
                    }
                }
                return doubleValue;
            }
            private void clear(JTextField textBox) {
                textBox.setText("");
            }
        });

        productReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.remove(topMenuPanel);
                productArray = arrayList.toArray(new Product[arrayList.size()]);
                // test
                System.out.println(arrayList);
                JTable reportTable = ReportOut.reportOut(productArray);
                reportTable.setPreferredScrollableViewportSize(new Dimension(550, 150));
                reportTable.setFillsViewportHeight(true);
                scrollPane = new JScrollPane(reportTable);

                JLabel reportTitle = new JLabel("Product Report");

                JButton returnButton = new JButton("Return");
                returnButton.setPreferredSize(new Dimension(70, 20));
                returnButton.setFont(new Font("Arial", Font.BOLD, 10));
                returnButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        mainFrame.remove(reportPanel);
                        mainFrame.add(topMenuPanel);

                        mainFrame.revalidate();
                        mainFrame.repaint();
                    }
                });

                constraints.gridx = 0;
                constraints.gridy = 0;
                constraints.gridwidth = 2;
                constraints.insets = new Insets(0,0,0,0);
                reportPanel.add(reportTitle, constraints);

                constraints.gridx = 0;
                constraints.gridy = 1;
                constraints.gridwidth = 2;
                constraints.insets = new Insets(13,0,0,0);
                reportPanel.add(scrollPane, constraints);

                constraints.gridx = 0;
                constraints.gridy = 2;
                constraints.gridwidth = 1;
                constraints.insets = new Insets(13, 0, 0, 0);
                reportPanel.add(returnButton, constraints);

                mainFrame.add(reportPanel);
                mainFrame.revalidate();
                mainFrame.repaint();
            }
        });
    }


}
