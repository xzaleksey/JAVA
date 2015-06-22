package net.wikijava.chapter16.dirlist;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File("C:\\git\\JAVA\\learningJava\\src\\net\\wikijava\\chapter16");
        String[] list;

        list = path.list(new DirFilter("[a-zA-Z]+\\u002Ejava"));
//        list=path.list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list)
            System.out.println(dirItem);
    }
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;

    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }

    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}