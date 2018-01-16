package Game.Main;

import java.awt.EventQueue;
import javax.swing.*;


public class App extends JFrame {

    public App() {

        initUI();
    }

    private void initUI() {

        add(new OldBoard());
        setResizable(false);
        pack();

        setTitle("ForFunApp");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                App example = new App();
                example.setVisible(true);
            }
        });
    }
}

