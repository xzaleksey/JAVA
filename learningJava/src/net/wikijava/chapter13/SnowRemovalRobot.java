package net.wikijava.chapter13;

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot {
    private String name;

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String model() {
        return "SnowBot Series 11";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + " может убирать снег";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + "  убирает снег");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + "  может колоть лед";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " колет лед");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + " может чистить крышу";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " чистит крышу");
                    }
                }
        );
    }
}
