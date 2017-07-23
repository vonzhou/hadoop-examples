# Hive 



hive-config.sh

```
HADOOP_HOME=/usr/local/Cellar/hadoop/2.7.1
```


```
Hive metastore database is not initialized. Please use schematool (e.g. ./schematool -initSchema -dbType ...) to create the schema
```

https://stackoverflow.com/questions/35655306/hive-installation-issues-hive-metastore-database-is-not-initialized

```
➜  bin git:(master) ✗ ./schematool -initSchema -dbType derby
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/usr/local/dev/hive/apache-hive-2.1.0-bin/lib/log4j-slf4j-impl-2.4.1.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/slf4j-log4j12-1.7.10.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
Metastore connection URL:	 jdbc:derby:;databaseName=metastore_db;create=true
Metastore Connection Driver :	 org.apache.derby.jdbc.EmbeddedDriver
Metastore connection User:	 APP
Starting metastore schema initialization to 2.1.0
Initialization script hive-schema-2.1.0.derby.sql
Error: FUNCTION 'NUCLEUS_ASCII' already exists. (state=X0Y68,code=30000)
org.apache.hadoop.hive.metastore.HiveMetaException: Schema initialization FAILED! Metastore state would be inconsistent !!
Underlying cause: java.io.IOException : Schema script failed, errorcode 2
Use --verbose for detailed stacktrace.
*** schemaTool failed ***
➜  bin git:(master) ✗ mv metastore_db metastore_db.tmp
➜  bin git:(master) ✗ ./schematool -initSchema -dbType derby
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/usr/local/dev/hive/apache-hive-2.1.0-bin/lib/log4j-slf4j-impl-2.4.1.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/slf4j-log4j12-1.7.10.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
Metastore connection URL:	 jdbc:derby:;databaseName=metastore_db;create=true
Metastore Connection Driver :	 org.apache.derby.jdbc.EmbeddedDriver
Metastore connection User:	 APP
Starting metastore schema initialization to 2.1.0
Initialization script hive-schema-2.1.0.derby.sql
Initialization script completed
schemaTool completed
➜  bin git:(master) ✗ ./hive
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/usr/local/dev/hive/apache-hive-2.1.0-bin/lib/log4j-slf4j-impl-2.4.1.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/slf4j-log4j12-1.7.10.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.

Logging initialized using configuration in jar:file:/usr/local/dev/hive/apache-hive-2.1.0-bin/lib/hive-common-2.1.0.jar!/hive-log4j2.properties Async: true
Hive-on-MR is deprecated in Hive 2 and may not be available in the future versions. Consider using a different execution engine (i.e. spark, tez) or using Hive 1.X releases.
hive>
```

配置mysql存储hive元数据：




```
➜  bin git:(master) ✗ ./schematool -initSchema -dbType mysql
SLF4J: Class path contains multiple SLF4J bindings.
SLF4J: Found binding in [jar:file:/usr/local/dev/hive/apache-hive-2.1.0-bin/lib/log4j-slf4j-impl-2.4.1.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: Found binding in [jar:file:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/slf4j-log4j12-1.7.10.jar!/org/slf4j/impl/StaticLoggerBinder.class]
SLF4J: See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.
Metastore connection URL:	 jdbc:mysql://localhost:3306/hive
Metastore Connection Driver :	 com.mysql.jdbc.Driver
Metastore connection User:	 root
Starting metastore schema initialization to 2.1.0
Initialization script hive-schema-2.1.0.mysql.sql
Initialization script completed
schemaTool completed
```

```
hive> create table u1_data(
    > userid int,
    > movieid int,
    > rating int,
    > city string,
    > viewTime string)
    > row format delimited
    > fields terminated by '\t'
    > stored as textfile;
OK
Time taken: 1.541 seconds
hive>
```

```
➜  hadoop-examples git:(master) ✗ ./hadoop fs -ls /user/hive/warehouse
17/07/23 08:08:40 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Found 1 items
drwxr-xr-x   - vonzhou supergroup          0 2017-07-23 08:08 /user/hive/warehouse/u1_data
```

```
create table u2_data(
userid int,
movieid int,
rating int,
city string,
viewTime string
) PARTITIONED BY(dt string)
row format delimited
fields terminated by '\t'
stored as textfile;
```

```
alter table u2_data add partition(dt='20170723');
```

```
➜  hadoop-examples git:(master) ✗ ./hadoop fs -ls /user/hive/warehouse/u2_data
17/07/23 11:59:04 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Found 1 items
drwxr-xr-x   - vonzhou supergroup          0 2017-07-23 11:58 /user/hive/warehouse/u2_data/dt=20170723
```


```
create table u_data(
userid int,
movieid int,
rating int,
city string,
unixtime string
) 
row format delimited
fields terminated by '\t'
stored as textfile;
```

```
hive> load data local inpath '/Users/vonzhou/Github/hadoop-examples/input/u.data'
    > overwrite into table u_data;
Loading data to table default.u_data
OK
Time taken: 1.848 seconds
hive> select count(*) from u_data;
WARNING: Hive-on-MR is deprecated in Hive 2 and may not be available in the future versions. Consider using a different execution engine (i.e. spark, tez) or using Hive 1.X releases.
Query ID = vonzhou_20170723161855_772c5644-9c7d-4cd3-abc9-85337757f96d
Total jobs = 1
Launching Job 1 out of 1
Number of reduce tasks determined at compile time: 1
In order to change the average load for a reducer (in bytes):
  set hive.exec.reducers.bytes.per.reducer=<number>
In order to limit the maximum number of reducers:
  set hive.exec.reducers.max=<number>
In order to set a constant number of reducers:
  set mapreduce.job.reduces=<number>
Job running in-process (local Hadoop)
2017-07-23 16:18:58,895 Stage-1 map = 100%,  reduce = 100%
Ended Job = job_local53968077_0001
MapReduce Jobs Launched:
Stage-Stage-1:  HDFS Read: 3958346 HDFS Write: 3958346 SUCCESS
Total MapReduce CPU Time Spent: 0 msec
OK
100000
Time taken: 3.488 seconds, Fetched: 1 row(s)
hive> select count(*) from u_data where rating >= 4;
WARNING: Hive-on-MR is deprecated in Hive 2 and may not be available in the future versions. Consider using a different execution engine (i.e. spark, tez) or using Hive 1.X releases.
Query ID = vonzhou_20170723162138_9ac1f477-f8b3-4c80-aa1a-027969e70544
Total jobs = 1
Launching Job 1 out of 1
Number of reduce tasks determined at compile time: 1
In order to change the average load for a reducer (in bytes):
  set hive.exec.reducers.bytes.per.reducer=<number>
In order to limit the maximum number of reducers:
  set hive.exec.reducers.max=<number>
In order to set a constant number of reducers:
  set mapreduce.job.reduces=<number>
Job running in-process (local Hadoop)
2017-07-23 16:21:40,490 Stage-1 map = 100%,  reduce = 100%
Ended Job = job_local824287437_0002
MapReduce Jobs Launched:
Stage-Stage-1:  HDFS Read: 7916692 HDFS Write: 3958346 SUCCESS
Total MapReduce CPU Time Spent: 0 msec
OK
55375
Time taken: 1.691 seconds, Fetched: 1 row(s)
```

































