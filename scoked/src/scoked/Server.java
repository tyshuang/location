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
 * 基于TCP协议的Socket通讯，实现用户登录
 * 服务器段
 */

public class Server {
	
	public static void main(String[] args) {
		//1.创建一个服务器端Socket,指定绑定端口，并监听次端口
		try {
			ServerSocket ss = new ServerSocket(8888);
			Socket socket = null;
			//记录客户端熟练
			int count = 0;
			//2.调用accept（）方法开始监听。等待客户端的链接
			System.out.println("***服务器即将启动，等待客户端的链接***");
			//循环监听，等待客户端的链接
			while(true) {
				socket = ss.accept();//监听的时候处于阻塞的状态
				//创建新的线程，
				ServerThread serverThread = new ServerThread(socket);
				//启动线程
				serverThread.start();
				
				count++;
				System.out.println("客户端的数量是： "+count);
				InetAddress add= socket.getInetAddress();
				System.out.println("当前客户端的IP"+add.getHostName());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
