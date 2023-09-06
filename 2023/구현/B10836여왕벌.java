import java.io.*;
import java.util.*;

public class B10836여왕벌 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken()); // 가로 세로 크기
    int N = Integer.parseInt(st.nextToken()); // 날짜 수

    int index = 2 * M - 1;
    int[] arr = new int[index]; // 한줄 배열로 입력받기
    int zero, one; // 0, 1 개수
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      zero = Integer.parseInt(st.nextToken());
      one = Integer.parseInt(st.nextToken());

      int temp = zero + one;
      for (int j = zero; j < temp; j++) { // 1 증가 범위 = 0의 개수 ~ (0의 개수 + 1의 개수)
        arr[j] += 1;
      }
      for (int j = temp; j < index; j++) { // 2 증가 범위 = (0의 개수 + 1의 개수)의 개수 ~ index
        arr[j] += 2;
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = M - 1; i >= 0; i--) {
      sb.append(arr[i] + 1).append(' ');
      for (int j = M; j < index; j++) {
        sb.append(arr[j] + 1).append(' ');
      }
      sb.append('\n');
    }

    System.out.print(sb);
  }

}