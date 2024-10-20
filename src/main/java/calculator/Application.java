package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

// model
class PositiveNumberModel {
    private final String REGEXP_ONLY_NUM = "^[\\d]*$";
    private final String EMPTY_NUMBER = "";

    private int count;

    public PositiveNumberModel(int count) {
        this.count = count;
    }

    public void plus(String numberAdded) {
        if (!Pattern.matches(REGEXP_ONLY_NUM, numberAdded)) {
            throw new IllegalArgumentException("잘못된 구분자를 포함합니다.");
        }
        if (numberAdded.equals(EMPTY_NUMBER)) {
            return;
        }

        int number = Integer.parseInt(numberAdded);
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닌 수를 포함합니다.");
        }
        this.count += number;
    }

    public int getCount() {
        return this.count;
    }
}

class ExpressionModel {
    private final String expression;

    public ExpressionModel(String expression) {
        this.expression = expression;
    }

    public boolean hasCustomDelimiter() {
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

    public String getExpression() {
        return expression;
    }
}

class DelimiterModel {
    private String delimiter;

    public DelimiterModel() {
        this.delimiter = ",|:";
    }

    public void registerDelimiter(String delimiterSection) {
        for (int nowDelimiterIdx = 0; nowDelimiterIdx < delimiterSection.length(); nowDelimiterIdx++) {
            this.delimiter += ("|\\" + delimiterSection.charAt(nowDelimiterIdx));
        }
    }

    public String getDelimiter() {
        return delimiter;
    }
}

class CalculatorModel {
    private final DelimiterModel delimiter = new DelimiterModel();

    public int calculate(ExpressionModel expressionModel) {
        // 커스텀 구분자 등록
        String nonDelimiterSection = expressionModel.getExpression();

        if (expressionModel.hasCustomDelimiter()) {
            delimiter.registerDelimiter(expressionModel.delimiterSection());
            nonDelimiterSection = expressionModel.nonDelimiterSection();
        }

        // 구분자로 문자열 자르기
        String[] numbers = nonDelimiterSection.split(delimiter.getDelimiter());

        PositiveNumberModel sum = new PositiveNumberModel(0);
        // 숫자 합 계산
        for (String nowNum : numbers) {
            sum.plus(nowNum);
        }
        return sum.getCount();
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

