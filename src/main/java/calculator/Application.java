package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputStr;
        String convertedStr;

        // 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        inputStr = camp.nextstep.edu.missionutils.Console.readLine();
        // 문자열이 ""인 경우 0 출력
        if (inputStr==""){
            System.out.println("결과 : 0");
            System.exit(0);
        }

        // 구분자 1차 병합 (":" -> ",")
        convertedStr = inputStr.replace(":",",");
        StringBuilder entireStr = new StringBuilder(convertedStr);

        //커스텀 구분자 여부 확인 및 적용
        int strLength = convertedStr.length();
        if (strLength>=5){
            if(convertedStr.startsWith("//") && (convertedStr.substring(3, 5).equals("\\n"))){
                entireStr = new StringBuilder(convertedStr.replace(convertedStr.charAt(2), ','));
                entireStr = new StringBuilder(entireStr.substring(5));
            }
        }

        //","를 기준으로 숫자 분할하기
        String[] separatedNumbers;
        String finalStr = new String(entireStr);
        separatedNumbers = finalStr.split(",");

        // 합계 도출하기
        int sum=0;
        IllegalArgumentException printError = new IllegalArgumentException();
        for (String num : separatedNumbers){
            //구분자 사이 숫자가 없는 경우 고려
            if(num.isEmpty()){
                continue;
            }

            int partNum = 0;
            try{
                partNum = Integer.parseInt(num);
                if (partNum<=0){
                    throw printError;
                }
            } catch(Exception ex){
                throw printError;
            }
            sum+=partNum;
        }
        System.out.println("결과 : "+sum);

    }
}
