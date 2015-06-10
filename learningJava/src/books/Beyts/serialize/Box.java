package books.Beyts.serialize;

import java.io.*;

public class Box implements Serializable {
    transient String hi = "hi";
    transient int i = 5;
    private int height, width;

    public static void main(String[] args) {
        Box myBox = new Box();
        myBox.setHeight(20);
        myBox.setWidth(50);
        myBox.i = 10;
        try {
            FileOutputStream fs = new FileOutputStream("src\\books\\Beyts\\serialize\\foo.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(myBox);
            os.close();
            myBox = null;
            ObjectInputStream os1 = new ObjectInputStream(new FileInputStream("src\\books\\Beyts\\serialize\\foo.ser"));
            Object one = os1.readObject();
            os1.close();
            myBox = (Box) one;
            System.out.println(myBox);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "hi='" + hi + '\'' +
                ", i=" + i +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
