import java.io.*;
import java.util.*;

public class B1012유기농배추 {
  static int[] dx = { -1, 0, 1, 0 }; // ↑ → ↓ ←
  static int[] dy = { 0, 1, 0, -1 };
  static int M, N;
  static int[][] map;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      int K = Integer.parseInt(st.nextToken());
      map = new int[M][N];

      while (K-- > 0) {
        st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        map[x][y] = -1;
      }

      // DFS
      int cnt = 0;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] == -1)
            dfs(i, j, ++cnt);
        }
      }

      // BFS
      // int cnt = 0;
      // for (int i = 0; i < M; i++) {
      // for (int j = 0; j < N; j++) {
      // if (map[i][j] == -1) bfs(i, j, ++cnt);
      // }
      // }

      System.out.println(cnt);
    }
  }

  private static void dfs(int x, int y, int cnt) {
    map[x][y] = cnt;
    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] == -1)
        dfs(nx, ny, cnt);
    }
  }

  private static void bfs(int x, int y, int cnt) {
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[] { x, y });
    map[x][y] = cnt;
    while (!q.isEmpty()) {
      int[] pos = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = pos[0] + dx[i];
        int ny = pos[1] + dy[i];
        if (nx >= 0 && ny >= 0 && nx < M && ny < N && map[nx][ny] == -1) {
          map[nx][ny] = cnt;
          q.add(new int[] { nx, ny });
        }
      }
    }
  }

}
