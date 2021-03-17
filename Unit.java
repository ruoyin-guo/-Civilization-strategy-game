
public abstract class Unit {
		//fields
		private Tile position;//position of the unit of game
		private double hp;    //health point
		private int moveRange; //available moving range
		private String faction;
		
		//constructor
		public Unit(Tile position, double hp, int moveRange, String faction) {
			this.position = position;
			this.hp = hp;
			this.moveRange = moveRange;
			this.faction = faction;	  

			boolean a = this.position.addUnit(this);
			if(a == false) {
				throw new IllegalArgumentException();
			}
		}
		
		//final get methods
		public final Tile getPosition() {
			return this.position;
		}
		public final double getHP() {
			return this.hp;
		}
		public final String getFaction() {
			return this.faction;
		}
		
		
		//take Tile input, where the unit should be placed
		//unit can be moved if the target tile is within the moving range:
		//distance to the tile is less than the unit range+1
		
		public boolean moveTo(Tile a) {		
			if(Tile.getDistance(a, this.getPosition()) < this.moveRange+1 && (a.addUnit(this))){
				Tile oldTile = this.position;
				this.position = a;
				return oldTile.removeUnit(this);
				}else 
					return false;
			}

		
		
		public void receiveDamage(double damage) {
			if(this.hp>0) {
				if(this.position.isCity()==true) { // if on a city, reduce damage before apply
					this.hp = this.hp - damage*0.9;
					if(this.hp<=0) {   // after the damage apply, check the hp
						this.position.removeUnit(this); //remove unit from the tile
					}
				}else {
					this.hp = this.hp - damage; // not on the city, apply directly
					if(this.hp<=0) {   // after the damage apply, check the hp
						this.position.removeUnit(this); //remove unit from the tile
					}	
				}	
				
			}
		}
		
		public abstract void takeAction(Tile position);
		
		
		//takes Object as input
		//true if match type, position, health, faction
		public boolean equals(Object a) {
			if(a instanceof Unit && ((Unit) a).getPosition().equals(this.position) && ((Unit) a).getHP()== this.hp && ((Unit) a).getFaction().equals(this.faction)) {
				return true;
			}
				return false;
			}	
		


	}



