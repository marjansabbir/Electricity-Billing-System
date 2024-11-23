


import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;

public class Signup2 extends JFrame implements ActionListener {

    JButton create, back;
    Choice accountType;
    JTextField meter, username, name, password;
    JLabel lblmeter;

    Signup2() {
        // Increased the frame size to make it bigger
        setBounds(400, 100, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/www.jpg"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
        JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
        setContentPane(backgroundLabel);

        backgroundLabel.setLayout(null);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setBounds(40, 30, 700, 400);  // Adjusted to fit the larger frame
        panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 20, 147), 3), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 203)));
        panel.setBackground(new Color(192, 192, 192, 200)); // Transparent gray background
        panel.setLayout(null);
        panel.setForeground(new Color(34, 139, 34));
        backgroundLabel.add(panel);

        JLabel heading = new JLabel("Create Account As");
        heading.setBounds(100, 50, 140, 20);
        heading.setForeground(new Color(128, 128, 128));
        heading.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(heading);

        accountType = new Choice();
        accountType.add("Customer");
        accountType.add("Admin");
        accountType.setBounds(260, 50, 150, 22);
        panel.add(accountType);

        lblmeter = new JLabel("Meter Number");
        lblmeter.setBounds(100, 90, 140, 20);
        lblmeter.setForeground(new Color(128, 128, 128));
        lblmeter.setFont(new Font("Roboto", Font.BOLD, 14));
        lblmeter.setVisible(false);
        panel.add(lblmeter);

        meter = new JTextField();
        meter.setBounds(260, 90, 150, 20);
        meter.setVisible(false);
        panel.add(meter);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(100, 130, 140, 20);
        lblusername.setForeground(new Color(128, 128, 128));
        lblusername.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(lblusername);

        username = new JTextField();
        username.setBounds(260, 130, 150, 20);
        panel.add(username);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(100, 170, 140, 20);
        lblname.setForeground(new Color(128, 128, 128));
        lblname.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(lblname);

        name = new JTextField();
        name.setBounds(260, 170, 150, 20);
        panel.add(name);

        JLabel lblpassword = new JLabel("Password");
        lblpassword.setBounds(100, 210, 140, 20);
        lblpassword.setForeground(new Color(128, 128, 128));
        lblpassword.setFont(new Font("Roboto", Font.BOLD, 14));
        panel.add(lblpassword);

        password = new JTextField();
        password.setBounds(260, 210, 150, 20);
        panel.add(password);

        create = new JButton("Create");
        create.setBackground(Color.BLACK);
        create.setForeground(Color.WHITE);
        create.setBounds(140, 260, 120, 25);
        create.addActionListener(this);
        panel.add(create);

        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300, 260, 120, 25);
        back.addActionListener(this);
        panel.add(back);

        // Added hover effect to change button color to pink
        addButtonHoverEffect(create);
        addButtonHoverEffect(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 250, 250);  // Adjusted image position for larger frame
        panel.add(image);

        ImageIcon photo = new ImageIcon("Icon/last.png");
        setIconImage(photo.getImage());

        // Add the item listener to handle visibility of meter input
        accountType.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ae) {
                toggleMeterVisibility();
            }
        });

        // Initially check the default selection to set visibility
        toggleMeterVisibility();

        setVisible(true);
    }

    // Method to toggle meter visibility based on account type
    private void toggleMeterVisibility() {
        String user = accountType.getSelectedItem();
        if (user.equals("Customer")) {
            lblmeter.setVisible(true);
            meter.setVisible(true);
            name.setEditable(true);
        } else if (user.equals("Admin")) {
            lblmeter.setVisible(false);
            meter.setVisible(false);
            name.setEditable(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == create) {
            String atype = accountType.getSelectedItem();
            String susername = username.getText();
            String sname = name.getText();
            String spassword = password.getText();
            String smeter = meter.getText();

            FileConn fileConn = new FileConn();
            try {
                File file = new File("C:\\Users\\marja\\Desktop\\Java\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\users.txt");
                File directory = new File(file.getParent());

                if (!directory.exists()) {
                    directory.mkdirs(); // Create directories if they don't exist
                }

                if (!file.exists()) {
                    file.createNewFile();
                }

                fileConn.writeUser(susername, spassword, atype, smeter);

                JOptionPane.showMessageDialog(null, "Account Created Successfully: " + susername);
                setVisible(false);
                new Login1();
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error creating account. Please try again.");
            }
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Login1();
        }
    }

    private void addButtonHoverEffect(JButton button) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.PINK); // Change to pink on hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.BLACK); // Revert to black when mouse exits
            }
        });
    }

    public static void main(String[] args) {
        new Signup2();
    }
}










    
// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import javax.swing.*;
// import javax.swing.border.*;

