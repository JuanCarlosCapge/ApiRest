package repaso;

public class PersonaMain extends Persona{

		private String idProfesor;
	
	public PersonaMain(String nombre, String apellidos, int edad) {
		
		
		super(nombre, apellidos, edad);

		idProfesor="maestro";
	}

		public void setidProfesor(String idProfesor) {
			this.idProfesor= idProfesor;
		}
		
		public String getIdProfesor() {
			return idProfesor;
		}
	
		
		public void mostrarNombreApellidosCarnet() {
			System.out.println("El profesor se llama " + getNombre () + " " + getApellidos () + " Con id de profesor " + getIdProfesor ());
		}
		
		

		
		
		
		
	public static void main(String[] args) {

		
	PersonaMain profe = new PersonaMain("Juan Carlos", "Pedraza", 30);
	System.out.println(profe.getApellidos() +profe.getEdad() + profe.getNombre() + profe.getIdProfesor());

	
		
	}

}
