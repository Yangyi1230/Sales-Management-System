import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TotalSaleCalculaterDlg extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextArea result;
    private JTextField clerkName;
    private JSpinner spinner1;
    private JTextField productName;
    SaleSystem saleSystem;

    public TotalSaleCalculaterDlg(SaleSystem saleSystem) {
        this.saleSystem=saleSystem;

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


        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x= 600;
        int Swing1y = 400;
        this.setBounds(screensize.width / 2 - Swing1x/2,screensize.height/2-Swing1y/2,Swing1x,Swing1y);
    }

    private void onOK() {
// add your code here
//        dispose();
        int proID = (int) spinner1.getValue();
        String name="Towel";
        productName.setText(name);
        int total=saleSystem.totalSaleCalculator.getTotalSaleCalculator(proID);
        result.setText("product total sale volume ："+total);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void main(String[] args) {
        TotalSaleCalculaterDlg dialog = new TotalSaleCalculaterDlg(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
