package net.wikijava.chapter9.interfaces;


interface E {
    void g();

    interface G {
        void f();
    }

    // Избыточное объявление public:
    interface H {
        void f();
    }
    // He может быть private внутри интерфейса:
    //! private interface I {}
}

class A {
    private D dRef;

    public D getD() {
        return new DImp2();
    }

    public void receiveD(D d) {
        dRef = d;
        dRef.f();
        System.out.println("Получил");
    }

    interface B {
        void f();
    }

    public interface C {
        void f();
    }

    private interface D {
        void f();
    }

    public class BImp implements B {
        @Override
        public void f() {
        }
    }

    private class BImp2 implements B {
        @Override
        public void f() {
        }
    }

    class CImp implements C {
        @Override
        public void f() {
        }
    }

    private class CImp2 implements C {
        @Override
        public void f() {
        }
    }

    private class DImp implements D {
        @Override
        public void f() {
        }
    }

    public class DImp2 implements D {
        @Override
        public void f() {
        }
    }
}

public class NestingInterfaces {
    public static void main(String[] args) {
        A a = new A();
        A.DImp2 di2 = (A.DImp2) a.getD();

        // Нет доступа к A.D:
        //! A.D ad = a.getD();
        // He возвращает ничего, кроме A.D:
        //! A.DImp2 di2 = a.getD();
        // Член интерфейса недоступен:
        //! a.getD().f();
        // Только другой объект класса А может использовать getD():
        A a2 = new A();
        a.receiveD(a2.getD());
    }

    public class BImp implements A.B {
        @Override
        public void f() {
        }
    }

    class CImp implements A.C {
        @Override
        public void f() {
        }
    }

    // Private-интерфейс не может быть реализован нигде,
    // кроме как внутри класса, где он был определен:
    //! class DImp implements A.D {
    //!  public void f() {}
    //! }
    class EImp implements E {
        @Override
        public void g() {
        }
    }

    class EGImp implements E.G {
        @Override
        public void f() {
        }
    }

    class EImp2 implements E {
        @Override
        public void g() {
        }

        class EG implements E.G {
            @Override
            public void f() {
            }
        }
    }
}