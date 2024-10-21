package calculator;

public class Application {

    public static void main(String[] args) {
        // 입력
        String request = UserInterface.getUserInput();

        if (request.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 커스텀 구분자와 문자열 분리
        String customDelimiter = DelimiterExtractor.extractCustomDelimiter(request);
        String subString = DelimiterExtractor.extractSubString(request, customDelimiter);

        // 구분자로 숫자분리
        String[] speratedStrings;

        if (!customDelimiter.isEmpty()) {
            speratedStrings = StringParser.splitString(subString, customDelimiter);
        } else {
            speratedStrings = StringParser.splitString(subString);
        }


        // 덧셈, 결과출력
        int answer = Calculate.add(speratedStrings);
        System.out.println("결과 : " + answer);

    }

}
