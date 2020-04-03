package com.maoyan.Spyder;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownTool {
    private String url;
    private String name;
    private HttpURLConnection conn = null;
    private InputStream inputStream = null;
    private BufferedInputStream bis = null;
    private FileOutputStream out = null;
    public DownTool(String url,String name){
        this.url=url;
        this.name = name;
        try
        {
            File file0=new File("D:\\Ψ��Ů��ͼƬ");
            if(!file0.isDirectory()&&!file0.exists()){
                file0.mkdirs();
            }
            out = new FileOutputStream(file0+"\\"+name+".jpeg");
            // ��������
            URL httpUrl=new URL(url);
            conn=(HttpURLConnection) httpUrl.openConnection();
            //��Post��ʽ�ύ����Ĭ��get��ʽ
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post��ʽ����ʹ�û���
            conn.setUseCaches(false);
            //����ָ������Դ
            conn.connect();
            //��ȡ����������
            inputStream=conn.getInputStream();
            bis = new BufferedInputStream(inputStream);
            byte b [] = new byte[1024];
            int len = 0;
            System.out.println("��ʼ����");
            while((len=bis.read(b))!=-1){
                out.write(b, 0, len);
            }
            System.out.println("�������...");
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(bis!=null){
                    bis.close();
                }
                if(inputStream!=null){
                    inputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

    }
}
