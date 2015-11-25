package UI;

import javax.swing.*;
import java.awt.event.*;

public class MainUI extends JDialog{
    private JPanel contentPane;
    private JButton inputButton;
    private JButton percentageCountButton;
    private JButton monthSaleCalulaterButton;
    private JButton totalSaleCalculaterButton;
    private JButton royaltyGeneratorButton;
    private JButton reportProducerButton;
    private JButton buttonOK;
    private JButton buttonCancel;

    public MainUI() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
//        monthSaleCalulaterButton = new JButton();

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
//        ActLer listener  = new ActLer();
//        monthSaleCalulaterButton.addActionListener(listener);
        MouseD mo = new MouseD();
    monthSaleCalulaterButton.addMouseListener(mo);
}

    public class MouseD extends WindowAdapter implements MouseListener {
//        JLabel label = null;
        public  void mouseClicked(MouseEvent e) {
            new MonthCalDlg();
            MonthCalDlg dialog2 = new MonthCalDlg();
            dialog2.pack();
            dialog2.setVisible(true);
        }
        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
//            label.setText("你已经放开鼠标按钮");
        }

        public void mouseEntered(MouseEvent e) {
//            label.setText("鼠标光标进入按钮");
        }
        public void mouseExited(MouseEvent e) {
//            label.setText("鼠标光标离开按钮");
        }
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }

    }
//    public void onMonthCal() {
//        new MonthCalDlg();
//    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        MainUI dialog = new MainUI();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}