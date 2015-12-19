import sun.security.x509.SubjectAlternativeNameExtension;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddDLg extends JDialog {
    SaleSystem saleSystem;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField productName;
    private JTextField amount;
    private JTextField price;

    public AddDLg(SaleSystem saleSystem) {
        this.saleSystem = saleSystem;
        productName.setText("");
        price.setText("");
        amount.setText("");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int swingx = 500;
        int swingy = 300;
        this.setBounds(screensize.width / 2- swingx / 2, screensize.height / 2 - swingy /2, swingx,swingy);
    }

    private void onOK() {
// add your code here
        if(productName.getText().equals("")||amount.getText().equals("")||price.getText().equals("")){
            JOptionPane.showMessageDialog(null, "必须将表单填满以完成输入", "",JOptionPane.ERROR_MESSAGE);
        }else if(saleSystem.addNewProduct.productIsExist(productName.getText())){
            JOptionPane.showMessageDialog(null, "该商品信息已存在", "", JOptionPane.ERROR_MESSAGE);
        } else{
            int productID = Transition.getNextProductId();
            try {
                saleSystem.addNewProduct.addProduct(productID, productName.getText(), Integer.parseInt(price.getText() ), Integer.parseInt(amount.getText()));
                saleSystem.SaveData();
                JOptionPane.showMessageDialog(null, "录入成功", "", JOptionPane.PLAIN_MESSAGE);
            }catch(Exception e){

            }finally {
                productName.setText("");
                price.setText("");
                amount.setText("");
            }
        }
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
