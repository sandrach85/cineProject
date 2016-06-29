package business.api.exceptions;

public class NotFoundThemeIdException extends ApiException {
	private static final long serialVersionUID = 1L;
    public static final String DESCRIPTION = "El tema referenciado no existe";

    public static final int CODE = 1;
	public NotFoundThemeIdException(String description) {
		super(DESCRIPTION + ". " + description, CODE);
	}
}
