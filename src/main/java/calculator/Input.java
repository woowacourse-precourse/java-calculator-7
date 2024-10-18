import camp.nextstep.edu.missionutils.Console;

public class Input  {
    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public void validateInput(String input) {
        // 빈 문자열 검사
        if (input.trim().length() == 0) {
            System.out.println("0");
        }
        // 음수 검사
        if (input.contains("-")) {
            throw new IllegalArgumentException("음수가 포함되어 있습니다.");
        }
        // 숫자 포함 검사
        if (!input.matches(".*[0-9].*")) {
            throw new IllegalArgumentException("숫자가 포함되지 않았습니다.");
        }

        // 커스텀 구분자 검사
        if (input.startsWith("//")) {
            Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (!matcher.find()) {
                throw new IllegalArgumentException("잘못된 형식입니다. '//(구분자)\n(문자열)' 형식이어야 합니다.");
            }
        }

    }






    }
}