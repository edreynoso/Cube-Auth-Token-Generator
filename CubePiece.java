
import java.util.ArrayList;

public abstract class CubePiece {

    // Certain pieces in cube carry different weights
    private final int weight;

    // Pieces will have unique piece numbers
    private final int piece_number;

    //Colors will be a list for simplicity as corners and edges have multiple colors 
    //This is for simplicity and also for face lookup    
    private ArrayList<? extends CubePiece> adjacencyList;

    public CubePiece(int weight, int piece_number, ArrayList<? extends CubePiece> adjacency_list) {
        this.weight = weight;
        this.piece_number = piece_number;
        this.adjacencyList = adjacency_list;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getPieceNumber() {
        return this.piece_number;
    }

    public abstract ArrayList<? extends CubePiece> getAdjacentPieces();

    public abstract void setAdjacentPieces(ArrayList<? extends CubePiece> update);

}
