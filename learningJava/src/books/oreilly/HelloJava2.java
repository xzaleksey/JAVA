package books.oreilly;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class HelloJava2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("HelloJava2");
        frame.add(new HelloComponent2("Hello, java!"));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

class HelloComponent2 extends JComponent
        implements MouseMotionListener {
    String theMessage;
    int messageX = 125, messayY = 95;//координаты сообщения

    HelloComponent2(String theMessage) {
        this.theMessage = theMessage;
        addMouseMotionListener(this);
    }

    @Override
    public Point getMousePosition() throws HeadlessException {
        return super.getMousePosition();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawString(theMessage, messageX, messayY);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        theMessage = getMousePosition().toString();
        messageX = e.getX();
        messayY = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}