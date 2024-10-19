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
        System.out.println(delimiter);
        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            try {
                sum += Integer.parseInt(token);

        }  catch(NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력입니다. :" + token);
        }
    }
        return  sum;
    }
}

