package ru.geekbrains.practise.task25;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Objects;

public class Expression {

    static Double parse(Interpreter interpreter, String code) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            code = Print.replaceWithVars(code, interpreter.getVars());
            code = code.replaceAll("SQRT", "Math.sqrt");
            if (code.contains("THEN")) { // проверка if
                String expr = code.split("THEN")[0]; //до then выражение
                String strings[] = code.split(" ");
                if (code.contains("=")) {
                    for (int i = 0; i < strings.length; i++) {
                        if (strings[i].equals("=") ) {
                            if (!Objects.equals(strings[i - 1], "<") && !Objects.equals(strings[i - 1], ">"))
                                strings[i] = "=="; //замена = на == чтоб js пробил
                        }
                    }
                }

                if (Objects.equals(engine.eval(expr).toString(), "true")) {
                    String opName = code.split("THEN")[1].trim().split(" ")[0];
                    Operator op = interpreter.getOperator(opName, code.split(opName)[1].trim());
                    op.execute(interpreter);
                    return null;
                } else {
                    interpreter.nextLine();
                }
            }
            Object result = engine.eval(code);
            return Double.parseDouble(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // parse();
    }
}
