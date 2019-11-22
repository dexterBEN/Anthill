package utils;

public enum AntType {
	QUEEN("Q"),
	FIGHTER("F"),
	WORKER("W");
	
	private final String badge;

    private AntType(String badge) {
        this.badge = badge;
    }
    
    public String getBadge() {
    	return this.badge;
    }
}
