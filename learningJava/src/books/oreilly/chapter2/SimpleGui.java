package books.oreilly.chapter2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SimpleGui implements ActionListener {
    JFrame frame;

    public static void main(String[] args) {
        SimpleGui gui = new SimpleGui();
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

    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        frame.repaint();
    }
}

class MeDrawPanel extends JPanel {
    Image image = new ImageIcon("C:\\Users\\ruaval\\Desktop\\4FFLnmArlaw.jpg").getImage();

    @Override
    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        int red = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        Color randomColor = new Color(red, green, blue, 100);
        g.setColor(randomColor);
        g.fillOval(70, 70, 100, 100);

        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gradientPaint = new GradientPaint(200, 200, Color.blue, 300, 200, Color.ORANGE);
        g2d.setPaint(gradientPaint);
        g2d.fillOval(200, 200, 100, 100);

        g.drawImage(image, 350, 200, this);
    }
}
