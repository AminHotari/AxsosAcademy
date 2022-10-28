public class TestPuzzleJava {
    public static void main(String[] args){
        PuzzleJava puzzle = new PuzzleJava();

        System.out.println(puzzle.getTenRolls());
        System.out.println(puzzle.getRandomLetter());
        System.out.println(puzzle.generatePassword());
        System.out.println(puzzle.getNewPasswordSet(7));
    }
}