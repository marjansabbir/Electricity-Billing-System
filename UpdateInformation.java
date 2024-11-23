import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class UpdateInformation extends JFrame implements ActionListener {
    JTextField tfaddress, tfstate, tfcity, tfemail, tfphone;
    JButton update, cancel;
    String meter;
    JLabel name;
    private FileConn fileConn; 

    UpdateInformation(String meter) {
        this.meter = meter;
        setBounds(300, 150, 1050, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("UPDATE CUSTOMER INFORMATION");
        heading.setBounds(110, 0, 400, 30);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(30, 70, 100, 20);
        add(lblname);

        name = new JLabel("");
        name.setBounds(230, 70, 200, 20);
        add(name);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(30, 110, 100, 20);
        add(lblmeternumber);

        JLabel meternumber = new JLabel("");
        meternumber.setBounds(230, 110, 200, 20);
        add(meternumber);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(30, 150, 100, 20);
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(230, 150, 200, 20);
        add(tfaddress);

        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(30, 190, 100, 20);
        add(lblcity);

        tfcity = new JTextField();
        tfcity.setBounds(230, 190, 200, 20);
        add(tfcity);

        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(30, 230, 100, 20);
        add(lblstate);

        tfstate = new JTextField();
        tfstate.setBounds(230, 230, 200, 20);
        add(tfstate);

        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(30, 270, 100, 20);
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(230, 270, 200, 20);
        add(tfemail);

        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(30, 310, 100, 20);
        add(lblphone);

        tfphone = new JTextField();
        tfphone.setBounds(230, 310, 200, 20);
        add(tfphone);

        
        loadCustomerDataFromFile(meter);

        
        update = new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(70, 360, 100, 25);
        add(update);
        update.addActionListener(this);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230, 360, 100, 25);
        add(cancel);
        cancel.addActionListener(this);

        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(550, 50, 400, 300);
        add(image);




        setVisible(true);
		
		
		
		
    }


    




    
    private void loadCustomerDataFromFile(String meter) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("customers.txt"))) {
            while ((line = br.readLine()) != null) {
                
                String[] data = line.split(",");
                if (data[1].equals(meter)) {
                    name.setText(data[0]);
                    tfaddress.setText(data[2]);
                    tfcity.setText(data[3]);
                    tfstate.setText(data[4]);
                    tfemail.setText(data[5]);
                    tfphone.setText(data[6]);
                    
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    private void updateCustomerDataInFile() {
        List<String> fileContent = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader("customers.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equals(meter)) {
                    
                    String updatedLine = String.join(",", name.getText(), meter, tfaddress.getText(), tfcity.getText(),
                            tfstate.getText(), tfemail.getText(), tfphone.getText());
                    fileContent.add(updatedLine);
                } else {
                    fileContent.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("customers.txt"))) {
            for (String contentLine : fileContent) {
                bw.write(contentLine);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == update) {
            updateCustomerDataInFile();
            JOptionPane.showMessageDialog(null, "User Information Updated Successfully");
            setVisible(false);
        } else {
            setVisible(false);
        }
    }

    
    public void setFileConn(FileConn fileConn) {
        this.fileConn = fileConn;
    }

    public static void main(String[] args) {
		
		
		
        new UpdateInformation("123456"); 
   



   }
}





