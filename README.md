# Learning Hadoop 
---



## Basics

### 安装,配置

## Examples

### WordCount 单词计数

构造两个文本文件：

```
➜  input git:(master) ✗ echo "Hello World Bye World" > file01
➜  input git:(master) ✗ echo "Hello Hadoop Bye Hadoop" > file02
```

把本地的两个文件拷贝到HDFS中：

```bash
➜  wordcount git:(master) ✗ hadoop fs -put input/file01 /user/vonzhou/input/file01
16/07/31 14:08:41 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
➜  wordcount git:(master) ✗ hadoop fs -put input/file02 /user/vonzhou/input/file02
16/07/31 14:08:54 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
```

编译程序得到jar:

```bash
mvn clean package
```

运行程序（指定main class的时候需要全包名限定）：

```bash
➜  wordcount git:(master) ✗ hadoop jar target/wordcount-1.0-SNAPSHOT.jar WordCount /user/vonzhou/input/ /user/vonzhou/output
Exception in thread "main" java.lang.ClassNotFoundException: WordCount
        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
        at java.lang.Class.forName0(Native Method)
        at java.lang.Class.forName(Class.java:348)
        at org.apache.hadoop.util.RunJar.run(RunJar.java:214)
        at org.apache.hadoop.util.RunJar.main(RunJar.java:136)
➜  wordcount git:(master) ✗ hadoop jar target/wordcount-1.0-SNAPSHOT.jar com.vonzhou.example.WordCount /user/vonzhou/input/ /user/vonzhou/output
16/07/31 14:13:37 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
16/07/31 14:13:37 INFO Configuration.deprecation: session.id is deprecated. Instead, use dfs.metrics.session-id
16/07/31 14:13:37 INFO jvm.JvmMetrics: Initializing JVM Metrics with processName=JobTracker, sessionId=
16/07/31 14:13:38 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
16/07/31 14:13:38 INFO input.FileInputFormat: Total input paths to process : 2
16/07/31 14:13:38 INFO mapreduce.JobSubmitter: number of splits:2
16/07/31 14:13:38 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_local651911427_0001
16/07/31 14:13:38 INFO mapreduce.Job: The url to track the job: http://localhost:8080/
16/07/31 14:13:38 INFO mapred.LocalJobRunner: OutputCommitter set in config null
16/07/31 14:13:38 INFO mapreduce.Job: Running job: job_local651911427_0001
16/07/31 14:13:38 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
16/07/31 14:13:38 INFO mapred.LocalJobRunner: OutputCommitter is org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter
16/07/31 14:13:39 INFO mapred.LocalJobRunner: Waiting for map tasks
16/07/31 14:13:39 INFO mapred.LocalJobRunner: Starting task: attempt_local651911427_0001_m_000000_0
16/07/31 14:13:39 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
16/07/31 14:13:39 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
16/07/31 14:13:39 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
16/07/31 14:13:39 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/vonzhou/input/file02:0+24
16/07/31 14:13:39 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
16/07/31 14:13:39 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
16/07/31 14:13:39 INFO mapred.MapTask: soft limit at 83886080
16/07/31 14:13:39 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
16/07/31 14:13:39 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
16/07/31 14:13:39 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
16/07/31 14:13:39 INFO mapred.LocalJobRunner: 
16/07/31 14:13:39 INFO mapred.MapTask: Starting flush of map output
16/07/31 14:13:39 INFO mapred.MapTask: Spilling map output
16/07/31 14:13:39 INFO mapred.MapTask: bufstart = 0; bufend = 40; bufvoid = 104857600
16/07/31 14:13:39 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214384(104857536); length = 13/6553600
16/07/31 14:13:39 INFO mapred.MapTask: Finished spill 0
16/07/31 14:13:39 INFO mapred.Task: Task:attempt_local651911427_0001_m_000000_0 is done. And is in the process of committing
16/07/31 14:13:39 INFO mapred.LocalJobRunner: map
16/07/31 14:13:39 INFO mapred.Task: Task 'attempt_local651911427_0001_m_000000_0' done.
16/07/31 14:13:39 INFO mapred.LocalJobRunner: Finishing task: attempt_local651911427_0001_m_000000_0
16/07/31 14:13:39 INFO mapred.LocalJobRunner: Starting task: attempt_local651911427_0001_m_000001_0
16/07/31 14:13:39 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
16/07/31 14:13:39 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
16/07/31 14:13:39 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
16/07/31 14:13:39 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/vonzhou/input/file01:0+22
16/07/31 14:13:39 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
16/07/31 14:13:39 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
16/07/31 14:13:39 INFO mapred.MapTask: soft limit at 83886080
16/07/31 14:13:39 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
16/07/31 14:13:39 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
16/07/31 14:13:39 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
16/07/31 14:13:39 INFO mapred.LocalJobRunner: 
16/07/31 14:13:39 INFO mapred.MapTask: Starting flush of map output
16/07/31 14:13:39 INFO mapred.MapTask: Spilling map output
16/07/31 14:13:39 INFO mapred.MapTask: bufstart = 0; bufend = 38; bufvoid = 104857600
16/07/31 14:13:39 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214384(104857536); length = 13/6553600
16/07/31 14:13:39 INFO mapred.MapTask: Finished spill 0
16/07/31 14:13:39 INFO mapred.Task: Task:attempt_local651911427_0001_m_000001_0 is done. And is in the process of committing
16/07/31 14:13:39 INFO mapred.LocalJobRunner: map
16/07/31 14:13:39 INFO mapred.Task: Task 'attempt_local651911427_0001_m_000001_0' done.
16/07/31 14:13:39 INFO mapred.LocalJobRunner: Finishing task: attempt_local651911427_0001_m_000001_0
16/07/31 14:13:39 INFO mapred.LocalJobRunner: map task executor complete.
16/07/31 14:13:39 INFO mapred.LocalJobRunner: Waiting for reduce tasks
16/07/31 14:13:39 INFO mapred.LocalJobRunner: Starting task: attempt_local651911427_0001_r_000000_0
16/07/31 14:13:39 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
16/07/31 14:13:39 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
16/07/31 14:13:39 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
16/07/31 14:13:39 INFO mapred.ReduceTask: Using ShuffleConsumerPlugin: org.apache.hadoop.mapreduce.task.reduce.Shuffle@3aaf3276
16/07/31 14:13:39 INFO reduce.MergeManagerImpl: MergerManager: memoryLimit=334338464, maxSingleShuffleLimit=83584616, mergeThreshold=220663392, ioSortFactor=10, memToMemMergeOutputsThreshold=10
16/07/31 14:13:39 INFO reduce.EventFetcher: attempt_local651911427_0001_r_000000_0 Thread started: EventFetcher for fetching Map Completion Events
16/07/31 14:13:39 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local651911427_0001_m_000001_0 decomp: 48 len: 52 to MEMORY
16/07/31 14:13:39 INFO reduce.InMemoryMapOutput: Read 48 bytes from map-output for attempt_local651911427_0001_m_000001_0
16/07/31 14:13:39 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 48, inMemoryMapOutputs.size() -> 1, commitMemory -> 0, usedMemory ->48
16/07/31 14:13:39 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local651911427_0001_m_000000_0 decomp: 50 len: 54 to MEMORY
16/07/31 14:13:39 INFO reduce.InMemoryMapOutput: Read 50 bytes from map-output for attempt_local651911427_0001_m_000000_0
16/07/31 14:13:39 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 50, inMemoryMapOutputs.size() -> 2, commitMemory -> 48, usedMemory ->98
16/07/31 14:13:39 INFO reduce.EventFetcher: EventFetcher is interrupted.. Returning
16/07/31 14:13:39 INFO mapred.LocalJobRunner: 2 / 2 copied.
16/07/31 14:13:39 INFO reduce.MergeManagerImpl: finalMerge called with 2 in-memory map-outputs and 0 on-disk map-outputs
16/07/31 14:13:39 INFO mapred.Merger: Merging 2 sorted segments
16/07/31 14:13:39 INFO mapred.Merger: Down to the last merge-pass, with 2 segments left of total size: 86 bytes
16/07/31 14:13:39 INFO reduce.MergeManagerImpl: Merged 2 segments, 98 bytes to disk to satisfy reduce memory limit
16/07/31 14:13:39 INFO reduce.MergeManagerImpl: Merging 1 files, 100 bytes from disk
16/07/31 14:13:39 INFO reduce.MergeManagerImpl: Merging 0 segments, 0 bytes from memory into reduce
16/07/31 14:13:39 INFO mapred.Merger: Merging 1 sorted segments
16/07/31 14:13:39 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 90 bytes
16/07/31 14:13:39 INFO mapred.LocalJobRunner: 2 / 2 copied.
16/07/31 14:13:39 INFO Configuration.deprecation: mapred.skip.on is deprecated. Instead, use mapreduce.job.skiprecords
16/07/31 14:13:39 INFO mapred.Task: Task:attempt_local651911427_0001_r_000000_0 is done. And is in the process of committing
16/07/31 14:13:39 INFO mapred.LocalJobRunner: 2 / 2 copied.
16/07/31 14:13:39 INFO mapred.Task: Task attempt_local651911427_0001_r_000000_0 is allowed to commit now
16/07/31 14:13:39 INFO output.FileOutputCommitter: Saved output of task 'attempt_local651911427_0001_r_000000_0' to hdfs://localhost:9000/user/vonzhou/output/_temporary/0/task_local651911427_0001_r_000000
16/07/31 14:13:39 INFO mapred.LocalJobRunner: reduce > reduce
16/07/31 14:13:39 INFO mapred.Task: Task 'attempt_local651911427_0001_r_000000_0' done.
16/07/31 14:13:39 INFO mapred.LocalJobRunner: Finishing task: attempt_local651911427_0001_r_000000_0
16/07/31 14:13:39 INFO mapred.LocalJobRunner: reduce task executor complete.
16/07/31 14:13:39 INFO mapreduce.Job: Job job_local651911427_0001 running in uber mode : false
16/07/31 14:13:39 INFO mapreduce.Job:  map 100% reduce 100%
16/07/31 14:13:39 INFO mapreduce.Job: Job job_local651911427_0001 completed successfully
16/07/31 14:13:39 INFO mapreduce.Job: Counters: 35
        File System Counters
                FILE: Number of bytes read=16554
                FILE: Number of bytes written=879244
                FILE: Number of read operations=0
                FILE: Number of large read operations=0
                FILE: Number of write operations=0
                HDFS: Number of bytes read=116
                HDFS: Number of bytes written=31
                HDFS: Number of read operations=22
                HDFS: Number of large read operations=0
                HDFS: Number of write operations=5
        Map-Reduce Framework
                Map input records=2
                Map output records=8
                Map output bytes=78
                Map output materialized bytes=106
                Input split bytes=224
                Combine input records=0
                Combine output records=0
                Reduce input groups=4
                Reduce shuffle bytes=106
                Reduce input records=8
                Reduce output records=4
                Spilled Records=16
                Shuffled Maps =2
                Failed Shuffles=0
                Merged Map outputs=2
                GC time elapsed (ms)=0
                Total committed heap usage (bytes)=1126170624
        Shuffle Errors
                BAD_ID=0
                CONNECTION=0
                IO_ERROR=0
                WRONG_LENGTH=0
                WRONG_MAP=0
                WRONG_REDUCE=0
        File Input Format Counters 
                Bytes Read=46
        File Output Format Counters 
                Bytes Written=31
```


