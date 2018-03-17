package codekamp.states;

import codekamp.entities.Entity;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cerebro on 27/06/17.
 */
abstract public class State {
    public   int SCORE = 0;
    public  int PASSED = 0;

    public List<Entity> entities = new ArrayList<>();;

    public void update() {
        for(Entity e:entities) {
            e.update();
        }
    }
    abstract public void render(Graphics a);

    public void onKeyDown(int keyCode) {

    }

    public void onKeyUp(int keyCode) {

    }

    public void onClick(int x, int y) {

    }
}
