package calculator;

public class Calculator {
    String inputString;


    public Calculator(String inputString){
        this.inputString = inputString;
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

        if(inputString.indexOf("//") != 0){
            int start = inputString.indexOf("//");
            int end = inputString.indexOf("\n");

            String newDelimiter = extractDelimiter(inputString,start,end);

            delimiters += "|" + newDelimiter;

            inputString = inputString.substring(end+1);
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


}
