import com.intellij.util.containers.HashMap;

import java.util.*;

import static com.intellij.ui.plaf.beg.BegResources.j;
import static org.apache.commons.lang.math.RandomUtils.nextInt;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first_number = scanner.next();
        String certain_operator = scanner.next();
        String second_number = scanner.next();

        ArabicToRomanConverter y = new ArabicToRomanConverter();
        RomanToArabicConverter x = new RomanToArabicConverter();
        Map<String, Integer> map_10 = new HashMap<>();
        map_10.put("I", 1);
        map_10.put("II", 2);
        map_10.put("III", 3);
        map_10.put("IV", 4);
        map_10.put("V", 5);
        map_10.put("VI", 6);
        map_10.put("VII", 7);
        map_10.put("VIII", 8);
        map_10.put("IX", 9);
        map_10.put("X", 10);

        Calculator calc = new Calculator();

        if (map_10.containsKey(first_number) && map_10.containsKey(second_number)) {
            int a = x.romanToInt(first_number);
            int b = x.romanToInt(second_number);
            System.out.println(y.intToRoman(calc.doing_math(certain_operator, a, b)));
            System.exit(0);
        }


        if (first_number.matches("-?\\d+(\\.\\d+)?") && map_10.containsKey(second_number) ||
                map_10.containsKey(first_number) && second_number.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("Ой, нельзя считать вместе римские и арабские циферки...");
        }


        if (first_number.matches("^[1-9]|1[0-0]$") && second_number.matches("^[1-9]|1[0-0]$")) {
            System.out.println(calc.doing_math(certain_operator, Integer.parseInt(first_number),
                    Integer.parseInt(second_number)));
        }

        else {System.out.println("Вы какую-то циферку не так написали. Или циферка не входит в диапазон от 1 до 10 включительно :с");}


    }


    private int doing_math(String operator, int first, int second) {
        int result = 0;
        if (operator.contains("*")) {
            result = first * second;
        }
        if (operator.contains("/")) {
            result = first / second;
        }
        if (operator.contains("+")) {
            result = first + second;
        }
        if (operator.contains("-")) {
            result = first - second;
        }
        if (!operator.matches(".*[*/+-].*")){System.out.println("Какой-то у Вас оператор неправильный!");}
        return result;

    }


}

