# java-calculator-precourse

## 📌 구현할 기능 목록

---

#### ✅ 구분자 등록

- [X] 커스텀 구분자 사용 여부 확인하는 함수 구현
- [X] 커스텀 구분자 사용 시, 이를 사용할 구분자로 등록하는 함수 구현

#### ✅ MAIN) 구분자로 문자열 자르기

- [ ] 입력받은 문자열을 등록된 구분자로 자르면서 Int로 형변환하여 배열로 저장하기

#### ✅ 추출된 숫자들의 합 구하기

- [ ] 추출된 숫자가 양수인지 확인하고, 양수가 아닐 경우 `IllegalArgumentException` 발생시키는 함수 구현
- [ ] 추출된 숫자들을 모두 더하기

## 📝 과제 요구 사항

---

1. 문자열 덧셈 계산기 포크하기
2. 기능 구현 전 README.md에 구현할 기능 목록 정리하여 추가
3. Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가
    1. https://gist.github.com/stephenparish/9941e89d80e2bc58a153
    2. 위 링크 참고하여 커밋 메시지 작성

## ⚒️ 기능 요구 사항

---

#### ✅ 문제

입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현

- 기본 구분자 ) 쉼표, 콜론 → 구분자를 기준으로 분리한 각 숫자의 합 반환
- 커스텀 구분자 ) 문자열 앞 부분의 “//”와 “\n” 사이에 위치하는 문자
- 잘못된 값 입력 시 IllegalArgumentException 발생

#### ✅ 입출력 요구 사항

**입력**

- 구분자와 양수로 구성된 문자열

**출력**

```
결과 : 6
```

**실행 결과 예시**

```bash
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## 💻 프로그래밍 요구 사항

---

- JDK 21 버전에서 실행 가능해야 함
- 프로그램 실행 시작점: Application의 main()
- build.gradle 파일 변경 불가, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않음
- 프로그램 종료 시 System.exit() 호출하지 않음
- 파일, 패키지 등의 이름 바꾸거나 이동 x
- 자바 코드 컨벤션 지키며 프로그래밍
    - https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java

#### 📚 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.