package codekamp.states;

import codekamp.Game;
import codekamp.GamePanel;
import codekamp.utils.Resources;
import javafx.scene.input.KeyCode;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by mohit on 7/1/2017.
 */
public class GameoverState extends State{
    @Override
    public void render(Graphics a) {
         a.setColor(Color.RED);
         a.fillRect(0,0, Game.WIDTH,Game.HEIGHT);
        a.setColor(Color.WHITE);
        a.drawImage(Resources.boomImage,0,0,Game.WIDTH,Game.HEIGHT,null);

      a.setFont(stage1State.MY_FONT);
        a.drawString("Game Over !", 10,10 );
         a.drawString("Your Score is "+ GamePanel.currentState.SCORE,10, 20);
        a.drawString("Press Enter to restart the Game ",120, 590);

    }


     public void onKeyDown(int KeyCode){
        if ( KeyCode == KeyEvent.VK_ENTER){


            GamePanel.currentState = new stage1State();
        }

     }
}
