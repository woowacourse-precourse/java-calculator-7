package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        List<Integer> changedNumber = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input the number.");
        String input = sc.nextLine();
        String cuttingMark = ",|:";

        int sum = 0;
        int previousSum =0;

        // 입력이 비어 있는 경우 처리
        if (input == null || input.trim().isEmpty()) {
            sum = 0;

        } else if (input.startsWith("//") && input.contains("\\n")) {
            // 커스텀 구분자 추출 (커스텀 구분자는 무조건 1개의 특수문자일때를 가정)
            String customCuttingMark = input.substring(2, 3);
            System.out.println("customCuttingMark = " + customCuttingMark);
            String safeCustomCuttingMark = Pattern.quote(customCuttingMark);
            String combinedCuttingMark = cuttingMark + "|" + safeCustomCuttingMark;

            // 숫자 부분 추출
            input = input.substring(5);
            String[] numbers = input.split(combinedCuttingMark);

            // 숫자 변환 및 추가
            for (String pureNumber : numbers) {
                if (!pureNumber.trim().isEmpty()) {
                    changedNumber.add(Integer.parseInt(pureNumber.trim()));
                }
            }

        } else if (input.startsWith("//")) {
            int cuttingMarkIndex = input.indexOf("\n");

            // 커스텀 구분자 추출 (커스텀 구분자는 개행문자인 \n 이전 까지라는 가정)
            String customCuttingMark = input.substring(2, cuttingMarkIndex);
            System.out.println("customCuttingMark = " + customCuttingMark);
            String safeCustomCuttingMark = Pattern.quote(customCuttingMark);
            String combinedCuttingMark = cuttingMark + "|" + safeCustomCuttingMark;

            // 숫자 부분 추출
            input = input.substring(cuttingMarkIndex + 1);
            String[] numbers = input.split(combinedCuttingMark);

            // 숫자 변환 및 추가
            for (String pureNumber : numbers) {
                if (!pureNumber.trim().isEmpty()) {
                    try {
                        changedNumber.add(Integer.parseInt(pureNumber.trim()));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("A non-numeric value is included.");
                    }
                }
            }
        } else {
            // 기본 구분자 처리 (입력값은 빈값이 아니고 커스텀 구분자가 없다는 가정)
            String[] numbers = input.split("[, :]");

            // 숫자 변환 및 추가
            for (String pureNumber : numbers) {
                if (!pureNumber.trim().isEmpty()) {
                    try {
                        changedNumber.add(Integer.parseInt(pureNumber.trim()));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("A non-numeric value is included.");
                    }
                }
            }
        }

        // 합계 계산
        for (int num : changedNumber) {
            previousSum = sum;  // 이전 합계를 저장
            sum += num;

            if (sum < previousSum) {
                throw new IllegalArgumentException("양수의 숫자만 입력 할 수 있습니다.");
            }
        }

        System.out.println("결과 : " + sum);

        sc.close();
    }
}
