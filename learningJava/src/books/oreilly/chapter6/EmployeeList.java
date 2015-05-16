package books.oreilly.chapter6;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

class Employee {
    String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }

}

public class EmployeeList {
    private Employee[] employees = {new Employee("Вася"), new Employee("Петя")};

    public static void main(String[] args) {
        EmployeeList employeeList = new EmployeeList();
        Iterator iterator = employeeList.new Iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Test test = new Test();

    }

    static class Test {

    }

    class Iterator implements java.util.Iterator {
        int element = 0;

        Iterator getIterator() {
            return new Iterator();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void forEachRemaining(Consumer action) {

        }

        @Override
        public boolean hasNext() {
            return element < employees.length;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return employees[element++];
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
