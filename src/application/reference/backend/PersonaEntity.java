package application.reference.backend;

public class PersonaEntity {
	private short id;
	private String nombre;
	private String apellido;
	private float deuda;
	private String telefono;


	public PersonaEntity() {

	}

	public PersonaEntity(int id, String nombre, String apellido, float deuda, String telefono) {
		this.id = (short) id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.deuda = deuda;
		this.telefono = telefono;
	}
	
	public PersonaEntity( String nombre, String apellido, float deuda, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.deuda = deuda;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = (short) id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public float getDeuda() {
		return deuda;
	}

	public void setDeuda(float deuda) {
		this.deuda = deuda;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "PersonaModel [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", deuda=" + deuda
				+ ", telefono=" + telefono + "]";
	}

}
