
public class CubeFace {

    // Add one custom graph per cube face
    //Possibly number each face of the cube
    //3x3 matrix representing the Rubik's Cube
    //Hashmap implementation might be better speed wise, but harder to visualize
    private CubePiece[][] face = new CubePiece[3][3];

    private Color centerColor;

    public CubeFace(CubePiece[][] face, Color centerColor) {
        this.face = face;
        this.centerColor = centerColor;
    }

    //Hash each side of the Cube, for a token of length 6
    public String hash_face(CubeFace cube) {
        //Take scrambled graph and create hash algo based on node weights
        return "Place Holder";
    }

}
