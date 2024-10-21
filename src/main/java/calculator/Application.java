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

        // 4. 계산식이 올바른 형식의 계산식인지 확인한다.
        isValidExpression(expression);

        // 5. 계산식에서 구분자를 기준으로 나눈 각각의 숫자들을 더한 합을 구한다.
        long total = sum(expression);

        System.out.printf("결과 : %d", total);
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

    // 계산식이 올바른 형식인지 확인하는 메소드
    private static void isValidExpression(String expression){
        // 모든 구분자를 쉼표로 치환한 계산식이 숫자, 쉼표(,)로만 구성되어 있지 않으면 입력 오류
        if(!expression.matches("[0-9,]+"))
            throw new IllegalArgumentException("계산식은 양수의 숫자와 콜론(:), 쉼표(,), 커스텀 구분자로만 입력할 수 있습니다.");

        // 숫자로 시작해서 숫자로 끝나지 않거나, 구분자를 연속으로 사용 할 경우 입력 오류
        if(!expression.matches("^[0-9]$|^[0-9].*[0-9]$") || expression.contains(",,"))
            throw new IllegalArgumentException("입력 양식을 지켜주세요. ex) 1,2:3, //*\\n1:2*3");
    }

    // 구분자로 분리한 숫자들의 합을 구해서 반환하는 메소드
    private static long sum(String expression){
        String[] numbers = expression.split(","); // 계산식의 모든 구분자를 쉼표로 치환했기 때문에 쉼표로 숫자 구분
        long total = 0;
        for(int i = 0; i < numbers.length; i++) {
            try {
                long number = Long.parseLong(numbers[i]);

                // number + total 이 Long 범위를 넘으면 예외 발생
                if (number > Long.MAX_VALUE - total) throw new RuntimeException();

                total += number;

            } catch (Exception e) {
                // 계산식에 들어있는 수가 Long 범위를 벗어나거나, 총 합이 Long 범위를 벗어나면 예외 발생
                throw new IllegalArgumentException(String.format("절대값이 %d를 넘는 값은 계산할 수 없습니다.", Long.MAX_VALUE));
            }
        }

        return total;
    }
}
