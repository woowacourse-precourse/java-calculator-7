package calculator.Service;

import calculator.DTO.StringCalculatorDTO;
import camp.nextstep.edu.missionutils.Console;

public class InputReader {

    // 입력을 받아 DTO로 반환하는 메서드
    public StringCalculatorDTO read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.isEmpty()) {
            // 빈 문자열을 " "로 바꿨지만 해당 부분 이외에는 공백에 대한 예외 처리를 하지 않음
            input = " ";
        } else if (input.isBlank()) {
            // 공백 문자는 입력 조건에 위배되기 때문에 예외 처리
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식 (공백):" + input);
        }

        // 입력 후 콘솛 객체 제거
        Console.close();

        // 입력값을 DTO로 감싸서 반환
        return new StringCalculatorDTO(input);
    }
}