// public class Signup2 extends JFrame implements ActionListener {

//     JButton create, back;
//     Choice accountType;
//     JTextField meter, username, name, password;
//     JLabel lblmeter;

//     Signup2() {
//         setBounds(400, 100, 800, 500);
//         setDefaultCloseOperation(EXIT_ON_CLOSE);

//         ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/www.jpg"));
//         Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
//         ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
//         JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
//         setContentPane(backgroundLabel);

//         backgroundLabel.setLayout(null);

//         JPanel panel = new JPanel();
//         panel.setBounds(40, 30, 700, 400);
//         panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 20, 147), 3), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 203)));
//         panel.setBackground(new Color(192, 192, 192, 200));
//         panel.setLayout(null);
//         backgroundLabel.add(panel);

//         JLabel heading = new JLabel("Create Account As");
//         heading.setBounds(100, 50, 140, 20);
//         heading.setForeground(new Color(128, 128, 128));
//         heading.setFont(new Font("Roboto", Font.BOLD, 14));
//         panel.add(heading);

//         accountType = new Choice();
//         accountType.add("Customer");
//         accountType.add("Admin");
//         accountType.setBounds(260, 50, 150, 22);
//         panel.add(accountType);

//         lblmeter = new JLabel("Meter Number");
//         lblmeter.setBounds(100, 90, 140, 20);
//         lblmeter.setForeground(new Color(128, 128, 128));
//         lblmeter.setFont(new Font("Roboto", Font.BOLD, 14));
//         lblmeter.setVisible(false);
//         panel.add(lblmeter);

//         meter = new JTextField();
//         meter.setBounds(260, 90, 150, 20);
//         meter.setVisible(false);
//         panel.add(meter);

//         JLabel lblusername = new JLabel("Username");
//         lblusername.setBounds(100, 130, 140, 20);
//         lblusername.setForeground(new Color(128, 128, 128));
//         lblusername.setFont(new Font("Roboto", Font.BOLD, 14));
//         panel.add(lblusername);

//         username = new JTextField();
//         username.setBounds(260, 130, 150, 20);
//         panel.add(username);

//         JLabel lblname = new JLabel("Name");
//         lblname.setBounds(100, 170, 140, 20);
//         lblname.setForeground(new Color(128, 128, 128));
//         lblname.setFont(new Font("Roboto", Font.BOLD, 14));
//         panel.add(lblname);

//         name = new JTextField();
//         name.setBounds(260, 170, 150, 20);
//         name.setEditable(false); // Initially not editable
//         panel.add(name);

//         JLabel lblpassword = new JLabel("Password");
//         lblpassword.setBounds(100, 210, 140, 20);
//         lblpassword.setForeground(new Color(128, 128, 128));
//         lblpassword.setFont(new Font("Roboto", Font.BOLD, 14));
//         panel.add(lblpassword);

//         password = new JTextField();
//         password.setBounds(260, 210, 150, 20);
//         panel.add(password);

//         create = new JButton("Create");
//         create.setBackground(Color.BLACK);
//         create.setForeground(Color.WHITE);
//         create.setBounds(140, 260, 120, 25);
//         create.addActionListener(this);
//         panel.add(create);

