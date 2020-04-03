package com.maoyan.test;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Maoyan
 * @date 2020/3/26 20:15
 */
@WebServlet("VolidServlet")
public class VolidServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一张图片
        //单位像素
        BufferedImage bufferedImage = new BufferedImage(200,100,BufferedImage.TYPE_INT_RGB);

        ServletOutputStream servletOutputStream = resp.getOutputStream();
        //工具类
        ImageIO.write(bufferedImage,"png",servletOutputStream);
    }
}
