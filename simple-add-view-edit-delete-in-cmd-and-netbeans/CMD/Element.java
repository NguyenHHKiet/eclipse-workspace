class Element {
     //	INSTANCE VARIABLES
    
	public String       name;
        public String       group;
	public static int   atomnum;
	private String      symbol;
	private double      atommass;
	private double      atomdense;
	private double      melt;
	private double      boil;
        public String       use;
	
        //OVERLOADING CONSTRUCTORS

    public Element(String name, String group, int atomnum, String symbol, double atommass, double atomdense, double melt, double boil, String use) {
        this.name = name;
	this.group = group;
	this.atomnum = atomnum;
	this.symbol = symbol;
	this.atommass = atommass;
	this.atomdense = atomdense;
	this.melt = melt;
	this.boil = boil;
	this.use = use;
    }

    Element() {
        name = "";
	group = "";
	atomnum = 0;
	symbol = "";
	atommass = 0.0;
	atomdense = 0.0;
	melt = 0.0;
	boil = 0.0;
	use = "";
    }
    
 //SETTERS OR MUTATOR METHODS
 // @param temp
    
        void setName(String name) {
            this.name = name;
        }

        static void setAtomnum(int temp) {
            atomnum = temp;
        }

        void setUse(String use) {
            this.use = use;
        }

        void setAtommass(double atommass) {
            this.atommass = atommass;
        }

        void setAtomdense(double atomdense) {
            this.atomdense = atomdense;
        }

        void setMelt(double melt) {
            this.melt = melt;
        }

        void setBoil(double boil) {
            this.boil = boil;
        }

        void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        void setGroup(String group) {
            this.group = group;
        }

//GETTERS OR ACCESSOR METHODS
// @return 
        
	public String getName(){
		return name;
	}
        public String getGroup(){
		return group;
	}
	public int getAtomnum(){
		return atomnum;
	}
        public String getSymbol(){
		return symbol;
	}
	public double getAtommass(){
		return atommass;
	}
	public double getAtomdense(){
		return 	atomdense;	
	}
	public double getMelt(){
		return 	melt;	
	}
        public double getBoil(){
		return 	boil;	
	}
        public String getUse(){
		return 	use;	
	}
}