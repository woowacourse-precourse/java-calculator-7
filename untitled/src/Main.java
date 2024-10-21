public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요:");

        String input = Console.readLine();

        try {
            int result = add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            if (parts.length == 2) {
                delimiter = parts[0].substring(2);
                input = parts[1];
            } else {
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;

        for (String number : numbers) {
            int num = toPositiveInt(number);
            sum += num;
        }

        return sum;
    }

    private static int toPositiveInt(String number) {
        try {
            int result = Integer.parseInt(number);
            if (result < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + result);
            }
            return result;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + number);
        }
    }
}