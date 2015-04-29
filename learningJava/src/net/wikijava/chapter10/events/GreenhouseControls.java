package net.wikijava.chapter10.events;

import java.util.concurrent.TimeUnit;

public class GreenhouseControls extends Controller {

    static long startTime;
    private boolean light = false;
    private boolean water = false;
    private String thermostat = "Day";

    public static void main(String[] args) {
        startTime = System.nanoTime();
        System.out.println(new Integer(args[0]));
        GreenhouseControls gc = new GreenhouseControls();
        // Вместо жесткого кодирования фиксированных данных
        // можно было бы считать информацию для настройки
        // из текстового файла:
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1)
            gc.addEvent(
                    new GreenhouseControls.Terminate(
                            new Integer(args[0])));
        gc.run();
    }

    public static class Terminate extends Event {

        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println(elapsedTime);
            System.out.println("which is " + TimeUnit.SECONDS.convert(elapsedTime, TimeUnit.NANOSECONDS) + " seconds");
            System.exit(0);
        }

        public String toString() {
            return "Terminating";
        }
    }

    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Сюда помещается аппаратный вызов
            // физическое включение света
            light = true;
        }

        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Сюда помещается аппаратный вызов
            // физическое выключение света
            light = false;
        }

        public String toString() {
            return "Light is off";
        }
    }

    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Сюда помещается аппаратный вызов.
            // выключения системы полива
            water = true;
        }

        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Сюда помещается аппаратный вызов.
            // выключения системы полива
            water = false;
        }

        public String toString() {
            return "Greenhouse water is off";
        }
    }

    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Сюда помещается аппаратный вызов.
            // thermostat = "Ночь";
            thermostat = "Night";
        }

        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Сюда помещается аппаратный вызов.
            // thermostat = "День"
            thermostat = "Day";
        }

        public String toString() {
            return "Thermostat on day setting";
        }
    }

    // Пример метода action(), вставляющего
    // самого себя в список событий.
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            addEvent(new Bell(delayTime));
        }

        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends Event {
        private Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (Event e : eventList)
                addEvent(e);
        }

        @Override
        public void action() {
            for (Event e : eventList) {
                e.start(); // Перезапуск каждый раз
                addEvent(e);
            }
            start(); // Возвращаем это событие Event
            addEvent(this);
        }

        public String toString() {
            return "Restarting system";
        }
    }
}