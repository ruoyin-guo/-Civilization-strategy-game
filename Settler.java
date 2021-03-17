

	public class Settler extends Unit {
		//constructor
		public Settler(Tile position, double hp, String faction) {
			super(position,hp, 2, faction);
			
		}
		
		public void takeAction(Tile a) {
			if(!a.isCity()&& a.equals(this.getPosition())) {
				a.foundCity(); // city should be built
				this.getPosition().removeUnit(this);
			}
			
		}
		
		//Override equal
		public boolean equals(Object a) {
			if(a instanceof Settler) {
				return super.equals(a);
			}
			return false;
		}
		

	}
	




