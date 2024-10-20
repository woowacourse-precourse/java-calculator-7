package calculator.model;

//실제 계산 로직 처리
public class Calculator {

    //검증된 배열 받아서 더하는 기능
    public int add(String[] numbers){
        int total = 0;
        for(String number : numbers){
            if (!number.isEmpty()) { // 빈 문자열을 무시
                total += Integer.parseInt(number);
            }
        }
        return total;
    }
}

