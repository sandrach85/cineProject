package data.entities;

public enum Role {
	DIRECTOR, ACTOR;
	
	public String roleName() {
        return "ROLE_" + this.toString();
    }

}
