package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;

public class Application {
    static String S; // 입력 받은 문자열
    static ArrayList<String> arrayList; // 계산할 숫자들을 저장하는 ArrayList
    static HashSet<String> delimiters; // 구분자들을 저장하는 집합
    static int ans = 0; // 최종 합을 저장

    static void sum() { // arrayList 에 저장된 수들을 모두 더하는 함수
        for(String num : arrayList) {
            ans += Integer.parseInt(num);
        }
    }

    // 커스텀 구분자를 찾고, 문자열에서 "//" "\n" 부분을 제거하는 함수
    static void findNewDelimiter() {
        while(true) {
            int startIndex = S.indexOf("//"); // "//" 시작 위치를 찾는다

            if(startIndex == -1) { // 없으면 break
               break;
            }

            int endIndex = S.indexOf("\\n", startIndex); // "\n" 위치를 찾는다

            if(endIndex == -1) { // "//" 은 있지만 "\n" 은 없는 경우 1. IllegalArgumentException 2. 구분자에 "//" 로 시작하는 문자열이 있는 경우
                break;
            }

            String newDelimiter = S.substring(startIndex + 2, endIndex); // 커스텀 구분자를 집합에 추가
            delimiters.add(newDelimiter);

            S = S.substring(0, startIndex) + S.substring(endIndex + 2); // "//" 부터 "\n" 까지의 문자열을 제외
        }
    }

    // 현재 위치의 문자를 가져와서 0 부터 9 사이의 수 인지를 확인
    static boolean isNumber(char ch) {
        return ch >= '0' && ch <= '9';
    }

    static void calculate() {
        findNewDelimiter();

        StringBuilder numberBuffer = new StringBuilder(); // 숫자 또는 구분자가 두 자리 이상일 경우를 대비하여 임시로 저장할 버퍼 선언

        // 각 자리의 문자를 처리
        for(int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i); // 현재 위치의 문자

            if(isNumber(currentChar)) { // 0 부터 9 사이의 수인 경우
                numberBuffer.append(currentChar); // 버퍼에 저장

                // 현재 위치 이후의 문자 탐색
                for(int j = i+1; j < S.length(); j++) {
                    if(!isNumber(S.charAt(j))) { // 0 부터 9 사이의 수가 아닌 경우 break
                        i = j-1;
                        break;
                    }

                    numberBuffer.append(S.charAt(j)); // 0 부터 9 사이의 수인 경우 버퍼에 저장
                }
                arrayList.add(numberBuffer.toString()); // 버퍼에 저장한 값을 배열리스트에 저장
                numberBuffer.setLength(0); // 버퍼 초기화

            }
            else { // 문자인 경우
                numberBuffer.append(currentChar); // 버퍼에 저장

                // 현재 위치 이후의 문자 탐색
                for(int j = i+1; j < S.length(); j++) {
                    if(isNumber(S.charAt(j))) { // 0 부터 9 사이의 수인 경우 break
                        i = j-1;
                        break;
                    }

                    if(j == S.length()-1) { // 문자열의 마지막이 문자인 경우 IllegalArgumentException 에러 처리
                        throw new IllegalArgumentException();
                    }

                    numberBuffer.append(S.charAt(j)); // 0 부터 9 사이의 수가 아닌 경우 버퍼에 저장
                }

                if(!delimiters.contains(numberBuffer.toString())) { // 버퍼에 저장된 문자열이 구분자 집합에 존재하지 않으면  IllegalArgumentException 에러 처리
                    throw new IllegalArgumentException();
                }

                numberBuffer.setLength(0); // 버퍼 초기화
            }
        }

        sum();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        arrayList = new ArrayList<>();
        delimiters = new HashSet<>();

        // 기본적으로 주어진 구분자를 집합에 추가
        delimiters.add(",");
        delimiters.add(":");

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        S = Console.readLine(); // readLine() 를 통해 입력받은 문자열을 대입

        try {
            calculate();
            System.out.println("결과 : " + ans);
        }
        catch(IllegalArgumentException e) { // 에러 발생 시
            System.err.println(e);
        }
    }
}
