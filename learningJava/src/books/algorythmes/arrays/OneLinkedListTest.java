package books.algorythmes.arrays;

import java.util.ArrayList;

public class OneLinkedListTest {
    static int counter = 1;
    static ArrayList<SimplyList> simplyLists = new ArrayList<>();

    static SimplyList revertList(SimplyList rootNode) {
        if (rootNode == null) return null;
        SimplyList next = rootNode.nextNode;
        if (next == null) {
            return rootNode;
        } else {
            rootNode.nextNode = null;
            SimplyList lastNode = revertList(next);
            next.nextNode = rootNode;
            return lastNode;
        }
    }

    static SimplyList revertList2(SimplyList rootNode) {
        if (rootNode == null) return null;
        SimplyList leftNode = rootNode;
        SimplyList nextNode;
        SimplyList rightNode = rootNode.nextNode;
        while (rightNode != null) {
            nextNode = rightNode.nextNode;
            rightNode.nextNode = leftNode;
            leftNode = rightNode;
            rightNode = nextNode;
        }
        rootNode.nextNode = null;
        return leftNode;
    }

    public static void main(String[] args) {
        SimplyList next = null;
        SimplyList first = null;
        while (counter <= 1000) {
            if (next == null) {
                first = next = createNode();
            } else {
                next = next.nextNode = createNode();
            }
            simplyLists.add(next);
            counter++;
        }
        long start = System.currentTimeMillis();
        output(revertList2(first));
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start) / 1000.);
    }

    public static void output(SimplyList next) {
        while (next != null) {
            System.out.println(next.value);
            next = next.nextNode;
        }
    }

    public static SimplyList createNode() {
        return new SimplyList(String.valueOf(counter));
    }

    static class SimplyList {
        SimplyList nextNode;
        String value;

        public SimplyList(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            String nextValue = "null";
            if (nextNode != null) {
                nextValue = nextNode.value;
            }
            return value + " " + nextValue;
        }
    }
}
