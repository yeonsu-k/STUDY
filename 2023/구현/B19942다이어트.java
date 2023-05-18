import java.io.*;
import java.util.*;

public class B19942다이어트 {
  static int N, mp, mf, ms, mv, minPrice = 7501;
  static IngredientInfo[] ingredients;
  static ArrayList<Integer> answer;
  static StringBuilder sb = new StringBuilder();

  static class IngredientInfo {
    int p, f, s, v, c;

    IngredientInfo(StringTokenizer st) {
      this.p = Integer.parseInt(st.nextToken()); // 단백질
      this.f = Integer.parseInt(st.nextToken()); // 지방
      this.s = Integer.parseInt(st.nextToken()); // 탄수화물
      this.v = Integer.parseInt(st.nextToken()); // 비타민
      this.c = Integer.parseInt(st.nextToken()); // 가격
    }

  }

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    ingredients = new IngredientInfo[N];
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    mp = Integer.parseInt(st.nextToken()); // 최소 단백질
    mf = Integer.parseInt(st.nextToken()); // 최소 지방
    ms = Integer.parseInt(st.nextToken()); // 최소 탄수화물
    mv = Integer.parseInt(st.nextToken()); // 최소 비타민

    for (int i = 0; i < N; i++) {
      ingredients[i] = new IngredientInfo(new StringTokenizer(br.readLine(), " "));
    }

    nCr(0, 0, new int[N], 0, 0, 0, 0, 0);

    if (minPrice == 7501) {
      sb.append("-1");
    } else {
      sb.append(minPrice + "\n");
      for (int s : answer) {
        sb.append(s + " ");
      }
    }

    System.out.print(sb.toString());
  }

  private static void nCr(int start, int cnt, int[] per, int tp, int tf, int ts, int tv, int tc) {
    if (cnt > N)
      return;

    if (check(tp, tf, ts, tv, tc)) {
      answer = new ArrayList<>();
      minPrice = tc;
      for (int i = 0; i < cnt; i++) {
        answer.add(per[i]);
      }
      return;
    }

    for (int i = start; i < N; i++) {
      if (tc + ingredients[i].c >= minPrice)
        continue;
      per[cnt] = i + 1;
      nCr(i + 1, cnt + 1, per, tp + ingredients[i].p, tf + ingredients[i].f, ts + ingredients[i].s,
          tv + ingredients[i].v, tc + ingredients[i].c);
    }
  }

  private static boolean check(int tp, int tf, int ts, int tv, int tc) {
    return tp >= mp && tf >= mf && ts >= ms && tv >= mv && tc < minPrice;
  }
}
