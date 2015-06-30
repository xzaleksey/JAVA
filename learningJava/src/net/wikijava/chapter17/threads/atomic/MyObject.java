package net.wikijava.chapter17.threads.atomic;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @author shaines
 */
public class MyObject {
    private static final AtomicReferenceFieldUpdater<MyObject, Book> updater =
            AtomicReferenceFieldUpdater.newUpdater(
                    MyObject.class, Book.class, "whatImReading");
    private volatile Book whatImReading;

    public Book getWhatImReading() {
        return whatImReading;
    }

    public void setWhatImReading(Book whatImReading) {
        //this.whatImReading = whatImReading;
        updater.compareAndSet(this, this.whatImReading, whatImReading);
    }
}

