package Game.Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BgImageInBoard extends JPanel {

    private Image bgimage;

    BgImageInBoard() {

        initBoard();
    }

    private void initBoard() {

        loadImage();

        int w = bgimage.getWidth(this);
        int h =  bgimage.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadImage() {

        ImageIcon ii = new ImageIcon("src/Game/Images/OldPaper.jpg");
        bgimage = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {

        g.drawImage(bgimage, 0, 0, null);
    }
}