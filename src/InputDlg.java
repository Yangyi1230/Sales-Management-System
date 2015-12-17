import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InputDlg extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField clerkID;
    private JTextField month;
    private JTextField day;
    private JTextField productID;
    private JTextField amount;
    SaleSystem saleSystem;

    public InputDlg(SaleSystem saleSystem) {
        this.saleSystem = saleSystem;


        clerkID.setText("");
        month.setText("");
        day.setText("");
        productID.setText("");

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
        int Swing1x = 500;
        int Swing1y = 300;
        this.setBounds(screensize.width / 2 - Swing1x / 2, screensize.height / 2 - Swing1y / 2, Swing1x, Swing1y);
    }


    private void onOK() {
// add your code here
//        dispose();
        if (clerkID.getText().equals("") || month.getText().equals("") || day.getText().equals("") || productID.getText().equals("") || amount.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "必须将表单填满以完成输入", "", JOptionPane.ERROR_MESSAGE);

        } else {

            if (productID.getText().equals("1")) {
                JOptionPane.showMessageDialog(null, "Pillow 暂时缺货", "", JOptionPane.ERROR_MESSAGE);
            } else {

                saleSystem.informationInput.input(Integer.parseInt(clerkID.getText()), Integer.parseInt(month.getText()), Integer.parseInt(day.getText()), Integer.parseInt(productID.getText()), Integer.parseInt(amount.getText()));
                saleSystem.SaveData();
                JOptionPane.showMessageDialog(null, "录入成功", "", JOptionPane.PLAIN_MESSAGE);

            }
            clerkID.setText("");
            month.setText("");
            day.setText("");
            productID.setText("");
            amount.setText("");

        }
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }


}
