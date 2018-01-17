package Game.Main;

import java.awt.event.KeyEvent;

public class Paddle extends Game_objects implements Commons {

    private int paddleX;

    public Paddle() {
        width = 50;
        height = 10;

        resetPaddle();
    }

    private void resetPaddle() {
        x = PaddleInitialX;
        y = PaddleInitialY;
    }

    public void paddleMove() {
        x += paddleX;

        if (x <= 0) {
            x = 0;
        }

        if (x >= GameAreaWidth - width) {
            x = GameAreaWidth - width;
        }
    }

    public void keyPressed (KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            paddleX = -1;
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            paddleX = 1;
        }
    }

    public void keyReleased (KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
            paddleX = 0;
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            paddleX = 0;
        }
    }
}
