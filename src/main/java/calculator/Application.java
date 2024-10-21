package calculator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();

        String input = app.getInputString();

        String[] slice;
        if (input.startsWith("/")) {
            slice = app.customSliceString(input);
        } else {
            slice = app.sliceString(input);
        }

        int[] numList = app.stringArrayToIntArray(slice);
        int sum = app.sumList(numList);
        app.printResult(sum);
    }

    public String getInputString() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input == null) {
            throw new IllegalArgumentException("빈 문자열입니다");
        }
        return input;
    }

    public String[] sliceString(String input) {
        if (input.matches(".*[^0-9,;].*")) {
            throw new IllegalArgumentException("유효하지 않은 문자가 포함되어 있습니다.");
        }
        return input.split("[,;]");
    }

    public int[] stringArrayToIntArray(String[] slice) {
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

    public int sumList(int[] numList) {
        int sum = 0;
        for (int j : numList) {
            sum += j;
        }
        return sum;
    }

    public String[] customSliceString(String input) {
        input = input.replace("\\n", "\n");
        String[] s = input.split("\n");
        if (s.length != 2) {
            throw new IllegalArgumentException("유효한 형식이 아닙니다");
        }
        String custom = s[0].substring(2);
        if (custom.length() != 1) {
            throw new IllegalArgumentException("구분자가 유효한 형식이 아닙니다");
        }
        String[] slice = s[1].split(Pattern.quote(custom));
        return slice;
    }

    public void printResult(int sum) {
        System.out.println("결과 : " + sum);
    }
}
