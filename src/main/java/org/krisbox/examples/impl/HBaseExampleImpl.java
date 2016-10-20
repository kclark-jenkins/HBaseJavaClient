package org.krisbox.examples.impl;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.phoenix.jdbc.PhoenixDriver;
import org.krisbox.examples.HBaseExample;
import org.krisbox.examples.utils.HBaseProperties;
import org.krisbox.examples.utils.impl.CLIParserImpl;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by kclark on 10/20/16.
 */
public class HBaseExampleImpl implements HBaseExample {
    final static Logger LOGGER = Logger.getLogger(HBaseExampleImpl.class);

    private HBaseProperties props;

    public static void main(String[] args) {
        try {
            new HBaseExampleImpl(args).createConnection();
        }catch(SQLException e){
            LOGGER.fatal(e);
        }catch(ClassNotFoundException e){
            LOGGER.fatal(e);
        }
    }

    public HBaseExampleImpl(String[] args) {
        LOGGER.debug(HBaseExampleImpl.class.getProtectionDomain().getCodeSource().getLocation());
        LOGGER.debug("     HBaseExample()");
        props = new CLIParserImpl().parseCLI(args);
    }

    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName(PhoenixDriver.class.getName());
        return DriverManager.getConnection(props.getConnectionString());
    }

    public HBaseProperties getPropertiesObject() {
        return props;
    }
}