//         back = new JButton("Back");
//         back.setBackground(Color.BLACK);
//         back.setForeground(Color.WHITE);
//         back.setBounds(300, 260, 120, 25);
//         back.addActionListener(this);
//         panel.add(back);

//         addButtonHoverEffect(create);
//         addButtonHoverEffect(back);

//         accountType.addItemListener(new ItemListener() {
//             public void itemStateChanged(ItemEvent ae) {
//                 toggleMeterVisibility();
//             }
//         });

//         toggleMeterVisibility(); // Initial check for visibility
//         setVisible(true);
//     }

//     private void toggleMeterVisibility() {
//         String user = accountType.getSelectedItem();
//         if (user.equals("Customer")) {
//             lblmeter.setVisible(true);
//             meter.setVisible(true);
//             meter.addFocusListener(new FocusAdapter() {
//                 public void focusLost(FocusEvent e) {
//                     autofillCustomerName();
//                 }
//             });
//             name.setEditable(false); // Name should be auto-filled
//         } else if (user.equals("Admin")) {
//             lblmeter.setVisible(false);
//             meter.setVisible(false);
//             name.setEditable(true); // Admin can manually enter name
//         }
//     }

//     private void autofillCustomerName() {
//         String meterNumber = meter.getText();
//         String customerName = getCustomerNameByMeter(meterNumber);
//         if (customerName != null) {
//             name.setText(customerName);
//         } else {
//             JOptionPane.showMessageDialog(this, "Customer with this meter number not found.");
//             name.setText(""); // Clear name if not found
//         }
//     }

//     private String getCustomerNameByMeter(String meterNumber) {
//         String customerFile = "C:\\Users\\DELL\\Desktop\\JAVA PROJECT\\Electricity Billing System\\customers.txt"; // Ensure this path is correct
//         try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
//             String line;
//             while ((line = reader.readLine()) != null) {
//                 String[] customerDetails = line.split(",");
//                 if (customerDetails.length > 1 && customerDetails[1].equals(meterNumber)) {
//                     return customerDetails[0]; // Return the customer name
//                 }
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         return null; // Return null if not found
//     }

//     @Override
//     public void actionPerformed(ActionEvent ae) {
//         if (ae.getSource() == create) {
//             String atype = accountType.getSelectedItem();
//             String susername = username.getText();
//             String sname = name.getText();
//             String spassword = password.getText();
//             String smeter = meter.getText();

//             if (atype.equals("Customer") && sname.isEmpty()) {
//                 JOptionPane.showMessageDialog(this, "Please enter a valid meter number.");
//                 return;
//             }

//             FileConn fileConn = new FileConn();
//             try {
//                 File file = new File("C:\\Users\\marja\\Desktop\\Java\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\users.txt");
//                 if (!file.getParentFile().exists()) {
//                     file.getParentFile().mkdirs();
//                 }
//                 if (!file.exists()) {
//                     file.createNewFile();
//                 }

//                 fileConn.writeUser(susername, spassword, atype, smeter);
//                 JOptionPane.showMessageDialog(null, "Account Created Successfully: " + susername);
//                 setVisible(false);
//                 new Login1();
//             } catch (IOException e) {
//                 e.printStackTrace();
//                 JOptionPane.showMessageDialog(null, "Error creating account. Please try again.");
//             }
//         } else if (ae.getSource() == back) {
//             setVisible(false);
//             new Login1();
//         }
//     }

//     private void addButtonHoverEffect(JButton button) {
//         button.addMouseListener(new MouseAdapter() {
//             @Override
//             public void mouseEntered(MouseEvent e) {
//                 button.setBackground(Color.PINK);
//             }

//             @Override
//             public void mouseExited(MouseEvent e) {
//                 button.setBackground(Color.BLACK);
//             }
//         });
//     }

//     public static void main(String[] args) {
//         new Signup2();
//     }
// }












