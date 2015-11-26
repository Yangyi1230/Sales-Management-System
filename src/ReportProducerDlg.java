import javafx.scene.control.Tab;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

public class ReportProducerDlg extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JSpinner spinner1;
    private JPanel TablePanel;
    private JPanel contentArea;
    private JPanel operatePanel;
    SaleSystem saleSystem;

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
// add your code here
//        dispose();
        JScrollPane scroll;

         int month=(int)spinner1.getValue();

        String[] columnNames={"员工","pillow","curtain","towel","bath mat","quilt","总销售额"};

        Object rowData[][]=new Object[Transition.clerkList.size()+2][7];

        int i=0;
        int j=0;

        Iterator clerkIterator=Transition.clerkList.iterator();
        while(clerkIterator.hasNext()){
            Clerk clerk=(Clerk)clerkIterator.next();


            rowData[i][j++]=clerk.getName();

            ReceiptCatalog monthCatalog=Transition.getClerkMonthRecord(month, clerk.getName());

            int tempSaleAmount=0;

            Iterator proIterator=Transition.productList.iterator();
            while(proIterator.hasNext()){
                Product product=(Product)proIterator.next();
                tempSaleAmount= Transition.getProTotalAmount(product.getId(), monthCatalog)*Transition.getProPriceById(product.getId());
                rowData[i][j++]= tempSaleAmount;
            }

            rowData[i][j]=Transition.getClerkTotalSaleAmountPerMonth(month, clerk.getName());


            j=0;
            i++;

        }

        int x=0;
        rowData[i][x++]="商品总销量";
        Iterator iterator1=Transition.productList.iterator();
        int tempProAmount=0;
        while(iterator1.hasNext()){
            Product product=(Product)iterator1.next();
            tempProAmount=Transition.getProMonthAmount(product.getId(), month, Transition.catalog);
            rowData[i][x++]= tempProAmount;
        }


        Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x=500;
        int Swing1y=300;


        JTable table=new JTable(rowData,columnNames);
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
        //scroll.setSize(700, 400);
        //TablePanel.add(scroll);

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

    public void main(String[] args) {
        ReportProducerDlg dialog = new ReportProducerDlg(saleSystem);
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
