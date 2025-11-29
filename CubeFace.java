import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CubeFace {

    // Add one custom graph per cube face
    //Possibly number each face of the cube
    //3x3 matrix representing the Rubik's Cube
    //Hashmap implementation might be better speed wise, but harder to visualize
    private CubePiece[][] face = new CubePiece[3][3];

    private static final int CUBESIZE = 3;
    private static final int PIECECOUNT = 26;
    private Color centerColor;

    public CubeFace(CubePiece[][] face, Color centerColor) {
        this.face = face;
        this.centerColor = centerColor;
    }

    private String face_stringify(){
        StringBuilder s = new StringBuilder();
        for (int i =0; i < CUBESIZE; i++){
            for (int j = 0; j < CUBESIZE; j++){
                int x = this.face[i][j].getWeight() + this.face[i][j].getPieceNumber()
                        / (((int) Math.random() * PIECECOUNT) +1);
                s.append(x);
            }
        }
        return s.toString();
    }

    public static String toAsciiToken(byte[] hash) {
        StringBuilder token = new StringBuilder();

        int val = hash[1] & 0xFF;   // convert signed → unsigned
        int ascii = 33 + (val % 94); // printable ASCII (33–126)
        token.append((char) ascii);


        return token.toString();
    }

    //Hash each side of the Cube, for a token of length 6
    public String hash_face(CubeFace cube) {
        //Take scrambled graph and create hash algo based on node weights

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(face_stringify().getBytes(StandardCharsets.UTF_8));

            return toAsciiToken(hash);
        }catch(NoSuchAlgorithmException e){
            System.out.println("Failed to use SHA_256");
            return "";
        }
    }

    public Color getCenterColor(){return this.centerColor;}

    public CubePiece get(int r, int c) {
        return face[r][c];   // assuming your internal storage is CubePiece[][] face
    }


    public CubePiece[] getRow(int r){
        CubePiece[] row = new CubePiece[CUBESIZE];
        for(int i =0; i< CUBESIZE; i++){
            row[i] = this.face[r][i];
        }

        return row;
    }

    public CubePiece[] getCol(int c){
        CubePiece[] col = new CubePiece[CUBESIZE];
        for(int i =0; i < CUBESIZE; i++){
            col[i] = this.face[i][c];
        }

        return col;
    }

    public void setRow(int r, CubePiece[] row){
        for(int i =0; i <CUBESIZE; i++){
            this.face[r][i] = row[i];
        }
    }

    public void setCol(int c, CubePiece[] col){
        for(int i =0; i < CUBESIZE; i++){
            this.face[i][c] = col[i];
        }
    }
    public void rotateCW(){
        CubePiece[][] temp = new CubePiece[3][3];
        for (int r = 0; r < CUBESIZE; r++)
            for (int c = 0; c < CUBESIZE; c++)
                temp[c][2 - r] = face[r][c];
        face = temp;
    }

    public void rotateCCW(){
        for(int i=0; i<3; i++){
            rotateCW();
        }
    }
}
