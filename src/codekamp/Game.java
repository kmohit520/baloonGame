package codekamp;

import javax.swing.*;


public class Game {

    public static final int WIDTH = 300;
    public static final int HEIGHT = 600;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        frame.add(new GamePanel());
        frame.pack();
        frame.setVisible(true);
    }
}
