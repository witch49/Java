package json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonArray {
	public static void main(String[] args) {
		// JSON DATA는 가장 아래 단계에서부터 만들어나간다.
		System.out.println("--------------------------------------------");
		System.out.println("JSON String 생성");
		JSONObject jObj = new JSONObject();
		JSONArray jArray = new JSONArray();
		
		JSONObject school = new JSONObject();
		school.put("subject", "math");
		jArray.add(school);
		
		school = new JSONObject();	// 새로운 값 넣을 때마다 새로 선언
		school.put("subject", "국어");
		jArray.add(school);
		
		jObj.put("school", jArray);
		System.out.println(jObj.toString());

		System.out.println("--------------------------------------------");
		System.out.println("JSON String Parsing");
		try {
			JSONArray returnSchool = (JSONArray) jObj.get("school");
			System.out.println("size = " + returnSchool.size());
			for (int i = 0; i < returnSchool.size(); i++) {
				JSONObject returnSubject = (JSONObject) returnSchool.get(i);
				System.out.println("subject : " + returnSubject.get("subject"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------");
	}

}
