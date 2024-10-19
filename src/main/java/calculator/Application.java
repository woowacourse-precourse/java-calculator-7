package calculator;


import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String userInput = Console.readLine();
        int start = 0;
        int end = 0;
        if (userInput.startsWith("//")) {
            start = userInput.indexOf("//");
            end = userInput.indexOf("\\n");
            String custom = null;
            if (end != -1) {
                System.out.println(end);
                // "//" 의 문자열 길이 만큼 subString 첫번째 인자값 설정 , "\n"의 시작지점 까지 두번째 인자값
                // "//" custom "\n"  커스텀 구분자의 인덱스 값을 찾아내 문자열로 변환한다.
                custom = userInput.substring(start + 2, end);
                //커스텀구분자 지정 값들을 배열에서 없앤다. end의 원 스트링의 길이는 3이기에 2를 더해준다.
                String customInput = userInput.substring(end + 2);
                //커스텀 문자열 삭제
                String[] input = customInput.split(custom);
                int num = 0;
                for (String s : input) {
                    if (!s.isEmpty()) {
                        num += Integer.parseInt(s);
                    }
                }
                System.out.println(num);
            }


//        String [] input = userInput.split("[,/]");
//
//        int num = 0;
//        for(int i =0; i<input.length; i++){
//            System.out.println(input[i]);
//
//            //input[i] 공백 처리;
//            if(!input[i].isEmpty()){
//                num += Integer.parseInt(input[i]);
//
//            }
//        }
//        System.out.println(num);
        }
    }
}
