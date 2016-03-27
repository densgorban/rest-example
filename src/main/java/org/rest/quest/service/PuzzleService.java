package org.rest.quest.service;

import com.google.gson.Gson;
import org.rest.quest.Utils;
import org.rest.quest.domain.Puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Roman Uholnikov
 */
public class PuzzleService {

    public static final Logger logger = Logger.getLogger(PuzzleService.class.getSimpleName());

    public static Integer KEY_RECORD_1 = null;
    public static Integer KEY_RECORD_2 = null;

    /** each puzzle consist of 2 fields: 0 - puzzle, 1 - answer */
    public static List<List<String>> puzzle = new ArrayList<>();


    static {
        String string = Utils.getStringFromFIle("init/puzzles.json", PuzzleService.class.getClassLoader());
        puzzle = (List<List<String>>) new Gson().fromJson(string, Map.class).get("puzzle");
        puzzle.addAll(puzzle);
        puzzle.addAll(puzzle);
        puzzle.addAll(puzzle);
        puzzle.addAll(puzzle);

        KEY_RECORD_1 = new Random().nextInt(puzzle.size());
        KEY_RECORD_2 = new Random().nextInt(puzzle.size());

        logger.info(puzzle.size() + " puzzles registered");
        logger.info(KEY_RECORD_1 + " first key record id");
        logger.info(KEY_RECORD_2 + " second key record id");
    }

    public static Puzzle getRandomPuzzle() {
        Random generator = new Random();
        int randomI = generator.nextInt(puzzle.size());
        List<String> puzzleList = puzzle.get(randomI);
        return new Puzzle(puzzleList.get(0),puzzleList.get(1));
    }

    public static String getPuzzle(int i) {
        return puzzle.get(i).get(0);
    }

    public static int getPuzzlesCount() {
        return puzzle.size();
    }
}
