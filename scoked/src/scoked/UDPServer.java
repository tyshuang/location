package scoked;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/*
 * 服务器段
 * 基于UDP的客户登录
 */

public class UDPServer {
	
	public static void main(String[] args) throws IOException {
		/*
		 * 服务器端，接受的客户端的信息
		 */
		int count =0;
		int port;
		
		try {
			//1.创建服务器DatagramSocket,指定端口号
			DatagramSocket socket = new DatagramSocket(2500);
			//2.调用accept（）方法开始监听。等待客户端的链接
			System.out.println("***服务器即将启动，等待客户端的链接***");
			//循环监听，等待客户端的链接
			while(true) {			
				byte[] data = new byte[1024];
				DatagramPacket dp = new DatagramPacket(data, data.length);
				//创建新的线程，
				socket.receive(dp);
				UDPServerThtread serverThread = new UDPServerThtread(dp,data);
				//启动线程
				InetAddress address = dp.getAddress();
				 port = dp.getPort();
				 byte[] data2 = "欢迎您".getBytes();
				 DatagramPacket dp2 = new DatagramPacket(data2,data2.length,address,port);
				 socket.send(dp2);	
				 
				serverThread.start();
				
				count++;
				System.out.println("客户端的数量是： "+count);
//			port= socket.getPort();
//			System.out.println("当前客户端的IP"+port);
		
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}

}