// // import java.awt.*;
// // import java.awt.event.*;
// // import java.io.*;
// // import javax.swing.*;
// // import javax.swing.border.*;

// // public class Signup2 extends JFrame implements ActionListener {

// //     JButton create, back;
// //     Choice accountType;
// //     JTextField meter, username, name, password;
// //     JLabel lblmeter;

// //     Signup2() {
// //         // Increased the frame size to make it bigger
// //         setBounds(400, 100, 800, 500);
// //         setDefaultCloseOperation(EXIT_ON_CLOSE);

// //         ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/www.jpg"));
// //         Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 500, Image.SCALE_DEFAULT);
// //         ImageIcon scaledBackgroundIcon = new ImageIcon(backgroundImage);
// //         JLabel backgroundLabel = new JLabel(scaledBackgroundIcon);
// //         setContentPane(backgroundLabel);

// //         backgroundLabel.setLayout(null);

// //         JPanel panel = new JPanel() {
// //             @Override
// //             protected void paintComponent(Graphics g) {
// //                 super.paintComponent(g);
// //                 g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
// //             }
// //         };
// //         panel.setBounds(40, 30, 700, 400);  // Adjusted to fit the larger frame
// //         panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 20, 147), 3), "Create-Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 102, 203)));
// //         panel.setBackground(new Color(192, 192, 192, 200)); // Transparent gray background
// //         panel.setLayout(null);
// //         panel.setForeground(new Color(34, 139, 34));
// //         backgroundLabel.add(panel);

// //         JLabel heading = new JLabel("Create Account As");
// //         heading.setBounds(100, 50, 140, 20);
// //         heading.setForeground(new Color(128, 128, 128));
// //         heading.setFont(new Font("Roboto", Font.BOLD, 14));
// //         panel.add(heading);

// //         accountType = new Choice();
// //         accountType.add("Customer");
// //         accountType.add("Admin");
// //         accountType.setBounds(260, 50, 150, 22);
// //         panel.add(accountType);

// //         lblmeter = new JLabel("Meter Number");
// //         lblmeter.setBounds(100, 90, 140, 20);
// //         lblmeter.setForeground(new Color(128, 128, 128));
// //         lblmeter.setFont(new Font("Roboto", Font.BOLD, 14));
// //         lblmeter.setVisible(false);
// //         panel.add(lblmeter);

// //         meter = new JTextField();
// //         meter.setBounds(260, 90, 150, 20);
// //         meter.setVisible(false);
// //         panel.add(meter);

// //         JLabel lblusername = new JLabel("Username");
// //         lblusername.setBounds(100, 130, 140, 20);
// //         lblusername.setForeground(new Color(128, 128, 128));
// //         lblusername.setFont(new Font("Roboto", Font.BOLD, 14));
// //         panel.add(lblusername);

// //         username = new JTextField();
// //         username.setBounds(260, 130, 150, 20);
// //         panel.add(username);

// //         JLabel lblname = new JLabel("Name");
// //         lblname.setBounds(100, 170, 140, 20);
// //         lblname.setForeground(new Color(128, 128, 128));
// //         lblname.setFont(new Font("Roboto", Font.BOLD, 14));
// //         panel.add(lblname);

// //         name = new JTextField();
// //         name.setBounds(260, 170, 150, 20);
// //         panel.add(name);

// //         JLabel lblpassword = new JLabel("Password");
// //         lblpassword.setBounds(100, 210, 140, 20);
// //         lblpassword.setForeground(new Color(128, 128, 128));
// //         lblpassword.setFont(new Font("Roboto", Font.BOLD, 14));
// //         panel.add(lblpassword);

// //         password = new JTextField();
// //         password.setBounds(260, 210, 150, 20);
// //         panel.add(password);

// //         create = new JButton("Create");
// //         create.setBackground(Color.BLACK);
// //         create.setForeground(Color.WHITE);
// //         create.setBounds(140, 260, 120, 25);
// //         create.addActionListener(this);
// //         panel.add(create);

