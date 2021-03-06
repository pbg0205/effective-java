## hashcode

- hashCode method : 객체의 메모리 번지를 해싱 알고리즘을 이용해 정수값을 반환하는 함수

- 자바는 기본적으로 hash 값을 사용해 HashMap, HashSet 과 같은 객체에서 논리적 동치성을 보장하는 
역할을 한다.

- 자바는 우선적으로 hashCode 의 리턴값을 확인하고 equals 리턴값을 확인해 같은 객체임을 판별한다.

- 좋은 인스턴스라면 다른 객체에 다른 해시 함수를 반환해야 한다.
  - 만약 모든 객체에 같은 해시값을 반한할 경우,
  특정 자료구조(ex. HashMap)에서 조회 시간 복잡도가 O(1)에서 O(n)으로 변된다.

- 좋은 해시함수를 선언하는 방법은 31을 사용하는 것이다.
```
result = 31 * result + c;
```