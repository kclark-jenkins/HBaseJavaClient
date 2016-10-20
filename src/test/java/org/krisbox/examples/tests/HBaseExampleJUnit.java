package org.krisbox.examples.tests;

import org.apache.log4j.Logger;
import org.junit.*;
import org.krisbox.examples.HBaseExample;
import org.krisbox.examples.impl.HBaseExampleImpl;
import org.krisbox.examples.tests.utils.TestProperties;
import org.krisbox.examples.utils.HBaseProperties;
import org.krisbox.examples.utils.impl.HBasePropertiesImpl;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by kclark on 10/20/16.
 */
public class HBaseExampleJUnit {
    private static final Logger LOGGER = Logger.getLogger(HBaseExampleJUnit.class);

    private static TestProperties  controlProps;

    private static String[] args;

    @BeforeClass
    public static void setup() {
        LOGGER.debug("Setting up tests");
        args = new String[]{};
        controlProps = new TestProperties();
    }

    @Test
    public void testConfigProperties() {
        HBaseProperties hbaseProps = new HBasePropertiesImpl();
        LOGGER.debug("Testing properties against control values");
        assertEquals(controlProps.getKeytabFilename(), hbaseProps.getKeytabFilename());
    }

    @Test
    public void testCLIPropertiesAbrv() {
        LOGGER.debug("Testing CLI Properties");

        HBaseExample test = new HBaseExampleImpl(new String[]{
            "-d", "com.driver1",
            "-p", "me@PRINCIPAL1",
            "-c", "my:protocol1",
            "-n", "host1,host2,host3",
            "-t", "1234",
            "-k", "krb:protocol1",
            "-l", "/home/user1",
            "-f", "file1.keytab"});

        assertEquals(test.getPropertiesObject().getHBaseDriver(),       "com.driver1");
        assertEquals(test.getPropertiesObject().getPrincipal(),         "me@PRINCIPAL1");
        assertEquals(test.getPropertiesObject().getPrincipalProtocol(), "krb:protocol1");
        assertEquals(test.getPropertiesObject().getNodes(),             "host1,host2,host3");
        assertEquals(test.getPropertiesObject().getPort(),              "1234");
        assertEquals(test.getPropertiesObject().getProtocol(),          "my:protocol1");
        assertEquals(test.getPropertiesObject().getKeytabLocation(),    "/home/user1");
        assertEquals(test.getPropertiesObject().getKeytabFilename(),    "file1.keytab");
    }

    @Test
    public void testCLIPropertiesFull() {
        LOGGER.debug("Testing CLI Properties");

        HBaseExample test = new HBaseExampleImpl(new String[]{
                "-driver", "com.driver1",
                "-principal", "me@PRINCIPAL1",
                "-protocol", "my:protocol1",
                "-nodes", "host1,host2,host3",
                "-port", "1234",
                "-krbProtocol", "krb:protocol1",
                "-keytabLocation", "/home/user1",
                "-keytabFilename", "file1.keytab"});

        assertEquals(test.getPropertiesObject().getHBaseDriver(),       "com.driver1");
        assertEquals(test.getPropertiesObject().getPrincipal(),         "me@PRINCIPAL1");
        assertEquals(test.getPropertiesObject().getPrincipalProtocol(), "krb:protocol1");
        assertEquals(test.getPropertiesObject().getNodes(),             "host1,host2,host3");
        assertEquals(test.getPropertiesObject().getPort(),              "1234");
        assertEquals(test.getPropertiesObject().getProtocol(),          "my:protocol1");
        assertEquals(test.getPropertiesObject().getKeytabLocation(),    "/home/user1");
        assertEquals(test.getPropertiesObject().getKeytabFilename(),    "file1.keytab");
    }

    @Test
    public void testCreateConnectionDefaults() throws SQLException, ClassNotFoundException {
        HBaseExample    hbaseExample = new HBaseExampleImpl(new String[]{});
        hbaseExample.createConnection();
    }

    @Test
    public void testCreateConnectionCLIAbrv() throws SQLException, ClassNotFoundException {
        HBaseExample hbaseExample = new HBaseExampleImpl(new String[]{
                "-d", "com.driver1",
                "-p", "me@PRINCIPAL1",
                "-c", "my:protocol1",
                "-n", "host1,host2,host3",
                "-t", "1234",
                "-k", "krb:protocol1",
                "-l", "/home/user1",
                "-f", "file1.keytab"});
        hbaseExample.createConnection();
    }

    @Test
    public void testCreateConnectionCLIFull() throws SQLException, ClassNotFoundException {
        HBaseExample hbaseExample = new HBaseExampleImpl(new String[]{
                "-driver", "com.driver1",
                "-principal", "me@PRINCIPAL1",
                "-protocol", "my:protocol1",
                "-nodes", "host1,host2,host3",
                "-port", "1234",
                "-krbProtocol", "krb:protocol1",
                "-keytabLocation", "/home/user1",
                "-keytabFilename", "file1.keytab"});

        hbaseExample.createConnection();
    }

    @AfterClass
    public static void doneTesting() {
        LOGGER.debug("JUnit Complete");
    }
}
