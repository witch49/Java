package day190415.ex03;

import java.io.FileReader;
import java.util.*;

public class WordCount {
	public static void main(String[] args) throws Exception {
		FileReader txt = new FileReader("D:/workspace/eclipse/practice/src/day190415/ex03/ex03.txt");

		int readCharNo;
		char[] cbuf = new char[10000];
		List<String> list = new ArrayList<>();
		List<Integer> listCnt = new ArrayList<>();
		Map<String, Integer> hashMap = new HashMap<>();

		String data = "";
		while ((readCharNo = txt.read(cbuf)) != -1) {
			data = new String(cbuf, 0, readCharNo);
		}

		StringTokenizer st = new StringTokenizer(data, ",| |.");

		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		for (int i = 0; i < list.size(); i++) {
			int cnt = 1;
			for (int k = i + 1; k < list.size() - 1; k++) {
				if (list.get(i).contains(list.get(k))) {
					cnt++;
				}
			}
			listCnt.add(cnt);
		}

		for (int i = 0; i < list.size(); i++) {
			for (int k = i + 1; k < list.size() - 1; k++) {
				if (!hashMap.containsKey(list.get(i)))
					hashMap.put(list.get(i), listCnt.get(i));
			}
		}

		Iterator it = sortByValue(hashMap).iterator();
		int count = 0;
		while (it.hasNext()) {
			String key = (String) it.next();
			Integer value = hashMap.get(key);
			System.out.println(key + " " + value);
			if(count++ == 10)
				break;
		}

		txt.close();
	}

	public static List<Integer> sortByValue(final Map map) {
		List<Integer> list = new ArrayList<>();
		list.addAll(map.keySet());

		Collections.sort(list, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Object v1 = map.get(o1);
				Object v2 = map.get(o2);

				return ((Comparable) v2).compareTo(v1);
			}
		});
		return list;
	}
}
