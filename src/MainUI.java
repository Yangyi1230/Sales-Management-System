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
    public static SaleSystem saleSystem;


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


        monthSaleCalulaterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onMonthCal();
            }
        });

        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x=500;
        int Swing1y=300;
        this.setBounds(screensize.width/2-Swing1x/2,screensize.height/2-Swing1y/2,Swing1x,Swing1y);

        inputButton.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onInput();
            }
        });
        percentageCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onPercentageCount();
            }
        });
        totalSaleCalculaterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onTotalSaleCalculater();
            }
        });
        royaltyGeneratorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onRoyaltyGenerator();
            }
        });
        reportProducerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onReportProducer();
            }
        });
    }

    public void onInput() {
        InputDlg dialog = new InputDlg(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
    }
    public void onPercentageCount() {
        PercentagesCouDlg dialog = new PercentagesCouDlg(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
    }
    public void onTotalSaleCalculater() {
        TotalSaleCalculaterDlg dialog = new TotalSaleCalculaterDlg(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
    }
    public void onRoyaltyGenerator() {
        SalaryCounterDlg dialog = new SalaryCounterDlg();
        dialog.pack();
        dialog.setVisible(true);
    }
    public void onReportProducer() {
        ReportProducerDlg dialog = new ReportProducerDlg(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
    }

    public void onMonthCal() {
        MonthCalDlg monthCalDlg = new MonthCalDlg(saleSystem);
        monthCalDlg.pack();
        monthCalDlg.setVisible(true);
    }

//    private void onOK() {
//// add your code here
//        dispose();
//    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        SaleSystem saleSystem = new SaleSystem("Tom");
        MainUI dialog = new MainUI(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}