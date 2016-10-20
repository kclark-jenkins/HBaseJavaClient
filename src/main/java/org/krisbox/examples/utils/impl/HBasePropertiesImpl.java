package org.krisbox.examples.utils.impl;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.log4j.Logger;
import org.krisbox.examples.utils.HBaseFields;
import org.krisbox.examples.utils.HBaseProperties;

import java.io.*;
import java.util.Properties;

/**
 * Created by kclark on 10/20/16.
 */
public class HBasePropertiesImpl implements HBaseProperties {
    private final Logger LOGGER = Logger.getLogger(HBaseProperties.class);
    private final String HBASE_PROPERTIES_FILENAME = new File(HBaseProperties.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParent() + "/HBaseExample.properties";

    private String principal;
    private String protocol;
    private String nodes;
    private String port;
    private String principalProtocol;
    private String keytabLocation;
    private String keytabFilename;
    private String hbaseDriver;

    private Properties hbaseProps;

    public HBasePropertiesImpl() {
        LOGGER.debug("  HBasePropertiesImpl()");
        hbaseProps = new Properties();
        initProperties();

        principal         = hbaseProps.getProperty(HBaseFields.JDBC_HBASE_PRINCIPAL.name());
        protocol          = hbaseProps.getProperty(HBaseFields.JDBC_HBASE_PROTOCOL.name());
        nodes             = hbaseProps.getProperty(HBaseFields.JDBC_HBASE_NODES.name());
        port              = hbaseProps.getProperty(HBaseFields.JDBC_HBASE_PORT.name());
        principalProtocol = hbaseProps.getProperty(HBaseFields.JDBC_HBASE_PRINCIPAL_PROTOCOL.name());
        keytabLocation    = hbaseProps.getProperty(HBaseFields.JDBC_HBASE_KERBEROS_KEYTAB_LOCATION.name());
        keytabFilename    = hbaseProps.getProperty(HBaseFields.JDBC_HBASE_KERBEROS_KEYTAB_FILENAME.name());
        hbaseDriver       = hbaseProps.getProperty(HBaseFields.JDBC_HBASE_DRIVER.name());


    }

    /*
    hbaseProps.getProperty(HBaseFields.JDBC_HBASE_PRINCIPAL.name());
    hbaseProps.getProperty(HBaseFields.JDBC_HBASE_PROTOCOL.name())
     */

    public String getPrincipal() {return principal;}

    public String getProtocol() {
        return protocol;
    }

    public String getNodes() {
        return nodes;
    }

    public String getPort() {return port;}

    public String getPrincipalProtocol() {return principalProtocol;}

    public String getKeytabLocation() {return keytabLocation;}

    public String getKeytabFilename() {return keytabFilename;}

    public String getHBaseDriver() {return hbaseDriver;}

    public String getConnectionString() {
        return new String(getProtocol() + ":" + getNodes() + ":" + getPort() + ":/" + getPrincipalProtocol()
                + ":" + getPrincipal() + ":" + getKeytabLocation() + getKeytabFilename());
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setNodes(String nodes) {
        this.nodes = nodes;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setPrincipalProtocol(String principalProtocol) {
        this.principalProtocol = principalProtocol;
    }

    public void setKeytabLocation(String keytabLocation) {
        this.keytabLocation = keytabLocation;
    }

    public void setKeytabFilename(String keytabFilename) {
        this.keytabFilename = keytabFilename;
    }

    public void setHBaseDriver(String hbaseDriver) {
        this.hbaseDriver = hbaseDriver;
    }

    private void initProperties() {
        try {
            hbaseProps.load(readPropertiesFile());
        }catch(IOException e){
            LOGGER.fatal(e);
        }
    }

    private InputStream readPropertiesFile() {
        try {
            InputStream inputStream = new ReaderInputStream(new FileReader(HBASE_PROPERTIES_FILENAME));

            if(inputStream != null)
                return inputStream;
            else
                throw new FileNotFoundException("Property file '" + HBASE_PROPERTIES_FILENAME + "' not found in the classpath");
        }catch(IOException e){
            LOGGER.fatal(e);
        }

        return null;
    }
}
