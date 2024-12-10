package menu.view;

import menu.domain.Recommend;

public class OutputView {
    private static final String START_MSG = "점심 메뉴 추천을 시작합니다.\n";
    private static final String RECOMMEND_RESULT = "메뉴 추천 결과입니다.\n";
    private static final String YOIL = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String CATEGORY_RESULT = "[ 카테고리 | %s | %s | %s | %s | %s ]\n";
    private static final String COACH_RESULT = "[ %s | %s | %s | %s | %s | %s ]\n";
    private static final String COMPLETE_RECOMMENDATION = "\n추천을 완료했습니다.";

    public void printStart() {
        System.out.println(START_MSG);
    }

    public void printResult(Recommend recommend) {
        System.out.println(RECOMMEND_RESULT);
        System.out.println(YOIL);
        printCategory(recommend);
        for (String coach : recommend.getCoach()) {
            printMenu(recommend, coach);
        }
        System.out.println(COMPLETE_RECOMMENDATION);
    }

    private void printCategory(Recommend recommend) {
        System.out.printf(CATEGORY_RESULT, recommend.getCategories().get(0), recommend.getCategories().get(1),
                recommend.getCategories().get(2), recommend.getCategories().get(3), recommend.getCategories().get(4));
    }

    private void printMenu(Recommend recommend, String coach) {
        System.out.printf(COACH_RESULT, coach, recommend.getInedible().get(coach).get(0),
                recommend.getInedible().get(coach).get(1), recommend.getInedible().get(coach).get(2),
                recommend.getInedible().get(coach).get(3), recommend.getInedible().get(coach).get(4));
    }
}
