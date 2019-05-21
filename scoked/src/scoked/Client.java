package scoked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 客户端
 */

public class Client {
	
	public static void main(String[] args) {
		//1.创建一个Socket，指定服务器地址和端口
		try {
			Socket socket = new Socket("localhost",8888);
			//2.获取输入流，向服务端发送信息
			OutputStream os= socket.getOutputStream();//字节输出流
			PrintWriter pw = new PrintWriter(os);//将输出流包装为打印流
			pw.write("用户名:Admin;密码：123");
			pw.flush();
			socket.shutdownOutput();//关闭输出流
			
			
			//3.获取输入流，读取服务器端的响应内容
			InputStream is = socket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String info=null;;
			while((info=br.readLine())!=null) {//循环读取
				System.out.println("我是客户端，，服务器说： "+info);
				
			}
			
			//4.关闭其他的资源
			is.close();
			br.close();
			pw.close();
			os.close();
			socket.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
