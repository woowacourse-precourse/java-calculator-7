package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Application app = new Application();
        Calculate calculate = new Calculate();

        String input = app.getInputString();

        int sum = calculate.calculate(input);
        app.printResult(sum);
    }

    private String getInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("빈 문자열입니다");
        }
        return input;
    }

    private void printResult(int sum) {
        System.out.println("결과 : " + sum);
    }
}


class Calculate {
    public int calculate(String input) {
        String[] slice;
        if (input.startsWith("/")) {
            slice = customSliceString(input);
        } else {
            slice = sliceString(input);
        }

        int[] numList = stringArrayToIntArray(slice);
        return sumList(numList);
    }

    private String[] sliceString(String input) {
        if (input.matches(".*[^0-9,;].*")) {
            throw new IllegalArgumentException("유효하지 않은 문자가 포함되어 있습니다.");
        }
        String[] slice = input.split("[,;]");
        validateSlice(slice);
        return slice;
    }

    private int[] stringArrayToIntArray(String[] slice) {
        int[] numList = new int[slice.length];

        for (int i = 0; i < slice.length; i++) {
            try {
                int number = Integer.parseInt(slice[i]);
                if (number < 0) {
                    throw new IllegalArgumentException("음수가 있습니다");
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(slice[i] + "는 유효하지 않은 숫자 형식입니다.");
            }
            numList[i] = Integer.parseInt(slice[i]);
        }
        return numList;
    }

    private int sumList(int[] numList) {
        int sum = 0;
        for (int j : numList) {
            sum += j;
        }
        return sum;
    }

    private String[] customSliceString(String input) {
        input = input.replace("\\n", "\n");
        String[] s = input.split("\n");
        if (s.length != 2) {
            throw new IllegalArgumentException("유효한 형식이 아닙니다");
        }
        String custom = s[0].substring(2);
        if (custom.length() != 1 || Character.isDigit(custom.charAt(0))) {
            throw new IllegalArgumentException("구분자가 유효한 형식이 아니거나 숫자가 될 수 없습니다.");
        }
        String[] slice = s[1].split(Pattern.quote(custom));
        validateSlice(slice);
        return slice;
    }

    private void validateSlice(String[] slice) {
        if (slice.length == 0) {
            throw new IllegalArgumentException("입력 값이 유효하지 않습니다. 숫자가 포함되어 있지 않습니다.");
        }
    }
}
