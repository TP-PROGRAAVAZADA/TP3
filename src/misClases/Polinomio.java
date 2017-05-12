package misClases;

public class Polinomio {
	
	private int grado ;
	private double [ ] coeficientes;
	private double [ ][ ] resultados;//resultados para el punto 3 [base][exp]
	public static final int FIL = 100;
	public static final int COL = 100;
	private double [] datos;//para la otra forma de ProgDinamica
	/**
	 * La posicion 0 del arreglo de coeficientes contiene el 
	 * coeficiente de grado n y la
	 * posicion n contiene al termino independiente. 
	*/
	
	//Constructor
	public Polinomio(int grado, double[] coeficientes){
		this.grado = grado;
		this.coeficientes = coeficientes;
		datos = new double [grado+1];//Vector de datos para la prog Dinamica
		datos [grado] = 1;//Inicializando potencia de x^0
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
	// Evaluacion de la recursividad
	public double evaluarRecursiva(double x){
		double suma = 0;
		 for(int i=0;i<=grado;i++){
			suma+=potencia(x,grado-i)*coeficientes[i];
		}
		return suma;
	}
	//Metodo recursivo para el calculo de la potencia sin considerar la paridad del exponente
	public double potencia(double x, int n){
		if(n>0){
			return x*potencia(x,n-1);
		}else
			return 1;
	}
	// Evaluacion de la recursividad Par
	public double evaluarRecursivaPar(double x){
		double suma = 0;
		 for(int i=0;i<=grado;i++){
			suma+=potencia2(x,grado-i)*coeficientes[i];
		}
		return suma;
	}
	//Metodo recursivo para el calculo de la potencia considerando la paridad del exponente
	public double potencia2(double x, int n){
		if(n>0){
			if(n%2==0){
				return potencia(x*x,n/2);
			}
			else
				return x*potencia(x,n-1);
		}
	return 1;
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
		//Placeholder para evaluarMejorada
		public double progDinamicaRecursiva (double x){
			double suma = 0;
			 for(int i=0;i<=grado;i++){
				suma+=potprogdinamica(x,grado-i)*coeficientes[i];
			}
			return suma;
		}
		
		public double potprogdinamica(double x, int n){
			if(coeficientes[n]==0&&x!=0)
				return coeficientes[n];
			if(n>0){
				return x*potencia(x,n-1);
			}else
				return 1;
		}
	//Metodo que evalua en un polinomio usando MathPow
	public double evaluarPow (double x ){
		double suma = 0;
		 for(int i=0;i<=grado;i++){
			suma+=Math.pow(x, grado-i)*coeficientes[i];
		}
		return suma;
	}
	
	//Metodo que evalua el polinomio mediante el metodo Horner de analisis matematico
	public double evaluarHorner ( double x ){
		double suma= coeficientes[0];
		for(int i=1;i<=grado;i++){
			suma=coeficientes[i]+x*suma;
		}
		return suma;
	}
   
	/// No se si servira, para validar la cantidad de coeficientes segun el grado
	public void cargarCoeficientes(){
		
		
	}
	//Lo usa evalua con mulSuc
	//calcula las potencias con multiplicaciones sucesivas
	public static double potenciaMultSuc(double base , int exponente){
		
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
	//Metodo de programacion dinamica guardando potencias ya calculadas en un vector
	public double progDinamica2(double x){
		double suma =0;
		for(int i=grado;i>=0;i--){
			if(datos[i]==0&&x!=0){
				suma+=coeficientes[i]*x*datos[i+1];
				datos[i]=x*(datos[i+1]);
			}
			else
				suma+=coeficientes[i]*datos[i];
		}
		return suma;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("y=");
		for(int i =0;i<grado;i++){
			string.append(coeficientes[i]+"x^"+(grado-i)+"+");
		}
		string.append(coeficientes[grado]);
		return string.toString();
	}
}
