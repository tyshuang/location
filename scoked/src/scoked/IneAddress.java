package scoked;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


public class IneAddress {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("���ؼ���������֣� "+addr.getHostName());
		System.out.println("IP��ַ�ǣ� "+addr.getHostAddress());
		byte[] bytes = addr.getAddress();
		System.out.println("�ֽ�������ʽ��IP"+Arrays.toString(bytes));
		System.out.println(addr);
		
		//������������ȡInetAddressʵ��
		//InetAddress addr2 = InetAddress.getByName("Mrzhai");
		InetAddress addr2 = InetAddress.getByName("192.168.43.63");
		System.out.println("�ڶ�������������֣� "+addr2.getHostName());
		System.out.println("�ڶ��������IP��ַ�ǣ� "+addr2.getHostAddress());

	}

}
