package calculator;

public class InputParser {
    private final String inputText;
    private String separator;
    private String[] numbers;

    public InputParser(String inputText) {
        this.inputText = inputText;
        parseInput();
    }

    private void parseInput() {
        if (isCustomSeparator(inputText)) {
            this.separator = inputText.substring(2, 3);
            if (this.separator.equals("\\")) {
                this.separator = "\\\\";
            }
            this.numbers = inputText.substring(5).split(separator);
        } else if (isDefaultSeparator(inputText)) {
            this.separator = "[,:]";
            this.numbers = inputText.split(separator);
        } else {
            System.out.println("입력 오류: 올바른 구분자를 입력해주세요");
            throw new IllegalArgumentException();
        }
    }

    private static boolean isCustomSeparator(String inputText) {
        if (inputText.startsWith("//")) {
            try {
                // "//문자\n" 형태라면 올바른 입력
                if (inputText.startsWith("\\n", 3)) {
                    return true;
                }
                // 에러 식별
                if (inputText.contains("\\n")) {
                    System.out.println("입력 오류: 커스텀 구분자가 두 글자 이상입니다.");
                } else {
                    System.out.println("입력 오류: 올바른 커스텀 구분자 양식이 아닙니다.");
                }
                throw new IllegalArgumentException();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("입력 오류: 커스텀 구분자 양식을 확인해주세요");
                throw new IllegalArgumentException();
            }
        }
        return false;
    }

    private static boolean isDefaultSeparator(String inputText) {
        return inputText.contains(",") || inputText.contains(":");
    }

    public String getSeparator() {
        return separator;
    }

    public String[] getNumbers() {
        return numbers;
    }
}
