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