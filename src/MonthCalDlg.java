import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MonthCalDlg extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JTextArea resultArea;
    private JTextField clerkName;
    SaleSystem saleSystem;
    public MonthCalDlg(SaleSystem saleSystem) {
        this.saleSystem=saleSystem;

        clerkName.setText(saleSystem.account.getUserName());
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
        int Swing1x= 500;
        int Swing1y = 300;
        this.setBounds(screensize.width / 2 - Swing1x/2,screensize.height/2-Swing1y/2,Swing1x,Swing1y);
    }

    private void onOK() {
// add your code here
        //dispose();
        int month = (int) spinner1.getValue();
        int total=saleSystem.monthSaleCalculator.getClerkTotalSaleAmountPerMonth(month, saleSystem.account.getUserName());

        resultArea.setText(Integer.toString(total));
    }
    private void onCancel() {
// add your code here if necessary
        dispose();
    }
}
