package net.wikijava.chapter14.bounds;

interface Payable<T> {
}

class Employee implements Payable {
}

class Hourly extends Employee
        implements Payable {
}
