package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    static String separator = ",|:";

    /**
     * 커스텀 구분자 존재 체크
     * @param str 입력받은 문자열
     */
    public void checkCustomSeparator(String str){
        if (str.contains("//") && str.contains("\n")){
            // 문자열 앞부분이 "//" 아닌 경우
            if(str.indexOf("//") != 0){
                throw new IllegalArgumentException();
            }
            // 커스텀 구분자 추출
            String pos = str.substring(1,str.indexOf("\n"));
            // 추출한 커스텀 구분자를 구분자에 추가
            separator = separator + "|" + pos;
        }

    }

    // 시작 함수
    public void start(){
        // 문자열 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String str = Console.readLine();

        checkCustomSeparator(str);

        String[] separateArray = str.split(separator);
    }
}
