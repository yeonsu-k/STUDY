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
      for (int j = 0; j < M; j++) map[i][j] = Integer.parseInt(st.nextToken());
    }

    bfs();

    System.out.println(minTime > T ? "Fail" : minTime);
  }

  private static void bfs() {
    Queue<Pos> q = new LinkedList<>();
    int time = -1;
    int size = 0;
    
    q.add(new Pos(0,0));
    visited[0][0] = true;

    // 0 : 빈공간 , 1: 벽, 2: 그람(벽을 부술 수 있는 검)
    while (!q.isEmpty()) {
      time++;
      size = q.size();

      for (int i = 0; i < size; i++) {
        Pos pos = q.poll();

        if (map[pos.x][pos.y] == 2) { // 검이 있는 자리라면
          minTime = time + N - 1 - pos.x + M - 1 - pos.y; // 지금까지의 시간 + 두점사이의 거리 구하기
          continue;
        } 
        else if (pos.x == N - 1 && pos.y == M - 1) { // 최종까지 도착했다면
          minTime = Math.min(minTime, time);
          return;
        }

        for (int j = 0; j < 4; j++) {
          int nx = pos.x + dx[j];
          int ny = pos.y + dy[j];
          if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
            if (map[nx][ny] != 1 && !visited[nx][ny]) {
              q.add(new Pos(nx, ny));
              visited[nx][ny] = true;
            }
          }
        }
        
      }
    }
  }
}
