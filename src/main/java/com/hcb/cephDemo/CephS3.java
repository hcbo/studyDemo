package com.hcb.cephDemo;

import java.util.List;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.util.StringUtils;

public class CephS3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String accessKey="ZGZTFZH9I23I4UWHE3YD";
		String secretKey="zbQ7CXjgx1Au2Z1qmwzCvJSKDwrlrUV8mPO0AKHz";
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
		
		ClientConfiguration clientConfig = new ClientConfiguration();
		clientConfig.setProtocol(Protocol.HTTP);

		AmazonS3 conn = new AmazonS3Client(credentials, clientConfig);
		conn.setEndpoint("192.168.225.200:7480");
		
		List<Bucket> buckets = conn.listBuckets();
		for (Bucket bucket : buckets) {
		        System.out.println(bucket.getName() + "\t" +
		                StringUtils.fromDate(bucket.getCreationDate()));
		}
		System.out.println("...................");
		Bucket myBucket=buckets.get(0);
		ObjectListing objects = conn.listObjects(myBucket.getName());
		do {
		        for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
		                System.out.println(objectSummary.getKey() + "\t" +
		                        objectSummary.getSize() + "\t" +
		                        StringUtils.fromDate(objectSummary.getLastModified()));
		        }
		        objects = conn.listNextBatchOfObjects(objects);
		} while (objects.isTruncated());
}

}
