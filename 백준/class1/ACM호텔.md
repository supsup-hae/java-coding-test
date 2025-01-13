# ACM 호텔

## 📌 문제 정보
- **문제**: [ACM 호텔](https://www.acmicpc.net/problem/10250)
- **난이도**: Bronze 3
- **풀이 날짜**: 2024-01-13

## 👓 문제 설명
ACM 호텔에서는 손님들에게 방을 배정할 때 다음과 같은 규칙을 따릅니다:
- 각 층에 W개의 방이 있는 H층 건물
- 엘리베이터는 가장 왼쪽에 있음
- 손님들은 걷는 거리가 짧은 방을 선호
- 같은 거리라면 낮은 층을 선호

## 🚫 제한사항
- 1 ≤ H, W ≤ 99
- 1 ≤ N ≤ H × W
- T개의 테스트 케이스 (T ≤ 30)

## 🖥️ 입출력 예
| 입력 | 출력 |
|------|------|
| 2<br>6 12 10<br>30 50 72 | 402<br>1203 |

## 📝 입출력 예 설명
첫 번째 테스트 케이스:
- 6층 12방, 10번째 손님
- 4층 2호실 (402)

두 번째 테스트 케이스:
- 30층 50방, 72번째 손님
- 12층 3호실 (1203)

### 💡 접근 방법
1. 층수 계산:
    - N을 H로 나눈 나머지가 층수
    - 나머지가 0이면 가장 높은 층
2. 호수 계산:
    - N을 H로 나눈 몫에 1을 더함
    - 나누어 떨어지는 경우는 몫만 사용
3. 방 번호 출력:
    - (층수 × 100) + 호수

```java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		int room = 0;
		int floor = 0;
		List<String> list = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			StringBuilder sb = new StringBuilder();
			int h = scanner.nextInt();
			int w = scanner.nextInt();
			int n = scanner.nextInt();
			floor = n % h;
			if (floor == 0) {
				floor = h;
				room = n / h;
			} else {
				room = n / h + 1;
			}
			sb.append(floor);
			if (room < 10) {
				sb.append(0);
			}
			sb.append(room);
			list.add(sb.toString());
		}
		list.forEach(System.out::println);
	}
}

```

### 주의점
- 문제를 끝까지 읽고 코드를 스스로 검증할 줄 알아야한다 특히 조건 내 메서드가 명확하지 않을 경우 반례에 따른 오류가 발생한다.