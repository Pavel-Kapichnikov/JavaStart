package com.example.javacalc;

import java.util.Scanner;

public class Main {

    public static String calc(String input) {

        String[] arr = input.split(" ");

        String x = arr[0];
        String op = arr[1];
        String y = arr[2];

        if (arr.length > 3)
            throw new Error("Некорректный ввод");

        int a;
        int b;
        boolean isRoman;

        try {
            a = Integer.parseInt(x);
            b = Integer.parseInt(y);
            isRoman = false;
        } catch (NumberFormatException e) {
            x = romanToArabic(x);
            y = romanToArabic(y);
            a = Integer.parseInt(x);
            b = Integer.parseInt(y);
            isRoman = true;
            }

        if (a > 10 || b > 10) throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        if (a < 1 || b < 1) throw new IllegalArgumentException("Числа должны быть от 1 до 10");

        int z;

        switch (op) {
            case "+":
                z = a + b;
                break;
            case "-":
                z = a - b;
                break;
            case "*":
                z = a * b;
                break;
            case "/":
                z = a / b;
                break;
            default:
                throw new Error("Ошибка, неизвестное действие");
        }

        String result;
        if (isRoman && z > 1) {
            result = arabicToRoman(z);
        } else if (isRoman && z < 1) {
            throw new Error("Результат < I");
        } else {
            result = String.valueOf(z);
        }

        return result;
    }

    private static String romanToArabic(String input) {
        String[] romanNumerals = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] arabicValues = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String newArabic = null;

        for (int i = 0; i < romanNumerals.length; i++) {
            if (romanNumerals[i].equals(input)) {
                newArabic = arabicValues[i];
            }
        }

        if (newArabic == null) {
            throw new IllegalArgumentException("Некорректные аргументы");
        }
        return newArabic;
    }

    private static String arabicToRoman(int number) {
        String result = "";
        int[] arabicSymbols = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbols = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < arabicSymbols.length; i++) {
            while (number >= arabicSymbols[i]) {
                result = result + romanSymbols[i];
                number = number - arabicSymbols[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        System.out.println(calc(input));
    }
}