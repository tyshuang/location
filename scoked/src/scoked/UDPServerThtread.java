package scoked;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class UDPServerThtread extends Thread{
	
	DatagramPacket dp;
	byte[] data;
	int port ;
	
	public UDPServerThtread(DatagramPacket dp,byte[] data) {
		this.dp = dp;
		this.data = data;	
	}
	
	public void run() {
		//2.创建数据报，用于接收客户端发送的信息
		System.out.println("***服务器段已经启动...正在监听客户端...***");
		//3.接受客户端发送的数据
		//此方法在接受数据报的时候会阻塞
		 //4.读取数据
		 String info = new String(data,0,dp.getLength());
		 System.out.println("我是服务器...客户端说："+info);
		 
		
		}
	}


