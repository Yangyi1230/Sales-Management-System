import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PercentagesCouDlg extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JTextArea result;
    private JTextField clerkName;
    SaleSystem saleSystem;

    public PercentagesCouDlg(SaleSystem saleSystem) {

        this.saleSystem=saleSystem;
        result.setLineWrap(true);
        clerkName.setText(saleSystem.account.getUserName());
        clerkName.setEditable(false);

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
//        dispose();
        result.setText("");
        int month = (int) spinner1.getValue();
        float percent1=saleSystem.percentageCounter.getProPercentageCounterResult(month,saleSystem.account.getUserName())*100;
        float percent2=saleSystem.percentageCounter.getSalePercentageCounterResult(month,saleSystem.account.getUserName())*100;
        result.append("Product Amount Percentage: " + Float.toString(percent1) + "%" + "\r\n");
        result.append("Sale Amount Percentage: " + Float.toString(percent2) + "%" + "\r\n");

    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void main(String[] args) {
        PercentagesCouDlg dialog = new PercentagesCouDlg(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