查看运行之后的结果：

```bash
➜  wordcount git:(master) ✗ hadoop fs -ls output                                                                     
16/07/31 14:15:06 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Found 2 items
-rw-r--r--   1 vonzhou supergroup          0 2016-07-31 14:13 output/_SUCCESS
-rw-r--r--   1 vonzhou supergroup         31 2016-07-31 14:13 output/part-r-00000
➜  wordcount git:(master) ✗ hadoop fs -cat output/part-r-00000
16/07/31 14:16:57 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Bye     2
Hadoop  2
Hello   2
World   2

```

### Deduplication 去重

```bash
➜  hadoop-examples git:(master) ✗ hadoop fs -cat input/file01                                                                                 
Hello World Bye World
this is deduplicate
➜  hadoop-examples git:(master) ✗ hadoop fs -cat input/file02
Hello Hadoop Bye Hadoop
this is deduplicate
luyna
➜  hadoop-examples git:(master) ✗ hadoop jar target/hadoop-examples-1.0-SNAPSHOT.jar com.vonzhou.learnhadoop.simple.Deduplication input output
......
➜  hadoop-examples git:(master) ✗ hadoop fs -cat output/part-r-00000
Hello Hadoop Bye Hadoop
Hello World Bye World
luyna
this is deduplicate
```

### Sort 排序

```bash
➜  hadoop-examples git:(master) ✗ hadoop fs -cat input/file01       
2
43
15
750
65223
➜  hadoop-examples git:(master) ✗ hadoop fs -cat input/file02
26
650
92
➜  hadoop-examples git:(master) ✗ hadoop jar target/hadoop-examples-1.0-SNAPSHOT.jar com.vonzhou.learnhadoop.simple.Sort input output
➜  hadoop-examples git:(master) ✗ hadoop fs -ls output                                                                               
Found 2 items
-rw-r--r--   1 vonzhou supergroup          0 2016-07-31 23:10 output/_SUCCESS
-rw-r--r--   1 vonzhou supergroup         44 2016-07-31 23:10 output/part-r-00000
➜  hadoop-examples git:(master) ✗ hadoop fs -cat output/part-r-00000
1       2
2       15
3       26
4       43
5       92
6       650
7       750
8       65223
```

## Run


## References

<Hadoop实战 2nd>