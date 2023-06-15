import java.io.*;
import java.util.*;

public class B9019DSLR {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      sb.append(BFS(A, B)).append('\n');
    }

    System.out.print(sb);
  }

  private static String BFS(int a, int b) {
    Queue<Integer> que = new LinkedList<>();
    char[] command = new char[10000]; // 명령어 저장
    int[] from = new int[10000]; // 경로 저장
    que.offer(a);

    while (!que.isEmpty()) {
      int now = que.poll();
      for (int i = 0; i < 4; i++) {
        int nx = calcN(i, now);
        if (command[nx] == 0) {
          command[nx] = i == 0 ? 'D' : i == 1 ? 'S' : i == 2 ? 'L' : 'R';
          from[nx] = now;
          que.add(nx);
        }
        if (nx == b) {
          StringBuilder sb = new StringBuilder();
          int temp = b;
          while (temp != a) {
            sb.append(command[temp]);
            temp = from[temp];
          }
          return sb.reverse().toString();
        }
      }
    }

    return null;
  }

  private static int calcN(int i, int now) {
    if (i == 0)
      return (2 * now) % 10000;
    if (i == 1)
      return (now == 0) ? 9999 : now - 1;
    if (i == 2)
      return (now % 1000) * 10 + now / 1000;
    return (now % 10) * 1000 + now / 10;
  }
}
