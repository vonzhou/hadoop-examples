# Mac下安装Hadoop

brew install hadoop

安装后目录：

```
➜  2.7.1 git:(master) ✗ pwd
/usr/local/Cellar/hadoop/2.7.1
➜  2.7.1 git:(master) ✗ tree -d . -L 2
.
├── bin
├── libexec
│   ├── bin
│   ├── etc
│   ├── libexec
│   ├── logs
│   ├── sbin
│   └── share
├── output
└── sbin
```

伪分布式配置：

```
➜  hadoop git:(master) ✗ pwd
/usr/local/Cellar/hadoop/2.7.1/libexec/etc/hadoop
➜  hadoop git:(master) ✗ ls
capacity-scheduler.xml     hadoop-metrics.properties  httpfs-log4j.properties    kms-log4j.properties       mapred-site.xml            yarn-site.xml
configuration.xsl          hadoop-metrics2.properties httpfs-signature.secret    kms-site.xml               slaves
container-executor.cfg     hadoop-policy.xml          httpfs-site.xml            log4j.properties           ssl-client.xml.example
core-site.xml              hdfs-site.xml              kms-acls.xml               mapred-env.sh              ssl-server.xml.example
hadoop-env.sh              httpfs-env.sh              kms-env.sh                 mapred-queues.xml.template yarn-env.sh
➜  hadoop git:(master) ✗
```

hadoop-env.sh

```
# The java implementation to use.
export JAVA_HOME="$(/usr/libexec/java_home)"
```

core-site.xml

```
<!-- Put site-specific property overrides in this file. -->

<configuration>
    <property>
        <name>hadoop.tmp.dir</name>
        <value>/usr/local/Cellar/hadoop/hdfs/tmp</value>
    </property>
    <property>
        <name>fs.default.name</name>
        <value>hdfs://localhost:9000</value>
    </property>
    <!--
    <property>
        <name>hadoop.proxyuser.vonzhou.groups</name>
        <value>*</value>
        <description>Allow the superuser vonzhou to impersonate any members of the group</description>
    </property>
    <property>
        <name>hadoop.proxyuser.vonzhou.hosts</name>
        <value>127.0.0.1,localhost</value>
        <description>The superuser can connect only from host1 and host2 to impersonate a user</description>
    </property>
    -->
</configuration>
```

hdfs-site.xml

```
<configuration>
    <property>
        <name>dfs.replication</name>
        <value>1</value>
    </property>
</configuration>
```

mapred-site.xml

```
<configuration>
    <property>
        <name>mapred.job.tracker</name>
        <value>localhost:9010</value>
    </property>
</configuration>
```

格式化HDFS：

