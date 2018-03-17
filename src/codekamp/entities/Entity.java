package codekamp.entities;

import java.awt.*;

/**
 * Created by cerebro on 28/06/17.
 */
abstract public class Entity {
    public int x = 0;
    public int y = 0;
    public int xVel = 0;
    public int yVel = 0;
    public int xAcc = 0;
    public int yAcc = 0;
    public int width;
    public int height;
    public boolean visible = true;

    public Rectangle rect = new Rectangle();

    abstract public Image getImage();

    public Entity(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void update() {
        x += xVel;
        y += yVel;
        xVel += xAcc;
        yVel += yAcc;
    }

    public boolean isCollidingWith(Entity other) {
        this.setRectBounds();
        other.setRectBounds();

        return this.visible && other.visible && this.rect.intersects(other.rect);
    }

    public void setRectBounds() {
        this.rect.setBounds(this.x, this.y, this.width, this.height);
    }


}
