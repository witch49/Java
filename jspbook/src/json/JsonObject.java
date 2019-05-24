package json;

import org.json.simple.JSONObject;

public class JsonObject {
	public static void main(String[] args) {
		System.out.println("--------------------------------------------");
		System.out.println("JSON String 생성");
		JSONObject jObj = new JSONObject();
		jObj.put("name", "홍길동"); 	// String name = "홍길동";
		jObj.put("age", 40); 			// int age = 40;
		
		System.out.println(jObj.toString());

		System.out.println("--------------------------------------------");
		System.out.println("JSON String Parsing");
		try {
			int age = (Integer) jObj.get("age");	// Object 값이므로 항상 casting 해줘야함.
			String name = (String) jObj.get("name");
			System.out.println("name = " + name);
			System.out.println("age = " + age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("--------------------------------------------");

	}

}
