package A1926그림;

import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = { -1, 0, 1, 0 }; // 상우하좌
  static int[] dy = { 0, 1, 0, -1 };
  static int N, M;
  static int[][] map;
  static boolean[][] visited;

  static class Pos {
    int x, y;

    Pos(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("A1926그림/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken()); // 세로크기
    M = Integer.parseInt(st.nextToken()); // 가로크기
    map = new int[N][M]; // 도화지
    visited = new boolean[N][M];
    int count = 0; // 도화지 수
    int maxArea = 0; // 가장 넓은 도화지

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 1 && !visited[i][j]) {
          count++;
          maxArea = Math.max(maxArea, bfs(i, j));
        }
      }
    }

    System.out.println(count);
    System.out.println(maxArea);
  }

  private static int bfs(int r, int c) {
    Queue<Pos> q = new LinkedList<>();
    int area = 0;

    q.add(new Pos(r, c));
    visited[r][c] = true;
    area++;

    while (!q.isEmpty()) {
      Pos pos = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = pos.x + dx[i];
        int ny = pos.y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (map[nx][ny] == 1 && !visited[nx][ny]) {
            q.add(new Pos(nx, ny));
            visited[nx][ny] = true;
            area++;
          }
        }
      }
    }

    return area;
  }
}