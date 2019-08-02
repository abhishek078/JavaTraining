package com.visa.training;
class ChemicalElements {

	private int atomicNumber;
	private String symbolicName;
	private String fullName;
	
	private static boolean arr[] = new boolean[120];
	
	static {
		arr[13] = true;
		arr[49] = true;
		arr[50] = true;
		arr[81] = true;
		arr[82] = true;
		arr[83] = true;
		arr[113] = true;
		arr[114] = true;
		arr[115] = true;
		arr[116] = true;
	}

	public ChemicalElements(int atomicNumber, String symbolicName, String fullName) {
		this.atomicNumber = atomicNumber;
		this.symbolicName = symbolicName;
		this.fullName = fullName;
	}

	public boolean isAlkaliMetal() {
		switch (atomicNumber) {
		case 3:
			return true;
		// break;
		case 11:
			return true;
		// break;
		case 19:
			return true;
		// break;
		case 37:
			return true;
		// break;
		case 55:
			return true;
		// break;
		case 87:
			return true;
		// break;
		default:
			return false;
		}

		// return false;
	}

	public boolean isTransitionMetal() {

		return ((atomicNumber >= 21 && atomicNumber <= 31) || (atomicNumber >= 39 && atomicNumber <= 48)
				|| (atomicNumber >= 72 && atomicNumber <= 80) || (atomicNumber >= 104 && atomicNumber <= 112));
	}

	public boolean isMetal() {
		return arr[atomicNumber];
	}

	public boolean equals(ChemicalElements o) {
		if(!(o instanceof ChemicalElements))
				return false;
		ChemicalElements other = (ChemicalElements) o;
		return (this.atomicNumber == other.atomicNumber);
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public String getSymbolicName() {
		return symbolicName;
	}

	public String getFullName() {
		return fullName;
	}
	

}

public class ChemicalElementApp {

	public static void main(String[] args) {

		ChemicalElements pot = new ChemicalElements(1, "K", "Potassium");
		boolean b = pot.isMetal();
		System.out.println(b);
		
		printDetails(pot);

		ChemicalElements hyd = new ChemicalElements(1, "H", "Hydrogen");

		boolean a = hyd.equals(pot);
		System.out.println(a);

		// boolean a =
	}

	private static void printDetails(ChemicalElements obj) {
		System.out.println("Element "+obj.getFullName()+" Atomic Number "+obj.getAtomicNumber());
	}
}
