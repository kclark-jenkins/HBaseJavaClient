package org.krisbox.examples.utils;

/**
 * Created by kclark on 10/20/16.
 */
public interface HBaseProperties {
    public String getPrincipal();
    public String getProtocol();
    public String getNodes();
    public String getPort();
    public String getPrincipalProtocol();
    public String getKeytabLocation();
    public String getKeytabFilename();
    public String getHBaseDriver();
    public String getConnectionString();

    public void setPrincipal(String principal);
    public void setProtocol(String protocol);
    public void setNodes(String nodes);
    public void setPort(String port);
    public void setPrincipalProtocol(String principalProtocol);
    public void setKeytabLocation(String keytabLocation);
    public void setKeytabFilename(String keytabFilename);
    public void setHBaseDriver(String hbaseDriver);
}
