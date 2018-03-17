package codekamp.states;

import codekamp.Game;
import codekamp.GamePanel;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by mohit on 7/1/2017.
 */
public class welcomeState extends State {
    @Override
    public void render(Graphics a) {
        a.setColor(Color.BLACK);
       a.fillRect(0,0, Game.WIDTH,Game.HEIGHT);
        a.setColor(Color.WHITE);
        a.drawString("Press Enter to start",120,300);
    }

    public void onKeyDown(int KeyCode){
        if(KeyCode== KeyEvent.VK_ENTER){
            GamePanel.currentState=new stage1State();
        }
    }
}
