package org.krisbox.examples.utils.impl;

import org.apache.commons.cli.*;
import org.apache.log4j.Logger;
import org.krisbox.examples.utils.CLIParser;
import org.krisbox.examples.utils.HBaseProperties;

/**
 * Created by kclark on 10/20/16.
 */
public class CLIParserImpl implements CLIParser {
    private final Logger LOGGER = Logger.getLogger(CLIParser.class);

    private CommandLineParser cliParser;
    private Options           cliOptions;

    public CLIParserImpl() {
        cliParser  = new BasicParser();
        cliOptions = new Options();

        cliOptions.addOption("h", "help", false, "show help.");
        cliOptions.addOption("d", "driver", true, "Specify a driver for HBase, default is org.apache.phoenix.jdbc.PhoenixDriver");
        cliOptions.addOption("p", "principal", true, "Specify the kerberos principal, default is user@DOMAIN");
        cliOptions.addOption("c", "protocol", true, "Specify the kerberos protocol, default is jdbc:phoenix");
        cliOptions.addOption("n", "nodes", true, "Comma seperated list of node hostnames, default is hostname1,hostname2,hostname3");
        cliOptions.addOption("t", "port", true, "HBase port, default is 2181");
        cliOptions.addOption("k", "krbProtocol", true, "Principal protocol, default is hbase-secure");
        cliOptions.addOption("l", "keytabLocation", true, "Keytab location, default is /home/user");
        cliOptions.addOption("f", "keytabFilename", true, "Keytab filename, defaut is krb.keytab");
    }

    public HBaseProperties parseCLI(String[] args) {
        HBaseProperties props = new HBasePropertiesImpl();

        CommandLine cmd = null;
        try {
            cmd = cliParser.parse(cliOptions, args);

            if(cmd.hasOption("h"))
                help();
            if(cmd.hasOption("d"))
                props.setHBaseDriver(cmd.getOptionValue("d"));
            if(cmd.hasOption("p"))
                props.setPrincipal(cmd.getOptionValue("p"));
            if(cmd.hasOption("c"))
                props.setProtocol(cmd.getOptionValue("c"));
            if(cmd.hasOption("n"))
                props.setNodes(cmd.getOptionValue("n"));
            if(cmd.hasOption("t"))
                props.setPort(cmd.getOptionValue("t"));
            if(cmd.hasOption("k"))
                props.setPrincipalProtocol(cmd.getOptionValue("k"));
            if(cmd.hasOption("l"))
                props.setKeytabLocation(cmd.getOptionValue("l"));
            if(cmd.hasOption("f"))
                props.setKeytabFilename(cmd.getOptionValue("f"));

        }catch(ParseException e){
            LOGGER.fatal(e);
        }

        return props;
    }

    private void help() {
        HelpFormatter helpFormater = new HelpFormatter();
        helpFormater.printHelp("Main", cliOptions);
        System.exit(0);
    }
}
