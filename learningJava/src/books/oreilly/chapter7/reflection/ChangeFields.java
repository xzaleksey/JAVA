package books.oreilly.chapter7.reflection;

import java.lang.reflect.Field;

public class ChangeFields {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        BankAccount bankAccount = new BankAccount();
        Field balanceField = BankAccount.class.getField("balance");
        int mybalance = balanceField.getInt(bankAccount);
        balanceField.setInt(bankAccount, 42);
        System.out.println(bankAccount.balance);
    }
}

class BankAccount {
    public int balance = 0;
}