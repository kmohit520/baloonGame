package codekamp;

import codekamp.states.stage1State;
import codekamp.states.State;
import codekamp.states.stage1State;
import codekamp.states.welcomeState;
import codekamp.utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements KeyListener, MouseListener, Runnable {

    public static State currentState;

    public GamePanel() {
        super();

        Dimension d = new Dimension(Game.WIDTH, Game.HEIGHT);
        this.setPreferredSize(d);

        this.setFocusable(true);

        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        Resources.load();
        this.requestFocus();

        GamePanel.currentState = new welcomeState();

        Thread t1 = new Thread(this);
        t1.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        GamePanel.currentState.onKeyDown(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        GamePanel.currentState.onKeyUp(e.getKeyCode());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        GamePanel.currentState.onClick(e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // do nothing
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // do nothing
    }

    @Override
    public void run() {
        Image myCanvas = new BufferedImage(Game.WIDTH, Game.HEIGHT, BufferedImage.TYPE_INT_RGB);

        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            GamePanel.currentState.update();

            Graphics ig = myCanvas.getGraphics();
            ig.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
            GamePanel.currentState.render(ig);
            ig.dispose();

            Graphics pg = this.getGraphics();
            pg.drawImage(myCanvas, 0, 0, null);
            pg.dispose();
        }
    }
}
