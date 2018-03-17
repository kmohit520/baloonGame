package codekamp.entities;

import codekamp.utils.Resources;

import java.awt.*;

/**
 * Created by mohit on 7/1/2017.
 */
public class Ballon extends Entity {

    public Ballon(int x, int y){
        super(128, 128);

        this.x = x;
        this.y = y;
        this.yVel = -5;
    }


    @Override
    public Image getImage() {
        return Resources.ballonImage;
    }
}
