public class Edge extends CubePiece {

    private final Color[] edgeColors = new Color[2];


    public Edge(int weight, int piece_number, Color c1, Color c2) {
        super(weight, piece_number);
        edgeColors[0] = c1;
        edgeColors[1] = c2;
    }

}
