public static int sumFromString(String input) {
    if (input == null || input.isEmpty()) {
        return 0;
    }

    String delimiter = ",|:";  // 기본 구분자 쉼표와 콜론
    String[] tokens = input.split(delimiter);  // 구분자를 기준으로 문자열 분리

    int sum = 0;
    for (String token : tokens) {
        sum += Integer.parseInt(token);  // 숫자를 더함
    }

    return sum;
}