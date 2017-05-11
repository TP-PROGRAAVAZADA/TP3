package misClases;

import misClases.Polinomio;

public class Main {

	public static void main(String[] args) {
		double [] vec = new double [] {20,10,5};
		Polinomio pol = new Polinomio(2,vec);
		int num =14;
		System.out.println(pol.evaluarRecursiva(num));
		System.out.println(pol.evaluarRecursivaPar(num));
		System.out.println(pol.ProgDinamica2(num));
		System.out.println(pol);

	}

}
