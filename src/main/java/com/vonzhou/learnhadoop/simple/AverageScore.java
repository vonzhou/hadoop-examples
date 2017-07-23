package com.vonzhou.learnhadoop.simple;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * 计算平均成绩
 * 输入文件的每行是: (姓名 成绩)
 */
public class AverageScore {

    public static class Map extends Mapper<LongWritable, Text, Text, IntWritable> {

        public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String line = value.toString();
            // 输出读入的内容
            System.out.println(line);
            StringTokenizer tokenizerLine = new StringTokenizer(line);

            // 处理每行
            while (tokenizerLine.hasMoreTokens()) {

                // 分隔行,取出各个字段
                StringTokenizer tokenizerWord = new StringTokenizer(tokenizerLine.nextToken());
                String strName = tokenizerWord.nextToken();
                String strScore = tokenizerWord.nextToken();

                Text name = new Text(strName);
                int scoreInt = Integer.valueOf(strScore);
                context.write(name, new IntWritable(scoreInt));
            }
        }
    }

    public static class Reduce extends
            Reducer<Text, IntWritable, Text, IntWritable> {

        // 达到的记录 key是姓名,values是成绩列表
        public void reduce(Text key, Iterable<IntWritable> values,
                           Context context) throws IOException, InterruptedException {
            int sum = 0;
            int count = 0;
            for (IntWritable val : values) {
                sum += val.get();
                count ++;
            }
            context.write(key, new IntWritable(sum/count));
        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        Job job = new Job(conf, "averagescore");
        job.setJarByClass(AverageScore.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);

        job.setInputFormatClass(TextInputFormat.class);
        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true);
    }

}