// //         back = new JButton("Back");
// //         back.setBackground(Color.BLACK);
// //         back.setForeground(Color.WHITE);
// //         back.setBounds(300, 260, 120, 25);
// //         back.addActionListener(this);
// //         panel.add(back);

// //         // Added hover effect to change button color to pink
// //         addButtonHoverEffect(create);
// //         addButtonHoverEffect(back);

// //         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/signupImage.png"));
// //         Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
// //         ImageIcon i3 = new ImageIcon(i2);
// //         JLabel image = new JLabel(i3);
// //         image.setBounds(450, 50, 250, 250);  // Adjusted image position for larger frame
// //         panel.add(image);

// //         ImageIcon photo = new ImageIcon("Icon/last.png");
// //         setIconImage(photo.getImage());

// //         // Add the item listener to handle visibility of meter input and name field behavior
// //         accountType.addItemListener(new ItemListener() {
// //             public void itemStateChanged(ItemEvent ae) {
// //                 toggleMeterVisibility();
// //             }
// //         });

// //         // Initially check the default selection to set visibility
// //         toggleMeterVisibility();

// //         setVisible(true);
// //     }

// //     // Method to toggle meter visibility based on account type
// //     private void toggleMeterVisibility() {
// //         String user = accountType.getSelectedItem();
// //         if (user.equals("Customer")) {
// //             lblmeter.setVisible(true);
// //             meter.setVisible(true);
// //             name.setEditable(false); // Make name field non-editable for Customer
// //             // Assuming the meter number is auto-generated or retrieved from another method
// //             meter.setText(generateMeterNumber()); // Generate or retrieve meter number
// //         } else if (user.equals("Admin")) {
// //             lblmeter.setVisible(false);
// //             meter.setVisible(false);
// //             name.setEditable(true); // Allow editing of name for Admin
// //         }
// //     }

// //     // Dummy method to simulate meter number generation or retrieval
// //     private String generateMeterNumber() {
// //         // Logic to generate or retrieve meter number
// //         // For now, just returning a random number as string
// //         return String.valueOf((int) (Math.random() * 1000000));
// //     }

// //     @Override
// //     public void actionPerformed(ActionEvent ae) {
// //         if (ae.getSource() == create) {
// //             String atype = accountType.getSelectedItem();
// //             String susername = username.getText();
// //             String sname = name.getText();
// //             String spassword = password.getText();
// //             String smeter = meter.getText();

// //             FileConn fileConn = new FileConn();
// //             try {
// //                 File file = new File("C:\\Users\\marja\\Desktop\\Java\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\users.txt");
// //                 File directory = new File(file.getParent());

// //                 if (!directory.exists()) {
// //                     directory.mkdirs(); // Create directories if they don't exist
// //                 }

// //                 if (!file.exists()) {
// //                     file.createNewFile();
// //                 }

// //                 fileConn.writeUser(susername, spassword, atype, smeter);

// //                 JOptionPane.showMessageDialog(null, "Account Created Successfully: " + susername);
// //                 setVisible(false);
// //                 new Login1();
// //             } catch (IOException e) {
// //                 e.printStackTrace();
// //                 JOptionPane.showMessageDialog(null, "Error creating account. Please try again.");
// //             }
// //         } else if (ae.getSource() == back) {
// //             setVisible(false);
// //             new Login1();
// //         }
// //     }

// //     private void addButtonHoverEffect(JButton button) {
// //         button.addMouseListener(new MouseAdapter() {
// //             @Override
// //             public void mouseEntered(MouseEvent e) {
// //                 button.setBackground(Color.PINK); // Change to pink on hover
// //             }

// //             @Override
// //             public void mouseExited(MouseEvent e) {
// //                 button.setBackground(Color.BLACK); // Revert to black when mouse exits
// //             }
// //         });
// //     }

// //     public static void main(String[] args) {
// //         new Signup2();
// //     }
// }
