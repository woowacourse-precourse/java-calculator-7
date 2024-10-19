package calculator.service;

import calculator.model.Calculator;

public class CalculatorService {
    public int calculate(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }
        if (input.contains("0")) {
            throw new IllegalArgumentException("음수 또는 0은 입력할 수 없습니다.");
        }
        input = input.replace("\\n", "\n");
        Calculator calculator = new Calculator();
        if (input.isEmpty()) {
            calculator.setNumbers(new int[]{0});
        } else {
            String delimiters = "[,|:]";
            if (input.startsWith("//")) {
                String[] split = input.split("\n", 2);
                String customDelimiter = split[0].substring(2);
                delimiters = "[" + delimiters.substring(1, 4) + "|" + customDelimiter + "]";
                input = split[1];
            }

            String[] splitInput = input.split(delimiters);
            int[] splitNum = new int[splitInput.length];

            for (int i = 0; i < splitInput.length; i++) {
                if (splitInput[i].isEmpty()) {
                    if (i == 0 || i == splitInput.length - 1) {
                        throw new IllegalArgumentException("경계값에는 구분자가 들어갈 수 없습니다.");
                    } else {
                        throw new IllegalArgumentException("구분자를 중첩해서 입력할 수 없습니다.");
                    }
                }
                //커스텀 구분자로 "-"가 들어올 수도 있기 때문에 음수는 여기서 판별함
                //int로 변환할 때 문자가 들어가 있으면 NumberFormatException 터지므로 이를 try-catch
                try {
                    if (Integer.parseInt(splitInput[i]) < 0) {
                        throw new IllegalArgumentException("음수 또는 0은 입력할 수 없습니다.");
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("구분자가 아닌 문자는 입력할 수 없습니다.");
                }

                splitNum[i] = Integer.parseInt(splitInput[i]);
            }
            calculator.setNumbers(splitNum);
            System.out.println(delimiters);
        }
        calculator.doSum();
        return calculator.getSum();
    }
}
