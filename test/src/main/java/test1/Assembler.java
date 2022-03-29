package aabbcc;

public class Assembler {
	private Human human;
	private Animal animal;
	private Stop stop;
	
	public Assembler() {
		human = new Human();
		animal = new Animal();
		stop = new Stop();
		stop.setAni(animal);
		
	}
	public Human getHuman() {
		return human;
	}
	
	public Animal getAnimal() {
		return animal;
	}
	
	public Stop getStop() {
		return stop;
	}

}
