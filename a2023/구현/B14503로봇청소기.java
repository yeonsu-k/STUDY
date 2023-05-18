import java.io.*;
import java.util.*;

/**
 * 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
 * 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
 * 2-1. 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
 * 2-2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
 * 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
 * 3-1. 반시계 방향으로 90˚ 회전한다.
 * 3-2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
 * 3-3. 1번으로 돌아간다.
 * 
 * d = {0,1,2,3} : 방향 북동남서 순
 * 0 : 청소되지 않은 빈칸
 * 1 : 벽
 * 출력 : 청소하는 칸의 개수
 */
public class B14503로봇청소기 {
  static int[] dy = { -1, 0, 1, 0 }; // 북동남서
  static int[] dx = { 0, 1, 0, -1 };
  static int N, M, cnt = 2;
  static int[][] map;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    st = new StringTokenizer(br.readLine(), " ");
    int y = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 처리
    dfs(y, x, d);
    // for (int[] k : map)
    // System.out.println(Arrays.toString(k));
    System.out.println(cnt - 1);
  }

  private static void dfs(int y, int x, int dir) {
    map[y][x] = cnt;

    int temp = dir; // 방향을 임시 저장
    for (int i = 0; i < 4; i++) {
      // 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
      dir = (dir + 3) % 4;
      int ny = y + dy[dir];
      int nx = x + dx[dir];
      if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] == 0) {
        cnt++;
        dfs(ny, nx, dir);
        return;
      }
    }

    // 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
    dir = temp; // 방향 유지
    int ny = y - dy[dir];
    int nx = x - dx[dir];
    if (ny >= 0 && nx >= 0 && ny < N && nx < M && map[ny][nx] != 1) {
      dfs(ny, nx, dir);
    }
  }
}