```
➜  bin git:(master) ✗ pwd
/usr/local/Cellar/hadoop/2.7.1/bin
➜  bin git:(master) ✗ ls
container-executor      hadoop                  hdfs                    mapred                  test-container-executor yarn
➜  bin git:(master) ✗ ./hadoop namenode -format
DEPRECATED: Use of this script to execute hdfs command is deprecated.
Instead use the hdfs command for it.

17/07/21 21:45:34 INFO namenode.NameNode: STARTUP_MSG:
/************************************************************
STARTUP_MSG: Starting NameNode
STARTUP_MSG:   host = vonzhoudeMacBook-Pro.local/192.168.168.100
STARTUP_MSG:   args = [-format]
STARTUP_MSG:   version = 2.7.1
STARTUP_MSG:   classpath = /usr/local/Cellar/hadoop/2.7.1/libexec/etc/hadoop:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/activation-1.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/apacheds-i18n-2.0.0-M15.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/apacheds-kerberos-codec-2.0.0-M15.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/api-asn1-api-1.0.0-M20.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/api-util-1.0.0-M20.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/asm-3.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/avro-1.7.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-beanutils-1.7.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-beanutils-core-1.8.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-cli-1.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-codec-1.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-collections-3.2.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-compress-1.4.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-configuration-1.6.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-digester-1.8.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-httpclient-3.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-io-2.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-lang-2.6.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-logging-1.1.3.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-math3-3.1.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/commons-net-3.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/curator-client-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/curator-framework-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/curator-recipes-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/gson-2.2.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/guava-11.0.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/hadoop-annotations-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/hadoop-auth-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/hamcrest-core-1.3.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/htrace-core-3.1.0-incubating.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/httpclient-4.2.5.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/httpcore-4.2.5.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jackson-core-asl-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jackson-jaxrs-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jackson-mapper-asl-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jackson-xc-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/java-xmlbuilder-0.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jaxb-api-2.2.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jaxb-impl-2.2.3-1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jersey-core-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jersey-json-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jersey-server-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jets3t-0.9.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jettison-1.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jetty-6.1.26.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jetty-util-6.1.26.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jsch-0.1.42.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jsp-api-2.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/jsr305-3.0.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/junit-4.11.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/log4j-1.2.17.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/mockito-all-1.8.5.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/netty-3.6.2.Final.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/paranamer-2.3.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/protobuf-java-2.5.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/servlet-api-2.5.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/slf4j-api-1.7.10.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/slf4j-log4j12-1.7.10.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/snappy-java-1.0.4.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/stax-api-1.0-2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/xmlenc-0.52.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/xz-1.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/lib/zookeeper-3.4.6.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/hadoop-common-2.7.1-tests.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/hadoop-common-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/common/hadoop-nfs-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/asm-3.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/commons-cli-1.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/commons-codec-1.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/commons-daemon-1.0.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/commons-io-2.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/commons-lang-2.6.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/commons-logging-1.1.3.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/guava-11.0.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/htrace-core-3.1.0-incubating.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/jackson-core-asl-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/jackson-mapper-asl-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/jersey-core-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/jersey-server-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/jetty-6.1.26.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/jetty-util-6.1.26.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/jsr305-3.0.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/leveldbjni-all-1.8.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/log4j-1.2.17.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/netty-3.6.2.Final.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/netty-all-4.0.23.Final.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/protobuf-java-2.5.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/servlet-api-2.5.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/xercesImpl-2.9.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/xml-apis-1.3.04.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/lib/xmlenc-0.52.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/hadoop-hdfs-2.7.1-tests.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/hadoop-hdfs-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/hdfs/hadoop-hdfs-nfs-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/activation-1.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/aopalliance-1.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/asm-3.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/commons-cli-1.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/commons-codec-1.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/commons-collections-3.2.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/commons-compress-1.4.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/commons-io-2.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/commons-lang-2.6.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/commons-logging-1.1.3.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/guava-11.0.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/guice-3.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/guice-servlet-3.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jackson-core-asl-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jackson-jaxrs-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jackson-mapper-asl-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jackson-xc-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/javax.inject-1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jaxb-api-2.2.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jaxb-impl-2.2.3-1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jersey-client-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jersey-core-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jersey-guice-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jersey-json-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jersey-server-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jettison-1.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jetty-6.1.26.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jetty-util-6.1.26.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/jsr305-3.0.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/leveldbjni-all-1.8.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/log4j-1.2.17.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/netty-3.6.2.Final.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/protobuf-java-2.5.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/servlet-api-2.5.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/stax-api-1.0-2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/xz-1.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/zookeeper-3.4.6-tests.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/lib/zookeeper-3.4.6.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-api-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-applications-distributedshell-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-applications-unmanaged-am-launcher-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-client-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-common-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-registry-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-server-applicationhistoryservice-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-server-common-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-server-nodemanager-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-server-resourcemanager-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-server-sharedcachemanager-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-server-tests-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/yarn/hadoop-yarn-server-web-proxy-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/aopalliance-1.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/asm-3.2.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/avro-1.7.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/commons-compress-1.4.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/commons-io-2.4.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/guice-3.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/guice-servlet-3.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/hadoop-annotations-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/hamcrest-core-1.3.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/jackson-core-asl-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/jackson-mapper-asl-1.9.13.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/javax.inject-1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/jersey-core-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/jersey-guice-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/jersey-server-1.9.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/junit-4.11.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/leveldbjni-all-1.8.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/log4j-1.2.17.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/netty-3.6.2.Final.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/paranamer-2.3.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/protobuf-java-2.5.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/snappy-java-1.0.4.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/lib/xz-1.0.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-app-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-common-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-hs-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-hs-plugins-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1-tests.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-jobclient-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-client-shuffle-2.7.1.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/share/hadoop/mapreduce/hadoop-mapreduce-examples-2.7.1.jar:/contrib/capacity-scheduler/*.jar:/usr/local/Cellar/hadoop/2.7.1/libexec/contrib/capacity-scheduler/*.jar
STARTUP_MSG:   build = https://git-wip-us.apache.org/repos/asf/hadoop.git -r 15ecc87ccf4a0228f35af08fc56de536e6ce657a; compiled by 'jenkins' on 2015-06-29T06:04Z
STARTUP_MSG:   java = 1.8.0_65
************************************************************/
17/07/21 21:45:34 INFO namenode.NameNode: registered UNIX signal handlers for [TERM, HUP, INT]
17/07/21 21:45:34 INFO namenode.NameNode: createNameNode [-format]
17/07/21 21:45:34 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Formatting using clusterid: CID-12eac91b-6e02-4748-b224-43e8d3544a0a
17/07/21 21:45:34 INFO namenode.FSNamesystem: No KeyProvider found.
17/07/21 21:45:34 INFO namenode.FSNamesystem: fsLock is fair:true
17/07/21 21:45:34 INFO blockmanagement.DatanodeManager: dfs.block.invalidate.limit=1000
17/07/21 21:45:34 INFO blockmanagement.DatanodeManager: dfs.namenode.datanode.registration.ip-hostname-check=true
17/07/21 21:45:34 INFO blockmanagement.BlockManager: dfs.namenode.startup.delay.block.deletion.sec is set to 000:00:00:00.000
17/07/21 21:45:34 INFO blockmanagement.BlockManager: The block deletion will start around 2017 七月 21 21:45:34
17/07/21 21:45:34 INFO util.GSet: Computing capacity for map BlocksMap
17/07/21 21:45:34 INFO util.GSet: VM type       = 64-bit
17/07/21 21:45:34 INFO util.GSet: 2.0% max memory 889 MB = 17.8 MB
17/07/21 21:45:34 INFO util.GSet: capacity      = 2^21 = 2097152 entries
17/07/21 21:45:34 INFO blockmanagement.BlockManager: dfs.block.access.token.enable=false
17/07/21 21:45:34 INFO blockmanagement.BlockManager: defaultReplication         = 1
17/07/21 21:45:34 INFO blockmanagement.BlockManager: maxReplication             = 512
17/07/21 21:45:34 INFO blockmanagement.BlockManager: minReplication             = 1
17/07/21 21:45:34 INFO blockmanagement.BlockManager: maxReplicationStreams      = 2
17/07/21 21:45:34 INFO blockmanagement.BlockManager: shouldCheckForEnoughRacks  = false
17/07/21 21:45:34 INFO blockmanagement.BlockManager: replicationRecheckInterval = 3000
17/07/21 21:45:34 INFO blockmanagement.BlockManager: encryptDataTransfer        = false
17/07/21 21:45:34 INFO blockmanagement.BlockManager: maxNumBlocksToLog          = 1000
17/07/21 21:45:34 INFO namenode.FSNamesystem: fsOwner             = vonzhou (auth:SIMPLE)
17/07/21 21:45:34 INFO namenode.FSNamesystem: supergroup          = supergroup
17/07/21 21:45:34 INFO namenode.FSNamesystem: isPermissionEnabled = true
17/07/21 21:45:34 INFO namenode.FSNamesystem: HA Enabled: false
17/07/21 21:45:34 INFO namenode.FSNamesystem: Append Enabled: true
17/07/21 21:45:35 INFO util.GSet: Computing capacity for map INodeMap
17/07/21 21:45:35 INFO util.GSet: VM type       = 64-bit
17/07/21 21:45:35 INFO util.GSet: 1.0% max memory 889 MB = 8.9 MB
17/07/21 21:45:35 INFO util.GSet: capacity      = 2^20 = 1048576 entries
17/07/21 21:45:35 INFO namenode.FSDirectory: ACLs enabled? false
17/07/21 21:45:35 INFO namenode.FSDirectory: XAttrs enabled? true
17/07/21 21:45:35 INFO namenode.FSDirectory: Maximum size of an xattr: 16384
17/07/21 21:45:35 INFO namenode.NameNode: Caching file names occuring more than 10 times
17/07/21 21:45:35 INFO util.GSet: Computing capacity for map cachedBlocks
17/07/21 21:45:35 INFO util.GSet: VM type       = 64-bit
17/07/21 21:45:35 INFO util.GSet: 0.25% max memory 889 MB = 2.2 MB
17/07/21 21:45:35 INFO util.GSet: capacity      = 2^18 = 262144 entries
17/07/21 21:45:35 INFO namenode.FSNamesystem: dfs.namenode.safemode.threshold-pct = 0.9990000128746033
17/07/21 21:45:35 INFO namenode.FSNamesystem: dfs.namenode.safemode.min.datanodes = 0
17/07/21 21:45:35 INFO namenode.FSNamesystem: dfs.namenode.safemode.extension     = 30000
17/07/21 21:45:35 INFO metrics.TopMetrics: NNTop conf: dfs.namenode.top.window.num.buckets = 10
17/07/21 21:45:35 INFO metrics.TopMetrics: NNTop conf: dfs.namenode.top.num.users = 10
17/07/21 21:45:35 INFO metrics.TopMetrics: NNTop conf: dfs.namenode.top.windows.minutes = 1,5,25
17/07/21 21:45:35 INFO namenode.FSNamesystem: Retry cache on namenode is enabled
17/07/21 21:45:35 INFO namenode.FSNamesystem: Retry cache will use 0.03 of total heap and retry cache entry expiry time is 600000 millis
17/07/21 21:45:35 INFO util.GSet: Computing capacity for map NameNodeRetryCache
17/07/21 21:45:35 INFO util.GSet: VM type       = 64-bit
17/07/21 21:45:35 INFO util.GSet: 0.029999999329447746% max memory 889 MB = 273.1 KB
17/07/21 21:45:35 INFO util.GSet: capacity      = 2^15 = 32768 entries
Re-format filesystem in Storage Directory /usr/local/Cellar/hadoop/hdfs/tmp/dfs/name ? (Y or N) y
17/07/21 21:45:46 INFO namenode.FSImage: Allocated new BlockPoolId: BP-1518963503-192.168.168.100-1500644746472
17/07/21 21:45:46 INFO common.Storage: Storage directory /usr/local/Cellar/hadoop/hdfs/tmp/dfs/name has been successfully formatted.
17/07/21 21:45:46 INFO namenode.NNStorageRetentionManager: Going to retain 1 images with txid >= 0
17/07/21 21:45:46 INFO util.ExitUtil: Exiting with status 0
17/07/21 21:45:46 INFO namenode.NameNode: SHUTDOWN_MSG:
/************************************************************
SHUTDOWN_MSG: Shutting down NameNode at vonzhoudeMacBook-Pro.local/192.168.168.100
************************************************************/
```

