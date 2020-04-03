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
		// 定义一个样式模板，此中使用正则表达式，括号中是要抓的内容
		  // 相当于埋好了陷阱匹配的地方就会掉下去
		int a =0 ;
        String all = null;
		  Pattern pattern = Pattern.compile(patternStr);
		  // 定义一个matcher用来做匹配
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
        File file = new File("D:/唯美女生图片");
        if(!file.exists()){
            file.mkdirs();
            System.out.println("目录创建完毕");
        }else{
            System.out.println("目录已存在");
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
