import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import java.util.Iterator;

public class ReportProducerDlg extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner dayDaySpinner;
    private JPanel TablePanel;
    private JPanel contentArea;
    private JPanel operatePanel;
    private JSpinner monthSpinner;
    private JRadioButton dayRadioButton;
    private JRadioButton monthRadioButton;
    private JSpinner dayMonthSpinner;
    private JSpinner quarterSpinner;
    private JRadioButton quarterRadioButton;
    private JSpinner yearSpinner;
    private JRadioButton yearRadioButton;
    SaleSystem saleSystem;
    private ButtonGroup buttonGroup;

    public ReportProducerDlg(SaleSystem saleSystem) {
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

        //使得buttonGroup内的 radioButton 变为单选状态

        buttonGroup=new ButtonGroup();

        buttonGroup.add(dayRadioButton);
        buttonGroup.add(monthRadioButton);
        buttonGroup.add(yearRadioButton);
        buttonGroup.add(quarterRadioButton);



// construct a new Listener
        ActionListener sliceActionListener =new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AbstractButton rButton=(AbstractButton)e.getSource();
                String name=rButton.getText();

                switch(name){
                    case "Day":
                    {
                        JFormattedTextField tf=((JSpinner.DefaultEditor)dayMonthSpinner.getEditor()).getTextField();
                        tf.setEnabled(true);
                        JFormattedTextField tf2=((JSpinner.DefaultEditor)dayDaySpinner.getEditor()).getTextField();
                        tf2.setEnabled(true);
                    }
                    break;
                    case "Month":
                    {
                        JFormattedTextField tf=((JSpinner.DefaultEditor)monthSpinner.getEditor()).getTextField();
                        tf.setEnabled(true);
                    }
                    break;
                    case "Quarter":
                    {
                        JFormattedTextField tf=((JSpinner.DefaultEditor)quarterSpinner.getEditor()).getTextField();
                        tf.setEnabled(true);
                    }
                    break;
                    case "Year":
                    {
                        JFormattedTextField tf=((JSpinner.DefaultEditor)yearSpinner.getEditor()).getTextField();
                        tf.setEnabled(true);
                    }
                    break;
                }
            }
        };

        dayRadioButton.addActionListener(sliceActionListener);
        monthRadioButton.addActionListener(sliceActionListener);
        yearRadioButton.addActionListener(sliceActionListener);
        quarterRadioButton.addActionListener(sliceActionListener);




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
        int Swing1x=500;
        int Swing1y=300;
        this.setBounds(screensize.width/2-Swing1x/2,screensize.height/2-Swing1y/2,Swing1x,Swing1y);


    }

    private void onOK() {



        int month=(int) monthSpinner.getValue();


        int dayDay=(int) dayDaySpinner.getValue();
        int dayMonth=(int) dayMonthSpinner.getValue();
        int quater=(int) quarterSpinner.getValue();

        String[] columnNames={"员工","pillow","curtain","towel","bathmat","quilt","总销售额"};

        Object rowData[][]=null;


        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {

                String x= button.getText();

                switch(x){
                    case "Day":
                    {
                        rowData=saleSystem.reportProducer.dayRowDataProducer(dayMonth,dayDay);
                    }
                    break;
                    case "Month":
                    {
                        rowData=saleSystem.reportProducer.monthRowDataProducer(month);
                    }
                    break;
                    case "Quarter":
                    {
                        rowData=saleSystem.reportProducer.quaterRowDataProducer(quater - 1);
                    }
                    break;
                    case "Year":
                    {
                        // to do
                    }
                    break;
                }
            }
        }






        JTable table=new JTable(rowData,columnNames);

        tableInitialise(table);


    }

    //初始化 Jtable 格式并显示
    void tableInitialise(JTable table){

        JScrollPane scroll;
        TableColumn column = null;

        int colunms = table.getColumnCount();
        for(int y = 0; y < colunms; y++)
        {
            column = table.getColumnModel().getColumn(y);
            /*将每一列的默认宽度设置为100*/
            column.setPreferredWidth(100);
        }
        /*
         * 设置JTable自动调整列表的状态，此处设置为关闭
         */
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFont(new Font("Menu.font", Font.PLAIN, 14));
        table.getTableHeader().setFont(new Font("Menu.font", Font.BOLD, 15));
        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/

        scroll = new JScrollPane(table);
        TablePanel.removeAll();

        TablePanel.setLayout(new BoxLayout(TablePanel,BoxLayout.Y_AXIS));
        TablePanel.add(scroll);


        TablePanel.revalidate();

        table.setRowSelectionAllowed(true);//设置JTable可被选择
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置JTable为单行选择
        table.getTableHeader().setBackground(new Color(206,231,255));//设置JTable表头颜色
        table.getTableHeader().setReorderingAllowed(false);//设置JTable每个字段的顺序不可以改变
        table.getTableHeader().setResizingAllowed(false); //设置JTable每个表头的大小不可以改变
        makeFace(table);//设置JTable 颜色

        //add(scroll);


        //table.setBounds(screensize.width / 2 - Swing1x / 2, screensize.height / 2 - Swing1y / 2, Swing1x, Swing1y);
        table.setVisible(true);
        //contentArea.remove(scroll);

    }

    public static void makeFace(JTable table) {
        try {
            DefaultTableCellRenderer tcr = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table,
                                                               Object value, boolean isSelected, boolean hasFocus,
                                                               int row, int column) {
                    if (row % 2 == 0)
                        setBackground(Color.white); // 设置奇数行底色
                    else if (row % 2 == 1)
                        setBackground(new Color(206, 231, 255)); // 设置偶数行底色
                    return super.getTableCellRendererComponent(table, value,
                            isSelected, hasFocus, row, column);
                }
            };
            for (int i = 0; i < table.getColumnCount(); i++) {
                table.getColumn(table.getColumnName(i)).setCellRenderer(tcr);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void onCancel() {
// add your code here if necessary
        dispose();
    }


}
