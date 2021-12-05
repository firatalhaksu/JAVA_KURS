package com.bilgeadam.patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Strings {

    private static final String WORD_REGEX = "\\w{3,8}";
    private static final String LABEL_REGEX = "\\w{2,15}\\s*\\d+";
    private static final Pattern PATTERN = Pattern.compile("\\w{3,}:\\s?\\d+TL|USD|EUR|CHY");

    public boolean isWord (String s){

        return s.matches(WORD_REGEX);
    }

    public boolean isProperLabel (String input){

        return input.matches(LABEL_REGEX);
    }

    public boolean isProperLabelCost (String s){
        Matcher m = PATTERN.matcher(s);

        return m.matches();
                //new Product(m.group());
    }
}

record Product (String label, float cost, String unit) {

}

