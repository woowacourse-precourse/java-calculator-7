    package calculator;

    import camp.nextstep.edu.missionutils.Console; // 콘솔 입력을 위한 라이브러리

    public class Application {

        // 주어진 입력 문자열을 구분자를 기준으로 나누는 메서드
        public static String[] splitString(String input) {
            String separator = ",|:";
            // 주어진 입력 문자열을 구분자로 나누어 문자열 배열로 반환
            return input.split(separator);
        }

        // 입력된 숫자 문자열을 계산하여 합계를 반환하는 메서드
        public static int calculate(String input) {
            // 입력이 null이거나 비어있으면 0 반환
            if (input == null || input.isEmpty()) {
                return 0; // 빈 문자열 입력 처리
            }
            int sum = 0; // 합계 초기화
            String[] numbers = splitString(input); // 문자열을 숫자 배열로 분리

            // 각 숫자에 대해 처리
            for (String number : numbers) {
                // 문자열을 정수로 변환하고 합산
                sum += Integer.parseInt(number);
            }
            return sum; // 최종 합계 반환
        }

        public static void main(String[] args) {
            String input = Console.readLine(); // 콘솔에서 입력 받기
            int sum = calculate(input); // 입력을 계산하여 합계 얻기
            System.out.println("결과 : " + sum); // 계산 결과 출력
        }
    }
