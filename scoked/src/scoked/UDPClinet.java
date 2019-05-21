package scoked;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class UDPClinet {
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * 发送信息
		 */
		//1.创建客户端信息
		InetAddress address = InetAddress.getByName("localhost");
		int port = 2500;
		byte[] data = "用户名:Admin;密码：123".getBytes();//把字符转换为字节数组
		// 2.创建一个数据报，包含发送的信息
		DatagramPacket dp = new DatagramPacket(data,data.length,address,port);
		//3.创建一个DatagramSocket对象，发送数据
		DatagramSocket socket = new DatagramSocket();
		//4.向服务器发送数据报
		socket.send(dp);
		
		/*
		 * 接受服务器端响应的信息
		 */
		//1.接受服务器端的响应数据
		byte[] data2 = new byte[1024];
		DatagramPacket dp2 = new DatagramPacket(data2, data2.length);
		//2.接受数据
		socket.receive(dp2);
		//3.读取服务器端的响应信息
		String reply = new String(data2,0,dp2.getLength());
		System.out.println("我是客户端。。。服务器说："+reply);
		//4.关闭资源
		socket.close();
	}

}
