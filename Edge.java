
import java.util.ArrayList;

public class Edge extends CubePiece {

    private final ArrayList<Color> edge_color;

    private ArrayList<Corner> adjacency_list;

    public Edge(int weight, int piece_number, ArrayList<Corner> adjacency_list, ArrayList<Color> edge_color) {
        super(weight, piece_number, adjacency_list);
        this.edge_color = edge_color;
    }

    @Override
    public ArrayList<Corner> getAdjacentPieces() {
        return this.adjacency_list;
    }

    @Override
    public void setAdjacentPieces(ArrayList<? extends CubePiece> update) {

    }
}
