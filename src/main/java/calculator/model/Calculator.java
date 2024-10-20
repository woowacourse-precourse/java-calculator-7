package calculator.model;

//실제 계산 로직 처리
public class Calculator {

    // 검증된 숫자 배열을 받아 합산하는 메서드
    public int add(String[] numbers){
        int total = 0;
        for(String number : numbers){
            if (!number.isEmpty()) { // 빈 문자열을 무시
                total += Integer.parseInt(number); // 숫자로 변환 후 합산
            }
        }
        return total;
    }
}

