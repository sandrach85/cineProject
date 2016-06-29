package business.api.exceptions;

public class NotFoundDirectionIdException extends ApiException {

	private static final long serialVersionUID = 1L;
    public static final String DESCRIPTION = "La dirección referenciada no existe";

    public static final int CODE = 1;
	public NotFoundDirectionIdException(String description) {
		super(DESCRIPTION + ". " + description, CODE);
	}
}
