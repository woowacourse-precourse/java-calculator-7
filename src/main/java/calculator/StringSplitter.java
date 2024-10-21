package calculator;

public class StringSplitter {

    String primaryDelimiter = ":";
    String secondaryDelimiter = ",";


    public String[] splitWithCustomDelimiter(String customDelimiter, String inputString) {
        this.primaryDelimiter = primaryDelimiter;
        this.secondaryDelimiter = secondaryDelimiter;

        String[] parts = inputString.split("\\\\n", 2); // 첫 번째 부분: 구분자, 두 번째 부분: 숫자
        String numbers = parts.length > 1 ? parts[1] : parts[0]; // 숫자 부분만 가져오기

        String regex = customDelimiter + "|" + primaryDelimiter + "|" + secondaryDelimiter;

        String[] numberList = numbers.split(regex);
        for (String number : numberList) {
            // 음수인 경우
            if (number.startsWith("-")) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다:");
            }
            // 문자인 경우
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("커스텀 구분자를 제외한 문자는 입력할 수 없습니다:");
            }
        }


        return numberList;
    }

    public String[] splitWithDefaultDelimiter(String inputString) {

        this.primaryDelimiter = primaryDelimiter;
        this.secondaryDelimiter = secondaryDelimiter;

        String regex =  primaryDelimiter + "|" + secondaryDelimiter;

        String[] numberList = inputString.split(regex);

        for (String number : numberList) {
            // 음수인 경우
            if (number.startsWith("-")) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다:");
            }
            // 문자인 경우
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException("커스텀 구분자를 제외한 문자는 입력할 수 없습니다:");
            }
        }


        return numberList;
    }

}
