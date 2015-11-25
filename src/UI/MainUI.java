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

    monthSaleCalulaterButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            onMonthCal();
        }
    });

        percentageCountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {onPercentagecount();}
        });

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {onInput();}
        });

        totalSaleCalculaterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {onTotalSaleCalculater();}
        });
        royaltyGeneratorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {onRoyaltyGenerator();}
        });
        reportProducerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {onReportProducer();}
        });
    }

    private void onOK() {
// add your code here
        dispose();
    }

    private void onPercentagecount() {
// add your code here
        PercentagesCouDlg dialog = new PercentagesCouDlg();
        dialog.pack();
        dialog.setVisible(true);
    }

    public void onTotalSaleCalculater() {
        TotalSaleCalculaterDlg dialog = new TotalSaleCalculaterDlg();
        dialog.pack();
        dialog.setVisible(true);
    }
    public void onRoyaltyGenerator() {
        RoyaltyGeneratorDlg dialog = new RoyaltyGeneratorDlg();
        dialog.pack();
        dialog.setVisible(true);
    }
    public void onReportProducer() {
        ReportProducerDlg dialog = new ReportProducerDlg();
        dialog.pack();
        dialog.setVisible(true);
    }
    public void onInput() {
        InputDlg dialog = new InputDlg();
        dialog.pack();
        dialog.setVisible(true);
    }

    public void onMonthCal() {
        MonthCalDlg dialog = new MonthCalDlg();
        dialog.pack();
        dialog.setVisible(true);
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