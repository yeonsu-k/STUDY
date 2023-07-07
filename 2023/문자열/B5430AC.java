import java.io.*;
import java.util.*;

public class B5430AC {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      char[] cmd = br.readLine().toCharArray(); // 명령어
      int N = Integer.parseInt(br.readLine()); // 정수 배열 수
      Deque<Integer> que = new ArrayDeque<>(N);

      StringTokenizer st = new StringTokenizer(br.readLine(), "[],"); // 정수 배열
      while (st.hasMoreTokens())
        que.add(Integer.parseInt(st.nextToken()));

      boolean rev = false, err = false;
      for (char c : cmd) {
        // 명령어 R일 경우
        if (c == 'R') {
          rev = !rev;
          continue;
        }

        // 명령어 D일 경우
        if (que.isEmpty()) {
          err = true;
          break;
        } else if (rev)
          que.pollLast();
        else
          que.pollFirst();
      }

      if (err) {
        sb.append("error\n");
      } else {
        sb.append('[');
        while (que.size() > 1) {
          if (rev) {
            sb.append(que.pollLast());
          } else {
            sb.append(que.poll());
          }
          sb.append(',');
        }
        if (que.size() == 1) {
          sb.append(que.poll());
        }
        sb.append("]\n");
      }

    }

    System.out.print(sb);
    br.close();
  }
}