import java.util.*;
import java.io.*;

public class S1309성적평가 {
  static class Jumsu implements Comparable<Jumsu> {
    int idx, score;

    Jumsu(int idx, int score) {
      this.idx = idx;
      this.score = score;
    }

    @Override
    public int compareTo(Jumsu o) {
      return o.score - this.score; // 내림차순
    }
  }

  public static void main(String args[]) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    // 입력
    int N = Integer.parseInt(br.readLine()); // 참가자의 수
    Jumsu[] jumsu = new Jumsu[N]; // 각 참가자의 대회 점수
    int[] sum = new int[N]; // 대회 총점수

    for (int i = 0; i < 4; i++) {
      String[] str = new String[N]; // 한줄씩 점수 입력 받기
      if (i < 3)
        str = br.readLine().split(" ");

      for (int j = 0; j < N; j++) {
        int num;

        if (i < 3) {
          num = Integer.parseInt(str[j]);
          sum[j] += num;
        } else
          num = sum[j];

        jumsu[j] = new Jumsu(j, num); // 점수, 참가자 순서
      }

      // 처리
      Arrays.sort(jumsu); // 점수를 내림차순 정렬

      int[] result = new int[N];
      int rank = 1;
      int cnt = 1; // 같은 점수 개수
      result[jumsu[0].idx] = rank;

      for (int j = 1; j < N; j++) {
        if (jumsu[j - 1].score == jumsu[j].score) {
          result[jumsu[j].idx] = rank;
          cnt++;
        } else {
          rank += cnt;
          result[jumsu[j].idx] = rank;
          cnt = 1;
        }
      }

      for (int res : result) {
        sb.append(res + " ");
      }
      sb.append('\n');
    }

    // 출력
    System.out.print(sb);
  }
}