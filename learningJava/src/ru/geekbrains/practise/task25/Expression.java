package ru.geekbrains.practise.task25;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Expression {

    static Double parse(Interpreter interpreter, String code) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            code = Print.replaceWithVars(code, interpreter.vars);
            code = code.replaceAll("SQRT", "Math.sqrt");
            if (code.contains("THEN")) { // проверка if
                String expr = code.split("THEN")[0]; //до then выражение
                String strings[] = code.split(" ");
                if (code.contains("=")) {
                    for (int i = 0; i < strings.length; i++) {
                        if (strings[i] == "=") {
                            if (strings[i - 1] != "<" && strings[i - 1] != ">")
                                strings[i] = "=="; //замена = на == чтоб js пробил
                        }
                    }
                }

                if (engine.eval(expr).toString() == "true") {
                    String opName = code.split("THEN")[1].trim().split(" ")[0];
                    Operator op = interpreter.getOperator(opName, code.split(opName)[1].trim());
                    op.execute(interpreter);
                } else {
                    interpreter.nextLine();
                }
            }
            Object result = engine.eval(code);
            return Double.parseDouble(result.toString());
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // parse();
    }
}
