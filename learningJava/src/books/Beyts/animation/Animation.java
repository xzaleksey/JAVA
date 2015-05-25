package books.Beyts.animation;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Animation implements ActionListener {
    JFrame frame;
    int x, y = 70;

    public static void main(String[] args) {
        Animation gui = new Animation();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Wrong color? Press me!");
        button.addActionListener(this);

        MeDrawPanel drawPanel = new MeDrawPanel();
        frame.getContentPane().add(BorderLayout.SOUTH, button);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(600, 600);
        frame.setVisible(true);
        for (int i = 0; i < 130; i++) {
            x += 5;
            y = 5;
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            } catch (Exception ex) {

            }
        }
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        frame.repaint();
    }

    class MeDrawPanel extends JPanel {


        @Override
        public void paintComponent(Graphics g) {
            g.setColor(Color.white);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());
            g.setColor(Color.orange);
            g.fillOval(x, y, 40, 40);
        }
    }
}

