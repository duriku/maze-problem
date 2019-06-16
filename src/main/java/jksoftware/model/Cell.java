package jksoftware.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
public abstract class Cell {
	private Integer x;
	private Integer y;

	@Getter
	@Setter
	private Cell parent;

	@Getter
	@Setter
	private boolean visited;

	@Getter
	@Setter
	private boolean path;

	Cell(final int x, final int y) {
		this.x = x;
		this.y = y;
		this.visited = false;
		this.path = false;
	}

	public Integer getX() {
		return x;
	}

	public Integer getY() {
		return y;
	}

	public abstract char getCharacter();


	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Cell{");
		sb.append("x=").append(x);
		sb.append(", y=").append(y);
		sb.append('}');
		return sb.toString();
	}
}
