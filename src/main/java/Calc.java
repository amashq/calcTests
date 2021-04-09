import java.util.Scanner;

public class Calc {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Calc calc = new Calc();
        char action = scanner.nextLine().toCharArray()[0];
        Double a = scanner.nextDouble();
        Double b = scanner.nextDouble();
        System.out.println("" + calc.doAction(a, b, action));

    }

    public Object doAction(Object num1, Object num2, Object action1) {
        char action = (char) action1;
        Double a = (Double) num1;
        Double b = (Double) num2;

        switch (action) {
            case ('+'):
                return a + b;
            case ('-'):
                return a - b;
            case ('*'):
                return a * b;
            case ('/'):
                try {
                    return a / b;
                } catch (ArithmeticException e) {
                    System.out.println("division by zero");
                    return false;
                }
        }
        return false;
    }
}
