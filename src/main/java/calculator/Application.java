package calculator;
import camp.nextstep.edu.missionutils.Console;


//1. 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우
// 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
//        예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" =>

//앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다.
//커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
//예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우
//커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
public class Application {
    public static void main(String[] args) {
        System.out.print("입력하세요: ");
        String input = Console.readLine(); // 사용자 입력을 Console API로 받기

        if(input.substring(0, 2).equals("//")){
            if((input.substring(4,5).equals("n")) && (input.substring(3,4).equals("\\"))) {
                 String delimiter = input.substring(2,3);
                 String cusInput = input.substring(5);
                 System.out.println(delimiter);
                 System.out.println(cusInput);
                 CustomDelimiterCalculator CustomDelimiterCalculator = new CustomDelimiterCalculator(delimiter,cusInput);
                System.out.println("결과: " + CustomDelimiterCalculator.sum);
            }
        }else{
            DelimiterCalculator DelimiterCalculator = new DelimiterCalculator(input);
            System.out.println("결과: " + DelimiterCalculator.sum);
        }
    }
}
