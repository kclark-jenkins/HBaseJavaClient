package org.krisbox.examples;

import org.apache.log4j.Logger;
import org.krisbox.examples.utils.HBaseProperties;
import org.krisbox.examples.utils.impl.HBasePropertiesImpl;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by kclark on 10/20/16.
 */
public interface HBaseExample {
    public Connection createConnection() throws ClassNotFoundException, SQLException;
    public HBaseProperties getPropertiesObject();
}
