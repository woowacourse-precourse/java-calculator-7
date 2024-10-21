package calculator;

public class NumberExtractor {
    // 입력받은 문자열을 커스텀구분자, 콜론, 쉼표로 구분하여 숫자 알아내고 배열에 저장하는 클래스

    //커스텀구분자가 있을경우:커스텀구분자, 기본구분자로 구분
    //"가 없을경우:기본구분자로만 구분
    //음의 숫자가 입력될 경우 IllegalArgumentException을 발생시킨 후 애플리케이션 종료

    float num = 0;
    float sum = 0;
    float[] numbers=null;

    public NumberExtractor(String enter, String customDelimiter) {
        this.numbers=extractNumbers(enter, customDelimiter);
    }

    private float[] extractNumbers(String str, String customDelimiter){
        //구분자를 기준으로 split하여 배열에 저장

    }

    public float[] getNumbers() {
        return numbers;
    }

        
}
