package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Queen {

	private UUID id;
	private boolean isAlive = true;
	private final Position position;
	private List<Fighter> fighters;
	private List<Worker> workers;

	public Queen(Position position) {
		this.id = UUID.randomUUID();
		this.position = position;
		this.fighters = new ArrayList<>();
		this.workers = new ArrayList<>();
		giveBirth(position.getX() != 0 ? -1 : 1);
	}

	public void giveBirth(int pas) {
		fighters.add(new Fighter(new Position(this.position.getX(), this.position.getY() + pas)));
		workers.add(new Worker(new Position(this.position.getX(), this.position.getY() + 2*pas)));
		randomBirth(pas);
	}
	
	public void randomBirth(int pas) {
		int randomIndex = new Random().nextInt(2);
		Position p = new Position(this.position.getX(), this.position.getY()+3*pas); 
		if (randomIndex == 0) {
			fighters.add(new Fighter(p));
		} else {
			workers.add(new Worker(p));
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public List<Fighter> getFighters() {
		return fighters;
	}

	public void setFighters(List<Fighter> fighters) {
		this.fighters = fighters;
	}

	public List<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<Worker> workers) {
		this.workers = workers;
	}

	public Position getPosition() {
		return position;
	}
	
	
}
