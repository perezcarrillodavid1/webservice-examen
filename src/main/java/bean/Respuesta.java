package bean;

public class Respuesta {
	private boolean correcto;

	public boolean isCorrecto() {
		return correcto;
	}

	public void setCorrecto(boolean correcto) {
		this.correcto = correcto;
	}

	public Respuesta(boolean correcto) {
		super();
		this.correcto = correcto;
	}
	
}
