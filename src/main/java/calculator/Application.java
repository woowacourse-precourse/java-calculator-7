package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

// model
class SumModel {
    private final int count;

    public SumModel(int count) {
        this.count = count;
    }
}

class ExpressionModel {
    private final String expression;

    public ExpressionModel(String expression) {
        this.expression = expression;
    }

    public boolean hasCustomDelimiter(String expression) {
        return expression.startsWith("//");
    }

    public String delimiterSection() {
        int startIdx = expression.indexOf("//") + 2;
        int endIdx = expression.indexOf("\\n");
        return expression.substring(startIdx, endIdx);
    }

    public String nonDelimiterSection() {
        int startIdx = expression.indexOf("\\n") + 2;
        return expression.substring(startIdx);
    }
}

class DelimiterModel {
    private String delimiter;

    public DelimiterModel() {
        this.delimiter = ",|:";
    }

    public void registerDelimiter(String delimiterRange) {
        for (int nowDelimiterIdx = 0; nowDelimiterIdx < delimiterRange.length(); nowDelimiterIdx++) {
            this.delimiter += ("|\\" + delimiterRange.charAt(nowDelimiterIdx));
        }
    }

    public String getDelimiter() {
        return delimiter;
    }
}

class CalculatorModel {
    private DelimiterModel delimiter;

    public int calculate(ExpressionModel expressionModel) {
        // 커스텀 구분자 등록

        // 구분자로 문자열 자르기

        int sum = 0;
        // 숫자 합 계산
        return sum;
    }

}

// view
class CalculateView {
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public void displayResult(int cnt) {
        System.out.println("결과 : " + cnt);
    }
}

// controller
class CalculatorController {
    private final CalculatorModel model;
    private final CalculateView view;

    public CalculatorController(CalculatorModel model, CalculateView view) {
        this.model = model;
        this.view = view;
    }

    public void calculate(int cnt) {
        String expression = view.getUserInput();
        // 데이터 처리

        // 출력
    }
}

public class Application {
    static String delimiter = ",|:";
    static String inputExpression;

    static int hasCustom(String str) {
        int start = str.indexOf("//");
        return start;
    }

    static void registerCustom(String str) {
        int customStart = hasCustom(str);
        for (int i = customStart + 2; i < str.length() - 2; i++) {
            // 여기 안의 과정을 하나로 묶어야 함 (idx 필요)
            if (str.startsWith("\\n", i)) {
                String tmp = str.substring(customStart + 2, i);
                for (int j = 0; j < tmp.length(); j++) {
                    delimiter += "|\\" + tmp.charAt(j);
                }
                inputExpression = inputExpression.substring(i + 2);
                break;
            }
        }
    }

    public static void main(String[] args) {
        // 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputExpression = Console.readLine();

        // 구분자 등록
        if (hasCustom(inputExpression) != -1) {
            registerCustom(inputExpression);
        }

        // 구분자로 문자열 자르기
        String[] numbers = inputExpression.split(delimiter);

        // 추출된 숫자들의 합 구하기
        int cnt = 0;
        for (String nowStr : numbers) {
            String REGEXP_ONLY_NUM = "^[\\d]*$";
            if (!Pattern.matches(REGEXP_ONLY_NUM, nowStr)) {
                throw new IllegalArgumentException();
            }
            if (nowStr.equals("")) {
                continue;
            }
            int nowInt = Integer.parseInt(nowStr);
            if (nowInt <= 0) {
                throw new IllegalArgumentException();
            }
            cnt += nowInt;
        }

        // 결과 출력
        System.out.println("결과 : " + cnt);
    }
}

