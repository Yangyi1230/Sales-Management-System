import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginScreenView extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JButton loginButton;
    private JPanel contentArea;
    public JTextField accountField;
    public JPasswordField passwordField;
    public LoginController loginController;

    public LoginScreenView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        loginButton.addActionListener((e) -> onLogin());
        buttonCancel.addActionListener((e) -> onCancel());

        Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
        int Swing1x = 500;
        int Swing1y = 300;
        this.setBounds(screensize.width / 2 - Swing1x / 2, screensize.height / 2 - Swing1y / 2, Swing1x, Swing1y);

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
    }

    private void onLogin() {
        loginController.loginPressed();
    }

    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void setControl(LoginController loginController) {
        this.loginController = loginController;
    }


}
