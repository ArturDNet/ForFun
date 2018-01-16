package Game.Main;

public class Ball extends Game_objects implements Commons {

    private int xMove;
    private int yMove;

    /* Shape ball = new Ellipse2D.Double(x, y, 10, 10);*/

    public Ball() {
        xMove = 1;
        yMove = -1;
        width = 10;
        height = 10;

        resetBall();
    }

    private void resetBall() {
        x = BallInitialX;
        y = BallInitialY;
    }
    public void ballMoves(){
        x += xMove;
        y += yMove;

        if (y == 0) {
            setYMove(1);
        }
        if (x == 0 || x == GameAreaWidth - (width / 2)) {
            setXMove(getxMove()*-1);
        }
    }

    public void setXMove(int xMove) {
        this.xMove = xMove;
    }

    public void setYMove(int yMove) {
        this.yMove = yMove;
    }

    public int getxMove() {
        return xMove;
    }

    public int getyMove() {
        return yMove;
    }
}
