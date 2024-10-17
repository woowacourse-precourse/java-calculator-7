# 문자열 덧셈 계산기

## 🔍 진행 방식

- 과제는 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있습니다.
- 세 가지 요구 사항을 만족하는 것을 목표로 진행하며, 기능 구현 전에 반드시 기능 목록을 작성하고, 기능 단위로 커밋합니다.

## ✉️ 과제 제출 방법

- GitHub을 통해 과제를 제출합니다.
    - GitHub 활용 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고하세요.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원 플랫폼](https://apply.techcourse.co.kr)에서 PR 링크를 포함하여 최종 제출합니다.
    - 자세한 제출 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#%EC%A0%9C%EC%B6%9C-%EA%B0%80%EC%9D%B4%EB%93%9C)를 참고하세요.

## ✔️ 과제 제출 전 체크 리스트

- 모든 기능을 올바르게 구현했더라도 출력 형식이 요구 사항과 다를 경우 0점 처리될 수 있습니다.
- 터미널에서 Mac 또는 Linux 사용자는 `./gradlew clean test`, Windows 사용자는 `gradlew.bat clean test` 명령을 실행하여 모든 테스트가 통과하는지 확인하세요.
    - 테스트가 실패할 경우 점수가 0점 처리됩니다.

---

## 🚀 기능 요구 사항

입력된 문자열에서 숫자를 추출하여 더하는 기능을 가진 문자열 덧셈 계산기를 구현합니다.

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 입력하면, 해당 구분자로 분리된 숫자들의 합을 반환합니다.
    - 예: "" => 0, "1,2" => 3, "1,2:3" => 6
- 커스텀 구분자를 설정할 수 있습니다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치한 문자를 사용합니다.
    - 예: "//;\n1;2;3" => 6
- 사용자가 잘못된 값을 입력하면 `IllegalArgumentException`을 발생시키며 프로그램을 종료합니다.

---

## ⚙️ 구현 기능 목록

- [x] 기본 구분자(쉼표, 콜론)를 기준으로 입력 문자열을 분리하고, 숫자의 합을 계산한다.
- [x] 커스텀 구분자가 포함된 문자열에서 구분자를 추출하고 이를 사용해 숫자를 분리한 후 합을 계산한다.
- [x] 입력된 문자열이 유효한 형식인지 검증한다.
- [x] 잘못된 입력값에 대해 `IllegalArgumentException`을 발생시키고 프로그램을 종료한다.

---

## ✍️ 입출력 요구 사항

### ⌨️ 입력

- 구분자와 양수로 이루어진 문자열을 입력받습니다.

### 🖥 출력

- 덧셈 결과를 출력합니다.

```
결과 : 6
```

---

## 📈 프로그래밍 요구 사항

- 프로그램의 시작점은 `Application`의 `main()`입니다.
- JDK 21 버전에서 실행 가능해야 합니다.
- 외부 라이브러리 사용은 금지되어 있으며, 제공된 `camp.nextstep.edu.missionutils` 라이브러리만 사용 가능합니다.
    - 사용자 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 사용합니다.

---

## 📝 과제 진행 요구 사항

- 과제는 [문자열 덧셈 계산기](https://github.com/woowacourse-precourse/java-calculator-7) 저장소를 포크한 후 시작합니다.
- 기능 구현 전에 `README.md` 파일에 기능 목록을 정리해 추가하고, Git 커밋은 기능 단위로 진행합니다.
- 커밋 메시지는 [AngularJS Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)를 참고하여 작성합니다.
