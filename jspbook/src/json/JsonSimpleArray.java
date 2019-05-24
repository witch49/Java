package json;

import org.json.simple.*;

public class JsonSimpleArray {
	public static void main(String[] args) {
		System.out.println("--------------------------------------------");
		System.out.println("JSON String 생성");
		JSONObject jObj = new JSONObject();
		JSONArray jArray = new JSONArray();

		// String[] subject = {"국어", "Math", "English"};
		jArray.add("국어");
		jArray.add("Math");
		jArray.add("English");
		jObj.put("subject", jArray);

		System.out.println(jObj.toString());
		System.out.println("--------------------------------------------");
		System.out.println("JSON String Parsing");
		try {
			JSONArray rSub = (JSONArray) jObj.get("subject");
			System.out.println("size = " + rSub.size());
			for (int i = 0; i < rSub.size(); i++)
				System.out.println("subject[" + i + "] : " + (String) rSub.get(i));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------");
	}

}
