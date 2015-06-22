package net.wikijava.chapter16.dirlist;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
    public static FilenameFilter filter(final String regex) {
        // Creation of anonymous inner class:
        return new FilenameFilter() {
            private Pattern pattern = Pattern.compile(regex);

            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        }; // End of anonymous inner class
    }

    public static void main(String[] args) {
        File path = new File("C:\\git\\JAVA\\learningJava\\src\\net\\wikijava\\chapter16");
        String[] list;
        if (args.length == 0)
            list = path.list(filter("[a-zA-Z]+\\u002Ejava"));
        else
            list = path.list(filter(args[0]));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}
