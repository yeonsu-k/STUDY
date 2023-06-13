import java.io.*;
import java.util.*;

/* 
 * 방향성 없는 그래프 
 * 연결된 정점 그룹의 개수
 * 속도 차이 : DFS > BFS 
 */

public class B11724연결요소의개수 {
  static int N, M;
  static ArrayList<Integer> list[];
  static boolean visited[];

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    list = new ArrayList[N + 1];
    for (int i = 1; i <= N; i++) {
      list[i] = new ArrayList<Integer>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());
      list[s].add(e);
      list[e].add(s);
    }

    int count = 0;
    visited = new boolean[N + 1];
    for (int i = 1; i <= N; i++) {
      if (visited[i])
        continue;
      DFS(i);
      // BFS(i);
      count++;
    }
    System.out.print(count);
  }

  private static void DFS(int i) {
    visited[i] = true;
    for (int n : list[i]) {
      if (visited[n])
        continue;
      DFS(n);
    }
  }

  private static void BFS(int i) {
    Queue<Integer> que = new LinkedList<>();
    que.offer(i);
    visited[i] = true;

    while (!que.isEmpty()) {
      int temp = que.poll();
      for (int num : list[temp]) {
        if (visited[num])
          continue;
        que.add(num);
        visited[num] = true;
      }
    }
  }

}
