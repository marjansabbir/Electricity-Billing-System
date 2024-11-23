// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;

// public class CustomerDetails extends JFrame implements ActionListener {
//     private FileConn fileConn;
//     private JTable table;
//     private JButton print;

//     public CustomerDetails() {
//         super("Customer Details");

//         setSize(1200, 650);
//         setLocation(200, 150);

//         String[] columnNames = {"Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
//         List<String[]> customers = getCustomerDetailsFromFile(); // Reading customer data from file
//         Object[][] data = new Object[customers.size()][columnNames.length];

//         for (int i = 0; i < customers.size(); i++) {
//             String[] customerData = customers.get(i);
//             for (int j = 0; j < columnNames.length; j++) {
//                 data[i][j] = customerData[j];  // Populate data for table
//             }
//         }

//         table = new JTable(data, columnNames);
//         JScrollPane sp = new JScrollPane(table);
//         add(sp);

//         print = new JButton("Print");
//         print.addActionListener(this);
//         add(print, "South");

//         setVisible(true);
//     }

//     public void setFileConn(FileConn fileConn) {
//         this.fileConn = fileConn;
//     }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         try {
//             table.print();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

    
//     public List<String[]> getCustomerDetailsFromFile() {
//         List<String[]> customerDetails = new ArrayList<>();
//         String customerFile = "C:\\Users\\DELL\\Desktop\\JAVA PROJECT\\Electricity Billing System\\customers.txt";

//         try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] customerData = line.split(",");
//                 customerDetails.add(customerData);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return customerDetails;
//     }

//     public static void main(String[] args) {
//         new CustomerDetails();
//     }
// }





























// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import javax.swing.*;

// public class CustomerDetails extends JFrame implements ActionListener {
//     private FileConn fileConn;
//     private JTable table;
//     private JButton print;

//     public CustomerDetails() {
//         super("Customer Details");

//         setSize(1200, 650);
//         setLocation(200, 150);

//         String[] columnNames = {"Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
//         List<String[]> customers = getCustomerDetailsFromFile(); // Reading customer data from file
//         Object[][] data = new Object[customers.size()][columnNames.length];

//         for (int i = 0; i < customers.size(); i++) {
//             String[] customerData = customers.get(i);
//             for (int j = 0; j < columnNames.length; j++) {
//                 data[i][j] = customerData[j];  // Populate data for table
//             }
//         }

//         table = new JTable(data, columnNames);
//         JScrollPane sp = new JScrollPane(table);
//         add(sp);

//         print = new JButton("Print");
//         print.addActionListener(this);
//         add(print, BorderLayout.SOUTH);

//         setVisible(true);
//     }

//     public void setFileConn(FileConn fileConn) {
//         this.fileConn = fileConn;
//     }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         try {
//             table.print();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public List<String[]> getCustomerDetailsFromFile() {
//         List<String[]> customerDetails = new ArrayList<>();
//         String customerFile = "C:\\Users\\DELL\\Desktop\\JAVA PROJECT\\Electricity Billing System\\customers.txt";

//         try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 System.out.println("Reading line: " + line);  // Log line for debugging
//                 String[] customerData = line.split(",");
//                 customerDetails.add(customerData);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return customerDetails;
//     }

//     public static void main(String[] args) {
//         new CustomerDetails();
//     }
// }














// import java.awt.event.*;
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import javax.swing.*;

// public class CustomerDetails extends JFrame implements ActionListener {
//     private FileConn fileConn;
//     private JTable table;
//     private JButton print;

//     public CustomerDetails() {
//         super("Customer Details");

//         setSize(1200, 650);
//         setLocation(200, 150);

//         String[] columnNames = {"Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
//         List<String[]> customers = getCustomerDetailsFromFile(); // Reading customer data from file
//         Object[][] data = new Object[customers.size()][columnNames.length];

//         for (int i = 0; i < customers.size(); i++) {
//             String[] customerData = customers.get(i);
//             for (int j = 0; j < columnNames.length; j++) {
//                 data[i][j] = customerData[j];  // Populate data for table
//             }
//         }

//         table = new JTable(data, columnNames);
//         JScrollPane sp = new JScrollPane(table);
//         add(sp);

//         print = new JButton("Print");
//         print.addActionListener(this);
//         add(print, "South");

//         setVisible(true);
//     }

//     public void setFileConn(FileConn fileConn) {
//         this.fileConn = fileConn;
//     }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         try {
//             table.print();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public List<String[]> getCustomerDetailsFromFile() {
//         List<String[]> customerDetails = new ArrayList<>();
//         String customerFile = "customers.txt"; // Ensure correct file path

//         try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] customerData = line.split(",");
//                 customerDetails.add(customerData);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return customerDetails;
//     }

//     public static void main(String[] args) {
//         new CustomerDetails();
//     }
// }







// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import javax.swing.*;

// public class CustomerDetails extends JFrame implements ActionListener {
//     private JTable table;
//     private JButton print;

//     public CustomerDetails() {
//         super("Customer Details");

//         // Set window size and location
//         setSize(1200, 650);
//         setLocation(200, 150);

//         // Define column names for the table
//         String[] columnNames = {"Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
        
