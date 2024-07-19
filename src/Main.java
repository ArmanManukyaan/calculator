import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        try {
            System.out.println(calc(input));
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static int operation(int num1, int num2, char operation) throws Exception {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new Exception("Деление на ноль");
                }
                return num1 / num2;
            default:
                throw new Exception("Неверный оператор");
        }
    }

    public static String calc(String input) throws Exception {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new Exception("строка не является математической операцией");
        }
        int num1 = parseNumber(parts[0]);
        int num2 = parseNumber(parts[2]);
        char operator = parts[1].charAt(0);

        int result = operation(num1, num2, operator);
        return String.valueOf(result);
    }

    private static int parseNumber(String input) throws Exception {
        int number = Integer.parseInt(input);
        try {
            if (number < 0 || number > 10) {
                throw new Exception("Число вне допустимого диапазона");
            }
            return number;
        } catch (Exception e) {
            throw new Exception("Неверный формат числа");
        }
    }
}