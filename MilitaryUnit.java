

	public abstract class MilitaryUnit extends Unit {
		private double damage;
		private int attackRange;
		private int armor;
		
		//constructor
		public MilitaryUnit(Tile position, double hp, int moveRange, String faction, double damage, int attackRange, int armor ) {
			super(position, hp, moveRange, faction);
			this.damage = damage;
			this.attackRange = attackRange;
			this.armor = armor;
			
		}
	
		
		public void takeAction(Tile a) {
			if(Tile.getDistance(a, this.getPosition()) >= this.attackRange+1) {
				return;
			}else {
				Unit enemy = a.selectWeakEnemy(this.getFaction());
				if(enemy!=null) {
					if(a.isImproved()) {
						enemy.receiveDamage(this.damage*1.05); // damage increase if on the city
					}else {
						enemy.receiveDamage(this.damage);
					}
				}
			}
		}
		
		public void receiveDamage(double damage) {
			super.receiveDamage(damage*100/(100+(double)this.armor));
		}
}



