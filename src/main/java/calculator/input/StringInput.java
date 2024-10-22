package calculator.input;

import static calculator.validate.StringValidate.validateNotNullInput;

import calculator.resources.AutoCloser;
import camp.nextstep.edu.missionutils.Console;

public class StringInput {
    public static String getInput() {
        // try-with-resources를 적용하여 자동으로 Console 리소스를 닫아줌
        try (AutoCloser autoCloser = new AutoCloser()) {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
            validateNotNullInput(input);
            return input;
        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류가 발생했습니다: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다: " + e.getMessage());
        }
        return null;
    }
}
