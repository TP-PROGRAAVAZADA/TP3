package misClases;

public class Polinomio {
	
	private int grado ;
	private double [ ] coeficientes;
	private double res = 0;
	private double [ ][ ] resultados;//resultados para el punto 3 [base][exp]
	public static final int FIL = 100;
	public static final int COL = 100;
	/**
	 * La posicion 0 del arreglo de coeficientes contiene el 
	 * coeficiente de grado n y la
	 * posicion n contiene al termino independiente. 
	*/
	
	//Constructor
	public Polinomio(int grado, double[] coeficientes){
		
		this.grado = grado;
		this.coeficientes = coeficientes;
		resultados = new double[FIL][COL];//para la prog Dinamica
	}
	
	//geters and setters
		public int getGrado() {
			return grado;
		}
		public double[] getCoeficientes() {
			return coeficientes;
		}
	
	
	public double evaluarMSucesivas(double x ){
		double res=0;
		for(int i = 0; i < coeficientes.length - 1; i++ ){
			
			 res += coeficientes[i]*potenciaMultSuc(x,grado - i); 
		}
		res += coeficientes[grado];
		return res;
	}
	
	public double evaluarRecursiva (double x ){
		
		return res;
	} 
	
	double evaluarRecursivaPar (double x ){
		return res;
	} 
	//Metodo para evaluar el polinomio en un punto con prog dinamica
	public double evaluarProgDinamica (int x ){
		double res=0;
		for(int i = 0; i < coeficientes.length - 1; i++ ){
			
			 res += coeficientes[i]*potenciaDinamica(x,grado - i); 
		}
		res += coeficientes[grado];
		return res;
		
	}
	
	public double evaluarMejorada (double x ){
		return res;
	}
	
	public double evaluarPow (double x ){
		return res;
	}
	public double evaluarHorner ( double x ){
		return res;
	}
   
	/// No se si servira, para validar la cantidad de coeficientes segun el grado
	public void cargarCoeficientes(){
		
		
	}
	//Lo usa evalua con mulSuc
	//calcula las potencias con multiplicaciones sucesivas
	public double potenciaMultSuc(double base , int exponente){
		
		double res = base ;
		for(int i = 0; i < exponente -1; i++){
			
			res *= base;
		}
		return res;
		
	}
	//El siguiente metodo lo usa el metodo evaluaDinamica
	public double potenciaDinamica(int base , int exponente){
		
		cargarMatrizResultados();
		if(resultados[base][exponente] != 0 ) return resultados[base][exponente];
		if( exponente == 0 ) return 1;
		return resultados[base][exponente] = base*potenciaDinamica(base,exponente-1);
		
		
	}
	//para la programacion dinamica
	public void cargarMatrizResultados(){
		
		for(int i= 1; i < FIL ; i++){
			
			for(int j=1; j < COL; j++ )
				
				resultados[i][j] = 0;//llena por columnas
			
		}
	}
	
}
