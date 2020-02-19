package com.hcb.alluxioDemo;

import alluxio.AlluxioURI;
import alluxio.client.file.FileInStream;
import alluxio.client.file.FileSystem;
import alluxio.conf.InstancedConfiguration;
import alluxio.conf.PropertyKey;
import alluxio.exception.AlluxioException;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class ReadFileDemo
{
    public static void main( String[] args )
    {
        /* 1.获取文件系统FileSystem */
        InstancedConfiguration conf = InstancedConfiguration.defaults();
        conf.set(PropertyKey.SECURITY_LOGIN_USERNAME, "administrator");
        FileSystem fs = FileSystem.Factory.create(conf);
        AlluxioURI path;
        path = new AlluxioURI("/dummy/wordCountInput.txt");
        FileInStream in = null;
        try {
            //3.打开文件输入流
            in = fs.openFile(path);

            //4.读取文件内容
            byte[] buffer = new byte[1024];
            for (int len = 0; (len = in.read(buffer)) != -1; ) {
                String content = new String(buffer, 0, len);
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AlluxioException e) {
            e.printStackTrace();
        } finally {
            try {
                //5.关闭输入流，释放资源
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
