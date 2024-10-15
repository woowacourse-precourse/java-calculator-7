# 프리코스 1주차 과제

## ✏️ 구현 기능 목록
- 빈 문자열 또는 null 입력 시 0을 반환한다.
- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하면 각 숫자의 합을 반환한다.
- "//[커스텀 구분자]\n" 형식의 문자열을 입력받아 커스텀 구분자로 분리된 숫자의 합을 반환한다.
- 잘못된 형식의 입력일 경우 IllegalArgumentException을 발생시킨다.
- 사용자로부터 문자열을 입력 받고 결과를 출력한다.
<br>

## 📌 최종 기능 명세
| Class | Method | Input | Output | Description |
|-------|--------|-------|--------|-------------|
<br>

## 💻 커밋 컨벤션
> [**AngularJS 커밋 컨벤션**](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고

| Type     | Description      |
|----------|------------------|
| feat     | 새로운 기능 추가        |
| fix      | 버그 수정            |
| docs     | 문서 변경            |
| style    | 코드 포맷 변경         |
| refactor | 코드 리팩토링          |
| test     | 테스트 추가 및 수정      |
| chore    | 빌드 작업 및 도구 관련 변경 |
<br>

## ✅ 체크 리스트
### 과제 진행 요구 사항
- [ ] 문자열 덧셈 계산기 저장소를 포크하고 클론한다.
- [ ] 기능을 구현하기 전에 README.md에 구현할 기능 목록을 정리해 추가한다.
- [ ] Git의 커밋은 README.md에 정리된 기능 목록 단위로 나눈다. (AngularJS Git Commit Message Conventions 참고)

### 기능 요구 사항
- [ ] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
- [ ] 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 "//"와 "\n" 사이에 위치한 문자를 사용한다.
- [ ] 잘못된 입력 값이 주어질 경우, IllegalArgumentException을 발생시키고 애플리케이션을 종료한다.
- [ ] 입력: 구분자와 양수로 구성된 문자열을 입력받는다.
- [ ] 출력: 덧셈의 결과를 출력한다.

### 프로그래밍 요구 사항
- [ ] JDK 21에서 실행 가능해야 한다.
- [ ] 프로그램의 시작점은 Application의 main()이다.
- [ ] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리만 사용해야 한다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다. 
- [ ] 별도의 지시가 없는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 준수하여 프로그래밍한다. 기본적으로 Google Java Style Guide를 따른다.
- [ ] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현해야 한다.
- [ ] 사용자의 입력은 camp.nextstep.edu.missionutils.Console의 readLine()을 사용한다.
