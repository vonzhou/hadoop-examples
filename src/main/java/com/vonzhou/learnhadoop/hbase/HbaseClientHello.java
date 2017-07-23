package com.vonzhou.learnhadoop.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

/**
 * Created by vonzhou on 16/9/11.
 */
public class HbaseClientHello {
    private static Configuration cfg = HBaseConfiguration.create();

    public static void main(String[] args) throws IOException {
        String tableName = "test1";
        String columnFamily = "cf";

        HBaseAdmin admin = new HBaseAdmin(cfg);
        if(admin.tableExists(tableName)){
            System.out.println(tableName + "表已存在!");
            System.exit(0);
        }

        HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
        tableDescriptor.addFamily(new HColumnDescriptor(columnFamily));
        admin.createTable(tableDescriptor);
        System.out.println(tableName + "表创建成功!");

        // 通过HTable对表进行 put/get
        String row = "row1";
        String columnQualifier = "q1";
        String value = "data";
        HTable table = new HTable(cfg, tableName);
        Put put = new Put(Bytes.toBytes(row));
        put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(columnQualifier), Bytes.toBytes(value));

        Get get = new Get(Bytes.toBytes(row));
        Result result = table.get(get);
        System.out.println("Get: " + result);



    }

}
