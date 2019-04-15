package sec07.exam03;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/* 연결 요청 */
public class ClientExample {
	public static void main(String[] args) {
		Socket socket = null;

		try {
			socket = new Socket(); // 소켓 생성
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 8080)); // 연결 요청
			System.out.println("[연결 성공]");
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
