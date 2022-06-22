package A17836공주님을구해라;

import java.io.*;
import java.util.*;

public class Main {
  static int[] dx = { -1, 0, 1, 0 }; // 상우하좌
  static int[] dy = { 0, 1, 0, -1 };
  static int N, M, T, minTime;
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
    System.setIn(new FileInputStream("A17836공주님을구해라/input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken()); // 세로크기
    M = Integer.parseInt(st.nextToken()); // 가로크기
    T = Integer.parseInt(st.nextToken()); // 제한시간
    map = new int[N][M]; // 성크기
    visited = new boolean[N][M];
    minTime = 10001; // 최단시간

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        if (map[i][j] == 0 && !visited[i][j]) {
          minTime = Math.min(minTime, bfs(i, j));
        }
      }
    }
    
    System.out.println(minTime);
  }

  private static int bfs(int r,int c) {
    Queue<Pos> q = new LinkedList<>();
    int time = 0;
    
    q.add(new Pos(r, c));
    visited[r][c] = true;
    time++;

    // 0 : 빈공간 , 1: 벽, 2: 그람(벽을 부술 수 있는 검)
    while (q.isEmpty()) {
      //if (time == minTime && time == T) break;
      Pos pos = q.poll();
      for (int i = 0; i < 4; i++) {
        int nx = pos.x + dx[i];
        int ny = pos.y + dy[i];
        if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
          if (map[nx][ny] == 0 && !visited[nx][ny]) {
            q.add(new Pos(nx, ny));
            visited[nx][ny] = true;
            time++;
            System.out.println();
          }
        }
      }
    }
    
    return time;
  }
}
