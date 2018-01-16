package Game.Main;

import javax.swing.*;
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
            Collisions.checkCollision();//TODO: checkCollision marked
            repaint();
        }
    }
}
