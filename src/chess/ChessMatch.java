package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rock;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8,8);
		inicialSetup();
	}
	
	public ChessPiece[][] GetPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for(int i=0; i<board.getRows(); i++) {
			for(int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	
	public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
		Position source = sourcePosition.toPosition();
		Position target = targetPosition.toPosition();
		validateSourcePosition(source);
		Piece capturePiece = makeMove(source , target);
		return(ChessPiece) capturePiece;
	}
	
	private Piece makeMove(Position source , Position target) {
		Piece p = board.removePiece(source);
		Piece capturedPiece = board.removePiece(source);
		board.placePiece(p, target);
		return capturedPiece;
	}
	
	private void validateSourcePosition(Position position) {
		if(!board.thereIsPiece(position)) {
			throw new ChessException("There is a no piece one source position");
		}
	}
	
	private void placeNewPiece(char column, int room, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, room).toPosition());
		
	}
	
	private void inicialSetup() {
		    placeNewPiece('c', 1, new Rock(board, Color.WHITE));
	        placeNewPiece('c', 2, new Rock(board, Color.WHITE));
	        placeNewPiece('d', 2, new Rock(board, Color.WHITE));
	        placeNewPiece('e', 1, new Rock(board, Color.WHITE));
	        placeNewPiece('e', 2, new Rock(board, Color.WHITE));
	        placeNewPiece('d', 1, new King(board, Color.WHITE));

	        placeNewPiece('c', 7, new Rock(board, Color.BLACK));
	        placeNewPiece('c', 8, new Rock(board, Color.BLACK));
	        placeNewPiece('d', 7, new Rock(board, Color.BLACK));
	        placeNewPiece('e', 7, new Rock(board, Color.BLACK));
	        placeNewPiece('e', 8, new Rock(board, Color.BLACK));
	        placeNewPiece('d', 8, new King(board, Color.BLACK));
		
	}

}
