package scoked;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/*
 * ��������
 * ����UDP�Ŀͻ���¼
 */

public class UDPServer {
	
	public static void main(String[] args) throws IOException {
		/*
		 * �������ˣ����ܵĿͻ��˵���Ϣ
		 */
		int count =0;
		int port;
		
		try {
			//1.����������DatagramSocket,ָ���˿ں�
			DatagramSocket socket = new DatagramSocket(2500);
			//2.����accept����������ʼ�������ȴ��ͻ��˵�����
			System.out.println("***�����������������ȴ��ͻ��˵�����***");
			//ѭ���������ȴ��ͻ��˵�����
			while(true) {			
				byte[] data = new byte[1024];
				DatagramPacket dp = new DatagramPacket(data, data.length);
				//�����µ��̣߳�
				socket.receive(dp);
				UDPServerThtread serverThread = new UDPServerThtread(dp,data);
				//�����߳�
				InetAddress address = dp.getAddress();
				 port = dp.getPort();
				 byte[] data2 = "��ӭ��".getBytes();
				 DatagramPacket dp2 = new DatagramPacket(data2,data2.length,address,port);
				 socket.send(dp2);	
				 
				serverThread.start();
				
				count++;
				System.out.println("�ͻ��˵������ǣ� "+count);
//			port= socket.getPort();
//			System.out.println("��ǰ�ͻ��˵�IP"+port);
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
