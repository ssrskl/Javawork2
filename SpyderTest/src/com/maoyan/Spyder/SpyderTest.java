package com.maoyan.Spyder;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SpyderTest {
	public static String SendGet(String url) throws IOException {
		String result=null;
		BufferedReader bufferedReader = null;
		URL url1 = new URL(url);
		URLConnection connection = url1.openConnection();
		connection.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:72.0) Gecko/20100101 Firefox/72.0");
		connection.connect();
		bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
		String line =null;
		while ((line=bufferedReader.readLine())!=null){
			result+=line;
		}
		bufferedReader.close();
		return result;
	}
	public static void getimage(String targetStr, String patternStr) throws InterruptedException {
		// ����һ����ʽģ�壬����ʹ��������ʽ����������Ҫץ������
		  // �൱�����������ƥ��ĵط��ͻ����ȥ
		int a =0 ;
        String all = null;
		  Pattern pattern = Pattern.compile(patternStr);
		  // ����һ��matcher������ƥ��
		  Matcher matcher = pattern.matcher(targetStr);
		  while (matcher.find()){
			  //System.out.println(matcher.group());
			  a++;
			  System.out.println(matcher.group());
              new DownTool(matcher.group(),String.valueOf(a));
              Thread.sleep(3000);
		  }
	}
	public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("D:/Ψ��Ů��ͼƬ");
        if(!file.exists()){
            file.mkdirs();
            System.out.println("Ŀ¼�������");
        }else{
            System.out.println("Ŀ¼�Ѵ���");
        }
		String url = "https://www.vmgirls.com/13615.html";
		//String url = "http://catjava.top";
		String result = SendGet(url);
		//getimage(result,"https://[^\\s]*gif");
		getimage(result, "[a-zA-z]+://[^\\s]*jpeg");
        //String msg = getimage(result,"https://[^\\s]*/[0-9]*\\.html");
		//new DownTool("https://static.vmgirls.com/image/2020/02/2020022410300260-scaled.jpeg","hello22");
	}
}
