package codekamp.entities;

import codekamp.utils.Resources;

import java.awt.*;

/**
 * Created by mohit on 7/1/2017.
 */
public class Bomb extends Entity {

    public Bomb (int x , int y){
        super(128 , 128);
        this.x = x;
        this.y = y;
        this.yVel = -4;
    }

    public Image getImage(){
        return Resources.bombImage;}
    }

