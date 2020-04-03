package com.maoyan.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Maoyan
 * @data 2020/3/31 12:30
 * @Version 1.0.0
 */
public class SpyderTest {
    private static HttpURLConnection conn = null;
    private static InputStream inputStream = null;
    private static BufferedInputStream bufferedInputStream = null;
    private static FileOutputStream fileOutputStream = null;
    //利用预编译正则表达式提高效率
    private static Pattern pattern = Pattern.compile("/images/\\w+");
    public static void main(String[] args) throws IOException {
            for (int i = 1;i<=5;i++) {
                //创建url
                URL url = new URL("https://gank.io/special/Girl/page/"+i);
                //创建doc对象
                Document document = Jsoup.parse(url, 20 * 1000);
                //获取img标签
                Elements imgs = document.getElementsByTag("title");
                Elements elements = document.select("a[title][target][style]");
                for (Element e :
                        elements) {
                    String image = "第"+i+"页："+"https://gank.io" + e.attr("style");
                    //正则表达式
                    Matcher matcher = pattern.matcher(image);
                    while (matcher.find()) {
                        System.out.println("第"+i+"页："+"https://gank.io" +matcher.group());
                        //这里可以写成工具类
                        File file=new File("D:\\下载图片的文件夹");
                        if (!file.isDirectory()&&!file.exists()){
                            //如果文件夹不存在则创建一个文件夹
                            file.mkdirs();
                        }
                        //生成一个唯一的标记来当作图片名称
                        String filename = UUID.randomUUID().toString();
                        fileOutputStream = new FileOutputStream(file+"\\"+filename+".jpeg");
                        //建立连接
                        URL imageurl = new URL("https://gank.io" +matcher.group());
                        conn = (HttpURLConnection) imageurl.openConnection();
                        //使用GET方法
                        conn.setRequestMethod("GET");
                        //连接指定的资源
                        conn.connect();
                        //获取输入流
                        inputStream = conn.getInputStream();
                        //新建buffer缓冲流包装输入流
                        bufferedInputStream = new BufferedInputStream(inputStream);
                        //创建大小为1k的"水桶"
                        byte[] bytes = new byte[1024];
                        //用于保存实际读取的字节数
                        int hasRead = 0;
                        //循环取水
                        System.out.println("开始下载第"+i+"页的图片");
                        while ((hasRead = inputStream.read(bytes))>0){
                            fileOutputStream.write(bytes,0,hasRead);
                        }
                        System.out.println("第"+i+"页的图片下载完成");

                        //释放资源
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        inputStream.close();
                    }

                }

            }
    }
}
