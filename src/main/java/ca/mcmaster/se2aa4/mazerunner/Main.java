package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import java.io.File;


public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.debug("** Starting Maze Runner");
        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse(getOptions(), args);

            File maze_file = new File(cmd.getOptionValue("i"));
            logger.debug("**** Reading the maze from file " + maze_file);
            Maze maze = new Maze(maze_file);
            if (cmd.hasOption("p")) {
                logger.debug("**** Checking path");
                checkPath(maze, cmd.getOptionValue("p"));
            } else {
                logger.debug("**** Computing path");
                generatePath(maze);
            }
            logger.debug("** End of MazeRunner");

        } catch(Exception e) {
            System.err.println("/!\\ An error has occured /!\\");
            System.err.println("PATH NOT COMPUTED");
            logger.fatal(e.getLocalizedMessage());
            System.exit(0);
        }
        
    }

    public static Options getOptions() {
        Options options = new Options();
        options.addOption(Option.builder("i")
            .hasArg(true)
            .desc("MAZE_FILE")
            .required(true)
        .build());

        options.addOption(Option.builder("p")
            .hasArg(true)
            .desc("PATH_SEQUENCE")
            .required(false)
        .build());
        return options;
    }

    public static void checkPath(Maze maze, String pathString) {
        StringFactorizer factorizer = new StringFactorizer();
        Checker checker = new Checker();
        boolean validPath = checker.checkPath(maze, factorizer.expand(pathString));
        if (validPath) {
            System.out.println("correct path");
        } else {
            System.out.println("inccorrect path");
        }
    }

    public static void generatePath(Maze maze) {
        StringFactorizer factorizer = new StringFactorizer();
        MazeSolver solver = new RightHandRule();
        String output = factorizer.factorize(solver.getPath(maze).toString());
        System.out.println(output);
    }


}
