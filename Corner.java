
import java.util.ArrayList;

public class Corner extends CubePiece {

    private final ArrayList<Color> corner_colors;

    private ArrayList<Edge> adjacency_list;

    public Corner(int weight, int piece_number, ArrayList<Color> corner_colors, ArrayList<Edge> adjacency_list) {
        super(weight, piece_number, adjacency_list);
        this.corner_colors = corner_colors;
    }

    @Override
    public ArrayList<Edge> getAdjacentPieces() {
        return this.adjacency_list;
    }

    @Override
    public void setAdjacentPieces(ArrayList<? extends CubePiece> update) {
        this.adjacency_list = (ArrayList<Edge>) update;
    }

    public ArrayList<Color> getCornerColors() {
        return this.corner_colors;
    }
}
