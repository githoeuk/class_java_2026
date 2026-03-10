package swing.ch07;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorFrame extends JFrame implements ActionListener {
    // 이전 코드를 한번 더 복습

    private JButton[] buttons;
    private JPanel panel1;

    private Color[] colors = {Color.red, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.LIGHT_GRAY, Color.MAGENTA};

    public ColorFrame() {
        initData();
        setInitLayout();
        addEventListener();
    }

    private void initData() {
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel1 = new JPanel();

        buttons = new JButton[7];

        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton("button" + (i+1));
        }
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        add(panel1);
        for(int i = 0; i < buttons.length; i++){
            panel1.add(buttons[i]);
        }
        setVisible(true);
    }

    private void addEventListener() {
        for(int i = 0 ; i < buttons.length; i++){
            buttons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       for(int i = 0; i < buttons.length; i++){
           if(e.getSource() == buttons[i]){
               System.out.println("button" + (i+1) + " 이벤트 발생");
               panel1.setBackground(colors[i]);
           }
       }
    }
}
