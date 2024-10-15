# 우테코 1주차 프리코스 - 문자열 덧셈 계산기

## 구현 기능 (흐름)

<br/>

### 1. 입력 요구 문구 출력 및 입력 받기

      덧셈할 문자열을 입력해 주세요.
      1,2:3

<br/>

### 2. 입력 요구사항 확인

<br/>

#### 입력 조건

1. 기본 구분자
   - 쉼표(,)
   - 콜론(;)


2. 커스텀 구분자
   - 원하는 문자를 구분자로 설정
   - "//" + "원하는 문자" + "\n"
   - 입력 문자열의 맨 앞에 위치


3. 가능한 숫자 범위
   - 양수

<br/>

#### 잘못된 입력 경우

- `IllegalArgumentException` 발생 후 애플리케이션 종료

<br/>

### 3. 계산 진행

- 구분자로 나눠 얻은 숫자들의 합 계산

<br/>

### 4. 결과 출력

    결과 : 6

---
## 설정 및 진행시 지킬 것

- JDK 21 버전으로 진행
- `build.gradle` 파일 불가
- 제공된 라이브러리 이외의 외부 라이브러리 사용 불가
- `System.exit()` 호출 금지
- 파일 및 패키지 등의 이름 변경 및 이동 금지
- 입력 받을 시 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용
- [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고해서 커밋 메세지 작성하기
- [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java) 에 맞춰 코드 컨벤션 지키기