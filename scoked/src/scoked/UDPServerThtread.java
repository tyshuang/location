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
		//2.�������ݱ������ڽ��տͻ��˷��͵���Ϣ
		System.out.println("***���������Ѿ�����...���ڼ����ͻ���...***");
		//3.���ܿͻ��˷��͵�����
		//�˷����ڽ������ݱ���ʱ�������
		 //4.��ȡ����
		 String info = new String(data,0,dp.getLength());
		 System.out.println("���Ƿ�����...�ͻ���˵��"+info);
		 
		
		}
	}


