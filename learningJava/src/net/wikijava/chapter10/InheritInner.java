package net.wikijava.chapter10;

//: innerclasses/InheritInner.java
// Наследование от внутреннего класса.

class WithInner {
    public int i = 10;

    class Inner {
        int getI() {
            return WithInner.this.i;
        }
    }
}

public class InheritInner extends WithInner.Inner {
    //! InheritInner() {} // He компилируется
    InheritInner(WithInner wi) {
        wi.super();
    }


    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
        System.out.println(ii.getI());
        WithInner.Inner inner = wi.new Inner();
        System.out.println(inner.getI());
    }
}