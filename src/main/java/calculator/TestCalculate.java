package calculator;

public class TestCalculate {
    public static void testcase() {
        // 여러 테스트 케이스 실행
        testcalculate("", 0); // 빈 문자열
        testcalculate("//1\\n1,2:3", 5); // 숫자('1')가 구분자일 때
        testcalculate("//#\\n1#2#3", 6); // '#'가 구분자일 때
        testcalculate("//?\\n1?2:3", 6); // 커스텀 구분자 + 기본 구분자
        testcalculate(":2", 2); // 미입력 + 기본 구분자
        testcalculate("//?\\n?3", 3); // 미입력 + 커스텀 구분자
        testcalculate("//?\\n1?2:", 3); // 미입력 + 기본 구분자 + 커스텀 구분자
        testcalculate("2", 2); // 숫자만 입력했을 경우
        testcalculate("//&\\n//^\\n1,2:3&2^8", 16); // 커스텀 구분자 여러 번 지정의 경우
        testcalculate("//&^\\n1,2:3&^8", 14); // 커스텀 구분자 여러 개 지정의 경우
        testcalculate(" 1:3", -1); // 공백 문자열 오류 처리
        testcalculate("12:-1", -1); // 음수 오류 처리
        testcalculate("//?1:2", -1); // 커스텀 구분자 지정 미종료 오류 처리
        testcalculate("2:a,3", -1); // 구분자 외 문자열 오류 처리
        testcalculate("0,-1", -1); // 0과 음수 조합 오류 처리
        testcalculate("1,2,-3", -1); // 여러 숫자 중 음수 포함
    }

    public static void testcalculate(String tcase, int expected) {
        try {
            String[] token = InputHandler.parse(tcase);
            int result = testsumNumbers(token);
            if (result == expected) {
                System.out.println("성공 : 기대값과 일치합니다.");
            } else {
                System.out.println("실패 : 기대값과 일치하지 않음. 기대값: " + expected + ", 실제값: " + result);
            }
        } catch (IllegalArgumentException e) {
            if (expected == -1) {
                System.out.println("성공 : 오류 체크 성공");
            } else {
                System.out.println("실패 : 오류 체크 실패. 메시지: " + e.getMessage());
            }
        }
    }

    private static int testsumNumbers(String[] parsedInput) {
        int sum = 0;
        for (String strNum : parsedInput) {
            if (strNum.isEmpty()) {
                strNum = "0";
            }
            int intNum = Integer.parseInt(strNum);
            sum += intNum;
        }
        return sum;
    }

    public static void main(String[] args) {
        testcase(); // 테스트 실행
    }

}
