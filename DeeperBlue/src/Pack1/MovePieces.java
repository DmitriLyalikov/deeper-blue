package Pack1;

public class MovePieces extends DrawBoard{
	
	public static int Get_Starting_Row() {
		int row;
		return 0;
	}
	public static int Get_Starting_Col() {
		int col;
		return 0;
	}
	public static int Get_Ending_Row() {
		int row;
		return 0;
	}
	public static int Get_Ending_Col() {
		int col;
		return 0;
	}
	
	public static byte[][] MakeMove(byte[][] currentboardstate, int Starting_Row, int Starting_Col, int Ending_Row, int Ending_Col){
		byte[][] updated_boardstate = currentboardstate; 		
		
		DrawBoard place = new DrawBoard();
		
		byte Piece = currentboardstate[Starting_Row][Starting_Col];
		
		updated_boardstate[Ending_Row][Ending_Col] = Piece;
		
		
		updated_boardstate[Starting_Row][Starting_Col] = (byte) place.EMPTY;
 
		
		
		
		return updated_boardstate;
	}
	
	

}
