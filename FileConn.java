import java.io.*;

public class FileConn {

    public String[] readCustomerData(String meter) throws IOException {
        String customerFile = "C:\\Users\\marja\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\customers.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(customerFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] customerData = line.split(",");
                if (customerData[1].equals(meter)) { 
                    return customerData;
                }
            }
        }
        return null; 
    }

    public String[] readBillData(String meter, String month) throws IOException {
        String billFile = "C:\\Users\\marja\\Desktop\\Java\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\bills.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(billFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] billData = line.split(",");
                if (billData[0].equals(meter) && billData[1].equals(month)) {
                    return billData;
                }
            }
        }
        return null; 
    }

    public void updateBillStatus(String meter, String month, String status) throws IOException {
        String billFile = "C:\\Users\\marja\\Desktop\\jJava\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\bills.txt";
        File inputFile = new File(billFile);
        File tempFile = new File("temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] billData = line.split(",");
                if (billData[0].equals(meter) && billData[1].equals(month)) {
                    billData[4] = status;
                    line = String.join(",", billData);
                }
                writer.write(line + System.lineSeparator());
            }
        }

        if (!inputFile.delete()) {
            System.out.println("Could not delete original file");
            return;
        }
        if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file");
        }
    }

    public void writeUser(String susername, String spassword, String atype, String smeter) throws IOException {
        String userFile = "C:\\Users\\marja\\Desktop\\Java\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\users.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(userFile, true))) {
            if (atype.equals("Admin")) {
                writer.write(susername + "," + spassword + "," + atype + "\n");
            } else {
                writer.write(susername + "," + spassword + "," + atype + "," + smeter + "\n");
            }
        }
    }

    public String[] readUser(String username, String password, String userType) throws IOException {
        String userFile = "C:\\Users\\marja\\Desktop\\Java\\Desktop\\Java Project 5\\JAVA PROJECT\\Electricity Billing System\\users.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(userFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData[0].equals(username) && userData[1].equals(password) && userData[2].equals(userType)) {
                    
                    if (userType.equals("Admin") && userData.length == 3) {
                        return userData;
                    }
                    return userData;
                }
            }
        }
        return null; 
    }
}
