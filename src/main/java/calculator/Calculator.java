package calculator;

public class Calculator {
    /*
     * 입력이 올바른 형태임을 가정 (ex. 11:22,33)
     * 숫자를 덧셈한다.
     * 커스텀 구분자는 선택적으로 입력 가능하다.
     */
    public int calculate(String input, String... customSep){
        String delimeters = ",|:";
        if (customSep.length > 0) {
            delimeters += "|" + customSep[0];
        }
        String[] arr = input.split(delimeters);
        int sum = 0;
        for (String s : arr) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
