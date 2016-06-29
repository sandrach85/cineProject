package business.api.exceptions;

public class NotFoundPersonIdException extends ApiException{
	private static final long serialVersionUID = 1L;
    public static final String DESCRIPTION = "La persona referenciada no existe";

    public static final int CODE = 1;
	public NotFoundPersonIdException(String description) {
		super(DESCRIPTION + ". " + description, CODE);
	}
}
