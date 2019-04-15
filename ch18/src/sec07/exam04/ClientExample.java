package sec07.exam04;

import java.io.*;
import java.net.*;

/* 데이터 보내고 받기 */
public class ClientExample {
	public static void main(String[] args) {
		Socket socket = null;

		try {
			socket = new Socket(); // 소켓 생성
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 8080)); // 연결 요청
			System.out.println("[연결 성공]");

			byte[] bytes = null;
			String message = null;

			/* 1) 클라이언트가 먼저 Hello Server를 서버로 보냄 */
			OutputStream os = socket.getOutputStream();
			message = "Hello Server";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 보내기 성공]");

			/* 4) 클라이언트가 데이터를 받음 */
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[데이터 받기 성공]: " + message);

			os.close();
			is.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!socket.isClosed()) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
