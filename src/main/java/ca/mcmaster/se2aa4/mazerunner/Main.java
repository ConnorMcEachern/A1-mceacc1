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
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption(Option.builder("i")
            .hasArg(true)
            .desc("MAZE_FILE")
            .required(true)
        .build());

        CommandLineParser parser = new DefaultParser();

        try {
            CommandLine cmd = parser.parse( options, args);

            File maze_file = new File(cmd.getOptionValue("i"));
            logger.info("**** Reading the maze from file " + maze_file);
            Maze maze = new Maze(maze_file);
            logger.info("**** Computing path");
            MazeSolver solver = new RightHandRule();
            System.out.println(solver.getPath(maze));
            logger.info("** End of MazeRunner");

        } catch(Exception e) {
            logger.fatal(e.getLocalizedMessage());
            System.exit(0);
        }
        
    }
}
