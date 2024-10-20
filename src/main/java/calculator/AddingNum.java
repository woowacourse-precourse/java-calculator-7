package calculator;

public class AddingNum {
    // 숫자 배열을 합산하는 메서드
    static int sum(String[] nums) {
        int result = 0;

        for (String word : nums) {
            if (word.trim().isEmpty()) {
                return 0;
            }
            CheckValid.isValidString(word);
            CheckValid.isValidNum(word);

            result += Integer.parseInt(word.trim());
        }
        return result;
    }
}
