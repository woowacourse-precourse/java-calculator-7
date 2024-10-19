package calculator;

public class StringCalculator {
    public int calculate(String userInput) {
        String[] nums = userInput.split("[,;]");
        int answer = 0;
        for (String num : nums) {
            answer += Integer.parseInt(num);
        }
        return answer;
    }
}

