package jksoftware.exception;

public class InvalidCellException extends RuntimeException {

	private final char c;
	private final int x;
	private final int y;

	public InvalidCellException(final char c, final int x, final int y) {
		this.c = c;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("InvalidCellException{");
		sb.append("c=").append(c);
		sb.append(", x=").append(x);
		sb.append(", y=").append(y);
		sb.append('}');
		return sb.toString();
	}
}
