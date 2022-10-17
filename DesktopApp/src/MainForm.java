import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {

    private JPanel mainPanel;
    private JButton button1;
    private JTextField patronymicName;
    private JTextField firstName;
    private JTextField lastName;

    public MainForm() {
        button1.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {

                    if ((firstName.getText() == null || firstName.getText().trim().length() == 0)
                            || (lastName.getText() == null || lastName.getText().trim().length() == 0)) {
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                "Фамилия и(или) имя не введены. Введите данные!",
                                "Ошибка!",
                                JOptionPane.ERROR_MESSAGE
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                                mainPanel,
                                lastName.getText() + " "
                                        + firstName.getText() + " "
                                        + patronymicName.getText(),
                                "Ф.И.О",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        if (button1.getText().equals("Collapse")) {
                            button1.setText("Expand");
                        } else if (button1.getText().equals("Expand")) {
                            button1.setText("Collapse");
                        }
                    }
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
