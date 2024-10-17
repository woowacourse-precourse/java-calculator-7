package calculator;

public class Validator {

    static Result validate(String input) {
        int start = input.indexOf("//");
        int end = input.indexOf("\\n");

        String message = null;
        boolean isCorrect = true;
        if (start != -1 && end != -1) {
            // 커스텀 구분자를 위한 // \n 가 입력에 존재하는 경우
            if (start > end) {
                message = "커스텀 구분자는 입력값 가장 앞에 //커스텀구분자\\n 와 같이 입력해야합니다.";
                isCorrect = false;
            }

            String separators = input.substring(start + 2, end);
            if (separators.isEmpty()) {
                message = "커스텀 구분자는 빈값(\"\") 이 될 수 없습니다.";
                isCorrect = false;
            }

            if (isWrong(separators, input.substring(end + 2))) {
                message = "커스텀 구분자를 사용한 경우 해당 구분자들과(" + separators + ")과 숫자로만 계산식이 구성되어야 합니다.";
                isCorrect = false;
            }
        } else {
            // 그렇지 않은 경우
            if (isWrong(",:", input)) {
                message = "커스텀 구분자를 입력하지 않는 경우 숫자, ',', ':' 로만 입력값을 구성해야 합니다.";
                isCorrect = false;
            }
        }

        return new Result(isCorrect, message, input);
    }

    private static boolean isWrong(String separators, String sequence) {
        for (char c: sequence.toCharArray()) {
            if (c == ' ') continue;
            if (!Character.isDigit(c) && !separators.contains(String.valueOf(c))) return true;
        }
        return false;
    }
}
