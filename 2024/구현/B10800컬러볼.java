import java.io.*;
import java.util.*;

/*
 * 구현
 * 정렬
 * 누적합
 */

public class B10800컬러볼 {

  static class Ball implements Comparable<Ball> {
    int idx, color, size;

    Ball(int idx, int color, int size) {
      this.idx = idx;
      this.color = color;
      this.size = size;
    }

    @Override
    public int compareTo(Ball o) {
      return this.size - o.size;
    }
  }

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    ArrayList<Ball> balls = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int color = Integer.parseInt(st.nextToken()) - 1;
      int size = Integer.parseInt(st.nextToken());
      balls.add(new Ball(i, color, size));
    }

    // 사이즈 크기로 정렬
    Collections.sort(balls);

    int total = 0; // 사이즈 누적합
    int beforeIdx = 0; // 탐색하는 사이즈 이전 ball
    int[] colorSum = new int[N]; // 색상별 합
    int[] result = new int[N];

    for (int i = 0; i < N; i++) {
      Ball now = balls.get(i);
      Ball before = balls.get(beforeIdx);

      while (before.size < now.size) {
        total += before.size;
        colorSum[before.color] += before.size;
        before = balls.get(++beforeIdx);
      }
      result[now.idx] = total - colorSum[now.color];
    }

    for (int res : result) {
      sb.append(res).append('\n');
    }

    System.out.print(sb);
  }
}