启动所有：

```
➜  sbin git:(master) ✗ pwd
/usr/local/Cellar/hadoop/2.7.1/sbin
➜  sbin git:(master) ✗ ./start-all.sh
This script is Deprecated. Instead use start-dfs.sh and start-yarn.sh
17/07/21 21:49:16 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Starting namenodes on [localhost]
Password:
localhost: starting namenode, logging to /usr/local/Cellar/hadoop/2.7.1/libexec/logs/hadoop-vonzhou-namenode-vonzhoudeMacBook-Pro.local.out
Password:
localhost: starting datanode, logging to /usr/local/Cellar/hadoop/2.7.1/libexec/logs/hadoop-vonzhou-datanode-vonzhoudeMacBook-Pro.local.out
Starting secondary namenodes [0.0.0.0]
Password:
0.0.0.0: starting secondarynamenode, logging to /usr/local/Cellar/hadoop/2.7.1/libexec/logs/hadoop-vonzhou-secondarynamenode-vonzhoudeMacBook-Pro.local.out
17/07/21 21:49:42 WARN util.NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
starting yarn daemons
starting resourcemanager, logging to /usr/local/Cellar/hadoop/2.7.1/libexec/logs/yarn-vonzhou-resourcemanager-vonzhoudeMacBook-Pro.local.out
Password:
localhost: starting nodemanager, logging to /usr/local/Cellar/hadoop/2.7.1/libexec/logs/yarn-vonzhou-nodemanager-vonzhoudeMacBook-Pro.local.out
➜  sbin git:(master) ✗ jps -lm
4114 org.apache.hadoop.hdfs.server.namenode.NameNode
4450 org.apache.hadoop.yarn.server.resourcemanager.ResourceManager
4325 org.apache.hadoop.hdfs.server.namenode.SecondaryNameNode
2391 org.jetbrains.idea.maven.server.RemoteMavenServer
4551 org.apache.hadoop.yarn.server.nodemanager.NodeManager
```


http://localhost:50070