//         // Retrieve customer details from the file
//         List<String[]> customers = getCustomerDetailsFromFile(); 
//         Object[][] data = new Object[customers.size()][columnNames.length];

//         // Populate the table data
//         for (int i = 0; i < customers.size(); i++) {
//             String[] customerData = customers.get(i);
//             for (int j = 0; j < columnNames.length; j++) {
//                 data[i][j] = customerData[j];
//             }
//         }

//         // Create the table with customer data and column names
//         table = new JTable(data, columnNames);
//         JScrollPane sp = new JScrollPane(table);
//         add(sp);

//         // Add a Print button
//         print = new JButton("Print");
//         print.addActionListener(this);
//         add(print, BorderLayout.SOUTH);

//         setVisible(true);
//     }

//     // Method to handle the Print button action
//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         try {
//             table.print();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     // Method to read customer details from the file
//     public List<String[]> getCustomerDetailsFromFile() {
//         List<String[]> customerDetails = new ArrayList<>();
//         String customerFile =  "C:\\Users\\DELL\\Desktop\\JAVA PROJECT\\Electricity Billing System\\customers.txt";

//         try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] customerData = line.split(",");
//                 // Ensure the line has exactly 7 fields
//                 if (customerData.length == 7) {
//                     customerDetails.add(customerData);
//                 } else {
//                     System.out.println("Skipping invalid line: " + line);
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return customerDetails;
//     }

//     public static void main(String[] args) {
//         new CustomerDetails();
//     }
// }








// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// import javax.swing.*;

// public class CustomerDetails extends JFrame implements ActionListener {
//     private JTable table;
//     private JButton print;

//     public CustomerDetails() {
//         super("Customer Details");

//         // Set window size and location
//         setSize(1200, 650);
//         setLocation(200, 150);

//         // Define column names for the table
//         String[] columnNames = {"Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
        
//         // Retrieve customer details from the file
//         List<String[]> customers = getCustomerDetailsFromFile();
//         System.out.println("Number of valid customer records: " + customers.size());

//         // Ensure there is data to display
//         if (customers.isEmpty()) {
//             JOptionPane.showMessageDialog(null, "No customer data found!");
//         }

//         Object[][] data = new Object[customers.size()][columnNames.length];

//         // Populate the table data
//         for (int i = 0; i < customers.size(); i++) {
//             String[] customerData = customers.get(i);
//             for (int j = 0; j < columnNames.length; j++) {
//                 data[i][j] = customerData[j];
//             }
//         }

//         // Create the table with customer data and column names
//         table = new JTable(data, columnNames);
//         JScrollPane sp = new JScrollPane(table);
//         add(sp);

//         // Add a Print button
//         print = new JButton("Print");
//         print.addActionListener(this);
//         add(print, BorderLayout.SOUTH);

//         setVisible(true);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//     }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         try {
//             table.print();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public List<String[]> getCustomerDetailsFromFile() {
//         List<String[]> customerDetails = new ArrayList<>();
//         String customerFile = "C:\\Users\\DELL\\Desktop\\JAVA PROJECT\\Electricity Billing System\\customers.txt";  // Ensure this path is correct

//         try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] customerData = line.split(",");
//                 if (customerData.length == 7) {
//                     customerDetails.add(customerData);
//                     System.out.println("Read Customer: " + String.join(", ", customerData));
//                 } else {
//                     System.out.println("Skipping invalid line: " + line);
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         return customerDetails;
//     }

//     public static void main(String[] args) {
//         new CustomerDetails();
//     }
// }










import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class CustomerDetails extends JFrame implements ActionListener {
    private JTable table;
    private JButton print;

    
    private FileConn fileConn;  

     



    public void setFileConn(FileConn fileConn) {
        this.fileConn = fileConn;
    }






    public CustomerDetails() {
        super("Customer Details");

        // Set window size and location
        setSize(1200, 650);
        setLocation(200, 150);

        // Define column names for the table
        String[] columnNames = {"Name", "Meter Number", "Address", "City", "State", "Email", "Phone"};
        
        // Retrieve customer details from the file
        List<String[]> customers = getCustomerDetailsFromFile();
        System.out.println("Number of valid customer records: " + customers.size());

        Object[][] data = new Object[customers.size()][columnNames.length];

        // Populate the table data
        for (int i = 0; i < customers.size(); i++) {
            String[] customerData = customers.get(i);
            for (int j = 0; j < columnNames.length; j++) {
                data[i][j] = customerData[j];
            }
        }

        // Create the table with customer data and column names
        table = new JTable(data, columnNames);
        JScrollPane sp = new JScrollPane(table);
        add(sp);

        // Add a Print button
        print = new JButton("Print");
        print.addActionListener(this);
        add(print, BorderLayout.SOUTH);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            table.print();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getCustomerDetailsFromFile() {
        List<String[]> customerDetails = new ArrayList<>();
        String customerFile = "C:\\Users\\DELL\\Desktop\\JAVA PROJECT\\Electricity Billing System\\customers.txt";  // Ensure this path is correct

        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] customerData = line.split(",");
                if (customerData.length == 7) {
                    customerDetails.add(customerData);
                    System.out.println("Read Customer: " + String.join(", ", customerData));
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return customerDetails;
    }

    public static void main(String[] args) {
        new CustomerDetails();
    }
}
