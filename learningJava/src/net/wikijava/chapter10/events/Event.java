package net.wikijava.chapter10.events;

//: innerclasses/controller/Event.java
// Общие для всякого управляющего события методы.

public abstract class Event {
    protected final long delayTime;
    private long eventTime;

    public Event(long delayTime) {
        this.delayTime = delayTime;
        start();
    }

    public void start() { // Позволяет перезапуск
        eventTime = System.nanoTime() + delayTime;
    }

    public boolean ready() {
        return System.nanoTime() >= eventTime;
    }

    public abstract void action();
}