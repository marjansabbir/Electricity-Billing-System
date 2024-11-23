import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ViewInformation extends JFrame implements ActionListener {
    private FileConn fileConn;
    private JButton cancel;

    public ViewInformation(String meter) {
        setBounds(350, 150, 850, 650);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("VIEW CUSTOMER INFORMATION");
        heading.setBounds(250, 0, 500, 40);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);

        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(70, 80, 100, 20);
        add(lblname);

        JLabel name = new JLabel("");
        name.setBounds(250, 80, 200, 20);
        add(name);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(70, 140, 100, 20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(250, 140, 200, 20);
        add(meternumber);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(70, 200, 100, 20);
        add(lbladdress);

        JLabel address = new JLabel("");
        address.setBounds(250, 200, 200, 20);
        add(address);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(70, 260, 100, 20);
        add(lblcity);

        JLabel city = new JLabel("");
        city.setBounds(250, 260, 200, 20);
        add(city);

        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(500, 80, 100, 20);
        add(lblstate);

        JLabel state = new JLabel("");
        state.setBounds(650, 80, 200, 20);
        add(state);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(500, 140, 100, 20);
        add(lblemail);

        JLabel email = new JLabel("");
        email.setBounds(650, 140, 200, 20);
        add(email);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(500, 200, 100, 20);
        add(lblphone);

        JLabel phone = new JLabel("");
        phone.setBounds(650, 200, 200, 20);
        add(phone);

    
        loadCustomerDataFromFile(meter, name, meternumber, address, city, state, email, phone);

        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(350, 340, 100, 25);
        add(cancel);
        cancel.addActionListener(this);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/viewcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(20, 350, 600, 300);
        add(image);

        setVisible(true);
    }

    public void setFileConn(FileConn fileConn) {
        this.fileConn = fileConn;
    }

    
    private void loadCustomerDataFromFile(String meter, JLabel name, JLabel meternumber, JLabel address,
                                          JLabel city, JLabel state, JLabel email, JLabel phone) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\marjan\\Desktop\\Java\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\customers.txt"))) {
            while ((line = br.readLine()) != null) {
                
                String[] data = line.split(",");

                
                if (data[1].equals(meter)) {
                    name.setText(data[0]);
                    meternumber.setText(data[1]);
                    address.setText(data[2]);
                    city.setText(data[3]);
                    state.setText(data[4]);
                    email.setText(data[5]);
                    phone.setText(data[6]);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewInformation(""); 
    }
}













