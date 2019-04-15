package sec07.exam04;

import java.io.*;
import java.net.*;

/* 데이터 받고 보내기*/
public class ServerExample {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// ServerSocket 생성
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 8080));

			while (true) {
				System.out.println(" [연결 기다림] ");
				Socket socket = serverSocket.accept(); // 클라이언트 연결 수락
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함] " + isa.getHostName());

				byte[] bytes = null;
				String message = null;

				/* 2) 서버가 데이터를 받음 */
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("[데이터 받기 성공]: " + message);

				/* 3) Hello Client를 클라이언트로 보냄 */
				OutputStream os = socket.getOutputStream();
				message = "Hello Client!";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");

				is.close();
				os.close();
				socket.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
