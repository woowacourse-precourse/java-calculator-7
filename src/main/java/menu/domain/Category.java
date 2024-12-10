package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import menu.util.Exception;

public enum Category {
    일식(1, List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
    한식(2, List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
    중식(3, List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
    아시안(4, List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
    양식(5, List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));

    private int categoryNumber;
    private List<String> menus;

    Category(int categoryNumber, List<String> menus) {
        this.categoryNumber = categoryNumber;
        this.menus = menus;
    }

    public static String recommendMenu(String category) {
        List<String> menu = Category.valueOf(category).menus;
        return Randoms.shuffle(menu).get(0);
    }

    public static String randomCategory() {
        int randomNumber = Randoms.pickNumberInRange(1, 5);
        return Arrays.stream(Category.values())
                .filter(value -> value.categoryNumber == randomNumber)
                .map(Category::name)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(Exception.ERROR + Exception.RANDOM_NUMBER));
    }
}
