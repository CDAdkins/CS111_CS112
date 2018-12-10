import javax.swing.JFrame;

public class Snake extends JFrame {

    public static boolean reset = false;

    public Snake() {
        initUI();
    }

    public void initUI() {

        add(new Board());

        setResizable(false);
        pack();

        setTitle("Battle Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        JFrame ex = new Snake();
        ex.setVisible(true);
    }

    public static void reset() {

        JFrame ex = new Snake();
        ex.setVisible(true);
    }
}