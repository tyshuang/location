package scoked;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//创建一个urL实例
			URL url = new URL("https://www.baidu.com");
			//通过URL的openStream方法获取URL对象所表示的自愿字符输入流
			InputStream is = url.openStream();
			//将字节输入流转换为字符输入流
			InputStreamReader isr = new InputStreamReader(is,"utf-8");
			//为字符输入流添加缓冲
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			while(data!=null) {//循环读取数据
				System.out.println(data);//输出数据
				data = br.readLine();
			}
			br.close();
			isr.close();
			is.close();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
