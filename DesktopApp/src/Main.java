import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Ввод Ф.И.О");
        jFrame.setSize(400, 270);

        MainForm form = new MainForm();
        jFrame.add(form.getMainPanel());

        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
