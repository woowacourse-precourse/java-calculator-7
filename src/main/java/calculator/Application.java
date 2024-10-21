    package calculator;

    import java.util.Scanner;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Application {
        // TODO: 프로그램 구현
        // 입력받은 문자열로 덧셈을 수행하는 메소드
        public static int calculate(String input) {
            if (input == null || input.isEmpty()) {
                return 0;
            }

            String delimiter = ",|;"; // 구분자
            String numbers = input.trim(); // 아직은 input이 문자열 타입이다.

            // 커스텀 구분자
            Matcher customDelimiter = Pattern.compile("//(.)\n(.*)").matcher(input);
            if (customDelimiter.matches()) {
                delimiter = Pattern.quote(customDelimiter.group(1)); //커스텀 구분자를 추출한다.
                numbers = customDelimiter.group(2).trim(); // 커스텀 구분자 이후의 숫자들을 추출한다.
            }

            String[] tokens = numbers.split(delimiter); // 구분자를 기준으로 numbers를 나누고tokens에 저장
            int sum = 0;

            for (String token : tokens) {
                int number;
                try {
                    number = Integer.parseInt(token.trim()); // 양수로 변환해주기
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다. For input string: \"" + token + "\"");
                }
                if (number < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
                }

                sum += number;
            }
            return sum;
        }

        public static void main(String[] args) {
            // TODO: 프로그램 구현
            Scanner sc = new Scanner(System.in);
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = sc.nextLine();

            try {
                int result = calculate(input);
                System.out.println("결과 : " + result);
            }
            catch (IllegalArgumentException e){
                System.out.println("잘못된 입력입니다." + e.getMessage());
            }
        }

    }
