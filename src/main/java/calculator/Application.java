package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine(); //Console API(문자열 입력받음)

        int result = PlusCalculator.add(input); //입력값을 계산기 클래스에 대입
        System.out.println("결과 : " + result); //반환된 덧셈값을 출력(최종)
    }
}
class PlusCalculator {

    public static int add(String input) {
        if (input.isEmpty()) {
            return 0; //String 변수 입력값이 비었으면 0반환
        }

        String delimiter = "[,:]"; // 구분자 = 쉼표,콜론
        String[] arrays = input.split(delimiter); // 구분자 기준 문자열 분리, 배열에 각각 저장

        // 숫자 합계 계산
        int sum = 0;
        for (String array : arrays) { //콜론으로 배열값 다 꺼내기
            int num = Integer.parseInt(array.trim());//문자열 좌우 공백 제거 후 숫자로 변환
            sum += num;
        }

        return sum;
    }
}