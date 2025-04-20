import java.util.*;

class Solution {
	static Map<String, Integer> map = new HashMap<>();
	static List<Integer> list = new ArrayList<>();
	static int today_yy;
	static int today_mm;
	static int today_dd;

	public int[] solution(String today, String[] terms, String[] privacies) {
		int[] answer = {};
		StringTokenizer st = new StringTokenizer(today, ".");

		today_yy = Integer.parseInt(st.nextToken());
		today_mm = Integer.parseInt(st.nextToken());
		today_dd = Integer.parseInt(st.nextToken());

		for (String term : terms) {
			String[] split = term.split(" ");
			map.put(split[0], Integer.parseInt(split[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			String[] privacie = privacies[i].split(" ");
			st = new StringTokenizer(privacie[0], ".");
			int yy = Integer.parseInt(st.nextToken());
			int mm = Integer.parseInt(st.nextToken());
			int dd = Integer.parseInt(st.nextToken());
			int expire = map.get(privacie[1]);

			mm = mm + expire;
			if (mm > 12 &&  mm / 12 >= 1) {
				yy += mm / 12;
				mm %= 12;
			} 
            if(mm == 0) {
                yy--;
                mm = 12;
            }
            

			dd = dd - 1;
			if (dd == 0) {
				dd = 28;
				if (mm == 1) {
					yy--;
					mm = 12;
				} else {
					mm--;
				}
			}
            
			if (yy < today_yy) {
				list.add(i + 1);
			} else if(yy == today_yy && mm < today_mm) {
                list.add(i + 1);
            } else if(yy == today_yy && mm == today_mm && dd < today_dd){
                list.add(i + 1);
            }
		}

		return list.stream().mapToInt(Integer::intValue).toArray();
	}
}
