public abstract class CubePiece {

    // Certain pieces in cube carry different weights
    private final int weight;

    // Pieces will have unique piece numbers
    private final int piece_number;

    public static final int CUBESIZE = 3;

    //Colors will be a list for simplicity as corners and edges have multiple colors 
    //This is for simplicity and also for face lookup    

    public CubePiece(int weight, int piece_number) {
        this.weight = weight;
        this.piece_number = piece_number;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getPieceNumber() {
        return this.piece_number;
    }



}
