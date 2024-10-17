package calculator;

public class Application {
    public static void main(String[] args) {
        String userInput = camp.nextstep.edu.missionutils.Console.readLine();
        // 사용자가 잘못된 값을 입력할 경우IllegalArgumentException을 발생시킨 후
        // 애플리케이션 종료

        System.out.println(sumString(userInput));
    }

    public static int sumString(String input) {
        String regex = ",+|:+";
        if ((input.trim().startsWith("//")) && (input.trim().indexOf("\n") != 2)){
            regex = input.trim().substring(2,input.indexOf("\n"));
        }

// 커스텀 구분자 1. 하나인 경우
//             2. 두개 이상인 경우 나눠야겠지?

// valid index로 검증을 해야되나?
// input.indexOf() 가1. 없으면 오류처리
        // 2. 끝에 있거나 하면0 처리 해야겠지?

// "//" 뒤에\n이 나오지 않을 경우-> 이거
        // \n 앞에//이 나오지 않을 경우-> 이거 두개는 고려 해야되나...?
// 구분자와 양수가 아닌 다른 문자(문자)가 나올경우-> 이건 구현 해야돼

        String[] inputToArr = input.trim().split(regex);
        int sum = 0;
        for (String i : inputToArr){
            sum += Integer.parseInt(i) ;
        }
        return sum;
    }
}

