package scoked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����TCPЭ���SocketͨѶ��ʵ���û���¼
 * ��������
 */

public class Server {
	
	public static void main(String[] args) {
		//1.����һ����������Socket,ָ���󶨶˿ڣ��������ζ˿�
		try {
			ServerSocket ss = new ServerSocket(8888);
			Socket socket = null;
			//��¼�ͻ�������
			int count = 0;
			//2.����accept����������ʼ�������ȴ��ͻ��˵�����
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			//ѭ���������ȴ��ͻ��˵�����
			while(true) {
				socket = ss.accept();//������ʱ����������״̬
				//�����µ��̣߳�
				ServerThread serverThread = new ServerThread(socket);
				//�����߳�
				serverThread.start();
				
				count++;
				System.out.println("�ͻ��˵������ǣ� "+count);
				InetAddress add= socket.getInetAddress();
				System.out.println("��ǰ�ͻ��˵�IP"+add.getHostName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
