package books.oreilly.chapter8;

public class ExceptionTester<T extends Throwable> {
    public static void main(String[] args) {
        try {
            ExceptionTester<ArithmeticException> et = new ExceptionTester<>();
            et.test(ArithmeticException.class);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void test(Class<T> type) throws T, IllegalAccessException, InstantiationException {
        throw type.newInstance();
    }
}
