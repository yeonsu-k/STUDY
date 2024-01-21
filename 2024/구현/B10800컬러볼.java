import java.io.*;
import java.util.*;

/*
 * 구현
 * 정렬
 * 누적합
 */

public class B10800컬러볼 {

  static class Ball {
    int idx, color, size;

    Ball(int idx, int color, int size) {
      this.idx = idx;
      this.color = color;
      this.size = size;
    }
  }

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    Ball[] balls = new Ball[N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int color = Integer.parseInt(st.nextToken()) - 1;
      int size = Integer.parseInt(st.nextToken());
      balls[i] = new Ball(i, color, size);
    }

    // 사이즈 크기로 정렬
    Arrays.sort(balls, (o1, o2) -> {
      if (o1.size == o2.size)
        return o1.color - o2.color;
      return o1.size - o2.size;
    });

    int total = 0; // 사이즈 누적합
    int[] colorSum = new int[N]; // 색상별 합
    int[] sizeSum = new int[2001]; // 사이즈별 합
    int[] result = new int[N];

    for (int i = 0; i < N; i++) {
      int idx = balls[i].idx;
      int color = balls[i].color;
      int size = balls[i].size;

      // 이전 공과 색상과 사이즈가 일치하면 이전과 같은 누적합으로 저장
      if (i != 0 && color == balls[i - 1].color && size == balls[i - 1].size) {
        result[idx] = result[balls[i - 1].idx];
      } else {
        result[idx] = total - colorSum[color] - sizeSum[size];
      }

      total += size;
      colorSum[color] += size;
      sizeSum[size] += size;
    }

    for (int res : result) {
      sb.append(res).append('\n');
    }

    System.out.print(sb.toString().trim());
  }
}
