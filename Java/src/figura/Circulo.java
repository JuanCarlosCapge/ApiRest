package figura;

public class Circulo extends Figura{
	
	public float radio;

	@Override
	public float area() {
		return 3.1415f *(this.radio * this.radio);
	}
	

}
