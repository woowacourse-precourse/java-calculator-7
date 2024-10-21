package calculator.domain.service;


import calculator.domain.dto.InputDTO;
import calculator.domain.dto.ResultDTO;

public class CalculatorService  {
    private final NormalCalculator normalCalculator;
    private final SpecialCalculator specialCalculator;

    //생성자 구현
    public CalculatorService(NormalCalculator normalCalculator, SpecialCalculator specialCalculator) {
        this.normalCalculator = normalCalculator;
        this.specialCalculator = specialCalculator;
    }
    //계산하는 기능
    public ResultDTO calculate(InputDTO inputDTO) {
        String input = inputDTO.getInput();
        if (input.startsWith("//")) {
            //"//"의 뒤에 나오게 되는 새로운 delimeter의 경우는 "\n"으로 끝나야 하기 때문에 인덱스 3이 "\"이고 인덱스 4가 "n"인지 확인한다.
            char checkChar =input.charAt(3);
            char checkChar2 =input.charAt(4);
            if (checkChar == '\\' && checkChar2 == 'n') {
                //checkChar가 \이고 그 뒤에 n이 오는지 확인하여 그 앞의 문자가 delimter로 설정
                char delimiter = input.charAt(2);
                String delimiters = ",|:|" + delimiter;

                int delimeterIndex = input.indexOf('n'); // "\n" 이후의 값을 input으로 넣어줌

                String numbersArray = input.substring( delimeterIndex+ 1); // n의 위치를 구해 substring으로 자름
                int result = specialCalculator.calculate(new InputDTO(numbersArray), delimiters);
                return new ResultDTO(result);
            }else{
                // //새로운 구분자\n 의 형식이 지켜지지 않을 경우에 대한 예외처리
                throw new IllegalArgumentException("잘못된 구분자 입력입니다.");
            }

        } else {
            // "//"으로 시직하지 않는 경우는 일반적인 계산기를 사용한다.
            int result = normalCalculator.calculate(inputDTO);
            return new ResultDTO(result);
        }
    }
}
