package com.example.root.osp_lab3;

/**
 * 
 * @author razvan
 * Compute the value of PI given a precision value
 * The computation is done using Viete's series where:
 * 2 / pi = (sqtr(2)/2) * (sqrt(2+sqrt(2))/2) * .....
 * The precision is the number of elements in the series to be computed
 */
public class PiComputer {
	private int precision;
	
	public PiComputer(int precision) {
		this.precision = precision;
	}
	
	public double compute() {
		int i, j;
		double f;
		double pi = 1;

		for(i = precision; i > 1; i--) {
			f = 2;
			for(j = 1; j < i; j++){
				f = 2 + Math.sqrt(f);
			}
			f = Math.sqrt(f);
			pi = pi * f / 2;
		}
		pi *= Math.sqrt(2) / 2;
		pi = 2 / pi;
		
		return pi;
	}
}
