package calculator.Service;
import calculator.DTO.StringCalculatorDTO;
import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    // 입력을 받아 DTO로 반환하는 메서드
    public StringCalculatorDTO read() {
        System.out.println("구분자와 양수로 구성되어있는 문자열을 입력하세요: ");
        String input = Console.readLine();      // 사용자로부터 입력 받기
        return new StringCalculatorDTO(input);  // 입력값을 DTO로 감싸서 반환
    }
}
