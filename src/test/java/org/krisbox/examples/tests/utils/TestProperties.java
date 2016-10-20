package org.krisbox.examples.tests.utils;

import org.apache.log4j.Logger;

/**
 * Created by kclark on 10/20/16.
 */
public class TestProperties {
    private final Logger LOGGER = Logger.getLogger(TestProperties.class);

    private final String PRINCIPAL;
    private final String PROTOCOL;
    private final String NODES;
    private final String PORT;
    private final String PRINCIPALPROTOCOL;
    private final String KEYTABLOCATION;
    private final String KEYTABFILENAME;
    private final String HBASEDRIVER;
    private final String CONNECTIONSTRING;

    public TestProperties() {
        LOGGER.debug("   TestProperties() - Setting up control variables");
        PRINCIPAL         = new String("crm_cfa_phoenixtest@EHD.LOCAL");
        PROTOCOL          = new String("jdbc:phoenix");
        NODES             = new String("dhffe03.pcp.conti.de,dhffe04.pcp.conti.de,dhffe05.pcp.conti.de");
        PORT              = new String("2181");
        PRINCIPALPROTOCOL = new String("hbase-secure");
        KEYTABLOCATION    = new String("/home/kclark");
        KEYTABFILENAME    = new String("krb.keytab");
        HBASEDRIVER       = new String("com.mysql");
        CONNECTIONSTRING  = new String("jdbc:phoenix:dhffe03.pcp.conti.de,dhffe04.pcp.conti.de,dhffe05.pcp.conti.de:2181:/hbase-secure:crm_cfa_phoenixtest@EHD.LOCAL:/home/kclarkkrb.keytab");
    }

    public String getPrincipal(){ return PRINCIPAL; }
    public String getProtocol(){ return PROTOCOL; }
    public String getNodes(){ return NODES; }
    public String getPort() { return PORT; }
    public String getPrincipalProtocol(){ return PRINCIPALPROTOCOL; }
    public String getKeytabLocation(){ return KEYTABLOCATION; }
    public String getKeytabFilename(){ return KEYTABFILENAME; }
    public String getHBaseDriver(){ return HBASEDRIVER; }
    public String getConnectionString(){ return CONNECTIONSTRING; }
}
