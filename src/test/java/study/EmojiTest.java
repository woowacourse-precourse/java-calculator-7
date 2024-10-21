package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.BreakIterator;
import java.util.Locale;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmojiTest {

    @Test
    @DisplayName("이모지 마다 다른 문자열 길이를 1로 통일한다")
    void 이모지_길이_1로_통일() {
        String smileEmoji = "\uD83D\uDE03"; // 웃음 이모지
        String koreaEmoji = "\uD83C\uDDF0\uD83C\uDDF7"; // 한국 국기 이모지
        String familyEmoji = "\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC66";

        System.out.println(smileEmoji.length()); // smile 이모지 길이 2
        System.out.println(smileEmoji);
        System.out.println(koreaEmoji.length()); // korea 이모지 길이 4
        System.out.println(koreaEmoji);
        System.out.println(familyEmoji.length()); // family 이모지 길이 11
        System.out.println(familyEmoji);

        int smileEmojiLength = convertEmojiLengthToOne(smileEmoji);
        int koreaEmojiLength = convertEmojiLengthToOne(koreaEmoji);
        int familyEmojiLength = convertEmojiLengthToOne(familyEmoji);

        assertThat(smileEmojiLength).isEqualTo(1);
        assertThat(koreaEmojiLength).isEqualTo(1);
        assertThat(familyEmojiLength).isEqualTo(1);
    }

    @Test
    void 이모지와_다른_문자가_함께_존재() {
        String withFamilyEmoji = "hi\uD83D\uDC68\u200D\uD83D\uDC69\u200D\uD83D\uDC67\u200D\uD83D\uDC66";

        System.out.println(withFamilyEmoji.length()); // hi + family 이모지 길이 13
        System.out.println(withFamilyEmoji);

        assertThat(convertEmojiLengthToOne(withFamilyEmoji)).isEqualTo(3);
    }

    private int convertEmojiLengthToOne(String emoji) {
        BreakIterator breakIterator = BreakIterator.getCharacterInstance(Locale.KOREA);
        breakIterator.setText(emoji);
        int count = 0;
        while (breakIterator.next() != BreakIterator.DONE) {
            count++;
        }
        return count;
    }

}
