package fr.uge.dummychargepoint;

import fr.uge.dummychargepoint.socket.ConfigurationClient;
import fr.uge.dummychargepoint.socket.ConfigurationServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.help.HelpFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyChargepoint {

  private static final int ERROR_CODE = 1;
  private static final Logger LOGGER = LoggerFactory.getLogger(DummyChargepoint.class);

  public static void main(String[] args) throws IOException {
    setupCLI(args);


/*
    try {
      switch (Type.fromString(args[0])) {
        case Type.SERVER -> handleServer(args);
        case Type.CLIENT -> handleClient(args);
      }
    } catch (IllegalTypeException e) {
      LOGGER.error(e.getMessage());
      usage();
      System.exit(ERROR_CODE);
    } catch (ArrayIndexOutOfBoundsException e) {
      LOGGER.error("Missing arguments");
      usage();
      System.exit(ERROR_CODE);
    }
*/
  }

  private static void setupCLI(String[] args) throws IOException {
    // Create the Options
    Options options = new Options();
    OptionGroup categoryGroup = new OptionGroup();
    categoryGroup.addOption(Option.builder("c")
        .longOpt("client")
        .desc("Run as client (requires --host and --port)")
        .get());
    categoryGroup.addOption(Option.builder("s")
        .longOpt("server")
        .desc("Run as server (requires --port)")
        .get());
    categoryGroup.setRequired(true);
    options.addOptionGroup(categoryGroup);

    options.addOption(Option.builder("h")
        .longOpt("host")
        .hasArg()
        .argName("HOST")
        .desc("Host to connect to (required for client)")
        .get());
    options.addOption(Option.builder("p")
        .longOpt("port")
        .hasArg()
        .argName("PORT")
        .desc("Port number (required for both client and server)")
        .get());

    // Create the parser
    CommandLineParser parser = new DefaultParser();

    try {
      // Parse the command-line arguments
      CommandLine cmd = parser.parse(options, args);

      // Check for help option
      if (cmd.hasOption("help")) {
        HelpFormatter formatter = HelpFormatter.builder().get();
        formatter.printHelp("dummyChargepoint", "A simulator for a chargepoint", options, "Have a nice day!", true);
        System.exit(0);
      }

      // Check for verbose mode
      if (cmd.hasOption("verbose")) {
        System.out.println("Verbose mode enabled");
      }

      // Get the input file
      if (cmd.hasOption("file")) {
        String filePath = cmd.getOptionValue("file");
        System.out.println("Input file: " + filePath);
      }

    } catch (ParseException e) {
      System.err.println("Error parsing command-line arguments: " + e.getMessage());
      HelpFormatter formatter = HelpFormatter.builder().get();
      formatter.printHelp("dummyChargepoint", "A simulator for a chargepoint", options, "Have a nice day!", true);
      System.exit(1);
    }
  }

  private static void handleClient(String[] args) throws URISyntaxException, InterruptedException {
    if (args.length < 3) {
      LOGGER.error("Not enough arguments for client, expected 3 arguments.");
      usage();
      System.exit(ERROR_CODE);
    }

    var remoteHost = args[1];
    var remotePort = Integer.parseInt(args[2]);
    var application =
        new ConfigurationClient(new URI("ws://" + remoteHost + ":" + remotePort), Map.of());
    application.connectBlocking();
  }

  private static void handleServer(String[] args) {
    if (args.length < 2) {
      LOGGER.error("Not enough arguments, expected at least 2.");
      usage();
      System.exit(ERROR_CODE);
    }

    var port = Integer.parseInt(args[1]);
    var application = new ConfigurationServer(new InetSocketAddress(port));
    application.start();
  }

  private static void usage() {
    System.out.println("Server: SERVER <local port>");
    System.out.println("Client: CLIENT <remote address> <remote port>");
  }

}