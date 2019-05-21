package scoked;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;


public class IneAddress {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		InetAddress addr = InetAddress.getLocalHost();
		System.out.println("本地计算机的名字： "+addr.getHostName());
		System.out.println("IP地址是： "+addr.getHostAddress());
		byte[] bytes = addr.getAddress();
		System.out.println("字节数组形式的IP"+Arrays.toString(bytes));
		System.out.println(addr);
		
		//根据主机名获取InetAddress实例
		//InetAddress addr2 = InetAddress.getByName("Mrzhai");
		InetAddress addr2 = InetAddress.getByName("192.168.43.63");
		System.out.println("第二个计算机的名字： "+addr2.getHostName());
		System.out.println("第二个计算机IP地址是： "+addr2.getHostAddress());

	}

}
