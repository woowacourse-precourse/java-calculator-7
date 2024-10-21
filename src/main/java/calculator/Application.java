package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 1. 입력을 받는다.
        String input = inputExpression();

        // 2. 입력에서 계산식과 커스텀 구분자를 각각 구해서 저장한다.
        String expression = findExpression(input);
        String customSeparator = findCustomSeparator(input, expression);

        // 3. 계산식에서 split() 으로 숫자를 구분하기 편하도록 계산식의 커스텀 구분자와 콜론(:)을 쉼표(,)로 통일한다.
        expression = unifySeparator(expression, customSeparator);
    }

    // 문자열을 입력 받아 입력 받은 문자열을 반환하는 메소드
    private static String inputExpression(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 입력에서 계산식을 추출해서 반환하는 메소드
    private static String findExpression(String input){
        String regex = "//.*\\\\n";
        return input.replaceFirst(regex, ""); // 구분자를 지정하는 부분을 잘라낸 후 계산식만 반환
    }

    // 입력에서 커스텀 구분자를 추출해서 반환하는 메소드
    private static String findCustomSeparator(String input, String expression){
        String customSeparator = "";
        if(input.length() > expression.length()){  // 커스텀 구분자 ( //\n )를 입력 했을 때만 입력 값에서 커스텀 구분자를 추출
            customSeparator = input.substring(2, input.length() - expression.length() - 2);
        }
        return customSeparator;
    }

    // 계산식의 모든 구분자를 쉼표(,) 로 치환하는 메소드
    private static String unifySeparator(String expression, String customSeparator){
        expression = expression.replace(":", ",");
        if(!customSeparator.equals("")) expression = expression.replace(customSeparator, ",");

        return expression;
    }
}
