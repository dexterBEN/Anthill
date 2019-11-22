package entities;

import java.util.UUID;

import utils.AntType;

public abstract class QueenChildren {
	
	private UUID id;
	private Position position;
	private AntType antType;
	
	public QueenChildren(Position position, AntType type) {
		this.position = position;
		this.antType = type;
		this.id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public AntType getAntType() {
		return antType;
	}

	public void setAntType(AntType antType) {
		this.antType = antType;
	}
	
}
