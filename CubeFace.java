public class CubeFace {

    // Add one custom graph per cube face
    //Possibly number each face of the cube
    //3x3 matrix representing the Rubik's Cube
    //Hashmap implementation might be better speed wise, but harder to visualize
    private CubePiece[][] face;

    private static final int CUBESIZE = 3;
    private Color centerColor;

    public CubeFace(CubePiece[][] face, Color centerColor) {
        this.face = face;
        this.centerColor = centerColor;
    }

    public String face_stringify(){
        StringBuilder s = new StringBuilder();

        for (int i =0; i < CUBESIZE; i++){
            for (int j = 0; j < CUBESIZE; j++){
                int x = this.face[i][j].getWeight() * this.face[i][j].getPieceNumber();
                s.append(x).append(",");
            }
        }

        return s.toString();
    }

    public Color getCenterColor(){return this.centerColor;}

    public CubePiece get(int r, int c) {
        return face[r][c];
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
        CubePiece[][] temp = new CubePiece[CUBESIZE][CUBESIZE];
        for (int r = 0; r < CUBESIZE; r++)
            for (int c = 0; c < CUBESIZE; c++)
                temp[c][2 - r] = face[r][c];
        face = temp;
    }
}
