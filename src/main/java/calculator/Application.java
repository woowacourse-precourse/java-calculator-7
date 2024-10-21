package calculator;
import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;
public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요: ");
        String input = Console.readLine(); //Console API(문자열 입력받음)

        PlusCalculator calculator = new PlusCalculator();
        int result = calculator.add(input); //입력값을 계산기 클래스에 대입
        System.out.println("결과 : " + result); //반환된 덧셈값을 출력(최종)
    }
}
class PlusCalculator{
    public int add(String input){
        if(input.isEmpty()){
            return 0;
        } //빈 문자열을 입력할 경우 0 반환
        
        else if(input.matches("-?\\d+")){
            int num = Integer.parseInt(input);
            check(num);
            return num;
        } //하나의 숫자만 입력할 경우 그 숫자를 반환
        
        else if(input.startsWith("//")){
            int index = input.indexOf("\\n");
            String n = input.substring(2, index);
            input = input.substring(index+2);
            String[] numbers = input.split(Pattern.quote(n) + "|," + "|:");

            int sum = 0;
            for(String number : numbers){
                int num = Integer.parseInt(number);
                check(num);
                sum+= num;
            }
            return sum;
        } // 커스텀 구분자 지정
        
        else {
            String delimiter = "[,:]"; // 구분자 = 쉼표,콜론
            String[] arrays = input.split(delimiter); // 구분자 기준 문자열 분리, 배열에 각각 저장

            // 숫자 합계 계산
            int sum = 0;
            for (String array : arrays) { //콜론으로 배열값 다 꺼내기
                int num = Integer.parseInt(array.trim());//문자열 좌우 공백 제거 후 숫자로 변환
                check(num);
                sum += num;
            }
            return sum;
        }
    }

    private void check(int num){
        if(num<0){ //숫자가 음수가 되면 에러
            throw new IllegalArgumentException("입력이 잘못되었습니다.");
        }
    }
}