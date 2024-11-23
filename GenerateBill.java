import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

public class GenerateBill extends JFrame implements ActionListener {
    String meter;
    JButton bill;
    Choice cmonth;
    JTextArea area;
    private FileConn fileConn;  

    GenerateBill(String meter) {
        this.meter = meter;
        fileConn = new FileConn(); 

        setSize(500, 800);
        setLocation(550, 30);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        JLabel heading = new JLabel("Generate Bill");
        JLabel meternumber = new JLabel(meter);
        cmonth = new Choice();
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");

        area = new JTextArea(50, 15);
        area.setText("\n\n\t--------Click on the---------\n\t Generate Bill Button to get\n\tthe bill of the Selected Month");
        area.setFont(new Font("Senserif", Font.ITALIC, 18));
        JScrollPane pane = new JScrollPane(area);

        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        panel.add(heading);
        panel.add(meternumber);
        panel.add(cmonth);

        add(panel, "North");
        add(pane, "Center");
        add(bill, "South");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String month = cmonth.getSelectedItem();
            area.setText("\tBENGEL Power Limited\nELECTRICITY BILL GENERATED FOR THE MONTH\n\tOF " + month + ", 2024\n\n\n");

            
            String[] customerData = fileConn.readCustomerData(meter);
            if (customerData != null) {
                area.append("\n Customer Name: " + customerData[0]); 
                area.append("\n Meter Number : " + customerData[3]); 
                area.append("\n Address : " + customerData[4]); 
                area.append("\n City : " + customerData[5]); 
                area.append("\n State : " + customerData[6]); 
                area.append("\n Email : " + customerData[7]); 
                area.append("\n Phone : " + customerData[8]); 
                area.append("\n---------------------------------------------------");
                area.append("\n");
            }

            
            String[] billData = fileConn.readBillData(meter, month);
            if (billData != null) {
                area.append("\n");
                area.append("\n Current Month: " + month);
                area.append("\n Units Consumed: " + billData[0]);
                area.append("\n Total Charges: " + billData[1]);
                area.append("\n-------------------------------------------------------");
                area.append("\n Total Payable: " + billData[1]);
                area.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            area.setText("An error occurred while generating the bill.");
        }
    }

    
    public void setFileConn(FileConn fileConn) {
        this.fileConn = fileConn;
    }

    public static void main(String[] args) {
        new GenerateBill("");
    }
}



