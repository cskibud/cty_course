package advanced_java.midtermProject;
import javax.swing.*;

public class ReportOut {
    public JTable reportOut(Product[] products) {
        String[] columnNames = { "Product Name", "Customer Name", "Warehouse Name", "Purchase Cost", "Stocking Cost", "Sale Price" };
        Object[][] productInfo = new Object[5][6];
        for (int i = 0; i < products.length; i++) {
            productInfo[i][0] = products[i].getProductName();
            productInfo[i][1] = products[i].getCustomer().customerName;
            productInfo[i][2] = products[i].getWarehouse().warehouseName;
            productInfo[i][3] = products[i].getPurchaseCost();
            productInfo[i][4] = products[i].getStockingCost();
            productInfo[i][5] = products[i].getSalePrice();
        }
        // for testing puropses
        System.out.print(productInfo);

        JTable report = new JTable(productInfo, columnNames);
        return report;
    }
}
