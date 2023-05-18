import java.io.*;
import java.util.*;

public class B22866탑보기 {

  static class Building {
    int num;
    int height;

    Building(int num, int height) {
      this.num = num;
      this.height = height;
    }
  }

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    Building[] building = new Building[N];
    int[][] gapInfo = new int[N][2]; // 가까운 건물 번호, 거리
    int[] cnt = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      building[i] = new Building(i, Integer.parseInt(st.nextToken()));
      Arrays.fill(gapInfo[i], 100001);
    }

    // 왼쪽 → 오른쪽
    Stack<Building> stack = new Stack<>();
    for (int i = 0; i < N; i++) {
      while (!stack.isEmpty() && stack.peek().height <= building[i].height) {
        stack.pop();
      }

      cnt[i] += stack.size();

      if (!stack.isEmpty()) {
        int gap = Math.abs(stack.peek().num - i);
        if (gap < gapInfo[i][1]) {
          gapInfo[i][0] = stack.peek().num;
          gapInfo[i][1] = gap;
        }
      }

      stack.push(building[i]);
    }

    // 오른쪽 → 왼쪽
    stack = new Stack<>();
    for (int i = N - 1; i >= 0; i--) {
      while (!stack.isEmpty() && stack.peek().height <= building[i].height) {
        stack.pop();
      }

      cnt[i] += stack.size();

      if (!stack.isEmpty()) {
        int gap = Math.abs(stack.peek().num - i);
        if (gap < gapInfo[i][1]) {
          gapInfo[i][0] = stack.peek().num;
          gapInfo[i][1] = gap;
        } else if (gap == gapInfo[i][1] && stack.peek().num < gapInfo[i][0]) {
          gapInfo[i][0] = stack.peek().num;
        }
      }
      stack.push(building[i]);
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      if (cnt[i] == 0)
        sb.append(0);
      else
        sb.append(cnt[i]).append(' ').append(gapInfo[i][0] + 1);
      sb.append("\n");
    }

    System.out.println(sb);
  }
}
