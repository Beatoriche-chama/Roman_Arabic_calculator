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
        List<Integer> arabic_values = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        if (map_10.containsKey(first_number) && map_10.containsKey(second_number)) {
            int a = x.romanToInt(first_number);
            int b = x.romanToInt(second_number);
            int k = calc.doing_math(certain_operator, a, b);
            System.out.println(y.intToRoman(k));
        }

        if (arabic_values.contains(Integer.parseInt(first_number)) &&
                arabic_values.contains(Integer.parseInt(second_number))) {
            System.out.println(calc.doing_math(certain_operator, Integer.parseInt(first_number),
                    Integer.parseInt(second_number)));
        }


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
        return result;

    }


}

