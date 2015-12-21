import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputDlg extends JDialog {
    SaleSystem saleSystem;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField clerkName;
    private JTextField month;
    private JTextField day;
    private JTextField productName;
    private JTextField amount;

    public InputDlg(SaleSystem saleSystem) {
        this.saleSystem = saleSystem;
        clerkName.setText("");
        month.setText("");
        day.setText("");
        productName.setText("");
        amount.setText("");
        clerkName.setText(saleSystem.account.getClerkName());
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
        int Swing1x = 500;
        int Swing1y = 300;
        this.setBounds(screensize.width / 2 - Swing1x / 2, screensize.height / 2 - Swing1y / 2, Swing1x, Swing1y);


    }


    private void onOK() {
        if (clerkName.getText().equals("") || month.getText().equals("") || day.getText().equals("") || productName.getText().equals("") || amount.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "必须将表单填满以完成输入", "", JOptionPane.ERROR_MESSAGE);
        } else {
            int productId;
            productId = Transition.getProductIdByName(productName.getText());
            if (productId != -1) {
                try {
                    Transition.calculateStoreAmount(productId, Integer.parseInt(amount.getText()));
                    saleSystem.informationInput.input(saleSystem.account.getClerkID(), Integer.parseInt(month.getText()), Integer.parseInt(day.getText()), productId, Integer.parseInt(amount.getText()));
                    saleSystem.saveData();
                    JOptionPane.showMessageDialog(null, "录入成功", "", JOptionPane.PLAIN_MESSAGE);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "该商品库存不足,无法出售", "", JOptionPane.ERROR_MESSAGE);
                } finally {
                    month.setText("");
                    day.setText("");
                    productName.setText("");
                    amount.setText("");
                }
            } else {
                JOptionPane.showMessageDialog(null, "无相关商品", "", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }


}
