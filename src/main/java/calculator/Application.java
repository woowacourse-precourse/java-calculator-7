package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        printInstructions();

        String input = Console.readLine();

        Calculator calculator = new Calculator(new Spliterator("[,:]"));
        System.out.println("결과 : " + calculator.calculate(input));

        Console.close();
    }

    private static void printInstructions() {
        System.out.println("""
                ==== 문자열 계산기 시작 ====        
                이 계산기는 입력된 문자열에서 숫자를 추출하여 더하는 기능을 제공합니다.
                
                ** 기본 구분자 **
                - 입력된 문자열에서 콤마(,) 또는 콜론(:)을 구분자로 사용하여 0 이상의 정수를 분리합니다.
                - 분리된 숫자들의 합을 계산하여 결과를 반환합니다.
                
                ** 예시: **
                  "" => 0
                  "1,2" => 3
                  "1,2,3" => 6
                  "1,2:3" => 6
                
                ** 커스텀 구분자 사용 **
                - 기본 구분자 외에도 커스텀 구분자를 지정할 수 있습니다.
                - 커스텀 구분자는 문자열의 첫 부분에 "//"와 "\\n" 사이에 위치하는 문자를 구분자로 사용합니다.
                
                ** 예시: **
                  "//;\\n1;2;3" => 6 (여기서는 세미콜론(;)이 구분자로 사용됩니다.)
                
                ** 주의: **
                - 입력된 문자열은 반드시 0 이상의 정수만 포함해야 합니다.
                - 잘못된 값이 입력될 경우 프로그램이 종료됩니다.
                ==============================
                """);
    }
}
