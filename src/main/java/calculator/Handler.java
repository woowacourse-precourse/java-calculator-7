package calculator;

public class Handler {
    public int[] inputHandler(String input) {
        String[] split;
        if (indicateCustom(input)) {
            String custom = makeCustomSeperator(input);
            split = splitter(input, custom);
        } else {
            split = splitter(input);
        }
        validInput(split);
        return transToInt(split);
    }

    private boolean indicateCustom(String input) {
        if (input.contains("//") || input.contains("\n")) {
            return true;
        } else {
            return false;
        }
    }

    private String makeCustomSeperator(String input) throws IllegalArgumentException {
        String custom = input.substring(2, input.indexOf("\\"));
        if (custom.equals("")) {
            throw new IllegalArgumentException("커스텀 구분자 선언이 잘못되었습니다.");
        }
        return custom;
    }

    private String[] splitter(String input) {
        String[] result = input.split("[,:]");
        return result;
    }

    private String[] splitter(String input, String custom) {
        String[] result = input.split(",|:|" + custom);
        return result;
    }

    private void validInput(String[] split) throws IllegalArgumentException {
        try {
            for (int i = 0; i < split.length; i++) {
                int argument = Integer.parseInt(split[i]);
                if (argument <= 0) {
                    throw new NumberFormatException("입력 숫자는 양수이어야 합니다.");
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력입니다");
        }
    }

    private int[] transToInt(String[] split) {
        int[] result = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            result[i] = Integer.parseInt(split[i]);
        }
        return result;
    }

}
