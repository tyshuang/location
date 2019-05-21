package scoked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * 服务器线程处理类
 */

public class ServerThread extends Thread{
	//和本线程相关的Socket
	Socket socket =null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	//线程执行的操作	，响应客户端的请求
	public void run() {
		
		//3.获取一个输入流，用来读取客户信息
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream os = null;
		PrintWriter pw = null;
		try {
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			String info=null;;
			while((info=br.readLine())!=null) {//循环读取
				System.out.println("我是服务器，，客户端说： "+info);
				
			}
			socket.shutdownInput();//关闭输入流
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("欢迎您");
			pw.flush();//调用flush方法将缓冲输出
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// alt + shift + z 
		} finally {
			//5.关闭相关的资源
			try {
				if(pw != null)
					pw.close();
				if(os != null)
					os.close();
				if(br !=null)
					br.close();
				if(is !=null)
					is.close();
				if(isr != null)
					isr.close();
				if(socket != null)
					socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		
		
		
	}
	


