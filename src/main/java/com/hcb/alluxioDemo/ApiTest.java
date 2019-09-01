package com.hcb.alluxioDemo;

import alluxio.AlluxioURI;
import alluxio.client.file.FileSystem;
import alluxio.conf.InstancedConfiguration;
import alluxio.conf.PropertyKey;
import alluxio.exception.AlluxioException;

import java.io.IOException;

public class ApiTest {
    public static void main(String[] args) {


        /* 1.获取文件系统FileSystem */
        InstancedConfiguration conf = InstancedConfiguration.defaults();
        conf.set(PropertyKey.SECURITY_LOGIN_USERNAME, "root");
        FileSystem fs = FileSystem.Factory.create(conf);
        AlluxioURI path;
        path = new AlluxioURI("/mnt/dummy/cpp.sublime-build");
        try {
            System.out.println(fs.getBlockLocations(path).get(0).getBlockInfo());
            System.out.println(fs.listStatus(path));
            System.out.println(fs.getStatus(path));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AlluxioException e) {
            e.printStackTrace();
        }

    }
}
