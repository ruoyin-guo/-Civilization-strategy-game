

public class Tile {
	private int x_co;
	private int y_co;
	private boolean cityBuilt;
	private boolean improvement;
	private ListOfUnits units ;
	
	//constructor
	public Tile(int x, int y) {
		this.x_co = x;
		this.y_co = y;
		this.cityBuilt = false;
		this.improvement = false;
		this.units = new ListOfUnits();
	}
	
	public int getX() {
		return this.x_co;
	}
	public int getY() {
		return this.y_co;
	}
	//return whether not the tile is a city
	public boolean isCity() {
		return this.cityBuilt;
	}
	//whether or not the tile is improved
	public boolean isImproved() {
		return this.improvement;
	}
	
	//turns the tile into the city if it wasn't already
	public void foundCity() {
		this.cityBuilt = true;
	}
	
	//improve the tile if it wasn't already
	public void buildImprovement() {
		this.improvement = true;
		
	}
	
	//takes unit and add to tile's ListOfUnits
	public boolean addUnit(Unit obj) {

		if(obj instanceof MilitaryUnit){ // if it is the military unit, check in the same faction
			
			MilitaryUnit[] army = this.units.getArmy();
			boolean result = true;
			for(int i =0 ; i<army.length;i++) {
				MilitaryUnit enemy = army[i]; // copy all the element in army to the enemy
				
				if(!obj.getFaction().equals(enemy.getFaction())) { //are not in the same faction
					result = false;
					break;
				}		
			}
			if(result) {
			 units.add(obj);
			}
		return result; //non military can always add
		}
		else {
			units.add(obj);
			return true;
		}
	}


	//remove the input unit from the tile's ListOfUnit
	//return boolean indicate whether or not the operation is successful
	public boolean removeUnit(Unit obj) {
		return units.remove(obj);
		}
		
	
	
	//return enemy unit
	public Unit selectWeakEnemy(String faction) {
		Unit[] allUnits = units.getUnits();
		int count =0; //count the number of enemy
		for(int i=0; i<units.size();i++) {
			if(!allUnits[i].getFaction().equals(faction)){ // if in the different faction, number of enemy++
				count++;
			}
		}
		
		if(count >0) {
			Unit[] enemy = new Unit[count];
			for(int  j =0; j<count;j++) {
				for(int i=0;i<units.size();i++) {
					enemy[j] = allUnits[i];
				}
			}
			
			int index = 0; 
			for(int i =0;i<count;i++) {
				if(enemy[i].getHP()<enemy[0].getHP()) {//compare the hp of enemy with the first one
					index = i;
				}
			}
			return enemy[index];
		}else return null; // no enemy present, null
			
	}

	
	public static double getDistance(Tile a, Tile b) {
		double x1 = a.x_co;
		double y1 = a.y_co;
		double x2 = b.x_co;
		double y2 = b.y_co;
		double distance = Math.sqrt(Math.pow((x1-x2),2)+Math.pow((y1-y2),2));
		return distance;
	}


}

