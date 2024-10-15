# java-calculator-precourse
해당 프로젝트는 사용자가 입력한 문자열에서 숫자를 추출하여 더하는 계산기를 구현하는 것을 목표로 한다.

<br>

## 제공 기능

| 기능명 | 설명 |
| --- | --- |
| 문자열 입력 기능 | ```camp.nextstep.edu.missionutils```의 ```Console``` API를 활용하여 사용자에게 문자열을 입력받는다. |
| 커스텀 구분자 등록 기능 | 사용자의 입력 문자열에서 커스텀 구분자를 추출하여 구분자 목록에 추가한다.<br>이 때, 사용자의 입력 문자열이 양식과 맞지 않다고 판단할 경우 ```IllegalArgumentException```을 발생시킨다. |
| 수 추출 기능 | 기본 구분자 및 커스텀 구분자를 활용하여 문자열에서 수를 추출한다. |
| 계산 기능 | 추출한 수를 모두 더한 값을 반환한다. |

<br>

## Commit Message Convention
[해당 문서 참조](./Docs/commit.md)