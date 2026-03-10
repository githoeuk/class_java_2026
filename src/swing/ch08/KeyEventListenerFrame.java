package swing.ch08;

/*
    keyListener 인터페이스를 구현하여 키보드 이벤트를 처리하는 클래스를 설계
    1. JFrame을 상속받아 창을 구현
    2. KeyListener를 구현하여 '감시자'자격을 갖춤
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventListenerFrame extends JFrame implements KeyListener {

    private final int FRAME_SIZE = 500;
    private JTextArea textArea;

    public KeyEventListenerFrame(){
     initData();
     setInitLayout();
     addEventListener();
    }

    private void initData() {
        setSize(FRAME_SIZE,FRAME_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false); // 사용자가 마우스크기로 창 크기를 조절 못하게 고정하는 옵션

        textArea = new JTextArea();
    }

    private void setInitLayout() {
        setLayout(new BorderLayout()); // 전체 기본 레이아웃
        add(textArea);
        setVisible(true);
    }

    private void addEventListener() {
        //핵심 개념
        // textArea 에게 키보드 입력이 들어오면 this(나)에게 알려줘 라고 등록하는 과정
        textArea.addKeyListener(this);
    }

    //-----KeyListener 추상 메서드 일반 메서드로 재정의(구현)-----
    @Override // 문자가 입력 되었을때 호출
    public void keyTyped(KeyEvent e) {
        //System.out.println("Key Typed 호출 됨");
    }

    @Override // 키보드가 어떤 키를 눌렸을 때 호출
    public void keyPressed(KeyEvent e) {
        //System.out.println(e.getSource() + " : 해당하는 이벤트의 주소값");
        System.out.println(e.getKeyCode() + " : 키 코드");
        // 콘솔창에 화살표 뭐가 눌러졌는지 구분해 보기
        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            textArea.append("← 왼쪽\n");
        }else if(e.getKeyCode() == KeyEvent.VK_UP ){
            textArea.append("↑ 위쪽\n");
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            textArea.append("→ 오른쪽\n");
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
            textArea.append("↓ 아래쪽\n");
        }
    }

     @Override // 키보드가 어떤 키를 뗏을 때 호출
    public void keyReleased(KeyEvent e) {
        //System.out.println("keyReleased 호출 됨");
    }

    //테스트 코드 - 메인 쓰레드
    public static void main(String[] args) {

        new KeyEventListenerFrame();


    } // end of main


}
