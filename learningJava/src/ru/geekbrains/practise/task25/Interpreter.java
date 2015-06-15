package ru.geekbrains.practise.task25;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Interpreter {
    TreeMap<Integer, Operator> code = new TreeMap<>();
    private HashMap<String, Double> vars = new HashMap<>();
    int curLineNumber = 0;

    public static void main(String[] args) {
        Interpreter interpreter = new Interpreter();
        try {
            interpreter.parse(new FileReader("D:\\JAVA\\JAVA\\learningJava\\src\\ru\\geekbrains\\practise\\task25\\program"));
            interpreter.nextLine();

//
// for(Map.Entry<Integer,Operator> entry : interpreter.code.entrySet()) {
//                interpreter.curLineNumber=entry.getKey();
//                Operator operator = entry.getValue();
//                operator.execute(interpreter);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void parse(FileReader f) {

        try (BufferedReader reader = new BufferedReader(f)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parsed = line.split(" ");

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 2; i < parsed.length; i++) {
                    stringBuilder.append(parsed[i]).append(" ");
                }
                String temp = stringBuilder.toString().trim();
                code.put(Integer.parseInt(parsed[0]), getOperator(parsed[1], temp.trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Неверный код программы");
        }

    }

    Operator getOperator(String s, String temp) throws Exception {
        Operator op;
        switch (s) {
            case "PRINT":
                op = new Print(temp);
                break;
            case "LET":
                op = new Let(temp);
                break;
            case "IF":
                op = new If(temp);
                break;
            case "GOTO":
                op = new Goto(temp);
                break;
            default:
                throw new Exception();
        }
        return op;
    }

    void goToLine(int num) {
        if (hasNextLine(num)) {
            curLineNumber = num;
            code.get(num).execute(this);
        }
        else  {
            System.exit(0);
        }
    }

    HashMap<String, Double> getVars() {
        return vars;
    }

    void nextLine() {
        goToLine(curLineNumber + 10);
    }

    boolean hasNextLine(int num) {
        return code.containsKey(num);
    }
}
