import sun.reflect.annotation.EnumConstantNotPresentExceptionProxy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteDlg extends JDialog {
    SaleSystem saleSystem;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField productName;

    public DeleteDlg(SaleSystem saleSystem) {
        productName.setText("");
        this.saleSystem = saleSystem;
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

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int swingx = 500;
        int swingy = 400;
        this.setBounds(screensize.width / 2 - swingx / 2, screensize.height / 2 - swingy / 2 , swingx, swingy);
    }

    private void onOK() {
// add your code here
       if(productName.getText().equals("")){
           JOptionPane.showMessageDialog(null, "请输入产品名称","",JOptionPane.ERROR_MESSAGE);
       }else{
           try{
               if(saleSystem.opeOnProduct.delete(productName.getText())){
                   saleSystem.saveData();
                   JOptionPane.showMessageDialog(null, "该商品信息删除成功", "",JOptionPane.INFORMATION_MESSAGE);
               }else{
                   JOptionPane.showMessageDialog(null,"该商品不存在", "", JOptionPane.INFORMATION_MESSAGE);
               }
           }catch(Exception e){

           }finally {
               productName.setText("");
           }
       }
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }
}
