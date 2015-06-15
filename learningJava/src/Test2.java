public class Test2 {

    public static void main(String[] args) {
        String strings[] = "\"x1=\";".split(";");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].charAt(0) == '"' && strings[i].charAt(strings[i].length() - 1) == '"') {
                System.out.print(strings[i].substring(1, strings[i].length() - 1));
            }
        }
    }
}
