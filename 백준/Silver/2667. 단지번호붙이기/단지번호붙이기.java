import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Main {
	static int N;
	static int groupNum;
	static int count;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static List<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		groupNum = 1;
		for (int i = 0; i < N; i++) {
			int[] input = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			board[i] = Arrays.copyOf(input, N);
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					count = 0;
					dfs(i, j, board, visited);
					list.add(count);
				}
			}
		}
		bw.write("" + list.size());
		list = list.stream().sorted().collect(Collectors.toList());
		for (int i : list) {
			bw.write("\n" + i);
		}
		br.close();
		bw.close();
	}

	private static void dfs(int x, int y, int[][] board, boolean[][] visited) {
		if (board[x][y] == 0) {
			return;
		}
		count++;
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int next_X = x + dx[i];
			int next_Y = y + dy[i];
			if (next_X >= 0 && next_X < N && next_Y >= 0 && next_Y < N && !visited[next_X][next_Y]) {
				dfs(next_X, next_Y, board, visited);
			}
		}

	}

}