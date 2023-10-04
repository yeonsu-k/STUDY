import java.util.*;

class P72412순위검색 {
  static Map<String, List<Integer>> map;

  public int[] solution(String[] info, String[] query) {
    // 코딩 테스트 참여 개발 언어 : cpp, java, python
    // 직군 : backend, fronted
    // 경력 : junior, senior
    // 선호 소울푸드 : chicken, pizza

    int[] answer = new int[query.length];
    map = new HashMap<>();
    Arrays.sort(info);

    for (String s : info) {
      makeKey(s.split(" "), 0, ""); // 가능한 모든 경우의 수 조합에 점수 넣기
    }

    // map에 저장된 점수 list를 오름차순으로 정렬
    for (String key : map.keySet()) {
      Collections.sort(map.get(key));
    }

    for (int i = 0; i < query.length; i++) {
      query[i] = query[i].replaceAll(" and ", "");
      String[] q = query[i].split(" "); // [javabackendjuniorpizza, 100] 형식
      answer[i] = map.containsKey(q[0]) ? search(q[0], Integer.parseInt(q[1])) : 0;
    }

    return answer;
  }

  static int search(String key, int score) {
    List<Integer> scoreList = map.get(key);
    int start = 0, end = scoreList.size() - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (scoreList.get(mid) < score) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return scoreList.size() - start;
  }

  static void makeKey(String[] info, int cnt, String key) {
    if (cnt == 4) {
      map.computeIfAbsent(key, v -> new ArrayList<Integer>()).add(Integer.parseInt(info[4]));
      return;
    }

    makeKey(info, cnt + 1, key + "-");
    makeKey(info, cnt + 1, key + info[cnt]);
  }
}