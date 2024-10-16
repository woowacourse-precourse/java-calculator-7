# 1주차 미션 - 문자열 덧셈 계산기

## ✔️ 미션 공통 체크리스트

- [ ] Pull Request 완료하기
- [ ] 지원 플랫폼 과제 제출하기
- [ ] 명시된 출력 형식 따르기
- [ ] 테스트 성공 확인하기

## 🚀 과제 진행 요구 사항

- [x] 미션은 [문자열 덧셈 계산기 저장소](https://github.com/woowacourse-precourse/java-calculator-7)를 포크하고 클론하는 것으로 시작한다.
- [x] **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
- [ ] Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋
      메시지를 작성한다.

## 🔍 기능 요구 사항

입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현한다.

- [ ] 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
    - 예: `"" => 0`, `"1,2" => 3`, `"1,2,3" => 6`, `"1,2:3" => 6`
- [ ] 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 `"//"`와 `"\n"` 사이에 위치하는 문자를 커스텀 구분자로 사용한다.
    - 예를 들어 `"//;\n1;2;3"`과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## ✍️ 입출력 요구 사항

⌨️ 입력

- 구분자와 양수로 구성된 문자열

🖥 출력

- 덧셈 결과

```
결과 : 6
```

💻 실행 결과 예시

```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

## ⚽ 프로그래밍 요구 사항

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- [ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [ ] 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## 📚 라이브러리

- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용하여 구현해야 한다.
    - [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

## 📜 구현할 기능 목록

- [x] `input` : 입력 클래스 생성
- [x] `IO` : 입출력 처리
- [ ] `basic` : 기본 구분자를 포함하는 입력 처리
- [ ] `custom` : 커스텀 구분자를 포함하는 입력 처리
- [ ] `exception` : 잘못된 입력에 대한 오류 처리

## 🤔 과제 목표(중요도 1~5)

2️⃣ 기능 요구사항을 잘 따르는지

5️⃣ 비기능 요구사항을 잘 따르는지

3️⃣ 자바 코드 컨벤션을 잘 지키는지

5️⃣ 깃 커밋 컨벤션을 잘 지키는지

## 🧗 목표 설정

- [x] 과제 요구사항 정리하기
- [ ] 제출하기 전, 한 줄 평을 남겨 요구사항들을 만족하는지 체크하기
- [ ] 1번만에 통과할 수 있도록 꼼꼼하게 체크하기
- [ ] 주석 적극 활용하기
- [ ] 제출 완료 후 커뮤니티를 통해 리팩토링하기
- [ ] 마무리하면서 어려웠던 로직은 무엇인지, 어떤 것을 깨달았는지, 무엇이 부족했는지 등의 메타인지 수행하기
