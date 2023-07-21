import java.io.*;
import java.util.*;

public class B17070파이브옮기기1 {
  static int[] dy = { 0, 1, 1 }; // 가로(0) ,세로(1), 대각선(2)
  static int[] dx = { 1, 0, 1 };
  static int N, map[][], cnt[][];

  static class Pipe {
    int y, x, dir;

    Pipe(int y, int x, int dir) {
      this.y = y;
      this.x = x;
      this.dir = dir;
    }
  }

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    N = Integer.parseInt(br.readLine());
    cnt = new int[N][N]; // 파이프 놓을 수 있는 경우의 수
    map = new int[N][N]; // 지도
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 처리
    if (map[N - 1][N - 1] != 1)
      BFS();

    // 결과
    System.out.print(cnt[N - 1][N - 1]);
  }

  private static void BFS() {
    Queue<Pipe> que = new LinkedList<>();
    que.add(new Pipe(0, 1, 0));

    while (!que.isEmpty()) {
      Pipe pipe = que.poll();
      for (int i = 0; i < 3; i++) {
        // 이전 파이프가 가로 방향일 때 세로 파이프 놓기 불가
        // 이전 파이프가 세로 방향일 때 가로 파이프 놓기 불가
        if (pipe.dir == 0 && i == 1 || pipe.dir == 1 && i == 0)
          continue;

        int ny = pipe.y + dy[i];
        int nx = pipe.x + dx[i];
        if (ny < 0 || nx < 0 || ny >= N || nx >= N || map[ny][nx] == 1)
          continue;
        if (i == 2 && (map[ny - 1][nx] == 1 || map[ny][nx - 1] == 1))
          continue;

        cnt[ny][nx] += 1;
        que.add(new Pipe(ny, nx, i));
      }
    }
  }
}
