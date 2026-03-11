package teamPj;

import javax.swing.*;
import java.awt.*;

public class MyImagePanel extends JPanel {
    private Image image1;
    private Image image2;

    public MyImagePanel() {
//        image1 = new ImageIcon("image3.png").getImage();
//        image2 = new ImageIcon("popo.png").getImage();

    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g);
//        g.drawImage(image1, 250, 200, 50, 50, null);
//        g.drawImage(image2, 310, 135, 200, 200, null);

        g.drawString("이미지게임", 400, 400);
        g.drawString("포포", 389, 120);
        g.drawRoundRect(300,140,200,200,50,50);
        g.drawArc(375,90,50,50,100,500);
        g.clearRect(100,100,100,100);
        //g.clipRect(100,300,100,100);
        g.drawLine(300, 150, 400, 80);
        g.drawLine(400, 80, 500, 150);
    }

}
