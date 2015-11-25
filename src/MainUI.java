import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MainUI extends JDialog {
    private JPanel contentPane;
    private JButton inputButton;
    private JButton percentageCountButton;
    private JButton monthSaleCalulaterButton;
    private JButton totalSaleCalculaterButton;
    private JButton royaltyGeneratorButton;
    private JButton reportProducerButton;
    private JButton buttonOK;
    private JButton buttonCancel;
    public SaleSystem saleSystem;


    public MainUI(SaleSystem saleSystem) {

        this.saleSystem = saleSystem;

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

        MouseD mo = new MouseD();
        monthSaleCalulaterButton.addMouseListener(mo);

        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x=500;
        int Swing1y=300;
        this.setBounds(screensize.width/2-Swing1x/2,screensize.height/2-Swing1y/2,Swing1x,Swing1y);
    }


    public class MouseD extends WindowAdapter implements MouseListener {
        //        JLabel label = null;
        public void mouseClicked(MouseEvent e) {
            new MonthCalDlg(saleSystem);
            MonthCalDlg monthCalDlg = new MonthCalDlg(saleSystem);
            monthCalDlg.pack();
            monthCalDlg.setVisible(true);
        }

        public void mousePressed(MouseEvent e) {
        }

        public void mouseReleased(MouseEvent e) {
//            label.setText("���Ѿ��ſ���갴ť");
        }

        public void mouseEntered(MouseEvent e) {
//            label.setText("�������밴ť");
        }

        public void mouseExited(MouseEvent e) {
//            label.setText("������뿪��ť");
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
        SaleSystem saleSystem = new SaleSystem();
        MainUI dialog = new MainUI(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}