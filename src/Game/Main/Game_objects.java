package Game.Main;

import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

public class Game_objects {

    protected int x;
    protected int y;
    protected int width;
    protected int height;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    Rectangle getHitbox() {
        return new Rectangle(x,y,width,height);
    }

    Ellipse2D getBallShape() {
        return new Ellipse2D.Double(x,y,width,height);
    }
}
