import java.util.HashMap;
import java.util.Map;

public class Converter {

    public static int romanToArab(String a) {

        if (Character.isDigit(a.charAt(0))) {
            return Integer.parseInt(a);
        }

        if (a.charAt(0) == '-') {
            throw new RuntimeException("Ошибка: У римлян не было отрицательных чисел и нуля");
        }

        Map<Character, Integer> numRome = new HashMap<>(){};
        numRome.put('I', 1);
        numRome.put('V', 5);
        numRome.put('X', 10);

        int result = 0;

        for (int i=0; i<a.length(); i++ ){
            Character ch = a.charAt(i);
            if (!numRome.containsKey(ch)) {
               throw new RuntimeException("Ошибка: Введены римские цифры неверного формата");
            }
        }
        for (int i=0 ;i<a.length(); i++){
            Character ch = a.charAt(i);
            if(i<a.length()-1) {
                Character nextCh = a.charAt(i + 1);
                if (numRome.get(ch) < numRome.get(nextCh)) {
                    if (ch == 'V' && nextCh == 'X') {
                        throw new RuntimeException("Ошибка: Введены несуществующие римские цифры");
                    }
                    if (i!=0){
                        Character prevCh= a.charAt(i-1);
                        if(numRome.get(ch)<=numRome.get(prevCh)){
                            throw new RuntimeException("Ошибка: Введены несуществующие римские цифры");
                        }
                    }
                    result += numRome.get(nextCh) - numRome.get(ch);
                    i++;
                } else {
                    result += numRome.get(ch);

                }
            }
            else {
                result+=numRome.get(ch);
            }
        }


        if (result > 10) {
            throw new RuntimeException("Ошибка: Введены римские числа превышающие 10");
        }

        if (result <= 0) {
            throw new RuntimeException("Ошибка: У римлян не было отрицательных чисел и нуля");
        }

        return result;
    }

    public static String arabToRoman(Integer a) {
        Map<Integer, String> numRome = new HashMap<>(){};
        numRome.put(1, "I");
        numRome.put(4, "IV");
        numRome.put(5, "V");
        numRome.put(9, "IX");
        numRome.put(10, "X");
        numRome.put(50, "L");
        numRome.put(100, "C");

        if (a <= 0) {
            throw new RuntimeException("Ошибка: У римлян не было отрицательных чисел и нуля");
        }

        int num = a;
        String result = "";

        while (num != 0) {
            if (num >= 100)  {
                result += numRome.get(100);
                num -= 100;
            } else if (num >= 50)  {
                result += numRome.get(50);
                num -= 50;
            } else if (num >= 10)  {
                result += numRome.get(10);
                num -= 10;
            } else if (num >= 9)  {
                result += numRome.get(9);
                num -= 9;
            } else if (num >= 5)  {
                result += numRome.get(5);
                num -= 5;
            } else if (num >= 4)  {
                result += numRome.get(4);
                num -= 4;
            } else  {
                result += numRome.get(1);
                num -= 1;
            }
        }



        return result;
    }
}





