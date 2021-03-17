
	public class Worker extends Unit{
		private int numJob; //number of jobs already done
		//constructor
		public Worker(Tile position, double hp, String faction) {
			super(position,hp, 2, faction);
			this.numJob = 0;
		}
		
		public void takeAction(Tile a) {
			if(!a.isImproved() && super.getPosition().equals(a)) {
				a.buildImprovement(); // improvement
				this.numJob++;
			}
			if(this.numJob ==10) {
				a.removeUnit(this);
			}
		}
		//override equals()
		public boolean equals(Object a) {
			if (a instanceof Worker) {
				if(super.equals(a) && ((Worker) a).numJob == this.numJob) {
					return true;
				}
			}
			
			return false;
		}
	}



