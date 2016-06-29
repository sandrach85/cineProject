package business.api.exceptions;

public class NotFoundInterpretationIdException extends ApiException {
	
	private static final long serialVersionUID = 1L;
    public static final String DESCRIPTION = "La interpretación referenciada no existe";

    public static final int CODE = 1;
    
    public NotFoundInterpretationIdException(String description) {
    	super(DESCRIPTION + ". " + description, CODE);
	}

}
