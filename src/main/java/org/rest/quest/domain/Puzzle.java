package org.rest.quest.domain;

/**
 * Created by roman on 17.03.16.
 */
public class Puzzle {

    private String puzzle;

    private String solution;

    public Puzzle() {
    }

    public Puzzle(String puzzle, String solution) {
        this.puzzle = puzzle;
        this.solution = solution;
    }

    public String getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
