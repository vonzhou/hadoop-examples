package com.vonzhou.learnhadoop.fs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.net.URI;

/**
 * Created by vonzhou on 16/8/2.
 */
public class ReadFileSeek {
    public static void main(String[] args) throws Exception {
        String uri = args[0];
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        FSDataInputStream in = fs.open(new Path(uri));
        IOUtils.copyBytes(in, System.out, 4096, false);
        in.seek(3);
        IOUtils.copyBytes(in, System.out, 4096, false);
        IOUtils.closeStream(in);
    }
}
