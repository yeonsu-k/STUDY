import java.io.*;
import java.util.*;

public class B14499주사위굴리기 {
  static int[] dx = { 0, 0, -1, 1 }; // 동 서 북 남
  static int[] dy = { 1, -1, 0, 0 };
  static int[] dice = { 0, 0, 0, 0, 0, 0 }; // 주사위 - 위 뒤 오 왼 앞 밑
  static int N, M, x, y, K, map[][], cmd[];
  static int[][] dir = {
      { 0, 2, 5, 3 }, // 동
      { 0, 3, 5, 2 }, // 서
      { 0, 1, 5, 4 }, // 북
      { 0, 4, 5, 1 } }; // 남
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    x = Integer.parseInt(st.nextToken());
    y = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    map = new int[N][M];
    cmd = new int[K];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < K; i++) {
      cmd[i] = Integer.parseInt(st.nextToken());
    }

    // 처리
    for (int i = 0; i < K; i++) {
      int move = cmd[i] - 1;
      int nx = x + dx[move];
      int ny = y + dy[move];
      if (nx < 0 || nx >= N || ny < 0 || ny >= M)
        continue;
      x = nx;
      y = ny;

      diceUpdate(move);

      sb.append(dice[0]).append("\n");
    }

    // 출력
    System.out.print(sb.toString());
  }

  private static void diceUpdate(int move) {
    int temp = dice[dir[move][0]];
    dice[dir[move][0]] = dice[dir[move][1]];
    dice[dir[move][1]] = dice[dir[move][2]];
    dice[dir[move][2]] = dice[dir[move][3]];
    dice[dir[move][3]] = temp;

    if (map[x][y] != 0) {
      dice[5] = map[x][y];
      map[x][y] = 0;
    } else
      map[x][y] = dice[5];
  }
}
