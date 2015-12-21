import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;

public class SalaryCheckDlg extends JDialog {
    TableCellListener tcl;
    Action action;
    SaleSystem saleSystem;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField level;
    private JSpinner monthSpinner;
    private JPanel TablePanel;
    private JTable table;

    public SalaryCheckDlg(SaleSystem saleSystem) {

        this.saleSystem = saleSystem;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        level.setText(saleSystem.account.getLevel() == 1 ? "Normal User" : "Super Manager");

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

        action = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                TableCellListener tcl = (TableCellListener) e.getSource();
                int row = tcl.getRow();
                int column = tcl.getColumn();
                Object newValue = tcl.getNewValue();
                String x = newValue.toString();
                x = x + "f";
                float tempSalary = Float.parseFloat(x);
                int salary = Math.round(tempSalary);
                //table.setValueAt(newValue, row, column);
                JTable tempTable = tcl.getTable();
                Object clerkObj = tempTable.getValueAt(row, column - 1);
                String clerkName = clerkObj.toString();


                if (saleSystem.account.getLevel() == 0) {
                    if (Integer.parseInt(monthSpinner.getValue().toString()) != 12) {
                        JOptionPane.showMessageDialog(null, "抱歉,只能修改当月数据", "", JOptionPane.ERROR_MESSAGE);
                        tempTable.setValueAt(Integer.parseInt(tcl.getOldValue().toString()), row, column);
                    } else {
                        for (Clerk c : Transition.clerkList) {
                            if (clerkName.equalsIgnoreCase(c.getName())) {
                                c.setSalary(salary);
                                break;
                            }
                        }
                        saleSystem.saveData();
                        JOptionPane.showMessageDialog(null, "工资修改成功!", "", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "抱歉,您无修改权限", "", JOptionPane.ERROR_MESSAGE);
                    tempTable.setValueAt(Integer.parseInt(tcl.getOldValue().toString()), row, column);
                }
            }
        };

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

    private void onOK() {


        String columnNames[] = {"Clerk", "Salary"};
        int month = (int) monthSpinner.getValue();
        Object rowData[][] = saleSystem.salaryCheck.salaryRowDataProduce(month);

        JTable table = new JTable(rowData, columnNames);

        tcl = new TableCellListener(table, action);


        tableInitialise(table);
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    void tableInitialise(JTable table) {

        JScrollPane scroll;
        TableColumn column = null;

        int colunms = table.getColumnCount();
        for (int y = 0; y < colunms; y++) {
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

        TablePanel.setLayout(new BoxLayout(TablePanel, BoxLayout.Y_AXIS));
        TablePanel.add(scroll);


        TablePanel.revalidate();

        table.setRowSelectionAllowed(true);//设置JTable可被选择
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置JTable为单行选择
        table.getTableHeader().setBackground(new Color(206, 231, 255));//设置JTable表头颜色
        table.getTableHeader().setReorderingAllowed(false);//设置JTable每个字段的顺序不可以改变
        table.getTableHeader().setResizingAllowed(false); //设置JTable每个表头的大小不可以改变
        makeFace(table);//设置JTable 颜色


        table.setVisible(true);

    }


}
