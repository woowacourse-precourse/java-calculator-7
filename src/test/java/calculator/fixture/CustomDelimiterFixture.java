package calculator.fixture;

public enum CustomDelimiterFixture implements SuccessDelimiterFixture {
    느낌표("//!\\n1!2!3", 6),
    골뱅이("//@\\n1@2@3", 6),
    샾("//#\\n4#5#6", 15),
    달러("//$\\n10$20$30", 60),
    별표("//*\\n7*8*9", 24),
    하이픈("//-\\n1-2-3", 6),
    언더스코어("//_\\n4_5_6", 15),
    플러스("//+\\n3+3+3", 9),
    파이프("//|\\n10|20|30", 60),
    세미콜론("//;\\n100;200;300", 600),
    등호("//=\\n2=3=4", 9),
    탭("//\t\\n5\t5\t5", 15),
    물음표("//?\\n1?1?1", 3),
    캐럿("//^\\n9^9^9", 27),
    슬래시("///\\n10/20/30", 60),
    퍼센트("//%\\n25%50%25", 100),
    대괄호("//[\\n1[2[3", 6),
    중괄호("//{\\n7{8{9", 24),
    괄호("//(\\n4(5(6", 15),
    공백("/// \\n3 4 5", 12),
    문자("//a\\n3a4a5", 12),
    여러문자("//abc\\n3abc4abc15", 22),
    ;

    private final String input;
    private final int result;

    CustomDelimiterFixture(String input, int result) {
        this.input = input;
        this.result = result;
    }

    @Override
    public String getInput() {
        return input;
    }

    @Override
    public String getResult() {
        return String.format("결과 : %d", result);
    }
}
