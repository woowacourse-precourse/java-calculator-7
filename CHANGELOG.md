#### 2024-10-20

##### Chores

* **$cr.yml:**
  *  깃허브 자동 리뷰 삭제 (41901a8f)
  *  깃허브 자동 리뷰 (522e353c)
  *  github action 자동 리뷰 (65f64a8f)

##### Documentation Changes

* **$README:**
  *  문서 수정 (3804c5be)
  *  문서 폴더 구조 추가 (2e73d72b)
  *  예외사항 문서 수정 (f148a50d)
* **$README.md:**
  *  문서 예외사항 수정 (d39b5a50)
  *  기능 목록 수정 (5a99a0d8)
* **$ readme.md:**  애플리케이션 기능 업데이트 (e22aefd9)

##### New Features

* **$NumberUtils:**
  *  원하는 에러 메시지 반환 구현 (4e7f7858)
  *  실수 검증 메서드 추가 (3ae55440)
  *  실수 판독 메서드 구현 (9d61d7dd)
* **$OutputView:**
  *  호출 불가 생성자 구현 (af9b6780)
  *  출력 UI 구현 (f1905c5f)
* **$DelimiterConstants:**
  *  커스텀 인덱스 상수 구현 (95e86d3d)
  *  상수 .(dot) 추가 (68d51dc6)
  *  커스텀 인식자 정규식 구현 (b0426948)
* **$Application:**  메인 구현 (f410a504)
* **$Delimiter:**
  *  구분자 . (dot) 검증 추가 (5dea538e)
  *  구분자 예외 사항 추가 (2d76c407)
  *  구분자 클래스 구현 (386353d4)
* **$ErrorMessages:**
  *  구분자 . (dot) 에러메시지 추가 (003b3464)
  *  에러 메시지 추가 (0d3ac1a8)
  *  예외 메시지 추가 (8967b188)
  *  새 에러 메시지 구현 (35df623c)
* **$CalculatorController:**  계산기 컨트롤러 구현 (b802143f)
* **$OriginalInput:**
  *  커스텀 구분자 지시자 예외 추가 (a061e989)
  *  커스텀 인식자 제거 기능 구현 (bb0dc771)
  *  구분자와 숫자 분리 메서드 구현 (0cd808c0)
  *  유저 인풋 데이터 클래스 구현 (0ff496bb)
* **$Number:**
  *  숫자 객체 검증 추가 (3b820f48)
  *  숫자 객체 구현 (d81c1d3c)
* **$Numbers:**
  *  계산합 메서드 구현 (6f195638)
  *  새 예외 구현 (6417122a)
  *  숫자 컬렉션 객체 구현 (fa8b2b35)
* **$StringSplitter:**
  *  커스텀 인식자 제거 메서드 구현 (c6843a1b)
  *  커스텀 구분자 분리 메서드 구현 (b56381b8)
  *  커스텀 문자열 구분 구현 (796a9aa4)
  *  문자열 구분 구현 (4990fe5b)
* **$InputView:**
  *  유저 입력기능 구현 (dced6039)
  *  입력 메시지 출력 구현 (88fa1520)
* **$InputMessages, $OutputMessages:**  상수 접근 제어자 수정 (0487039e)
* **$ErrorMessages, $InputMessages, $OutputMessages:**  상수 정리 (b68585bd)
*  setup project (d0a82b7d)

##### Bug Fixes

* **$Number:**
  *  Number 클래스 0 에러 수정 (f6a3a191)
  *  Number 클래스 실수 구현 (fcd2691f)
  *  잘못된 숫자 에러 수정 (9fdf6332)
  *  숫자 객체 공백 오류 수정 (71a4cd11)
* **$NumberUtils:**  에러 출력 오류 수정 (ab78bec5)
* **$OutputView:**  실수 출력 에러 수정 (f6f2d83b)
* **$Numbers:**  Numbers 클래스 실수합 구현 (edf344d3)
* **$OrigingalInput:**  잘못된 커스텀 구분자 지시자 수정 (7baa98f2)
* **$DelimiterConstants:**  세미콜론을 콜론으로 변경 (276b03c7)

##### Refactors

* **$ALL:**  폴더 이름 변경 (a8e391be)
* **$Views, $Constants:**  생성자 접근제어자 수정 (cccd2572)
* **$Numbers:**  모호한 메서드 이름 변경 (4b4e47d9)
* **$Delimiter:**  모호한 메서드 이름 변경 (a0eb8179)
* **$Delimiter, $Number:**  숫자 검증 메서드 추가 (e5e1073c)
* **$NumberUtils:**  숫자 검증 메서드 수정 (e9616817)
* **$README:**  상수 삭제 (e55229a6)
* **$Number:**
  *  매직넘버 제거 (03265874)
  *  생성자 인풋 형태 변경 (2789eaaa)
  *  생성자 인풋 형태 변경 (c4df2085)
  *  Integer 형변환 메서드 구현 (d57fae46)
* **$DelimiterConstants, $InputMessages, $NumberUtils, $OutputMessages, $ StringSplitter:**  빈 생성자 생성 (fab80ad3)
* **$InputView:**  변수 선언 제거 (08113138)
* **$StringSplitter:**
  *  상수 제거 (5c73c6d3)
  *  오탈자 수정 (d530c0ea)
  *  상수 제거 (0695a23a)
  *  파라미터 수정 (5062069e)
  *  사용하지 않는 기능 제거 (31436e5e)
* **$DelimiterConstants:**  구분자 상수 추가 (32b6de1f)

##### Code Style Changes

* **$CalculatorController, $Numbers:**  줄바꿈 (e49b3950)
* **$Number:**  모호한 표현 제거 (08cfe372)

##### Tests

* **$MyApplicationTest:**  애플리케이션 전체 테스트 추가 (fe8efeb6)
* **$NumberTest:**
  *  Numbers 클래스 테스트 추가 (97854918)
  *  Number 클래스 테스트 추가 (637fcace)
* **$DelimiterTest:**  Delimiter 테스트 추가 (693fb093)
* **$NumerUtilsTest:**  메서드 변경에 따른 테스트 수정 (a1faebe3)
* **$StringSplitterTest:**  문자열 분리 관련 유틸리티 클래스 테스트 (62389f4d)
* **$NumberUtilsTest:**  숫자 관련 유틸리티 클래스 테스트 (6e0629ab)

