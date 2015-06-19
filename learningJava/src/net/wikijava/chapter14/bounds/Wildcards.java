package net.wikijava.chapter14.bounds;

import net.wikijava.chapter14.generic.Holder;

public class Wildcards {
    // Низкоуровневый аргумент:
    static void rawArgs(Holder holder, Object arg) {
        // holder.set(arg); // Предупреждение
        // Непроверенный вызов set(T) как члена
        // низкоуровневого типа Holder
        // holder.set(new Wildcards());// To же предупреждение
        // Невозможно: нет информации о 'Т'
        // T t = holder.get();

        // Допустимо, но информация типа теряется
        Object obj = holder.get();
        System.out.println(obj);
    }

    // По аналогии с rawArgs(), но ошибки вместо предупреждений:
    static void unboundedArg(Holder<?> holder, Object arg) {
        // holder.set(arg); // Ошибка:
        // set(capture of ?) в Holder<capture of ?>
        // не может применяться к (Object)
        // holder.set(new Wildcards()); // Та же ошибка

        // Невозможно; нет информации о 'T':
        // T t = holder.get();

        // Допустимо, но информация типа теряется:
        Object obj = holder.get();
    }

    static <T> T exact1(Holder<T> holder) {
        T t = holder.get();
        return t;
    }

    static <T> T exact2(Holder<T> holder, T arg) {
        holder.set(arg);
        T t = holder.get();
        return t;
    }

    static <T> T wildSubtype(Holder<? extends T> holder, T arg) {
        // holder.set(arg); // Ошибка:
        // set(capture of ? extends T) in
        // Holder<capture of ? extends T>
        // cannot be applied to (T)
        T t = holder.get();
        return t;
    }

    static <T> void wildSupertype(Holder<? super T> holder, T arg) {
        holder.set(arg);
        // T t = holder.get();  // Ошибка:
        // Несовместимые типы: обнаружен Object, требуется T

        // Допустимо, но информация типа теряется:
        Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<>();
        // Или:
        raw = new Holder();

        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();
        Long lng = 1L;

        rawArgs(raw, lng);
        rawArgs(qualified, lng);
        rawArgs(unbounded, lng);
        rawArgs(bounded, lng);

        unboundedArg(raw, lng);
        unboundedArg(qualified, lng);
        unboundedArg(unbounded, lng);
        unboundedArg(bounded, lng);

        // Object r1 = exact1(raw);// Предупреждение
        // Непроверенное преобразование Holder в Holder<T>
        // Непроверенный вызов метода: exactl(Holder<T>)
        // применяется к (Holder)
        Long r2 = exact1(qualified);
        Object r3 = exact1(unbounded); // Должен возвращать Object
        Long r4 = exact1(bounded);

        // Long r5 = exact2(raw, lng); // Предупреждения-
        // Непроверенное преобразование Holder в Holder<Long>
        // Непроверенный вызов метода. exact2(Holder<T>,T)
        // применяется к (Holder,Long)
        Long r6 = exact2(qualified, lng);
        // Long r7 = exact2(unbounded, lng);// Ошибка:
        // exact2(Holder<T>.T) не может применяться к
        // (Holder<capture of ?>.Long)
        // Long r8 = exact2(bounded, lng); // Ошибка:
        // exact2(Holder<T>.T) не может применяться
        // к (Holder<capture of ? extends Long>,Long)
        // Long r9 = wildSubtype(raw, lng); // Предупреждения
        // Непроверенное преобразование Holder
        // к Holder<? extends Long>
        // Непроверенный вызов метода-
        // wildSubtype(Holder<? extends T>,T)
        // применяется к (Holder.Long)
        Long r10 = wildSubtype(qualified, lng);
        // Допустимо, но возвращать может только Object-
        Object r11 = wildSubtype(unbounded, lng);
        Long r12 = wildSubtype(bounded, lng);
        // wildSupertype(raw, lng);// Предупреждения.
        // Непроверенное преобразование Holder
        // к Holder<? super Long>
        // Непроверенный вызов метода:
        // wildSupertype(Holder<? super T>,T)
        // применяется к (Holder.Long)
        wildSupertype(qualified, lng);
        // wildSupertype(unbounded, lng); // Ошибка:
        // wi1dSupertype(Hoider<? super T>,T) не может
        // применяться к (Holder<capture of ?>,Long)
        // wildSupertype(bounded, lng); // Ошибка:
        // wildSupertype(Holder<? super T>,T) не может
        // применяться к (Holder<capture of ? extends Long>.Long)
    }
}
