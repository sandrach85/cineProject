package business.api.exceptions;

public class NotFoundThemeUsedIdException extends ApiException {

	private static final long serialVersionUID = 1L;
    public static final String DESCRIPTION = "El tema usado con la referenciada no existe";

    public static final int CODE = 1;
	public NotFoundThemeUsedIdException(String description) {
		super(DESCRIPTION + ". " + description, CODE);
	} 

}
