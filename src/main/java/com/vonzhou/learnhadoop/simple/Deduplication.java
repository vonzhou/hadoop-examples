package com.vonzhou.learnhadoop.simple;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;

public class Deduplication {

    public static class Map extends
            Mapper<LongWritable, Text, Text, NullWritable> {
        private static Text line = new Text();

        // 把输入的value作为输出的key,输出的value无关紧要
        public void map(LongWritable key, Text value, Context context)
                throws IOException, InterruptedException {
            line = value;
            context.write(line, NullWritable.get());
        }
    }

    public static class Reduce extends
            Reducer<Text, NullWritable, Text, NullWritable> {

        public void reduce(Text key, Iterable<NullWritable> values,
                           Context context) throws IOException, InterruptedException {
            context.write(key, NullWritable.get());
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = new Job(conf, "Deduplication");
        job.setJarByClass(Deduplication.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);

        job.setMapperClass(Map.class);
        job.setCombinerClass(Reduce.class);
        job.setReducerClass(Reduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true);
    }

}