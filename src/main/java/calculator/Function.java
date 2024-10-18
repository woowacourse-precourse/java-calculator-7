package calculator;

import java.util.StringTokenizer;

public class Function {

    // 싱글턴 객체 생성
    private static Function instance = new Function();
    private Function() {}
    public static Function getInstance() {
        return instance;
    }

    //기능 1 : 문자열을 쉼표(,) 또는 콜론(:)이라는 구분자를 기준으로 분리하여 합을 반환하기
    public int isSplit(String str) {

        int sum = 0;
        StringTokenizer st = new StringTokenizer(str, ",:");

        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            validateNumber(token);
            sum += Integer.parseInt(token);
        }

        return sum;
    }

    //기능 2 : 커스텀 구분자를 지정하여 숫자를 추출하는 기능
    public int customSeparator(String str) {

        int sum = 0;

        str = str.replace("\\n", "\n"); // \n 입력을 공백으로 바꾸기

        char separator = str.charAt(2); // 구분자는 "//" 뒤에오는 문자

        int secondSeparatorIndex = str.indexOf("\n") + 1;

        String subString = str.substring(secondSeparatorIndex); // 숫자가 시작되는 곳 추출

        String[] numbers = subString.split(String.valueOf(separator)); //숫자들을 구분자로 분리하기

        for (String number : numbers) {
            validateNumber(number);
            sum += Integer.parseInt(number);
        }

        return sum;
    }

    //기능 3 : 숫자 검증 로직 (양수인지)
    private void validateNumber(String number) {
        int num = Integer.parseInt(number);

        if (num < 0) {
            //throw new InputException();
            throw new InputException();
        }
    }
}
