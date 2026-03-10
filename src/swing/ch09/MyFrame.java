package swing.ch09;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame {

    private JLabel backgroundMap;
    private JLabel player;
    private final int MOVE_STEP = 10;
    ImageIcon playerIconL = new ImageIcon("images/playerL.png");
    ImageIcon playerIconR = new ImageIcon("images/playerR.png");

    public MyFrame() {

        initData();
        setInitLayout();
        addEventListener();

    }

    private void initData() {
        setTitle(":이미지 사용 연습");
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //배경이미지 설정
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);
        backgroundMap.setSize(1000, 600);
        backgroundMap.setLocation(0, 0);

        //플레이어 설정
        //왼쪽

        player = new JLabel(playerIconL);
        player.setSize(100, 100);
        player.setLocation(600, 390);

    }

    private void setInitLayout() {
        setLayout(null); // 좌표 기반
        backgroundMap.add(player);
        add(backgroundMap);
        setVisible(true);
    }

    private void addEventListener() {

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                int x = player.getX();
                int y = player.getY();

                if (keyCode == KeyEvent.VK_LEFT) {
                    player.setIcon(playerIconL);
                    player.setLocation(x - MOVE_STEP, y);
                } else if (keyCode == KeyEvent.VK_UP) {
                    player.setLocation(x, y - MOVE_STEP);
                } else if (keyCode == KeyEvent.VK_RIGHT) {
                    player.setIcon(playerIconR);
                    player.setLocation(x + MOVE_STEP, y);
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    player.setLocation(x, y + MOVE_STEP);
                } else if (keyCode == 27) {
                    player.setLocation(600, 390);
                }

                 if (x >= 870){
                    System.out.println("벗어남");
                    player.setLocation(860, y);
                 }else if (x <= 40){
                     System.out.println("벗어남");
                     player.setLocation(50, y);
                 }else if(y <= -10){
                     System.out.println("벗어남");
                     player.setLocation(x, 0);
                 }else if(y >= 490){
                     System.out.println("벗어남");
                     player.setLocation(x, 480);
                 }





                System.out.println(x + " " + y);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


    }

    public static void main(String[] args) {
        new MyFrame();
    } // end of main

}
