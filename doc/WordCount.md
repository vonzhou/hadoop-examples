# WordCount Run
---



构造两个文本文件：

```
➜  hadoop-examples git:(master) ✗ tree  input
input
├── file01
└── file02
```

当前目前创建一个符号链接，指向具体的hadoop可执行文件。

```
➜  hadoop-examples git:(master) ✗ ln -s /usr/local/Cellar/hadoop/2.7.1/bin/hadoop hadoop
```

把本地的两个文件拷贝到HDFS中：

```bash
➜  hadoop-examples git:(master) ✗ ./hadoop fs -put input/file01 /user/vonzhou/input/file01
17/07/21 22:27:34 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
➜  hadoop-examples git:(master) ✗ ./hadoop fs -put input/file02 /user/vonzhou/input/file02
17/07/21 22:27:55 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
```

编译程序得到jar:

```bash
mvn clean package
```

运行程序（指定main class的时候需要全包名限定）：

```
➜  hadoop-examples git:(master) ✗ ./hadoop jar target/hadoop-examples-1.0-SNAPSHOT.jar com.vonzhou.learnhadoop.simple.WordCount /user/vonzhou/input/ /user/vonzhou/output
17/07/21 22:28:49 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
17/07/21 22:28:50 INFO Configuration.deprecation: session.id is deprecated. Instead, use dfs.metrics.session-id
17/07/21 22:28:50 INFO jvm.JvmMetrics: Initializing JVM Metrics with processName=JobTracker, sessionId=
17/07/21 22:28:50 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/07/21 22:28:50 INFO input.FileInputFormat: Total input paths to process : 2
17/07/21 22:28:50 INFO mapreduce.JobSubmitter: number of splits:2
17/07/21 22:28:50 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_local796492782_0001
17/07/21 22:28:50 INFO mapreduce.Job: The url to track the job: http://localhost:8080/
17/07/21 22:28:50 INFO mapreduce.Job: Running job: job_local796492782_0001
17/07/21 22:28:50 INFO mapred.LocalJobRunner: OutputCommitter set in config null
17/07/21 22:28:50 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
17/07/21 22:28:50 INFO mapred.LocalJobRunner: OutputCommitter is org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter
17/07/21 22:28:50 INFO mapred.LocalJobRunner: Waiting for map tasks
17/07/21 22:28:50 INFO mapred.LocalJobRunner: Starting task: attempt_local796492782_0001_m_000000_0
17/07/21 22:28:50 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
17/07/21 22:28:50 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
17/07/21 22:28:50 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
17/07/21 22:28:51 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/vonzhou/input/file01:0+18
17/07/21 22:28:51 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
17/07/21 22:28:51 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
17/07/21 22:28:51 INFO mapred.MapTask: soft limit at 83886080
17/07/21 22:28:51 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
17/07/21 22:28:51 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
17/07/21 22:28:51 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
17/07/21 22:28:51 INFO mapred.LocalJobRunner:
17/07/21 22:28:51 INFO mapred.MapTask: Starting flush of map output
17/07/21 22:28:51 INFO mapred.MapTask: Spilling map output
17/07/21 22:28:51 INFO mapred.MapTask: bufstart = 0; bufend = 38; bufvoid = 104857600
17/07/21 22:28:51 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214380(104857520); length = 17/6553600
17/07/21 22:28:51 INFO mapred.MapTask: Finished spill 0
17/07/21 22:28:51 INFO mapred.Task: Task:attempt_local796492782_0001_m_000000_0 is done. And is in the process of committing
17/07/21 22:28:51 INFO mapred.LocalJobRunner: map
17/07/21 22:28:51 INFO mapred.Task: Task 'attempt_local796492782_0001_m_000000_0' done.
17/07/21 22:28:51 INFO mapred.LocalJobRunner: Finishing task: attempt_local796492782_0001_m_000000_0
17/07/21 22:28:51 INFO mapred.LocalJobRunner: Starting task: attempt_local796492782_0001_m_000001_0
17/07/21 22:28:51 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
17/07/21 22:28:51 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
17/07/21 22:28:51 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
17/07/21 22:28:51 INFO mapred.MapTask: Processing split: hdfs://localhost:9000/user/vonzhou/input/file02:0+10
17/07/21 22:28:51 INFO mapred.MapTask: (EQUATOR) 0 kvi 26214396(104857584)
17/07/21 22:28:51 INFO mapred.MapTask: mapreduce.task.io.sort.mb: 100
17/07/21 22:28:51 INFO mapred.MapTask: soft limit at 83886080
17/07/21 22:28:51 INFO mapred.MapTask: bufstart = 0; bufvoid = 104857600
17/07/21 22:28:51 INFO mapred.MapTask: kvstart = 26214396; length = 6553600
17/07/21 22:28:51 INFO mapred.MapTask: Map output collector class = org.apache.hadoop.mapred.MapTask$MapOutputBuffer
17/07/21 22:28:51 INFO mapred.LocalJobRunner:
17/07/21 22:28:51 INFO mapred.MapTask: Starting flush of map output
17/07/21 22:28:51 INFO mapred.MapTask: Spilling map output
17/07/21 22:28:51 INFO mapred.MapTask: bufstart = 0; bufend = 22; bufvoid = 104857600
17/07/21 22:28:51 INFO mapred.MapTask: kvstart = 26214396(104857584); kvend = 26214388(104857552); length = 9/6553600
17/07/21 22:28:51 INFO mapred.MapTask: Finished spill 0
17/07/21 22:28:51 INFO mapred.Task: Task:attempt_local796492782_0001_m_000001_0 is done. And is in the process of committing
17/07/21 22:28:51 INFO mapred.LocalJobRunner: map
17/07/21 22:28:51 INFO mapred.Task: Task 'attempt_local796492782_0001_m_000001_0' done.
17/07/21 22:28:51 INFO mapred.LocalJobRunner: Finishing task: attempt_local796492782_0001_m_000001_0
17/07/21 22:28:51 INFO mapred.LocalJobRunner: map task executor complete.
17/07/21 22:28:51 INFO mapred.LocalJobRunner: Waiting for reduce tasks
17/07/21 22:28:51 INFO mapred.LocalJobRunner: Starting task: attempt_local796492782_0001_r_000000_0
17/07/21 22:28:51 INFO output.FileOutputCommitter: File Output Committer Algorithm version is 1
17/07/21 22:28:51 INFO util.ProcfsBasedProcessTree: ProcfsBasedProcessTree currently is supported only on Linux.
17/07/21 22:28:51 INFO mapred.Task:  Using ResourceCalculatorProcessTree : null
17/07/21 22:28:51 INFO mapred.ReduceTask: Using ShuffleConsumerPlugin: org.apache.hadoop.mapreduce.task.reduce.Shuffle@7fb5adae
17/07/21 22:28:51 INFO reduce.MergeManagerImpl: MergerManager: memoryLimit=334338464, maxSingleShuffleLimit=83584616, mergeThreshold=220663392, ioSortFactor=10, memToMemMergeOutputsThreshold=10
17/07/21 22:28:51 INFO reduce.EventFetcher: attempt_local796492782_0001_r_000000_0 Thread started: EventFetcher for fetching Map Completion Events
17/07/21 22:28:51 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local796492782_0001_m_000000_0 decomp: 50 len: 54 to MEMORY
17/07/21 22:28:51 INFO reduce.InMemoryMapOutput: Read 50 bytes from map-output for attempt_local796492782_0001_m_000000_0
17/07/21 22:28:51 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 50, inMemoryMapOutputs.size() -> 1, commitMemory -> 0, usedMemory ->50
17/07/21 22:28:51 INFO reduce.LocalFetcher: localfetcher#1 about to shuffle output of map attempt_local796492782_0001_m_000001_0 decomp: 30 len: 34 to MEMORY
17/07/21 22:28:51 INFO reduce.InMemoryMapOutput: Read 30 bytes from map-output for attempt_local796492782_0001_m_000001_0
17/07/21 22:28:51 INFO reduce.MergeManagerImpl: closeInMemoryFile -> map-output of size: 30, inMemoryMapOutputs.size() -> 2, commitMemory -> 50, usedMemory ->80
17/07/21 22:28:51 INFO reduce.EventFetcher: EventFetcher is interrupted.. Returning
17/07/21 22:28:51 INFO mapred.LocalJobRunner: 2 / 2 copied.
17/07/21 22:28:51 INFO reduce.MergeManagerImpl: finalMerge called with 2 in-memory map-outputs and 0 on-disk map-outputs
17/07/21 22:28:51 INFO mapred.Merger: Merging 2 sorted segments
17/07/21 22:28:51 INFO mapred.Merger: Down to the last merge-pass, with 2 segments left of total size: 70 bytes
17/07/21 22:28:51 INFO reduce.MergeManagerImpl: Merged 2 segments, 80 bytes to disk to satisfy reduce memory limit
17/07/21 22:28:51 INFO reduce.MergeManagerImpl: Merging 1 files, 82 bytes from disk
17/07/21 22:28:51 INFO reduce.MergeManagerImpl: Merging 0 segments, 0 bytes from memory into reduce
17/07/21 22:28:51 INFO mapred.Merger: Merging 1 sorted segments
17/07/21 22:28:51 INFO mapred.Merger: Down to the last merge-pass, with 1 segments left of total size: 73 bytes
17/07/21 22:28:51 INFO mapred.LocalJobRunner: 2 / 2 copied.
17/07/21 22:28:51 INFO Configuration.deprecation: mapred.skip.on is deprecated. Instead, use mapreduce.job.skiprecords
17/07/21 22:28:51 INFO mapred.Task: Task:attempt_local796492782_0001_r_000000_0 is done. And is in the process of committing
17/07/21 22:28:51 INFO mapred.LocalJobRunner: 2 / 2 copied.
17/07/21 22:28:51 INFO mapred.Task: Task attempt_local796492782_0001_r_000000_0 is allowed to commit now
17/07/21 22:28:51 INFO output.FileOutputCommitter: Saved output of task 'attempt_local796492782_0001_r_000000_0' to hdfs://localhost:9000/user/vonzhou/output/_temporary/0/task_local796492782_0001_r_000000
17/07/21 22:28:51 INFO mapred.LocalJobRunner: reduce > reduce
17/07/21 22:28:51 INFO mapred.Task: Task 'attempt_local796492782_0001_r_000000_0' done.
17/07/21 22:28:51 INFO mapred.LocalJobRunner: Finishing task: attempt_local796492782_0001_r_000000_0
17/07/21 22:28:51 INFO mapred.LocalJobRunner: reduce task executor complete.
17/07/21 22:28:51 INFO mapreduce.Job: Job job_local796492782_0001 running in uber mode : false
17/07/21 22:28:51 INFO mapreduce.Job:  map 100% reduce 100%
17/07/21 22:28:51 INFO mapreduce.Job: Job job_local796492782_0001 completed successfully
17/07/21 22:28:51 INFO mapreduce.Job: Counters: 35
	File System Counters
		FILE: Number of bytes read=42912
		FILE: Number of bytes written=906058
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=74
		HDFS: Number of bytes written=44
		HDFS: Number of read operations=22
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=5
	Map-Reduce Framework
		Map input records=8
		Map output records=8
		Map output bytes=60
		Map output materialized bytes=88
		Input split bytes=224
		Combine input records=0
		Combine output records=0
		Reduce input groups=8
		Reduce shuffle bytes=88
		Reduce input records=8
		Reduce output records=8
		Spilled Records=16
		Shuffled Maps =2
		Failed Shuffles=0
		Merged Map outputs=2
		GC time elapsed (ms)=9
		Total committed heap usage (bytes)=955777024
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters
		Bytes Read=28
	File Output Format Counters
		Bytes Written=44
```






