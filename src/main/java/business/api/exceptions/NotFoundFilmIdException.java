package business.api.exceptions;

public class NotFoundFilmIdException extends ApiException {

	private static final long serialVersionUID = 1L;
	public static final String DESCRIPTION = "La película referenciada no existe";
	
    public static final int CODE = 1;
	public NotFoundFilmIdException(String description) {
		super(DESCRIPTION + ". " + description, CODE);
	}

}
