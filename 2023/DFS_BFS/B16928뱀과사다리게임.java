import java.io.*;
import java.util.*;

/**
 * B16928뱀과사다리게임
 * 너비우선탐색
 */

public class B16928뱀과사다리게임 {
  static HashMap<Integer, Integer> map;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    map = new HashMap<>();

    for (int i = 0; i < N + M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      map.put(x, y);
    }

    System.out.print(bfs());
  }

  static class Node {
    int x, cnt;

    Node(int x, int cnt) {
      this.x = x;
      this.cnt = cnt;
    }
  }

  private static int bfs() {
    Queue<Node> que = new LinkedList<>();
    HashSet<Integer> visit = new HashSet<>();
    que.add(new Node(1, 0)); // 시작 위치, 이동 횟수
    visit.add(1);

    while (!que.isEmpty()) {
      Node pos = que.poll();
      for (int i = 1; i <= 6; i++) {
        int nx = pos.x + i;

        if (nx == 100)
          return pos.cnt + 1;

        if (nx > 100 || visit.contains(nx))
          continue;

        visit.add(nx);
        if (map.containsKey(nx)) // 사다리 또는 뱀을 만나면
          nx = map.get(nx);

        que.add(new Node(nx, (pos.cnt + 1)));
      }

    }
    return 0;
  }
}
