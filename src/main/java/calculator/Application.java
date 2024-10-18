package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        // TODO: 프로그램 구현
        String userInput = Console.readLine();
        Console.close();

        List<Integer> nums;

        if (userInput.startsWith("//") && userInput.startsWith("\\n", 3)) {
            nums = customDelim(userInput);
        } else {
            nums = basicDelim(userInput);
        }

        int sum = (nums != null) ? nums.stream().mapToInt(i -> i).sum() : 0;
        System.out.println("결과 : " + sum);
    }

    private static List<Integer> customDelim(String userInput) {
        String customDelim = userInput.substring(2, 3);
        String checkString = userInput.substring(5);
        StringTokenizer st = new StringTokenizer(checkString, customDelim);
        List<Integer> nums = new ArrayList<>();
        extracted(st, nums);
        return !nums.isEmpty() ? nums : null;
    }

    private static List<Integer> basicDelim(String userInput) {
        List<String> strings = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(userInput, ",");
        while (st.hasMoreTokens()) {
            strings.add(st.nextToken());
        }
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            st = new StringTokenizer(strings.get(i), ":");
            extracted(st, nums);
        }
        return nums;
    }

    private static void extracted(StringTokenizer st, List<Integer> nums) {
        while (st.hasMoreTokens()) {
            int num;
            try {
                num = Integer.parseInt(st.nextToken());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            if (num <= 0) {
                throw new IllegalArgumentException();
            }
            nums.add(num);
        }
    }
}
