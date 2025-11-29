public class Corner extends CubePiece {

    private final Color[] cornerColors = new Color[3];


    public Corner(int weight, int piece_number, Color c1, Color c2, Color c3) {
        super(weight, piece_number);
        cornerColors[0] = c1;
        cornerColors[1] = c2;
        cornerColors[2] = c3;
    }

}
