package com.vonzhou.learnhadoop.simple;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Text;

import java.net.URI;

/**
 * Created by vonzhou on 2016/12/18.
 */
public class SequenceFileDemo {
    public static final int NUM = 1000;
    static String[] values = {
            "hello hadoop",
            "hello vonzhou",
            "byte luyna",
            "byte world xxxxxxxxxxx asfoadfasjf;asfjlk;af;asfasd"
    };

    public static void main(String[] args) throws Exception {
        String uri = "input/sequencefile";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        Path path = new Path(uri);
        IntWritable key = new IntWritable();
        Text value = new Text();
        SequenceFile.Writer writer = null;
        try {
            writer = SequenceFile.createWriter(fs, conf, path, key.getClass(), value.getClass());
            for (int i = 0; i < NUM; i++) {
                key.set(NUM - i);
                value.set(values[i % values.length]);
                writer.append(key, value);
            }
        } finally {
            IOUtils.closeStream(writer);
        }
    }
}
