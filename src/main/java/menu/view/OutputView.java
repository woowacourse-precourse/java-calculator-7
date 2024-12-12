package menu.view;

import java.util.List;

public class OutputView {
    private static final String RECOMMENDATION_START_MSG = "점심 메뉴 추천을 시작합니다.";
    private static final String RECOMMENDATION_RESULT_MSG = "메뉴 추천 결과입니다.";
    private static final String DAY = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORIES = "[ 카테고리 | %s | %s | %s | %s | %s ]\n";
    private static final String COACH_RECOMMEND_MENUS = "[ %s | %s | %s | %s | %s | %s ]\n";
    private static final String COMPLETE_RECOMMEND = "\n추천을 완료했습니다."
    private static final int MONDAY = 0;
    private static final int TUESDAY = 1;
    private static final int WEDNESDAY = 2;
    private static final int THURSDAY = 3;
    private static final int FRIDAY = 4;

    public void printStart() {
        System.out.println(RECOMMENDATION_START_MSG);
    }

    public void printResult(List<String> category, String coach, List<String> menus) {
        System.out.println(RECOMMENDATION_RESULT_MSG);
        System.out.println(DAY);
        printCategory(category);
        printCoachRecommendMenus(coach, menus);
        System.out.println(COMPLETE_RECOMMEND);
    }

    private void printCategory(List<String> category) {
        System.out.printf(CATEGORIES, category.get(MONDAY), category.get(TUESDAY), category.get(WEDNESDAY),
                category.get(THURSDAY), category.get(FRIDAY));
    }

    private void printCoachRecommendMenus(String coach, List<String> menus) {
        System.out.printf(COACH_RECOMMEND_MENUS, coach, menus.get(MONDAY), menus.get(TUESDAY), menus.get(WEDNESDAY),
                menus.get(THURSDAY), menus.get(FRIDAY));
    }
}
