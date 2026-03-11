package swing.ch10;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
    플레이어 이동 + 적군 자동 이동(thread 활용)
    thread : 적군을 백그라운드에서 자동으로 움직이게하는 별도 작업자
    runnable : thread가 실행할 작업을 정의하는 인터페이스

 */

public class MyFrame2 extends JFrame {
    // ---- 배경 & 플레이어 ----
    // 플레이어 방향 이미지
    private JLabel backgroundMap;
    private JLabel player;
    ImageIcon playerIconR = new ImageIcon("images/playerR.png");
    ImageIcon playerIconL = new ImageIcon("images/playerL.png");

    //-- 적군 --------
    private JLabel enemy;
    private ImageIcon enemyIconL = new ImageIcon("images/enemyL.png");
    private ImageIcon enemyIconR = new ImageIcon("images/enemyR.png");

    //--- 이동 설정 ------
    private final int MOVE_STEP = 10; // 플레이어 이동 픽셀
    private final int ENEMY_STEP = 5;
    private final int DELAY_MS = 50; // 적군 이동 간격(ms) - 숫자가 작을 수록 빠름

    //-- 범위 제한------
    private final int MAX_X = 1000 - 100;
    private final int MAX_Y = 600 - 100;
    private final int MIN_POS = 0;



    public MyFrame2() {
        initData();
        setInitLayout();
        addEventListener();
        startEnemyThread();
    }

    private void startEnemyThread() {

        Runnable enemyTask = new Runnable() {
            @Override
            public void run() {
                int x = enemy.getX();
                boolean movingRight = true; // true = 오른쪽으로 이동
                while(true){ // 게임이 끝날때 까지 계속 반복

                    if(movingRight == true){
                        x += ENEMY_STEP;
                        enemy.setIcon(enemyIconR);
                    }else if(movingRight == false){
                        x -= ENEMY_STEP;
                        enemy.setIcon(enemyIconL);
                    }

                    if(x >= 860){ //왼쪽으로 방향 전환
                        movingRight = false;
                    }
                    if (x <= 45) { // 오른쪽으로 방향 전환
                        movingRight = true;
                    }

                    // 변경된 x값을 다시 설정
                    enemy.setLocation(x , enemy.getY());
                    try {
                        Thread.sleep(DELAY_MS);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }


                }
            } // end of run
        };

        //thread작업자 생성
        Thread thread = new Thread(enemyTask);
        thread.start(); // 작성 실행
    } // end of startEnemyThread

    private void initData() {

        setTitle("이미지 사용 연습");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배경 이미지 설정
        ImageIcon backgroundIcon = new ImageIcon("images/backgroundMap.png");
        backgroundMap = new JLabel(backgroundIcon);
        backgroundMap.setSize(1000, 600);
        backgroundMap.setLocation(0, 0);

        // 플레이어 설정
        player = new JLabel(playerIconL); // 초기값
        player.setSize(100, 100);
        player.setLocation(200, 200);

        // 적군 설정 - 하단 중앙에서 시작
        enemy = new JLabel(enemyIconR); // 초기값
        enemy.setSize(100,100);
        enemy.setLocation(100,510);


    }

    private void setInitLayout() {
        setLayout(null); // 좌표 기반
        backgroundMap.add(player);
        backgroundMap.add(enemy);
        add(backgroundMap);
        setVisible(true);
    }

    private void addEventListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int x = player.getX();
                int y = player.getY();

                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        y -= MOVE_STEP;
                        break;
                    case KeyEvent.VK_LEFT:
                        player.setIcon(playerIconL);
                        x -= MOVE_STEP;
                        break;
                    case KeyEvent.VK_DOWN:
                        y += MOVE_STEP;
                        break;
                    case KeyEvent.VK_RIGHT:
                        player.setIcon(playerIconR);
                        x += MOVE_STEP;
                        break;
                    default:
                        return;
                } // end of switch

                // 클램프 : 배경 밖으로나가지 않도록 범위 제한
                //
                x = Math.max(MIN_POS,Math.min(x,MAX_X));
                y = Math.max(MIN_POS,Math.min(y,MAX_Y));

                player.setLocation(x, y);
            } // end of pressed

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        // 추천 옵션 - 필수
        setFocusable(true);
        requestFocusInWindow();
    }

    // 테스트 코드 (메인 쓰레드)
    public static void main(String[] args) {
        new MyFrame2();
    }

}
