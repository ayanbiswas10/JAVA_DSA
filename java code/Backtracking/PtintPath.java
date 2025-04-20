public class PtintPath {
    public static void main(String[] args) {
        int rows=3;
        int cols=3;
        printPath(1,1,rows,cols,"");
    }

    private static void printPath(int sr, int sc, int er, int ec, String s) {
        if(sr>er || sc>ec) return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        //go right
        printPath(sr+1,sc,er,ec,s+"R");
        //go down
        printPath(sr,sc+1,er,ec,s+"D");
    }
}
