import java.io.*;
import java.util.*;

public class B마법사상어와비바라기 {
  static class Pos {
    int y, x;
    Pos(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 }; // ←, ↖, ↑, ↗, →, ↘, ↓, ↙
    int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[][] map = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 처리(구름 이동, 방향 입력 받으면서)
    LinkedList<Pos> cloud = new LinkedList<>();
    LinkedList<Pos> rain = new LinkedList<>();
    cloud.add(new Pos(N - 1, 0));
    cloud.add(new Pos(N - 1, 1));
    cloud.add(new Pos(N - 2, 0));
    cloud.add(new Pos(N - 2, 1));
    for (int i = 0; i < M; i++) {
      boolean[][] visit = new boolean[N][N];
      st = new StringTokenizer(br.readLine(), " ");
      int d = Integer.parseInt(st.nextToken()) - 1; // 방향
      int s = Integer.parseInt(st.nextToken()) % N; // 이동
      while (!cloud.isEmpty()) {
        Pos pos = cloud.poll();
        int ny = (pos.y + (dy[d] * s) + N) % N, nx = (pos.x + (dx[d] * s) + N) % N; // 구름이 맵 밖으로 나가는지 체크
        visit[ny][nx] = true;
        map[ny][nx] += 1;
        rain.add(new Pos(ny, nx));
      }

      // 4. 물복사마법
      while (!rain.isEmpty()) {
        Pos pos = rain.poll();
        int cnt = 0;
        for (int t = 1; t < 8; t += 2) {
          int ny = pos.y + dy[t], nx = pos.x + dx[t];
          if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 0) continue;
          cnt++;
        }
        map[pos.y][pos.x] += cnt;
      }
      
      // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (map[j][k] >= 2 && !visit[j][k]) {
            map[j][k] -= 2;
            cloud.add(new Pos(j, k));
          }
        }
      }
    }

    int sum = 0;
    for (int[] m : map) {
      for (int s : m) {
        sum += s;
      }
    }
    System.out.print(sum);
  }
}
