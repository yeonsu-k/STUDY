import java.io.*;

// 카운팅 정렬(counting sort)

public class B10989수정렬하기 {

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int[] cnt = new int[10001];
    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      // 해당 인덱스의 값을 1 증가
      cnt[Integer.parseInt(br.readLine())]++;
    }

    for (int i = 1; i < 10001; i++) {
      // i 값이 개수가 0 이 될 때 까지 출력 (빈도수를 의미)
      while (cnt[i] > 0) {
        sb.append(i).append('\n');
        cnt[i]--;
      }
    }
    System.out.print(sb);
  }
}