package calculator;

public class Calculator {
    String inputString;


    public Calculator(String inputString){
        this.inputString = inputString;
    }

    /**
     * 입력 받은 문자열의 합을 구하는 메서드
     * @param inputString
     * @return 총합
     */

    public int calculate(String inputString){

        if(isEmptyString(inputString)){
            return 0;
        }

        String[] numbers = extractNumbers(inputString);

        return sumNumbers(numbers);
    }

    /**
     * 빈 문자열을 처리하는 메서드
     * @param inputString
     * @return 빈 문자열일 경우 true
     */
    private boolean isEmptyString(String inputString) {
        return inputString == null || inputString.isEmpty();
    }

    /**
     * 숫자를 추출하는 메서드
     * @param inputString
     * @return 추출된 숫자 배열
     */
    private String[] extractNumbers(String inputString){

        String delimiters = ",|:";

        if(inputString.contains("//")){
            int start = inputString.indexOf("//");
            int end = inputString.indexOf("\\n");

            String newDelimiter = extractDelimiter(inputString,start+2,end);

            delimiters += "|" + newDelimiter;

            inputString = inputString.substring(end+2);
        }

        return inputString.split(delimiters);
    }

    /**
     * 사용자 지정 구분자 추출 함수
     * @param inputString
     * @param start
     * @param end
     * @return 추출된 구분자
     */
    private String extractDelimiter(String inputString, int start, int end){

        return inputString.substring(start,end);
    }

    /**
     * 배열의 숫자들을 더하는 메서드
     * @param numbers
     * @return 총합
     */

    private int sumNumbers(String[] numbers){

        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number.trim());
        }

        return sum;

    }


}
