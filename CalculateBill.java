import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class CalculateBill extends JFrame implements ActionListener {
    private FileConn fileConn;
    private JTextField tfunits;
    private JButton next, cancel;
    private JLabel lblname, labeladdress;
    private Choice meternumber, cmonth;

    public CalculateBill() {
        setSize(700, 500);
        setLocation(400, 150);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100, 10, 400, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100, 80, 100, 20);
        p.add(lblmeternumber);

        meternumber = new Choice();
       
        meternumber.add("12345");
        meternumber.add("97890");
		 meternumber.add("82345");
        meternumber.add("997880");
		 meternumber.add("986345");
        meternumber.add("61890");

        meternumber.setBounds(240, 80, 200, 20);
        p.add(meternumber);

        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);

        lblname = new JLabel("PRINCE");
        lblname.setBounds(240, 120, 100, 20);
        p.add(lblname);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);

        labeladdress = new JLabel("North Badda"); 
        labeladdress.setBounds(240, 160, 200, 20);
        p.add(labeladdress);

        JLabel lblunits = new JLabel("Units Consumed");
        lblunits.setBounds(100, 200, 100, 20);
        p.add(lblunits);

        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);

        JLabel lblmonth = new JLabel("Month");
        lblmonth.setBounds(100, 240, 100, 20);
        p.add(lblmonth);

        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
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
        p.add(cmonth);


        next = new JButton("Submit");
        next.setBounds(120, 350, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 350, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());
        add(p, "Center");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
    }

    public void setFileConn(FileConn fileConn) {
        this.fileConn = fileConn;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = meternumber.getSelectedItem();
            String units = tfunits.getText();
            String month = cmonth.getSelectedItem();
            int totalbill = calculateBill(Integer.parseInt(units));

           
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\marja\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\bills.txt", true))) {
                writer.write(meter + "," + month + "," + units + "," + totalbill + ",Not Paid");
                writer.newLine();
                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                setVisible(false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    private int calculateBill(int units) {
       
        int costPerUnit = 10; 
        return units * costPerUnit;
    }

    public static void main(String[] args) {
        new CalculateBill();
    }
}
















// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import javax.swing.*;

// public class CalculateBill extends JFrame implements ActionListener {
//     private JTextField tfunits;
//     private JButton next, cancel;
//     private JLabel lblname, labeladdress;
//     private Choice meternumber, cmonth;

//     public CalculateBill() {
//         setSize(700, 500);
//         setLocation(400, 150);

//         JPanel p = new JPanel();
//         p.setLayout(null);
//         p.setBackground(new Color(173, 216, 230));
//         add(p);

//         JLabel heading = new JLabel("Calculate Electricity Bill");
//         heading.setBounds(100, 10, 400, 25);
//         heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
//         p.add(heading);

//         JLabel lblmeternumber = new JLabel("Meter Number");
//         lblmeternumber.setBounds(100, 80, 100, 20);
//         p.add(lblmeternumber);

//         meternumber = new Choice();
//         meternumber.add("12345");
//         meternumber.add("97890");
//         meternumber.add("82345");
//         meternumber.add("997880");
//         meternumber.add("986345");
//         meternumber.add("61890");
//         meternumber.setBounds(240, 80, 200, 20);
//         p.add(meternumber);

//         JLabel lblmeterno = new JLabel("Name");
//         lblmeterno.setBounds(100, 120, 100, 20);
//         p.add(lblmeterno);

//         lblname = new JLabel("PRINCE");
//         lblname.setBounds(240, 120, 100, 20);
//         p.add(lblname);

//         JLabel lbladdress = new JLabel("Address");
//         lbladdress.setBounds(100, 160, 100, 20);
//         p.add(lbladdress);

//         labeladdress = new JLabel("North Badda");
//         labeladdress.setBounds(240, 160, 200, 20);
//         p.add(labeladdress);

//         JLabel lblunits = new JLabel("Units Consumed");
//         lblunits.setBounds(100, 200, 100, 20);
//         p.add(lblunits);

//         tfunits = new JTextField();
//         tfunits.setBounds(240, 200, 200, 20);
//         p.add(tfunits);

//         JLabel lblmonth = new JLabel("Month");
//         lblmonth.setBounds(100, 240, 100, 20);
//         p.add(lblmonth);

//         cmonth = new Choice();
//         cmonth.setBounds(240, 240, 200, 20);
//         cmonth.add("January");
//         cmonth.add("February");
//         cmonth.add("March");
//         cmonth.add("April");
//         cmonth.add("May");
//         cmonth.add("June");
//         cmonth.add("July");
//         cmonth.add("August");
//         cmonth.add("September");
//         cmonth.add("October");
//         cmonth.add("November");
//         cmonth.add("December");
//         p.add(cmonth);

//         next = new JButton("Submit");
//         next.setBounds(120, 350, 100, 25);
//         next.setBackground(Color.BLACK);
//         next.setForeground(Color.WHITE);
//         next.addActionListener(this);
//         p.add(next);

//         cancel = new JButton("Cancel");
//         cancel.setBounds(250, 350, 100, 25);
//         cancel.setBackground(Color.BLACK);
//         cancel.setForeground(Color.WHITE);
//         cancel.addActionListener(this);
//         p.add(cancel);

//         setLayout(new BorderLayout());
//         add(p, "Center");

//         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon2.jpg"));
//         Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
//         ImageIcon i3 = new ImageIcon(i2);
//         JLabel image = new JLabel(i3);
//         add(image, "West");

//         getContentPane().setBackground(Color.WHITE);

//         setVisible(true);
//     }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         if (ae.getSource() == next) {
//             String meter = meternumber.getSelectedItem();
//             String unitsText = tfunits.getText();
//             String month = cmonth.getSelectedItem();
//             int totalbill = 0;

//             // Input validation
//             try {
//                 int units = Integer.parseInt(unitsText);
//                 totalbill = calculateBill(units);
//             } catch (NumberFormatException e) {
//                 JOptionPane.showMessageDialog(null, "Please enter valid units.");
//                 return; // Stop further processing if input is invalid
//             }

//             // File writing logic
//             try (BufferedWriter writer = new BufferedWriter(new FileWriter("bills.txt", true))) {
//                 writer.write(meter + "," + month + "," + unitsText + "," + totalbill + ",Not Paid");
//                 writer.newLine();
//                 JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
//                 setVisible(false);
//             } catch (IOException e) {
//                 JOptionPane.showMessageDialog(null, "Error while writing to file.");
//                 e.printStackTrace();
//             }
//         } else if (ae.getSource() == cancel) {
//             setVisible(false); // Close the window
//         }
//     }

//     private int calculateBill(int units) {
//         int costPerUnit = 10;
//         return units * costPerUnit;
//     }

//     public static void main(String[] args) {
//         new CalculateBill();
//     }
// }
