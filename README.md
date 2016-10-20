# HBaseJavaClient

* Download HBaseExample.jar
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

* Optionally use command line arguments

```
java -jar ./org.krisbox.examples.HBaseExample.jar -help

 -c,--protocol <arg>         Specify the kerberos protocol, default is
                             jdbc:phoenix
 -d,--driver <arg>           Specify a driver for HBase, default is
                             org.apache.phoenix.jdbc.PhoenixDriver
 -f,--keytabFilename <arg>   Keytab filename, defaut is krb.keytab
 -h,--help                   show help.
 -k,--krbProtocol <arg>      Principal protocol, default is hbase-secure
 -l,--keytabLocation <arg>   Keytab location, default is /home/user
 -n,--nodes <arg>            Comma seperated list of node hostnames,
                             default is hostname1,hostname2,hostname3
 -p,--principal <arg>        Specify the kerberos principal, default is
                             user@DOMAIN
 -t,--port <arg>             HBase port, default is 2181
```
