import java.io.*;

public class B1283단축키지정 {
  static boolean[] alph = new boolean[26];
  static StringBuffer sb = new StringBuffer();

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      if (firstKey(str)) continue;
      if (str.contains(" ") && wordKey(str)) continue; // 두단어 이상이면
      if (leftKey(str)) continue;
    }

    System.out.println(sb);
  }

  private static boolean firstKey(String str) {
    boolean change = false;
    char c = str.charAt(0);
    int n = ascii(c);
    if (!alph[n]) {
      alph[n] = true;
      change = true;
      sb.append("[" + c + "]").append(str.substring(1, str.length()) + "\n");
    }
    return change;
  }

  private static boolean wordKey(String str) {
    boolean change = false;
    String[] word = str.split(" ");
    for (int i = 0; i < word.length; i++) {
      char c = word[i].charAt(0);
      int n = ascii(c);
      if (!alph[n] && !change) {
        alph[n] = true;
        change = true;
        sb.append("[" + c + "]").append(word[i].substring(1, word[i].length()) + " ");
      } else {
        sb.append(word[i] + " ");
      }
    }
    sb.append("\n");
    return change;
  }

  private static boolean leftKey(String str) {
    boolean change = false;
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      int n = ascii(c);
      if (c != ' ' && !alph[n] && !change) {
        alph[n] = true;
        change = true;
        sb.append("[" + c + "]");
      } else {
        sb.append(c);
      }
    }
    sb.append("\n");
    return change;
  }

  private static int ascii(char c) {
    return c >= 'a' ? c - 'a' : c - 'A'; // 'A' 65 < 'a' 97
  }
}
