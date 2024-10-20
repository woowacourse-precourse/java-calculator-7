package calculator;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        int result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = scanner.nextLine();

        try {
            result = calculateResult(input);
            System.out.printf("결과 : %d",result);
        } catch (IllegalArgumentException e) {
        }
    }

    // 문자를 숫자로 바꿀 수 있는지 확인
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str); // 문자열을 숫자로 변환 시도
            return true; // 변환 성공
        } catch (NumberFormatException e) {
            return false; // 변환 실패
        }
    }

    // 숫자 변환 및 합산을 처리하는 메서드
    // 마지막 숫자를 제외한 나머지를 더하는 과정
    private static int parseAndSum(String str, ArrayList<Integer> arr, int startIndex) {
        int result;
        try {
            result = Integer.parseInt(str.substring(startIndex, arr.get(0)));
            if (result < 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < arr.size() - 1; i++) {
            try {
                String substring = str.substring(arr.get(i) + 1, arr.get(i + 1));
                int num = Integer.parseInt(substring);
                if (num < 0) {
                    throw new IllegalArgumentException();
                }
                result += num;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        return result;
    }

    //구분자가 처음 혹은 끝에 있을 때 구분해야함
    //구분자의 위치가 0일때(지정구분자인 경우 5일때), 첫번째의 result에 더해주는 과정은 생략
    //구분자의 위치가 str.length-1 일때, 마지막의 result에 더해주는 과정은 생략
    //",," 일때 0 반환

    // 합치는 코드 만들기
    public static int calculateResult(String str) {
        int result;
        char customDelimiter, delimiter1, delimiter2;
        ArrayList<Integer> delimiterPositions;
        DelimiterFinder delimiterFinder;

        if (isNumeric(str)) {
            // A1 숫자만 있는 경우
            return Integer.parseInt(str);
        } else if (str.isEmpty()) {
            // A2 아무것도 없는 경우
            return 0;
        } else if (str.length() > 4 && str.substring(0, 2).equals("//") && str.substring(3, 5).equals("\\n")) { // //@\n 꼴의 양식인가?
            // A3 구분 지정자(//@\n) 경우
            customDelimiter = str.charAt(2);
            delimiterFinder = new DelimiterFinder(str, customDelimiter);
            delimiterPositions = delimiterFinder.findDelimiterPositions();

            // 구분지정자를 설정했지만 뒤에 구분지정자를 생성하지 않은 경우 (#1. 숫자도 없는 경우 #2. 숫자만 있음 #3. 다른 구분자가 있음)
            if (delimiterPositions.isEmpty()) {
                if (str.length() == 5) { // #1
                    return 0;
                } else if (isNumeric(str.substring(5))) { // #2
                    return Integer.parseInt(str.substring(5));
                } else { // #3
                    throw new IllegalArgumentException();
                }
            } else {
                //구분 지정자를 설정하고, 뒤에도 구분 지정자가 나오는 경우 -> 정상 작동

                //마지막 숫자를 제외한 나머지를 더하는 과정
                result = parseAndSum(str, delimiterPositions, 5);
                if (result < 0) {
                    throw new IllegalArgumentException();
                }

                // 마지막 숫자 처리
                if (delimiterPositions.get(delimiterPositions.size() - 1) == str.length() - 1) { // 만약 문자로 끝나는 경우
                    return result;
                } else { //문자로 안끝나는 경우
                    result += Integer.parseInt(str.substring(delimiterPositions.get(delimiterPositions.size() - 1) + 1));
                    return result;
                }
            }
        } else {
            //구분지정자가 잘못 되었을 경우 이쪽으로 들어옴
            //기본지정자라면 이쪽으로 들어옴
            delimiter1 = ',';
            delimiter2 = ':';
            delimiterFinder = new DelimiterFinder(str, delimiter1, delimiter2);
            delimiterPositions = delimiterFinder.findDelimiterPositions();

            //마지막 숫자를 제외한 나머지를 더하는 과정
            result = parseAndSum(str, delimiterPositions, 0);

            //마지막 숫자 처리
            try {
                int lastNumber = Integer.parseInt(str.substring(delimiterPositions.get(delimiterPositions.size() - 1) + 1));
                if (lastNumber<0){
                    throw new IllegalArgumentException();
                } else {
                    result += lastNumber;
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                throw new IllegalArgumentException();
            }

            return result;
        }
    }
}

class DelimiterFinder { // 구분자 위치 반환
    String str;
    char delimiter1, delimiter2;

    DelimiterFinder(String str, char delimiter1) {
        this.str = str;
        this.delimiter1 = delimiter1;
        this.delimiter2 = delimiter1;
    }

    DelimiterFinder(String str, char delimiter1, char delimiter2) {
        this.str = str;
        this.delimiter1 = delimiter1;
        this.delimiter2 = delimiter2;
    }

    public ArrayList<Integer> findDelimiterPositions() { // 구분자 위치를 반환한다
        ArrayList<Integer> arr = new ArrayList<>();
        if (delimiter1 == delimiter2) { // 구분자 같은 경우
            for (int i = 5; i < str.length(); i++) {
                if (str.charAt(i) == delimiter1) {
                    arr.add(i);
                }
            }
        } else { // 구분자가 다른 경우
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == delimiter1 || str.charAt(i) == delimiter2) {
                    arr.add(i);
                }
            }
        }
        return arr;
    }
}