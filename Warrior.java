

	public class Warrior extends MilitaryUnit {
		//constructor
		public Warrior(Tile position,double hp, String faction) {
			super(position, hp, 1, faction, 20.0, 1, 25);
			
		}
		
		public boolean equals(Object a) {
			if(a instanceof Warrior) {
				return super.equals(a);
			}
			return false;

		}
	}




