import java.io.*;
import java.util.*;

public class B9081단어맞추기 {

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 0; t < T; t++) {
      char[] word = br.readLine().toCharArray();
      int index = -1, index2 = 0;

      for (int i = word.length - 1; i >= 1; i--) {
        if (word[i] > word[i - 1]) {
          index = i - 1;
          break;
        }
      }

      if (index == -1)
        sb.append(String.valueOf(word)).append("\n");
      else {
        for (int i = word.length - 1; i >= 0; i--) {
          if (word[i] > word[index]) {
            index2 = i;
            break;
          }
        }

        char temp = word[index];
        word[index] = word[index2];
        word[index2] = temp;

        Arrays.sort(word, index + 1, word.length);

        sb.append(String.valueOf(word)).append("\n");
      }

    }

    System.out.println(sb);
  }
}
