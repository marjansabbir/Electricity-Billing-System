import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class HomePage implements ActionListener {
    JFrame frm3;
    JPanel pnlAccount, pnlCart, pnlConsoles;
    JLabel lblCartBar, lblUserBar, lblCART;
    JButton btnUser, btnCart, btnConsole1, btnConsole2, btnConsole3, btnConsole4, btnConsole5, btnProceedToCheckout;
    ArrayList<String> cartItems = new ArrayList<>(); 
    JTextArea cartDisplayArea; 
    
    
    public HomePage(String username) {
        frm3 = new JFrame("Homepage");
        frm3.getContentPane().setBackground(Color.decode("#FFF8F0"));
        frm3.setSize(1700, 1020);
        frm3.setLayout(null);
        frm3.setLocationRelativeTo(null);
        frm3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm3.setResizable(false);

        
        pnlCart = new JPanel();
        pnlCart.setLayout(null);
        pnlCart.setBackground(Color.decode("#2C3E50"));
        pnlCart.setBounds(1300, 80, 400, 940);
        frm3.add(pnlCart);

        lblCART = new JLabel("Cart");
        lblCART.setBounds(30, 20, 250, 30);
        lblCART.setFont(new Font("Roboto", Font.BOLD, 23));
        lblCART.setForeground(Color.WHITE);
        pnlCart.add(lblCART);

        cartDisplayArea = new JTextArea(); 
        cartDisplayArea.setBounds(30, 60, 340, 600);
        cartDisplayArea.setFont(new Font("Roboto", Font.PLAIN, 17));
        cartDisplayArea.setEditable(false);
        cartDisplayArea.setBackground(Color.decode("#FFF8F0"));
        pnlCart.add(cartDisplayArea);

        btnProceedToCheckout = new JButton("$ PROCEED TO CHECKOUT >");
        btnProceedToCheckout.setFont(new Font("Roboto", Font.BOLD, 17));
        btnProceedToCheckout.setBounds(70, 700, 260, 35);
        pnlCart.add(btnProceedToCheckout);

        
        pnlConsoles = new JPanel();
        pnlConsoles.setLayout(new GridLayout(2, 4, 30, 30));
        pnlConsoles.setBackground(Color.decode("#FFF8F0"));
        pnlConsoles.setBounds(0, 345, 1300, 500);
        frm3.add(pnlConsoles);

        
        btnConsole1 = createProductButton("PlayStation 5 Pro", "PlayStation 5 Pro.png");
        pnlConsoles.add(btnConsole1);

        btnConsole2 = createProductButton("PlayStation 5", "PlayStation 5.png");
        pnlConsoles.add(btnConsole2);

        btnConsole3 = createProductButton("XBOXX", "XBOXX.png");
        pnlConsoles.add(btnConsole3);

        btnConsole4 = createProductButton("XBOXS", "XBOXS.png");
        pnlConsoles.add(btnConsole4);

        btnConsole5 = createProductButton("Steam Deck", "Steam.png");
        pnlConsoles.add(btnConsole5);

    
        frm3.setVisible(true);
    }

    private JButton createProductButton(String productName, String iconPath) {
        JButton button = new JButton();
        button.setIcon(new ImageIcon(iconPath));
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.addActionListener(e -> addToCart(productName)); 
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setContentAreaFilled(true);
                button.setBackground(Color.decode("#ffbd59"));
            }

            public void mouseExited(MouseEvent e) {
                button.setContentAreaFilled(false);
                button.setBackground(Color.decode("#FFF8F0"));
            }
        });
        return button;
    }

    private void addToCart(String product) {
        
        cartItems.add(product);
        
        cartDisplayArea.setText("");
        for (String item : cartItems) {
            cartDisplayArea.append(item + "\n");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    
    public static void main(String[] args) {
        new HomePage("User123"); 
    }
}
