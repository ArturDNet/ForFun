package Game.Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OldBoard extends JPanel
        implements ActionListener {

    private int randomX = ThreadLocalRandom.current().nextInt(0,630);
    private int randomY = ThreadLocalRandom.current().nextInt(0,430);
    private final int B_WIDTH = 750;
    private final int B_HEIGHT = 550;
    private int INITIAL_X = 0;
    private int INITIAL_Y = 0;
    private final int DELAY = 10;

    private Image star;
    private Image background;
    private Timer timer;
    private int x, y;
    private int xAxis = 1;
    private int yAxis = 1;


    public void setxAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setyAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public OldBoard() {

        initBoard();
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/Game/Images/Starman.png");
        star = ii.getImage();
        ImageIcon bg = new ImageIcon("src/Game/Images/OldPaper.jpg");
        background = bg.getImage();
    }

    private void initBoard() {

        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setDoubleBuffered(true);

        loadImage();

        x = randomX;
        y = randomY;

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background,0,0,B_WIDTH,B_HEIGHT,null);
        drawStar(g);
    }

    private void drawStar(Graphics g) {

        g.drawImage(star, x, y, this);
        Toolkit.getDefaultToolkit().sync();
    }

    private void direction () {
        x += xAxis;
        y += yAxis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        direction();

        if (y >= B_HEIGHT-120) {setyAxis(-1);}
        if (x >= B_WIDTH-120) {setxAxis(-1);}
        if (y == 0) {setyAxis(1);}
        if (x == 0) {setxAxis(1);}

        repaint();
    }
}
