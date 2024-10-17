package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Application {

    /*
    전체 흐름 제어
     */
    public static void main(String[] args) {
        // 사용자로부터 문자열을 입력 받음
        String input = getUserInput();
        // 입력 형식이 올바른지 검증
        validateInput(input);
        // 기본 구분자 또는 커스텀 구분자 추출
        String delimiter = getDelimiter(input);
        System.out.println("delimiter="+delimiter);
        // 문자열에서 커스텀 구분자 정의 섹션 제거
        input = removeDelimiterSection(input);
        // 구분자로 문자열을 분리
        String[] numbers = splitByDelimiter(input, delimiter);
        // 배열 요소를 정수로 변환하여 합을 계산
        int sum = sumNumbers(numbers);
        System.out.println("결과 : " + sum);
    }

    /*
    * 사용자로부터 입력을 받는 메서드
    */
    public static String getUserInput(){
        System.out.println("덧셈할 문자열을 입력해주세요.");
        return Console.readLine();
    }

    /*
    * 문자열을 검증하는 메서드
    * 형식이 잘못된 경우 'IllegalArgumentException을 발생시킨다.
    */
    public static void validateInput(String input){
        // 기본 구분자와 숫자만 있을 경우 return
        if(input.matches("[0-9,:]+")){
            return;
        }
        // 커스텀 구분자를 가질 경우
        if(input.startsWith("//") && input.contains("\n")){
            String Delimiter = input.substring(2, input.indexOf("\n"));
            String regex = "[0-9" + Delimiter + "]+";
            String subInput = input.substring(input.indexOf("\n") + 1);
            // 구분자가 숫자를 포함하지 않고, 구분자 정의 섹션 외의 문자열에 구분자와 숫자만 갖는지 확인
            if (!Delimiter.matches(".*[0-9].*") && subInput.matches(regex)){
                return;
            }
        }
        throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
    }

    /*
    * 입력된 문자열에서 구분자를 추출하는 메서드
    * 기본 구분자 (,), (:) 또는 커스텀 구분자를 반환한다.
     */
    public static String getDelimiter(String input) {
        if (input.startsWith("//")){
            return input.substring(2, input.indexOf("\n"));
        }
        return "[,|:]";
    }

    /*
    * 커스텀 구분자가 있는 경우 해당 구분자 정의 섹션을 제거하는 메서드
    * 커스텀 구분자가 없으면 원본 문자열을 반환한다.
     */
    public static String removeDelimiterSection(String input){
        throw new UnsupportedOperationException("removeDelimiterSection() 아직 구현되지 않았습니다.");
    }


    /*
    * 문자열을 주어진 구분자를 기준으로 분리하여 배열로 변환하는 메서드
     */
    public static String[] splitByDelimiter(String input, String Delimiter){
        throw new UnsupportedOperationException("splitByDelimiter() 아직 구현되지 않았습니다.");
    }


    /*
    * 배열의 문자열 요소들을 정수형으로 변환하여 합을 구하는 메서드
     */
    public static int sumNumbers(String[] numbers){
        throw new UnsupportedOperationException("sumNumbers() 아직 구현되지 않았습니다.");
    }
}


