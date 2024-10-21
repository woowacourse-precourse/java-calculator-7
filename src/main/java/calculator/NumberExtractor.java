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
        //구분자를 기준으로 split하여 배열에 저장하는 메소드
        String delimiter;

        // split할 구분자를 설정하는 코드
        if (customDelimiter == null) { // 커스텀 구분자가 null인 경우 구분자로 쉼표, 콜론을 사용

            delimiter = ",|:";
        } else { // 커스텀 구분자가 null이 아닐경우 커스텀 구분자, 쉼표, 콜론을 모두 구분자로 사용
            delimiter = customDelimiter + "|,|:"; 
        }

        // 문자열을 구분자로 분리하여 임시배열에 저장
        String[] stringNumbers = str.split(delimiter);

        // 배열의 크기를 기반으로 numbers 배열 생성
        float[] numbers = new float[stringNumbers.length];

        // 양의 숫자로 변환하여 numbers 배열에 저장하는코드(음수는 에러처리)
        for (int i = 0; i < stringNumbers.length; i++) {
//            numbers[i] = Float.parseFloat(stringNumbers[i].trim()); // 공백 제거

            // 숫자로 변환
            float number = Float.parseFloat(stringNumbers[i]);

            // 사용자가 잘못된 값을 입력한 경우 : 음수값 입력
            if (number < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다" );
            }

            // numbers 배열에 저장
            numbers[i] = number;
        }

        return numbers;
    }

    public float[] getNumbers() {
        return numbers;
    }

}
