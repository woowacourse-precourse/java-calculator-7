//package calculator;
//
//import camp.nextstep.edu.missionutils.Console;
//
//public class Application {
//    public static void main(String[] args) {
//        // TODO: 프로그램 구현
//        System.out.println("덧셈할 문자열을 입력해 주세요.");
//        String input = Console.readLine();
//        int answer = 0;
//
//        if (input != null && !input.isEmpty()) {
//            char firstChar = input.charAt(0);
//            if (Character.isDigit(firstChar)) {
//                StartNumber startNumber = new StartNumber();
//                answer = startNumber.readNumInput(input);
//                System.out.println("결과 : " + answer);
//            } else if (firstChar == '/') {
//                StartSlash startSlash = new StartSlash();
//                answer = startSlash.readSlashInput(input);
//                System.out.println("결과 : " + answer);
//            } else {
//                throw new IllegalArgumentException();
//            }
//        } else {
//            throw new IllegalArgumentException();
//        }
//    }
//}
