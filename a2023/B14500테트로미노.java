import java.io.*;
import java.util.*;

public class B14500테트로미노 {
  static int[] dy = { -1, 0, 1, 0 }; // ↑ → ↓ ←
  static int[] dx = { 0, 1, 0, -1 };
  static int N, M, max = Integer.MIN_VALUE;
  static int[][] map;
  static boolean[][] visited;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        visited[i][j] = true;
        dfs(i, j, 1, map[i][j]);
        visited[i][j] = false;

        com(0, 0, i, j, map[i][j]);
      }
    }

    System.out.println(max);
  }

  private static void dfs(int y, int x, int cnt, int sum) {
    if (cnt == 4) {
      max = Math.max(max, sum);
      return;
    }

    for (int d = 0; d < 4; d++) {
      int ny = y + dy[d];
      int nx = x + dx[d];

      if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx])
        continue;

      visited[ny][nx] = true;
      dfs(ny, nx, cnt + 1, sum + map[ny][nx]);
      visited[ny][nx] = false;
    }
  }

  private static void com(int cnt, int start, int y, int x, int sum) {
    if (cnt == 3) {
      max = Math.max(max, sum);
      return;
    }

    for (int d = start; d < 4; d++) {
      int ny = y + dy[d];
      int nx = x + dx[d];

      if (ny < 0 || ny >= N || nx < 0 || nx >= M)
        continue;
      com(cnt + 1, d + 1, y, x, sum + map[ny][nx]);
    }
  }
}
