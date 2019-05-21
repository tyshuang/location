package scoked;

import java.net.MalformedURLException;
import java.net.URL;

public class Urll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//创建一个URL
			URL url = new URL("http://www.imooc.com");
			URL url2 = new URL(url,"/index.html?.username=tom#test");//?后表示参数  #号表示的是 描点
			
			System.out.println("协议类型："+url.getProtocol());
			System.out.println("主机名称："+url.getHost());
			//如果没有指定端口号，则根据协议不同使用默认的端口号，此时用getport()方法返回值是-1
			System.out.println("端口号："+url.getPort());
			System.out.println("文件路径"+url2.getPath());
			System.out.println("文件名："+url2.getFile());
			System.out.println("相对路径"+url2.getRef());//相对路径表示的是描点的内容
			System.out.println("查询字符串："+url2.getQuery());//查询字符串是参数的内容
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
