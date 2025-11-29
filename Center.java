public class Center extends CubePiece{

    private final Color pieceColor;

    public Center(int weight, int pieceNumber, Color c){
        super(weight, pieceNumber);
        this.pieceColor = c;
    }

    public Color getPieceColor(){
        return this.pieceColor;
    }
}
