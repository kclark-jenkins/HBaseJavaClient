# HBaseJavaClient

* Download org.krisbox.examples.HBaseExample.jar
* Create a file named "HBaseExample.properties" in the same directory as the jar

```
JDBC_HBASE_DRIVER=org.apache.phoenix.jdbc.PhoenixDriver
JDBC_HBASE_PRINCIPAL=user@DOMAIN
JDBC_HBASE_PROTOCOL=jdbc:phoenix
JDBC_HBASE_NODES=hostname1,hostname2,hostname3
JDBC_HBASE_PORT=2181
JDBC_HBASE_PRINCIPAL_PROTOCOL=hbase-secure
JDBC_HBASE_KERBEROS_KEYTAB_LOCATION=/home/kclark
JDBC_HBASE_KERBEROS_KEYTAB_FILENAME=krb.keytab
```

* Execute the jar

```
java -jar ./org.krisbox.examples.HBaseExample.jar
```
