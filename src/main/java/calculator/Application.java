package calculator;

    public static int calculator(String input) {
        if (input.isEmpty()) {
            return 0;
        }
        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\\n");
            for (int i = 2; i < delimiterIndex; i++) {
                delimiter += "|" + input.charAt(i);
            }
            input = input.substring(delimiterIndex + 2);
        }

}

