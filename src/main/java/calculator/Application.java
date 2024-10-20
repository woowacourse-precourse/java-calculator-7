package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 문자열 입력받기
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr;
        String convertedStr;
        inputStr = camp.nextstep.edu.missionutils.Console.readLine();

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
        System.out.println(separatedNumbers);

        // 합계 도출하기
        int sum=0;
        for (String num : separatedNumbers){
            int partNum = 0;
            partNum = Integer.parseInt(num);
            sum+=partNum;
        }
        System.out.println("결과 : "+sum);
    }
}
