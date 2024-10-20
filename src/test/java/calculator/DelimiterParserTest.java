//package calculator;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//
//import org.junit.jupiter.api.Test;
//
//class DelimiterParserTest {
//
//    @Test
//    void parse_숫자_하나() {
//        String input = "1";
//        String[] result = DelimiterParser.parse(input); // 클래스 이름을 사용하여 호출
//        assertThat(result).containsExactly("1");
//    }
//
//    @Test
//    void parse_기본_구분자() {
//        String input = "1,2:3";
//        String[] result = DelimiterParser.parse(input);
//        assertThat(result).containsExactly("1", "2", "3");
//    }
//
//    @Test
//    void parse_커스텀_구분자() {
//        String input = "//;\n1;2;3";
//        String[] result = DelimiterParser.parse(input);
//        assertThat(result).containsExactly("1", "2", "3");
//    }
//
//     @Test
//     void parse_기본_구분자_커스텀_구분자() {
//         String input = "//;\n1;2,3:4";
//         String[] result = DelimiterParser.parse(input);
//         assertThat(result).containsExactly("1", "2", "3", "4");
//     }
//
//    @Test
//    void parse_커스텀_구분자_다양() {
//        String input = "//$%\n1,2,3";
//        String[] result = DelimiterParser.parse(input);
//        assertThat(result).containsExactly("1", "2", "3");
//    }
//
//    @Test
//    void invalidCustomDelimiter_커스텀_구분자_없음() {
//        String input = "//\n1,2:3";
//        assertThatThrownBy(() -> DelimiterParser.parse(input))
//                .isInstanceOf(IllegalArgumentException.class);
//    }
//}