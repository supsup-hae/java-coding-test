# solved.ac

## 📌 문제 정보
- **문제**: [solved.ac](https://www.acmicpc.net/problem/18110)
- **난이도**: Silver 4
- **풀이 날짜**: 2024-01-19

## 👓 문제 설명
solved.ac 시스템에서는 문제의 난이도를 결정하기 위해 사용자들의 난이도 의견을 수집하고, 30% 절사평균을 사용하여 최종 난이도를 결정합니다. 각 사용자가 제출한 난이도 의견들을 바탕으로 문제의 최종 난이도를 계산해야 합니다.

## 🚫 제한사항
- 0 ≤ n ≤ 300,000 (난이도 의견의 개수)
- 모든 난이도 의견은 1 이상 30 이하의 정수
- 시간 제한: 1초
- 메모리 제한: 1024MB

## 🖥️ 입출력 예
| 입력 | 출력 |
|------|------|
| 5<br>1 5 5 7 8 | 6 |
| 10<br>1 13 12 15 3 16 13 12 14 15 | 13 |

### 생각해볼점
- Math.rint() 함수를 사용했다가 round() 함수로 변경하니 정답이 나왔다. 차이점이 뭘까?

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int[] array = new int[n];
		int margin = (int)(Math.round(n * 0.15));
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		int[] sorted = Arrays.stream(array).sorted().toArray();
		for (int i = 0; i < margin; i++) {
			sorted[i] = 0;
			sorted[sorted.length - 1 - i] = 0;
		}
		double sum = 0;
		for (int i = 0; i < sorted.length; i++) {
			sum += sorted[i];
		}

		bw.write((int)Math.round(sum / (n - (margin * 2))) + "");
		bw.flush();
		bw.close();
	}

}
```