package Tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import misClases.Polinomio;

public class PolinomioTest {

	//p(x) = 2x^2 + 3x + 4
	@Test
	public void pruebaConstructor(){
		double[] coeficientes = {2,3,4};
		Polinomio p = new Polinomio(2,coeficientes); 
		Assert.assertArrayEquals(coeficientes, p.getCoeficientes(),0.00001);
		Assert.assertEquals(2,p.getGrado());
	}
	
	@Test
	public void pruebaPotenciaMultSuc(){
		
		Assert.assertEquals(3125,Polinomio.potenciaMultSuc(5,5),0.000001);
		
	}
	
	@Test
	public void pruebaEvaluarMSucesivas(){
		
		double[] coeficientes = {2,3,4};
		Polinomio p = new Polinomio(2,coeficientes); 
		Assert.assertEquals(18,p.evaluarMSucesivas(2),0.000001);
		
	}
	
	@Test
	public void pruebaPotenciaDinamica(){
		
		double[] coeficientes = {2,3,4};
		Polinomio p = new Polinomio(2,coeficientes);
		Assert.assertEquals(243,p.potenciaDinamica(3,5),0.000001);
		
	}
	@Test
	public void pruebaEvaluarDinamica(){
		
		double[] coeficientes = {2,3,4};
		Polinomio p = new Polinomio(2,coeficientes); 
		Assert.assertEquals(18,p.evaluarProgDinamica(2),0.000001);
		
	}

}
