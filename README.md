# java-calculator-precourse

## 학습목표
* Git, Github, IDE 등 실제 개발 환경 적응
* 교육 분야에 맞는 프로그래밍 언어를 사용해 간단한 문제 해결

## 요구사항

### 과제 진행 요구 사항
- [ ] `REAEME.md`에 정리한 기능 목록 단위로 커밋
- [ ] [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고

### 기능 요구 사항
- [ ] 입력한 문자열에서 숫자를 추출하여 더하는 계산기 구현
- [ ] ",", ":"을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환
- [ ] 커스텀 구분자를 지정할 수 있으며, "//"와 "\n" 사이에 위치하는 문자를 커스텀 구분자로 사용
- [ ] 사용자가 잘못된 값을 입력한 경우 `IllegalArgumentException` 발생시킨 후 종료

입력: 구분자와 양수로 구성된 문자열
출력: 덧셈 결과

실행 결과 예시
```
덧셈할 문자열을 입력해 주세요.
1,2:3
결과 : 6
```

### 프로그래밍 요구 사항
- [ ] JDK 21
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`
- [ ] build.gradle 파일 변경 불가, 제공된 라이브러리 외 외부 라이브러리 사용 불가
- [ ] 프로그램 종료시 `System.exit()` 호출 X
- [ ] 요구 사항에서 명시하지 않는 한 파일, 패키지 등의 이름을 변경, 이동 X
- [ ] 자바 코드 컨벤션 준수 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)

라이브러리
- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API 사용해 구현
- [ ] 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

---

## 기능 목록

사용자 입력 `input`
- [ ] `camp.nextstep.edu.missionutils.Console`의 `readLine()` 사용하여 사용자 입력 구현

문자열 필터링 `filtering`
- [ ] 사용자가 커스텀 구분자를 지정했는지 확인하고, 지정했다면 커스텀 구분자 저장
- [ ] 사용자가 입력한 문자열에서 구분자 기준으로 숫자 분리
- [ ] 기본 구분자(",", ";")와 커스텀 구분자 외에 다른 문자 입력시 `IllegalArgumentException` 예외처리

계산 처리 `calculate`
- [ ] 문자열 필터링에서 구한 숫자로 덧셈 계산 후 `result` 변수에 저장

출력 `output`
- [ ] `결과 : result` 형식으로 출력