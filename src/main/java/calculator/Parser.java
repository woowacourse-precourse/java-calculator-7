package calculator;

public class Parser {
    public ParsedInput parse(String input) {
        if (input == null || input.isEmpty()) {
            return new ParsedInput("", ""); // 빈 입력일 경우 처리
        }

        if (input.startsWith("//")) {
            String[] parts = splitCommandAndExpression(input);
            return new ParsedInput(parts[0], parts[1]); // command와 expression을 분리해 반환
        }
        return new ParsedInput("", input); // command가 없으면 빈 문자열 반환
    }

    private String[] splitCommandAndExpression(String input) {
        String endCommand = "\\n";
        int endCommandIndex = input.indexOf(endCommand);
        if (endCommandIndex == -1) {
            throw new IllegalArgumentException("Invalid input format. Missing newline after custom delimiter.");
        }

        String command = input.substring(0, endCommandIndex);
        String expression = input.substring(endCommandIndex + endCommand.length());
        return new String[]{command, expression};
    }
}
