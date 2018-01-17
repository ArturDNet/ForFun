package Game.Main;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Board extends JPanel implements Commons {

    private Timer timer;
    private Ball ball;
    private Paddle paddle;
    private Block block[];
    private String message = ":(";
    private boolean ingame = true;

    public Board() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);

        block = new Block[BlockAmount];
        setDoubleBuffered(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new ScheduleTask(), Delay, Period);
    }

    private void stopGame() {

        ingame = false;
        timer.cancel();
    }

    @Override
    public void addNotify() {

        super.addNotify();
        gameInit();
    }

    private void gameInit() {

        ball = new Ball();
        paddle = new Paddle();
        //TODO: finish gameInit
    }

    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed (KeyEvent e) {
            paddle.keyPressed(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }
    }

    private class ScheduleTask extends TimerTask {

        @Override
        public void run() {

            ball.ballMoves();
            paddle.paddleMove();
            checkCollision();
            repaint();
        }
    }

    private void checkCollision() {
        if (ball.getBallShape().getMaxY() > Commons.LooseBallEdge) {
            stopGame();
        }

        for (int i = 0; i < BlockAmount; i++) {
            if ((ball.getBallShape().intersects(block[i].getHitbox())) ||
                    (ball.getBallShape().intersects(paddle.getHitbox()))) {

                int ballHitboxMinX = (int) ball.getBallShape().getMinX();
                int ballhitboxMinY = (int) ball.getBallShape().getMinY();
                int ballhitboxWidth = (int) ball.getBallShape().getWidth();
                int ballhitboxHeight = (int) ball.getBallShape().getHeight();

                Point BallHitboxUpperLeft = new Point(ballHitboxMinX, ballhitboxMinY);
                Point BallHitboxUpperRight = new Point(ballHitboxMinX + ballhitboxWidth, ballhitboxMinY);
                Point BallHitboxLowerLeft = new Point(ballHitboxMinX, ballhitboxMinY + ballhitboxHeight);
                Point BallHitboxLowerRight = new Point(ballHitboxMinX + ballhitboxWidth, ballhitboxMinY + ballhitboxHeight);

                if (!block[i].isDestroyed()) {
                    if (((block[i].getHitbox().contains(BallHitboxUpperLeft)) &&
                            (block[i].getHitbox().contains(BallHitboxUpperRight))) ||
                            ((block[i].getHitbox().contains(BallHitboxLowerLeft)) &&
                                    (block[i].getHitbox().contains(BallHitboxLowerRight)))) {
                        ball.setYMove(ball.getYMove() * -1);
                    }
                    if (((block[i].getHitbox().contains(BallHitboxUpperLeft)) &&
                            (block[i].getHitbox().contains(BallHitboxLowerLeft))) ||
                            ((block[i].getHitbox().contains(BallHitboxUpperRight)) &&
                                    (block[i].getHitbox().contains(BallHitboxLowerRight)))) {
                        ball.setXMove(ball.getXMove() * -1);
                    }
                    if ((block[i].getHitbox().contains(BallHitboxLowerLeft)) ||
                            (block[i].getHitbox().contains(BallHitboxLowerRight)) ||
                            (block[i].getHitbox().contains(BallHitboxUpperLeft)) ||
                            (block[i].getHitbox().contains(BallHitboxUpperRight))) {
                        ball.setXMove(ball.getXMove() * -1);
                        ball.setYMove(ball.getYMove() * -1);
                    }

                    block[i].setDestroyed(true);
                }
            }
        }

        //TODO paddle 15 left, 15 right, 20 middle
    }
}
