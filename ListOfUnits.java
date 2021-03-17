

public class ListOfUnits {
	private Unit[] units;//array of Units used to store the units part of the ListOfUnit
	private int size;//how many units have been stored in this list
	
	//constructor:create an empty ListOfUnits
	public ListOfUnits() {
		units = new Unit[10];
		size = 0;
	}
	
	//other method
	//return the number of units of this ListOfUnits
	public int size() {
		return this.size;
	
	}
	
	//return an array containing the units part of the ListOfUnit
	public Unit[] getUnits() {
		//return this.units;
	//	create a new array which copy the non-null element
		Unit[] copy = new Unit[this.size];
		for(int i =0; i<this.size;i++) {
			copy[i] = this.units[i];
		}
		
		return copy;
	}
	
	//return the i-nth unit in this List
	public Unit get(int i) {
		if(i < 0||i>=this.size) {
			throw new IndexOutOfBoundsException();
		}
			return this.units[i];
	}
	
	//add the Unit at the end of the list
	public void add(Unit obj) {
		if(this.size() == this.units.length) {//if the last space is not free, resize the list
			Unit[] newArray = new Unit[units.length + units.length/2 +1];
				for(int i =0; i< this.size;i++) {
					newArray[i] = this.units[i];
				}
				this.units = newArray;
				this.units[this.size] = obj;
		}
				this.units[this.size] = obj;
				this.size++;
	}

	//return an int indicating the position of the first occurrence of obj
	//if no such element exist, return -1
	public int indexOf(Unit a) {
		int index = -1;
		for(int i=0;i<this.size;i++) {    
			if(this.units[i].equals(a)) {
				index = i;
				break;
			}
		}
		return index;
	}

	
	public boolean remove(Unit a) {
		int i = indexOf(a);
		if(i == -1) {
			return false;
		}else {
		for(int k=i;k<this.size;k++) {//shift down by one position
			units[k]=units[k+1];		
		}
		this.size = this.size-1;	
		return true;
		}
	}

	
	
	public MilitaryUnit[] getArmy() {
		// get the number of object MilitaryUnit in the Unit[]
		int newArrSize = 0;
		
		for(int i =0; i<this.size;i++) {
			if(units[i] instanceof MilitaryUnit) {
				newArrSize++;
			}
		}
		
		//create a MilitaryUnit[]
		MilitaryUnit[] militaryUnits = new MilitaryUnit[newArrSize];
		int position = 0;
		for(int j =0; j<this.size;j++) {
			if(units[j] instanceof MilitaryUnit) {
				militaryUnits[position] = (MilitaryUnit) units[j];
				position++;
			}
		}
		return militaryUnits;
	}
	

}
