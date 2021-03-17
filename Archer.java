
public class Archer extends MilitaryUnit {
	private int numArrow;
	
	//constructor
	public Archer(Tile position, double hp, String faction) {
		super(position, hp, 2,faction, 15.0, 2, 0); 
		this.numArrow = 5;
	}
	
	
	public void takeAction(Tile a) {
		if(this.numArrow==0) {
			this.numArrow = 5;
			return;
		}else {
			super.takeAction(a);
			this.numArrow --;

		}
	}
	public boolean equals(Object a) {
		if(a instanceof Archer) {
			if(super.equals(a) && ((Archer)a).numArrow == this.numArrow) {
				return true;
			}
		}
		return false;
	}

}



