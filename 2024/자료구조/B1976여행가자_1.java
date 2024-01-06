import java.io.*;
import java.util.*;

/*
 * 그래프
 * BFS
 */

public class B1976여행가자_1 {
  static int N, M;
  static boolean[][] map;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    map = new boolean[N][N];

    // 방문 가능한 도시 입력 받기
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        if ((str.charAt(2 * j) - '0') == 1) {
          map[i][j] = true;
        }
      }
    }

    // 여행 가능 여부 확인
    boolean check = true;
    StringTokenizer st = new StringTokenizer(br.readLine());
    int now = Integer.parseInt(st.nextToken()) - 1;
    for (int i = 1; i < M; i++) {
      int next = Integer.parseInt(st.nextToken()) - 1;
      if (!BFS(now, next)) {
        check = false;
        break;
      }
      now = next;
    }

    System.out.print(check ? "YES" : "NO");
  }

  private static boolean BFS(int now, int next) {
    if (now == next)
      return true;

    Queue<Integer> que = new LinkedList<>();
    boolean[] visited = new boolean[N];
    que.add(now);
    visited[now] = true;

    while (!que.isEmpty()) {
      int city = que.poll();
      for (int i = 0; i < N; i++) {
        if (i == next && map[city][i])
          return true;

        if (map[city][i] && !visited[i]) {
          que.add(i);
          visited[i] = true;
        }
      }
    }

    return false;
  }
}
