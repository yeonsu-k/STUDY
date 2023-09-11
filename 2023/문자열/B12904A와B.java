import java.io.*;

public class B12904A와B {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String S = br.readLine();
    StringBuilder sb = new StringBuilder(br.readLine()); // T
    int sLen = S.length();
    int tLen = sb.length();

    while (sLen != tLen) {
      if (sb.charAt(sb.length() - 1) == 'A') {
        sb.deleteCharAt(sb.length() - 1);
      } else {
        sb.deleteCharAt(sb.length() - 1);
        sb.reverse();
      }
      tLen--;
    }

    System.out.print((S.equals(sb.toString())) ? 1 : 0);
  }
}
