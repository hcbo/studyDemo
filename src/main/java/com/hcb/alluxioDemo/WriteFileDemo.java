package com.hcb.alluxioDemo;

import alluxio.AlluxioURI;
import alluxio.client.file.FileOutStream;
import alluxio.client.file.FileSystem;
import alluxio.conf.InstancedConfiguration;
import alluxio.conf.PropertyKey;
import alluxio.exception.AlluxioException;

import java.io.IOException;

public class WriteFileDemo {
    public static void main(String[] args) {
        // Create a file system with custom configuration
        InstancedConfiguration conf = InstancedConfiguration.defaults();
        conf.set(PropertyKey.SECURITY_LOGIN_USERNAME, "root");
//        conf.set(PropertyKey.USER_FILE_WRITE_TYPE_DEFAULT,"MUST_CACHE");
        FileSystem fs = FileSystem.Factory.create(conf);
        AlluxioURI path = new AlluxioURI("/dummy/checkpoint4/state/3/1/5.delta");
        FileOutStream out = null;
        try {
            out = fs.createFile(path);
            //4.读取文件内容
            String str = "hello alluxio";
            byte[] buffer = str.getBytes();
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AlluxioException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }
}
