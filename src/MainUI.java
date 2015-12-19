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
    private JButton addButton;
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


        monthSaleCalulaterButton.addActionListener((event)->onMonthCal());

        inputButton.addActionListener ((event)->onInput());

        percentageCountButton.addActionListener((event)->onPercentageCount());

        totalSaleCalculaterButton.addActionListener((event)->onTotalSaleCalculater());

        royaltyGeneratorButton.addActionListener((event)->onRoyaltyGenerator());

        reportProducerButton.addActionListener((event)->onReportProducer());

        addButton.addActionListener((event)->onAdd());

        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x=500;
        int Swing1y=300;
        this.setBounds(screensize.width/2-Swing1x/2,screensize.height/2-Swing1y/2,Swing1x,Swing1y);
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
        SalaryCheckDlg salaryCheckDlg = new SalaryCheckDlg(saleSystem);
        salaryCheckDlg.pack();
        salaryCheckDlg.setVisible(true);
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

    public void onAdd() {
        AddDLg dialog = new AddDLg(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
    }


    private void onCancel() {
// add your code here if necessary
        dispose();
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}