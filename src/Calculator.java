import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Калькулятор для выражений вида: \"Число1 Операция Число2\", через пробел. Допускаются числа от 1 до 10 или от I до X включительно. Операции: + - * /");
            System.out.print("Введите выражение: ");

            String str = sc.nextLine();
            String[] input = str.split(" ");

            if (Validator.inputElementsNumberCheck(input)) {
                throw new Exception("Ошибка: Неверное количество элементов ввода");
            }

            if (Validator.inputElementsSameTypeCheck(input[0], input[2])) {
                throw new Exception("Ошибка: Введённые операнды разного типа");
            }

            boolean inputIsRoman = !Character.isDigit(input[0].charAt(0));
            int a = Converter.romanToArab(input[0]);
            int b = Converter.romanToArab(input[2]);
            String operator = input[1];

            Integer calculationResult = CalculationProcedure.calculate(a, b, operator);
            String outputResult;

            if (inputIsRoman) {
                outputResult = Converter.arabToRoman(calculationResult);
            } else {
                outputResult = calculationResult.toString();
            }

            System.out.println("Ответ = " + outputResult);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

