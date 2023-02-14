import java.io.*;
import java.util.*;

public class B14940쉬운최단거리 {
  static int N, M;
  static Queue<Pos> q = new LinkedList<>();
  static boolean[][] visit;
  static int[][] map, result;

  static class Pos {
    int x, y;

    Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    result = new int[N][M];
    visit = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      Arrays.fill(result[i], -1);
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 2) {
          result[i][j] = 0;
          visit[i][j] = true;
          q.add(new Pos(i, j));
        } else if (map[i][j] == 0) {
          result[i][j] = 0;
        }
      }
    }

    bfs();

    for (int[] rs : result) {
      for (int r : rs) {
        sb.append(r + " ");
      }
      sb.append("\n");
    }
    System.out.print(sb);
  }

  private static void bfs() {
    int[] dy = { -1, 0, 1, 0 }; // ↑ → ↓ ←
    int[] dx = { 0, 1, 0, -1 };
    while (!q.isEmpty()) {
      Pos pos = q.poll();
      for (int i = 0; i < 4; i++) {
        int ny = pos.y + dy[i];
        int nx = pos.x + dx[i];
        if (ny < 0 || nx < 0 || nx >= M || ny >= N || map[ny][nx] == 0 || visit[ny][nx])
          continue;
        visit[ny][nx] = true;
        result[ny][nx] = result[pos.y][pos.x] + 1;
        q.add(new Pos(ny, nx));
      }
    }
  }
}