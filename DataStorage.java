import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
public class DataStorage {
 
    public static final String BILL_FILE = "C:\\Users\\DELL\\Desktop\\JAVA PROJECT\\Electricity Billing System\\bills.txt";
   public static final String TAX_FILE = "C:\\Users\\DELL\\Desktop\\JAVA PROJECT\\Electricity Billing System\\tax.txt";
 
    
    public List<String[]> getBillDetails(String meter) {
        List<String[]> billDetails = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(BILL_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] billData = line.split(",");
                if (billData[0].equals(meter)) {
                    billDetails.add(billData);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return billDetails;
    }
 
    
    public void saveBill(String meter, String month, String units, int totalBill) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BILL_FILE, true))) {
            writer.write(meter + "," + month + "," + units + "," + totalBill + ",Not Paid");
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    
    public int[] getTaxDetails() {
        int[] taxes = new int[6]; 
        try (BufferedReader reader = new BufferedReader(new FileReader(TAX_FILE))) {
            String line;
            if ((line = reader.readLine()) != null) {
                String[] taxData = line.split(",");
                for (int i = 0; i < taxData.length; i++) {
                    taxes[i] = Integer.parseInt(taxData[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return taxes;
    }
}













