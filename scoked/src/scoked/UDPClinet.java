package scoked;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClinet {
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * ������Ϣ
		 */
		//1.�����ͻ�����Ϣ
		InetAddress address = InetAddress.getByName("localhost");
		int port = 2500;
		byte[] data = "�û���:Admin;���룺123".getBytes();//���ַ�ת��Ϊ�ֽ�����
		// 2.����һ�����ݱ����������͵���Ϣ
		DatagramPacket dp = new DatagramPacket(data,data.length,address,port);
		//3.����һ��DatagramSocket���󣬷�������
		DatagramSocket socket = new DatagramSocket();
		//4.��������������ݱ�
		socket.send(dp);
		
		/*
		 * ���ܷ���������Ӧ����Ϣ
		 */
		//1.���ܷ������˵���Ӧ����
		byte[] data2 = new byte[1024];
		DatagramPacket dp2 = new DatagramPacket(data2, data2.length);
		//2.��������
		socket.receive(dp2);
		//3.��ȡ�������˵���Ӧ��Ϣ
		String reply = new String(data2,0,dp2.getLength());
		System.out.println("���ǿͻ��ˡ�����������˵��"+reply);
		//4.�ر���Դ
		socket.close();
	}

}
