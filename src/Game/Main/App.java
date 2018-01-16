package Game.Main;

import java.awt.EventQueue;
import javax.swing.*;


public class App extends JFrame {


    public App() {

        initUI();
    }

    private void initUI() {

        add(new Board());
        setTitle("Breakout");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(Commons.GameAreaWidth, Commons.GameAreaHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                App game = new App();
                game.setVisible(true);
            }
        });
    }
}

