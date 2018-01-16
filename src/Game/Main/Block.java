package Game.Main;

public class Block extends Game_objects {

    private boolean destroyed;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        width = 20;
        height = 10;

        destroyed = false;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
