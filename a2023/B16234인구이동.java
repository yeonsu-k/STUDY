import java.io.*;
import java.util.*;

public class B16234인구이동 {
	static int N, L, R;
	static int[][] map;
	static boolean[][] visit;
	static ArrayList<Pos> list;

	static class Pos {
		int x, y;

		Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("./input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 구현
		int result = 0;
		while (move()) {
			result++;
		}

		// 출력
		System.out.println(result);
	}

	private static boolean move() {
		boolean isMove = false;
		visit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visit[i][j]) {
					list = new ArrayList<>(); // 국경이 열린 마을 리스트
					int sum = bfs(i, j);
					if (list.size() > 1) { // 국경이 열린 마을이 2개 이상이면 인구 이동
						int avg = sum / list.size();
						for (Pos pos : list) {
							map[pos.x][pos.y] = avg;
						}
						isMove = true;
					}
				}
			}
		}
		return isMove;
	}

	private static int bfs(int x, int y) {
		int[] dx = { 0, 1, 0, -1 }, dy = { 1, 0, -1, 0 };
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(x, y));
		list.add(new Pos(x, y));
		visit[x][y] = true;
		int sum = map[x][y];

		while (!q.isEmpty()) {
			Pos temp = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = temp.x + dx[i];
				int ny = temp.y + dy[i];
				if (diff(temp.x, temp.y, nx, ny)) {
					q.add(new Pos(nx, ny));
					list.add(new Pos(nx, ny));
					visit[nx][ny] = true;
					sum += map[nx][ny];
				}
			}
		}
		return sum;
	}

	private static boolean diff(int x, int y, int nx, int ny) {
		if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
			int res = Math.abs(map[x][y] - map[nx][ny]);
			if (res >= L && res <= R && !visit[nx][ny])
				return true;
		}
		return false;
	}
}
