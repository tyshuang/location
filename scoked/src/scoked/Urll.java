package scoked;

import java.net.MalformedURLException;
import java.net.URL;

public class Urll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//����һ��URL
			URL url = new URL("http://www.imooc.com");
			URL url2 = new URL(url,"/index.html?.username=tom#test");//?���ʾ����  #�ű�ʾ���� ���
			
			System.out.println("Э�����ͣ�"+url.getProtocol());
			System.out.println("�������ƣ�"+url.getHost());
			//���û��ָ���˿ںţ������Э�鲻ͬʹ��Ĭ�ϵĶ˿ںţ���ʱ��getport()��������ֵ��-1
			System.out.println("�˿ںţ�"+url.getPort());
			System.out.println("�ļ�·��"+url2.getPath());
			System.out.println("�ļ�����"+url2.getFile());
			System.out.println("���·��"+url2.getRef());//���·����ʾ������������
			System.out.println("��ѯ�ַ�����"+url2.getQuery());//��ѯ�ַ����ǲ���������
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
