package com.evoxon.romans.domain;

public class RomanConverter {

    public String fromDecimalToRoman(int decimal) {

        int thousands = decimal / 1000;
        int hundreds = (decimal % 1000) / 100;
        int tens = (decimal % 100) / 10;
        int units = (decimal % 10);

        String romanThousands = "";
        String romanHundreds = "";
        String romanTens = "";
        String romanUnits = "";

        romanThousands = String.join("", "M".repeat(thousands));
        if (hundreds == 9) {
            romanHundreds += String.join("", "CM");
            hundreds -= 9;
        }
        if (hundreds >= 5) {
            romanHundreds += String.join("", "D");
            hundreds -= 5;
        }
        if (hundreds == 4) {
            romanHundreds += String.join("", "CD");
            hundreds -= 4;
        }
        if (hundreds <= 3) {
            romanHundreds += String.join("", "C".repeat(hundreds));
        }
        if (tens == 9) {
            romanTens += String.join("", "XC");
            tens -= 9;
        }
        if (tens >= 5) {
            romanTens += String.join("", "L");
            tens -= 5;
        }
        if (tens == 4) {
            romanTens += String.join("", "XL");
            tens -= 4;
        }
        if (tens <= 3) {
            romanTens += String.join("", "X".repeat(tens));
        }
        if (units == 9) {
            romanUnits += String.join("", "IX");
            units -= 9;
        }
        if (units >= 5) {
            romanUnits += String.join("", "V");
            units -= 5;
        }
        if (units == 4) {
            romanUnits += String.join("", "IV");
            units -= 4;
        }
        if (units <= 3) {
            romanUnits += String.join("", "I".repeat(units));
        }
        return romanThousands + romanHundreds + romanTens + romanUnits;
    }

    public int fromRomanToDecimal(String roman) {

        roman += String.join(""," ");
        char[] charArray = roman.toCharArray();
        int decimal = 0;

        for (int i = 0; i < charArray.length; i++) {
            switch (charArray[i]) {
                case 'M': {
                    decimal += 1000;
                    break;
                }
                case 'D': {
                    decimal += 500;
                    break;
                }
                case 'C': {
                    if (charArray[i + 1] == 'M') {
                        decimal += 900;
                        i++;
                        break;
                    }
                    if (charArray[i + 1] == 'D') {
                        decimal += 400;
                        i++;
                        break;
                    }
                    decimal += 100;
                    break;
                }
                case 'L': {
                    decimal += 50;
                    break;
                }
                case 'X': {
                    if (charArray[i + 1] == 'C') {
                        decimal += 90;
                        i++;
                        break;
                    }
                    if (charArray[i + 1] == 'L') {
                        decimal += 40;
                        i++;
                        break;
                    }
                    decimal += 10;
                    break;
                }
                case 'V': {
                    decimal += 5;
                    break;
                }
                case 'I': {
                    if (charArray[i + 1] == 'X') {
                        decimal += 9;
                        i++;
                        break;
                    }
                    if (charArray[i + 1] == 'V') {
                        decimal += 4;
                        i++;
                        break;
                    }
                    decimal += 1;
                    break;
                }
            }
        }
        return decimal;
    }
}
