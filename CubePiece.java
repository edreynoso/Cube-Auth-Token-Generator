
public class CubePiece {

    // Certain pieces in cube carry different weights
    private final int weight;

    // Pieces will have unique piece numbers
    private final int pieceNumber;

    private final Color pieceColor;

    public static final int CUBESIZE = 3;

    public CubePiece(int weight, int pieceNumber, Color pieceColor) {
        this.pieceColor = pieceColor;
        this.weight = weight;
        this.pieceNumber = pieceNumber;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getPieceNumber() {
        return this.pieceNumber;
    }

    public Color getPieceColor() {
        return this.pieceColor;
    }

}
