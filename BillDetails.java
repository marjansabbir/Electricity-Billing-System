import java.awt.*;
import java.util.List;
import javax.swing.*;

public class BillDetails extends JFrame {
    private FileConn fileConn; 

    BillDetails(String meter) {
        setSize(700, 650);
        setLocation(400, 150);
        
        getContentPane().setBackground(Color.WHITE);
        
        JTable table = new JTable();

        
        DataStorage dataStorage = new DataStorage();
        
        
        List<String[]> billData = dataStorage.getBillDetails(meter);
        
        
        String[] columnNames = {"Meter Number", "Month", "Units", "Total Bill", "Status"};
        Object[][] data = new Object[billData.size()][5];

        for (int i = 0; i < billData.size(); i++) {
            data[i] = billData.get(i);
        }

        
        table.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
        
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0, 0, 700, 650);
        add(sp);
        
        setVisible(true);
    }

    
    public void setFileConn(FileConn fileConn) {
        this.fileConn = fileConn;
    }

    public static void main(String[] args) {
        new BillDetails(""); 
    }
}











