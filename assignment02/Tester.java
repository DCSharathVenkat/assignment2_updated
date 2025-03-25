package assignment02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class Tester {
	// for taxable income up to 99,999 use https://www.irs.gov/instructions/i1040tt
	// PLEASE NOTE that the tables showing how to calculate taxes over $100,000 do NOT include the Medicare surcharge
	// which the AARP calculator does.
	// this page also shows Earned Income Credit but IGNORE that for this assignment.
	// for taxable income 100,000 and above use:
	// https://www.aarp.org/money/taxes/1040-tax-calculator/?cmp=KNC-DMP-COR-Core-Money-Tax-NonBrand-Phrase-52385-GOOG-MONY-1040TaxCalculator-Phrase-NonBrand&gad_source=1&gclid=EAIaIQobChMIo_P95-viiwMVGGZHAR1JEjRYEAAYASAAEgJIV_D_BwE&gclsrc=aw.ds

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		TaxComponent payer = new Single(null);
		payer = new Bracket1(payer);
		payer = new Bracket2(payer);
		payer = new Bracket3(payer);
		payer = new Bracket4(payer);
		payer = new Bracket5(payer);
		payer = new Bracket6(payer);
		payer = new Bracket7(payer);
		Scanner scan = new Scanner(new FileReader("single.txt"));
		int count = 0;
		while (scan.hasNextLine()) {
			count++;
			String input = scan.nextLine();
			if(input.trim().length() > 0) {
				String[] line = input.trim().split("\s");
				payer.setIncome(14600 + Integer.parseInt(line[0].trim()));
				int tax = (int)Math.round(payer.getTaxInfo().taxdue());
				if(tax != Integer.parseInt(line[1])) {
					System.out.println(Arrays.toString(line));
					System.out.printf("\n%d: %s: %d: %.2f\n", payer.getTaxableIncome(), line[1], tax, payer.getTaxInfo().taxdue());
				}
			}
		}
		System.out.println(count); // should be 2075
		
		payer = new MarriedFJ(null);
		payer = new Bracket1(payer);
		payer = new Bracket2(payer);
		payer = new Bracket3(payer);
		payer = new Bracket4(payer);
		payer = new Bracket5(payer);
		payer = new Bracket6(payer);
		payer = new Bracket7(payer);
		scan = new Scanner(new FileReader("marriedfj.txt"));
		count = 0;		
		while (scan.hasNextLine()) {
			count++;
			String input = scan.nextLine();
			if(input.trim().length() > 0) {
				String[] line = input.trim().split("\s");
				payer.setIncome(29200 + Integer.parseInt(line[0].trim()));
				int tax = (int)Math.round(payer.getTaxInfo().taxdue());
				if(tax != Integer.parseInt(line[1])) {
					System.out.println(Arrays.toString(line));
					System.out.printf("\n%d: %s: %d: %.2f\n", payer.getTaxableIncome(), line[1], tax, payer.getTaxInfo().taxdue());
				}
			}
		}
		System.out.println(count); // should be 2076

		payer = new MarriedFS(null);
		payer = new Bracket1(payer);
		payer = new Bracket2(payer);
		payer = new Bracket3(payer);
		payer = new Bracket4(payer);
		payer = new Bracket5(payer);
		payer = new Bracket6(payer);
		payer = new Bracket7(payer);
		scan = new Scanner(new FileReader("marriedfs.txt"));
		count = 0;

		while (scan.hasNextLine()) {
			count++;
			String input = scan.nextLine();
			if(input.trim().length() > 0) {
				String[] line = input.trim().split("\s");
				payer.setIncome(14600 + Integer.parseInt(line[0].trim()));
				int tax = (int)Math.round(payer.getTaxInfo().taxdue());
				if(tax != Integer.parseInt(line[1])) {
					System.out.println(Arrays.toString(line));
					System.out.printf("\n%d: %s: %d: %.2f\n", payer.getTaxableIncome(), line[1], tax, payer.getTaxInfo().taxdue());
				}
			}
		}
		System.out.println(count); // should be 2076

		payer = new HeadofHouse(null);
		payer = new Bracket1(payer);
		payer = new Bracket2(payer);
		payer = new Bracket3(payer);
		payer = new Bracket4(payer);
		payer = new Bracket5(payer);
		payer = new Bracket6(payer);
		payer = new Bracket7(payer);
		scan = new Scanner(new FileReader("hoh.txt"));
		count = 0;

		while (scan.hasNextLine()) {
			count++;
			String input = scan.nextLine();
			if(input.trim().length() > 0) {
				String[] line = input.trim().split("\s");
				payer.setIncome(21900 + Integer.parseInt(line[0].trim()));
				int tax = (int)Math.round(payer.getTaxInfo().taxdue());
				if(tax != Integer.parseInt(line[1])) {
					System.out.println(Arrays.toString(line));
					System.out.printf("\n%d: %s: %d: %.2f\n", payer.getTaxableIncome(), line[1], tax, payer.getTaxInfo().taxdue());
				}
			}
		}
		System.out.println(count); // should be 2076
		
	}

}
