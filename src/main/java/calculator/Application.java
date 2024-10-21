package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class Application{
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 입력 안내문
        String str = Console.readLine();
        String delimiter = "[,:]"; // 기본 구분자 (쉼표 또는 콜론)

        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("입력 문자열이 비어 있습니다.");
        }

        if (str.startsWith("//")) {
            int delimiterIndex1 = str.indexOf('\\');
            int delimiterIndex2 = str.indexOf('n');
            if (delimiterIndex1 == -1 || delimiterIndex2 == -1) {
                throw new IllegalArgumentException("구분자가 잘못 입력되었습니다.");
            }
            try {
                if (str.charAt(3) == '\\' && str.charAt(4) == 'n') {
                    try {
                        String delimiterCustom;
                        delimiterCustom = str.substring(2, delimiterIndex1);
                        if (delimiterCustom.length() > 1) {
                            throw new IllegalArgumentException("구분자는 한 글자여야 합니다.");
                        }
                        for (int i = 0; i < delimiterCustom.length(); i++) {
                            if (Character.isDigit(delimiterCustom.charAt(i))) {
                                throw new IllegalArgumentException("구분자로 숫자가 입력되었습니다.");
                            }
                        }
                        delimiter = Pattern.quote(delimiterCustom);
                    } catch (IllegalArgumentException e) {
                        throw new RuntimeException(e);
                    }
                }
                str = str.substring(delimiterIndex2 + 1);
            } catch (Exception e) {
                throw new IllegalArgumentException("잘못된 구분자가 입력되었습니다");
            }
        }


        String[] strArr = str.split(delimiter);


        int[] intArr = new int[strArr.length];
        int sum = 0; // 숫자의 합계를 저장할 변수
            try {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        intArr[i] = Integer.parseInt(strArr[i]);
                    }catch(NumberFormatException e) {
                        throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
                    }
                    if (intArr[i] <= 0) {
                        throw new IllegalArgumentException("잘못된 숫자값이 입력되었습니다");
                    }
                    sum += intArr[i];
                }
                System.out.println("결과 :" + sum);

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자값이 입력되었습니다");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
