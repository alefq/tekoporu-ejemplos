package py.gov.setics.asistente.event;

public class TestEvent {
	private final String message;

	public TestEvent(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}