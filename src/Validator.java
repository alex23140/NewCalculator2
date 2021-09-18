public class Validator {

    public static boolean numbersInRangeCheck(int a, int b) {
        return (a < 1 || a > 10) || (b < 1 || b > 10);
}

    public static boolean inputElementsNumberCheck(String[] input) {
        return input.length != 3;
    }

    public static boolean inputElementsSameTypeCheck(String a, String b) {
        return !(Character.isDigit(a.charAt(0)) && Character.isDigit(b.charAt(0)) ||
                (!Character.isDigit(a.charAt(0)) && !Character.isDigit(b.charAt(0))));

    }
}
