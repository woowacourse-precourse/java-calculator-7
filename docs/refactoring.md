# 리팩토링

## Layered Architecture 도입?
- 현재 미션에 Layered Architecture, 기본 레이어를 도입?
- 기본 레이어: Presentation Layer(view, controller) -> Business Layer(service) -> Implement Layer -> Data Access Layer
  - Presentation 계층은 뼈대가 존재, 현재 구현한 `Controller`는 Presentation 계층 코드가 아님
  - Business 계층을 도입할 것인가, 현재 구조는 domain에서 핵심 로직들을 처리하고 `Controller`가 service 역할을 하는 중
  - 데이터 접근 계층은 필요 없음
- 계층형 아키텍처에 대한 학습이 필요
  - MVC 포함
- 현재 `OutputView`가 핵심 도메인인 `PositiveNumber`를 알고 있음 -> DTO 필요

## 개념과 격벽
- 현재의 개념과 격벽에 대한 구조도를 한번 그려 볼 필요가 있음
- 덧셈은 누구의 책임인가? 별도의 계산기가 책임을 가져야 하나? 양수들이 서로를 더해야 하나?
- 구분자를 분리해 1급 개념으로 올릴 것인가? 기본 구분자(1급 개념), 커스텀 구분자(1급 개념)
- 입력을 분리하는 것은 누구의 책임인가? 구분자 자체에서 진행해야 하나? 별도의 분리기 개념이 필요하나?
