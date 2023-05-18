import java.io.*;
import java.util.*;

public class B20058마법사상어와파이어스톰 {
  static int[] dx = { 0, 1, 0, -1 }; // ← ↓ → ↑
  static int[] dy = { -1, 0, 1, 0 };
  static int N, Q, L[], map[][], iceberg, total;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = (int) Math.pow(2, Integer.parseInt(st.nextToken())); // 2^N 맵크기
    Q = Integer.parseInt(st.nextToken()); // 마법 시전 횟수
    L = new int[Q]; // 마법사 상어가 시전한 단계
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < Q; i++) {
      L[i] = Integer.parseInt(st.nextToken());
    }

    // 처리
    for (int i = 0; i < Q; i++) {
      map = rotation(L[i]); // 회전하기
      melt(); // 얼음 녹이기
    }

    // 남아있는 얼음 중 가장 큰 덩어리 차지하는 칸 개수
    bfs();

    System.out.println(total);
    System.out.println(iceberg);

  }

  private static int[][] rotation(int L) {
    int[][] temp = new int[N][N];
    L = (int) Math.pow(2, L);
    // L크기만큼 분리
    for (int i = 0; i < N; i += L) {
      for (int j = 0; j < N; j += L) {
        // 사각형 내 회전
        for (int a = 0; a < L; a++) {
          for (int b = 0; b < L; b++) {
            temp[i + a][j + b] = map[i + L - 1 - b][j + a];
          }
        }
      }
    }
    return temp;
  }

  private static void melt() {
    LinkedList<int[]> temp = new LinkedList<>();
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        int cnt = 0;
        if (map[i][j] == 0)
          continue;
        for (int d = 0; d < 4; d++) {
          int nx = i + dx[d];
          int ny = j + dy[d];
          if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > 0) {
            cnt++;
          }
        }
        if (cnt < 3)
          temp.add(new int[] { i, j });
      }
    }

    while (!temp.isEmpty()) {
      int[] t = temp.poll();
      int x = t[0], y = t[1];
      map[x][y] -= 1;
    }
  }

  private static void bfs() {
    Queue<int[]> q = new LinkedList<>();
    boolean[][] visit = new boolean[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        total += map[i][j];
        if (map[i][j] == 0 || visit[i][j])
          continue;
        q.add(new int[] { i, j });
        visit[i][j] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
          int[] t = q.poll();
          for (int d = 0; d < 4; d++) {
            int nx = t[0] + dx[d];
            int ny = t[1] + dy[d];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > 0) {
              if (map[nx][ny] > 0 && !visit[nx][ny]) {
                visit[nx][ny] = true;
                q.add(new int[] { nx, ny });
                cnt++;
              }
            }
          }
          iceberg = Math.max(iceberg, cnt);
        }

      }
    }
  }

}