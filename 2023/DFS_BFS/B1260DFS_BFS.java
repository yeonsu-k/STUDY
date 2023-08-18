import java.io.*;
import java.util.*;

public class B1260DFS_BFS {
  static StringBuilder sb = new StringBuilder();
  static int N, M, V;
  static boolean[] check;
  static int[][] arr;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken()); // 정점 수
    M = Integer.parseInt(st.nextToken()); // 간선 수
    V = Integer.parseInt(st.nextToken()); // 탐색 시작 번호
    arr = new int[N + 1][N + 1];
    check = new boolean[N + 1];

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      arr[x][y] = arr[y][x] = 1;
    }

    dfs(V);
    sb.append("\n");
    check = new boolean[N + 1];
    bfs(V);

    System.out.println(sb);
  }

  private static void dfs(int start) {
    check[start] = true;
    sb.append(start + " ");

    for (int i = 0; i <= N; i++) {
      if (arr[start][i] == 1 && !check[i])
        dfs(i);
    }
  }

  private static void bfs(int start) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    check[start] = true;
    while (!q.isEmpty()) {
      start = q.poll();
      sb.append(start + " ");

      for (int i = 1; i <= N; i++) {
        if (arr[start][i] == 1 && !check[i]) {
          q.add(i);
          check[i] = true;
        }
      }
    }

  }
}
