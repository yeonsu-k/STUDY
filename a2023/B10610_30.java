import java.io.*;
import java.util.*;

public class B10610_30 {
  static String result = "-1";

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    String str = br.readLine();
    if (str.contains("0")) {
      char[] num = str.toCharArray();
      Arrays.sort(num);
      int sum = 0;
      for (int i = num.length - 1; i >= 0; i--) {
        sum += num[i];
        sb.append(num[i]);
      }
      if (sum % 3 == 0)
        result = sb.toString();
    }

    System.out.println(result);
  }
}