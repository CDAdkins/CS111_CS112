import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private final int B_WIDTH = 400;
    private final int B_HEIGHT = B_WIDTH;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = ((B_HEIGHT * B_WIDTH) / (DOT_SIZE * DOT_SIZE));
    private final int RAND_POS = ((B_WIDTH / DOT_SIZE) - 1);
    private final int DELAY = 50;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];
    private final int x2[] = new int[ALL_DOTS];
    private final int y2[] = new int[ALL_DOTS];

    private int dots;
    private int dots2;
    private int apple_x;
    private int apple_y;

    private boolean leftDirection = false;
    private boolean leftDirection2 = false;
    private boolean rightDirection = true;
    private boolean rightDirection2 = true;
    private boolean upDirection = false;
    private boolean upDirection2 = false;
    private boolean downDirection = false;
    private boolean downDirection2 = false;
    private boolean inGame = true;
    private int     winner = 0;

    private Timer timer;
    private Image ball;
    private Image ball2;
    private Image apple;
    private Image head;
    private Image head2;

    public Board() {

        Snake.reset = false;
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.BLACK);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    private void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/body.png");
        ball = iid.getImage();

        ImageIcon iid2 = new ImageIcon("src/resources/body.png");
        ball2 = iid2.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head1.png");
        head = iih.getImage();

        ImageIcon iih2 = new ImageIcon("src/resources/head2.png");
        head2 = iih2.getImage();
    }

    private void initGame() {

        dots  = 5;
        dots2 = 5;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * DOT_SIZE;
            y[z] = 50;
        }

        for (int z = 0; z < dots2; z++) {
            x2[z] = 50 - z * DOT_SIZE;
            y2[z] = B_HEIGHT - 50;
        }

        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        if (inGame) {

            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            for (int z = 0; z < dots2; z++) {
                if (z == 0) {
                    g.drawImage(head2, x2[z], y2[z], this);
                } else {
                    g.drawImage(ball2, x2[z], y2[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {

            gameOver(g);
        }
    }

    private void gameOver(Graphics g) {

        String msg = "Game Over";
        String reset = "Press Spacebar To Reset";
        String p1 = "Player One Wins!";
        String p2 = "Player Two Wins!";
        String tie = "It's A Tie!";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.WHITE);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);

        if (winner == 0) {
            g.drawString(tie, (B_WIDTH - metr.stringWidth(tie)) / 2, (B_HEIGHT / 2) + 20);
        } else if (winner == 1) {
            g.drawString(p1, (B_WIDTH - metr.stringWidth(p1)) / 2, (B_HEIGHT / 2) + 20);
        } else if (winner == 2) {
            g.drawString(p2, (B_WIDTH - metr.stringWidth(p2)) / 2, (B_HEIGHT / 2) + 20);
        }
        g.drawString(reset, (B_WIDTH - metr.stringWidth(reset)) / 2, (B_HEIGHT - 20));
    }

    private void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots += 3;
            locateApple();
        } else if ((x2[0] == apple_x) && (y2[0] == apple_y)) {
            dots2 += 3;
            locateApple();
        }
    }

    private void move() {

        for (int z = dots; z > 0; z--) {
            x[z] = x[(z - 1)];
            y[z] = y[(z - 1)];
        }

        for (int z = dots2; z > 0; z--) {
            x2[z] = x2[(z - 1)];
            y2[z] = y2[(z - 1)];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }
        if (leftDirection2) {
            x2[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }
        if (rightDirection2) {
            x2[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }
        if (upDirection2) {
            y2[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }
        if (downDirection2) {
            y2[0] += DOT_SIZE;
        }
    }

    private void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                winner = 2;
                inGame = false;
            } else if (x[0] == x2[z] && y[0] == y2[z]) { //Player One Loses
                winner = 2;
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            winner = 2;
            inGame = false;
        }

        if (y[0] < 0) {
            winner = 2;
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            winner = 2;
            inGame = false;
        }

        if (x[0] < 0) {
            winner = 2;
            inGame = false;
        }

        for (int z = dots2; z > 0; z--) {

            if ((z > 4) && (x2[0] == x2[z]) && (y2[0] == y2[z])) {
                winner = 1;
                inGame = false;
            } else if (x2[0] == x[z] && y2[0] == y[z]) { //Player Two Loses
                winner = 1;
                inGame = false;
            }
        }

        if (y2[0] >= B_HEIGHT) {
            winner = 1;
            inGame = false;
        }

        if (y2[0] < 0) {
            winner = 1;
            inGame = false;
        }

        if (x2[0] >= B_WIDTH) {
            winner = 1;
            inGame = false;
        }

        if (x2[0] < 0) {
            winner = 1;
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    private void locateApple() {

        int r = (int) (Math.random() * RAND_POS);
        apple_x = ((r * DOT_SIZE));

        r = (int) (Math.random() * RAND_POS);
        apple_y = ((r * DOT_SIZE));
    }

    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();


            if ((key == KeyEvent.VK_SPACE)) {
                Snake.reset = true;
                Snake.reset();
            }

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_A) && (!rightDirection2)) {
                leftDirection2 = true;
                upDirection2 = false;
                downDirection2 = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_D) && (!leftDirection2)) {
                rightDirection2 = true;
                upDirection2 = false;
                downDirection2 = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_W) && (!downDirection2)) {
                upDirection2 = true;
                rightDirection2 = false;
                leftDirection2 = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_S) && (!upDirection2)) {
                downDirection2 = true;
                rightDirection2 = false;
                leftDirection2 = false;
            }
        }
    }
}