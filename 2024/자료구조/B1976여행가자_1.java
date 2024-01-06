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
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    map = new boolean[N][N];
    int[] plan = new int[M];

    // 방문 가능한 도시 입력 받기
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        if (Integer.parseInt(st.nextToken()) == 1) {
          map[i][j] = true;
        }
      }
    }

    // 여행 계획 입력 받기
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      plan[i] = Integer.parseInt(st.nextToken()) - 1;
    }

    // 처리
    boolean check = true;
    for (int i = 0; i < M - 1; i++) {
      if (!BFS(plan[i], plan[i + 1])) {
        check = false;
        break;
      }
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
