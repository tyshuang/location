package scoked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * �������̴߳�����
 */

public class ServerThread extends Thread{
	//�ͱ��߳���ص�Socket
	Socket socket =null;
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	//�߳�ִ�еĲ���	����Ӧ�ͻ��˵�����
	public void run() {
		
		//3.��ȡһ����������������ȡ�ͻ���Ϣ
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
			while((info=br.readLine())!=null) {//ѭ����ȡ
				System.out.println("���Ƿ����������ͻ���˵�� "+info);
				
			}
			socket.shutdownInput();//�ر�������
			os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write("��ӭ��");
			pw.flush();//����flush�������������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();// alt + shift + z 
		} finally {
			//5.�ر���ص���Դ
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
	


