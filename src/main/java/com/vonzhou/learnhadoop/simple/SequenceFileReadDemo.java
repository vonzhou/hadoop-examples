package com.vonzhou.learnhadoop.simple;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.SequenceFile;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.util.ReflectionUtils;

import java.net.URI;

/**
 * Created by vonzhou on 2016/12/18.
 */
public class SequenceFileReadDemo {
    public static void main(String[] args) throws Exception {
        String uri = "input/sequencefile";
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        Path path = new Path(uri);
        SequenceFile.Reader reader = null;
        try {
            reader = new SequenceFile.Reader(fs, path, conf);
            Writable key = (Writable) ReflectionUtils.newInstance(reader.getKeyClass(), conf);
            Writable value = (Writable) ReflectionUtils.newInstance(reader.getValueClass(), conf);
            Long postion = reader.getPosition();
            while (reader.next(key, value)) {
                String syncSeen = reader.syncSeen() ? "*" : "";
                System.out.printf("[%s%s]\t%s\t%s\n", postion, syncSeen, key, value);
                postion = reader.getPosition();
            }
        } finally {
            IOUtils.closeStream(reader);
        }
    }
}
