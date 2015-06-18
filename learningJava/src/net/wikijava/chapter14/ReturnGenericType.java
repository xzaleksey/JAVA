package net.wikijava.chapter14;

class ReturnGenericType<T extends HasF> {
    private T obj;

    public ReturnGenericType(T x) {
        obj = x;
    }

    public static void main(String[] args) {
        ReturnGenericType<HasF> hasFReturnGenericType = new ReturnGenericType<>(new HasF());
        System.out.println(hasFReturnGenericType.get());
    }

    public T get() {
        return obj;
    }
}