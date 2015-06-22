import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
    public static final Pattern pattern = Pattern.compile
            ("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");

    public static void doMatch(String word) {
        String output = "Validation for \"" + word + "\"";
        Matcher matcher = pattern.matcher(word);
        if (matcher.matches())
            output += " passed.";
        else
            output += " not passed.";
        System.out.println(output);
    }

    public static void main(String[] args) {
        doMatch("c0nst@money.simply.net");
        doMatch("somebody@dev.com.ua");
        doMatch("Name.Sur_name@gmail.com");
        doMatch("useR33@somewhere.in.the.net");
    }

}
