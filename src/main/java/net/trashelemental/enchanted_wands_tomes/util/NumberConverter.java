package net.trashelemental.enchanted_wands_tomes.util;

//This only exists because I'm addicted to complexity
public class NumberConverter {

    public static String numberToRomanNum(int number) {
        if (number <= 0) return "";

        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        StringBuilder roman = new StringBuilder();
        roman.append(tens[(number % 100) / 10]);
        roman.append(ones[number % 10]);

        return roman.toString();
    }

}