```bash
➜  hadoop-examples git:(master) ✗ ./hadoop fs -ls output
17/07/21 22:35:25 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Found 2 items
-rw-r--r--   1 vonzhou supergroup          0 2017-07-21 22:35 output/_SUCCESS
-rw-r--r--   1 vonzhou supergroup        102 2017-07-21 22:35 output/part-r-00000
➜  hadoop-examples git:(master) ✗ ./hadoop fs -cat output/part-r-00000
17/07/21 22:35:42 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
HBase	1
Hadoop	2
Hello	1
Hive	2
Pig	1
Raft	1
Sring	1
Storm	2
String	1
Zookeeper	1
database	1
system	2
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




### ReadFileURL 使用Hadoop URL读取数据

* 注意端口号要和`core-site.xml`中配置的一致

```bash
➜  hadoop-examples git:(master) ✗ hadoop jar target/hadoop-examples-1.0-SNAPSHOT.jar com.vonzhou.learnhadoop.fs.ReadFileURL hdfs://localhost:9000/user/vonzhou/input/file01
2
43
15
750
65223
```

### ReadFileSeek 使用FileSystem API, 可以seek

```bash
➜  hadoop-examples git:(master) ✗ hadoop jar target/hadoop-examples-1.0-SNAPSHOT.jar com.vonzhou.learnhadoop.fs.ReadFileSeek hdfs://localhost:9000/user/vonzhou/input/file01
2
43
15
750
65223
3   // 第二次 seek 后, 从第三个字节开始读取的
15
750
65223
```

### 


## Run


## References

<Hadoop实战 2nd>