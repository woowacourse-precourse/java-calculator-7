package calculator;

public class StringCalculator {
    private String input;

    public StringCalculator(String input) {
        this.input = input;
    }

    private String findSeperator() {
        // 1차적으로 문자열 맨 앞에 "//" 가 있고, "\n"으로 닫혀있는지 확인하여 어떤 커스텀 구분자를 사용하는지 검출
        if (input.startsWith("//")) {
            return whichCustomSperator(input.substring(2));
        }
        return "defaultSeparator";
    }

    private String whichCustomSperator(String subInput) {
        int newlineIndex = subInput.indexOf("\\n");

        if (newlineIndex == -1) {
            // exception 구현 예정
            throw new IllegalArgumentException("\\n으로 끝나지 않았다는 exception 구현 예정");
        }
        // "\n" 이전까지의 문자열을 커스텀 구분자로 사용
        String customSperator = subInput.substring(0, newlineIndex);

        if (customSperator.isEmpty()) {
            // exception 구현 예정
            throw new IllegalArgumentException("// \\n 사이 구분자가 존재하지 않는다는 exception 구현 예정");
        }
        return customSperator;
    }

    public int calculate() {
        String separator = findSeperator();
        return 0;
    }
}
