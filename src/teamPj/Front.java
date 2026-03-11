package teamPj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Front extends JFrame implements ActionListener {

    private JButton button1;
    private JLabel jLabel;
    private Circle circle;

    public Front() {
        initData();
        setInitLayout();
        addEventListener();
        setVisible(true);
    }

    private void initData() {
        setTitle("Lotto Game");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1 = new JButton("Game start");
        jLabel = new JLabel("Game Start 버튼을 눌러주세요", JLabel.CENTER);
    }

    private void setInitLayout() {
        setLayout(new BorderLayout());
        add(button1, BorderLayout.NORTH);
        button1.setSize(100, 100);
        add(jLabel,BorderLayout.CENTER);
        jLabel.setFont(new Font("맑은 고딕", Font.BOLD, 50));

    }

    //내부클래스 - 원형
    static class Circle extends JPanel{

        Color[] color = new Color[]{Color.red, Color.YELLOW, Color.BLUE, Color.GRAY, Color.GREEN , Color.cyan};
        int i;





        public void paint(Graphics g){
            super.paint(g);
            g.setColor(color[0]);
            g.fillOval(10,50,100,100);
            g.setColor(color[1]);
            g.fillOval(120,50,100,100);
            g.setColor(color[2]);
            g.fillOval(230,50,100,100);
            g.setColor(color[3]);
            g.fillOval(340,50,100,100);
            g.setColor(color[4]);
            g.fillOval(100,200,100,100);
            g.setColor(color[5]);
            g.fillOval(250,200,100,100);

        }
    }

    private void addEventListener() {
        button1.addActionListener(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            jLabel.setText("");
            circle = new Circle();
            add(circle);
            setVisible(true);

        }
    }



    // main
    public static void main(String[] args) {

        new Front();

    } // end of main
} // end of Front
