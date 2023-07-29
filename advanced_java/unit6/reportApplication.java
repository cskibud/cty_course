package advanced_java.unit6;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.*;
import java.util.Date;
import java.util.List;
import java.util.*;

public class reportApplication {
    private static JScrollPane scrollPane;
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("Sales Report");
        mainFrame.setSize(500, 400);

        JLabel startDateLbl = new JLabel("Report Start Date:  ");
        JTextField startDateTxt = new JTextField(10);
        JLabel endDateLbl = new JLabel("Report End Date:");
        JTextField endDateTxt = new JTextField(10);
        JButton button = new JButton("Show Report");

        JLabel errorAtIndexMsg = new JLabel(); 
        JLabel errorMsgToUser = new JLabel();
        JLabel wrongOrderError = new JLabel();

        GridBagLayout layoutMgr = new GridBagLayout();
        mainFrame.setLayout(layoutMgr);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(4,0,0,0);
        mainFrame.add(startDateLbl, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.insets = new Insets(4,0,0,0);
        mainFrame.add(startDateTxt, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(4,0,0,0);
        mainFrame.add(endDateLbl, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.insets = new Insets(4,0,0,0);
        mainFrame.add(endDateTxt, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(13,0,0,0);
        mainFrame.add(button, constraints);

        mainFrame.setVisible(true);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {  
                //  validate date inputs, show report
                String startDateString;
                String endDateString;

                startDateString = startDateTxt.getText();   
                endDateString = endDateTxt.getText();

                try {
                    // remove previous components
                    if (mainFrame.isAncestorOf(errorAtIndexMsg)) {
                        mainFrame.remove(errorAtIndexMsg);
                    }
                    if (mainFrame.isAncestorOf(errorMsgToUser)) {
                        mainFrame.remove(errorMsgToUser);
                    }
                    if (mainFrame.isAncestorOf(wrongOrderError)) {
                        mainFrame.remove(wrongOrderError);
                    }
                    if (mainFrame.isAncestorOf(scrollPane)) {
                        mainFrame.remove(scrollPane);
                    }

                    LocalDate start = stringToDate(startDateString);
                    LocalDate end = stringToDate(endDateString);

                    if (start.isAfter(end)) {
                        wrongOrderError.setText("Start date cannot be after end date");

                        constraints.gridx = 0;
                        constraints.gridy = 3;
                        constraints.gridwidth = 2;
                        constraints.insets = new Insets(13,0,0,0);
                        mainFrame.add(wrongOrderError, constraints);

                        mainFrame.revalidate();
                        mainFrame.repaint();
                        return;
                    }
                    // sample data
                    String[] columnNames = { "Sale Date", "Sale Price", "Sale Cost", "Profit/Loss", "Profit Margin" };
                    Object[][] data = {
                        { "03/01/2021", 100.0, 60.0, 40.0, 0.67 },
                        { "03/10/2021", 120.0, 80.0, 40.0, 0.5 },
                        { "03/15/2021", 80.0, 50.0, 30.0, 0.6 },
                        { "03/25/2021", 200.0, 150.0, 50.0, 0.33 },
                    };
                    List<Object[]> dataForTable = new ArrayList<>(); 

                    for (int i = 0; i < data.length; i++) {
                        Object stringDate = data[i][0];
                        LocalDate date;
                        if (stringDate instanceof String) {
                            date = stringToDate((String) stringDate);

                            if ((date.isAfter(start) && date.isBefore(end)) || 
                            date.isEqual(start) || 
                            date.isEqual(end)) {
                                dataForTable.add(data[i]);
                            }
                        }
                    }
                    JTable report = new JTable(dataForTable.toArray(new Object[0][0]), columnNames);
                    report.setPreferredScrollableViewportSize(new Dimension(450, 150));
                    report.setFillsViewportHeight(true);

                    scrollPane = new JScrollPane(report);

                    constraints.gridx = 0;
                    constraints.gridy = 3;
                    constraints.insets = new Insets(13,0,0,0);
                    mainFrame.add(scrollPane, constraints);

                    mainFrame.revalidate();
                    mainFrame.repaint();

                } catch (Exception exp) {
                    // show msgs
                    errorAtIndexMsg.setText(exp.getMessage());
                    errorMsgToUser.setText("You entered an invalid date - Enter date in mm/dd/yyyy format e.g. 01/01/2021");

                    constraints.gridx = 0;
                    constraints.gridy = 3;
                    constraints.gridwidth = 2;
                    constraints.insets = new Insets(13,0,0,0);
                    mainFrame.add(errorAtIndexMsg, constraints);

                    constraints.gridx = 0;
                    constraints.gridy = 4;
                    constraints.gridwidth = 2;
                    constraints.insets = new Insets(13,0,0,0);
                    mainFrame.add(errorMsgToUser, constraints);

                    mainFrame.revalidate();
                    mainFrame.repaint();
                    return;
                }
            } 
            private LocalDate stringToDate(String dateStr) throws DateTimeParseException {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                return LocalDate.parse(dateStr, df);
            }
        });
        
    }
}
