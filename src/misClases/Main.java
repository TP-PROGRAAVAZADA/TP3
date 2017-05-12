package misClases;

import misClases.Polinomio;

public class Main {

	public static void main(String[] args) {
		double [] vec = new double [] {20,10,5};
		Polinomio pol = new Polinomio(2,vec);
		int num =-20;
		System.out.println("evaluarRecursiva");
		System.out.println(pol.evaluarRecursiva(num));
		System.out.println("evaluarRecursivaPar");
		System.out.println(pol.evaluarRecursivaPar(num));
		System.out.println("evaluarProgDinamica2");
		System.out.println(pol.progDinamica2(num));
		System.out.println("evaluarHorner");
		System.out.println(pol.evaluarHorner(num));
		System.out.println(pol);

	}

}
