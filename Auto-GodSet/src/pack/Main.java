package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	
	String[] e = {"Protection", "Fire Protection", "Feather Falling", "Blast Protection", 
			"ProjectileProtection", "Thorns", "Respiration", "Depth Strider", 
			"Aqua Affinity", "Sharpness", "Smite", "Bane of Arthropods", "Knockback", 
			"Fire Aspect", "Looting", "Efficiency", "Silk Touch", "Unbreaking", "Fortune", 
			"Power", "Punch", "Flame", "Infinity", "Luck of the Sea", "Lure", "Frost Walker",
			"Mending", "Curse of Binding", "Curse of Vanishing", "Impaling", "Riptide",
			"Loyalty", "Channeling", "Multishot", "Piercing", "Quick Charge", "Soul Speed", 
			"Sweeping Edge"};
	
	String[] e2 = {"Protection", "Fire Protection", "Feather Falling", "Blast Protection", 
			"ProjectileProtection", "Thorns", "Respiration", "Depth Strider", 
			"Aqua Affinity", "Sharpness", "Smite", "Bane of Arthropods", "Knockback", 
			"Fire Aspect", "Looting", "Efficiency", "Silk Touch", "Unbreaking", "Fortune", 
			"Power", "Punch", "Flame", "Infinity", "Luck of the Sea", "Lure", "Frost Walker",
			"Mending", "Curse of Binding", "Curse of Vanishing", "Impaling", "Riptide",
			"Loyalty", "Channeling", "Multishot", "Piercing", "Quick Charge", "Soul Speed", 
			"Sweeping Edge"};
	
	String[] t = {"Sword", "Axe", "Pickaxe", "Shovel", "Hoe", "Helmet", "Chestplate", "Leggings", ""};
	String[] se = {"Sharpness", "Smite", "Bane of Arthropods", "Looting", "Unbreaking", "Mending", "Sweeping Edge", "Knockback", "Fire Aspect", "Curse of Vanishing"};
	String[] ae = {"Sharpness", "Smite", "Bane of Arthropods", "Unbreaking", "Mending", "Efficiency", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] pe = {"Efficiency", "Unbreaking", "Mending", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] she = {"Efficiency", "Unbreaking", "Mending", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] he = {"Efficiency", "Unbreaking", "Mending", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] hee = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Respiration", "Aqua Affinity", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] ce = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] le = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] be = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Depth Strider", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing", "Soul Speed", "Frost Walker",
			"Feather Falling"};
	
	ArrayList<String> compute = new ArrayList<>();
	ArrayList<String> fin = new ArrayList<>();
	ArrayList<String> seq = new ArrayList<>();
	
	int[] m = {4,4,4,4,4,3,3,3,1,5,5,5,2,2,3,5,1,3,3,5,2,1,1,3,3,2,1,1,1,5,3,3,1,1,4,3,3,3};
	int[] i = {1,1,1,2,1,4,2,2,2,1,1,1,1,2,2,1,4,1,2,1,2,2,4,2,2,2,2,4,4,2,2,1,4,2,1,1,4,2};
	
	//This is just data about the enchantments that I need to store to calculate cost.
	
	String tempEn = "error";
	String item;

	int[] tempFin;
	
	public void setUp() {
		
		System.out.println("What would you like to enchant? (Say sword if Diamond sword, don't include material).");
		
		Scanner in1 = new Scanner(System.in);  //Input item.
		
		item = in1.nextLine(); 
		
		boolean listing = true;
		boolean god = false;
		while (listing) {
		enchantQuery();
		if (tempEn.equalsIgnoreCase("List")) {
			list();
		}
		else if (Arrays.asList(e).contains(tempEn)) {
			listing = false;
		}
		else if (tempEn.equalsIgnoreCase("God")) {
			listing = false;
			god = true;
		}
		else {
			System.out.println("This is not a proper enchantment. Please input a correct one.");
		}
		}
		
		if(item.equalsIgnoreCase("Sword")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(se[0], se[3], se[4], se[5], se[6], se[7], se[8], "none", "none");
				compute();	
			}		
			else {
				procedure(se);
			}
		}
		else if(item.equalsIgnoreCase("Axe")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(ae[0], ae[3], ae[4], ae[5], ae[7], "none", "none", "none", "none");
				compute();	
			}		
			else {
				procedure(ae);
			}
		}
		else if(item.equalsIgnoreCase("Pickaxe") || item.equalsIgnoreCase("Pick")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(pe[0], pe[1], pe[2], pe[3], "none", "none", "none", "none", "none");
				compute();	
			}		
			else {
				procedure(pe);
			}
		}
		else if(item.equalsIgnoreCase("Shovel")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(she[0], she[1], she[2], she[3], "none", "none", "none", "none", "none");
				compute();	
			}		
			else {
				procedure(she);
			}
		}
		else if(item.equalsIgnoreCase("Hoe")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(he[0], he[1], he[2], he[3], "none", "none", "none", "none", "none");
				compute();	
			}		
			else {
				procedure(he);
			}
		}
		else if(item.equalsIgnoreCase("Helmet")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(hee[0], hee[4], hee[5], hee[6], hee[7], hee[8], "none",  "none", "none");
				compute();	
			}		
			else {
				procedure(hee);
			}
		}
		else if(item.equalsIgnoreCase("Chestplate")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(ce[0], ce[4], ce[5], ce[6], "none", "none", "none", "none", "none");
				compute();	
			}		
			else {
				procedure(se);
			}
		}
		else if(item.equalsIgnoreCase("Leggings")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(le[0], le[4], le[5], le[6], "none", "none", "none", "none", "none");
				compute();	
			}		
			else {
				procedure(le);
			}
		}
		else if(item.equalsIgnoreCase("Boots")) {

			if (tempEn.equalsIgnoreCase("God")) {
				setCompute(be[0], be[4], be[5], be[6], be[7], be[10], be[12], "none", "none");
				compute();	
			}		
			else {
				procedure(be);
			}
		}
			
				
	}
	
	public void enchantQuery() {
		
		System.out.println("What would you like to have on the enchantment? All enchantments will be assummed to be maximum.");
		System.out.println("Type 'God' for standard god gear.");
		System.out.println("Type 'List' to get a list to copy and paste from (you must get the exact phrase or it won't register).");
		
		Scanner in2 = new Scanner(System.in);  //Input enchantment.
		
		tempEn = in2.nextLine(); 
		
	}
	
	public void eq2() {
		
		System.out.println("Input another enchantment if you would like one. All enchantments will be assummed to be maximum.");
		System.out.println("Type 'List' to get a list to copy and paste from (you must get the exact phrase or it won't register).");
		System.out.println("Type 'Stop' to end adding new enchantments");
		
		Scanner in2 = new Scanner(System.in);  //Input enchantment.
		
		tempEn = in2.nextLine(); 
	}
	
	public void compute() {
		
		String tempNum;
		int tempNumInt;
		
		Object[] conv = compute.toArray();
		String[] convert = Arrays.copyOf(conv, conv.length, String[].class);
		
		for(int l = 0; l < e.length; l++) {
			tempNumInt = m[l] * i[l];
			tempNum = String.valueOf(tempNumInt);
			e[l] = e[l]+tempNum;
		}
		for(int r = 0; r < e2.length; r++) {
			for(int l = 0; l < compute.size(); l++) {
			
				if (e2[r].equalsIgnoreCase(convert[l])) {
					fin.add(e2[r]);
				}
			}
		}
		
	    Collections.sort(fin, new Comparator<String>() {
	        public int compare(String o1, String o2) {
	            return extractInt(o2) - extractInt(o1);
	        }

	        int extractInt(String s) {
	            String num = s.replaceAll("\\D", "");
	            // return 0 if no digits found
	            return num.isEmpty() ? 0 : Integer.parseInt(num);
	        }
	    });
	    
	    Object[] fina = fin.toArray();
		String[] f = Arrays.copyOf(fina, fina.length, String[].class);
		
		if (fin.size() == 1) {
			seq.add(f[0]);
		}
		
		else {
		seq.add(f[0]);
		seq.add(f[1]);
		
			if (fin.size() == 3) {
				seq.add(f[2]);
			}
			else if (fin.size() == 4) {
				seq.add(f[3]);
				seq.add(f[2]);
			}
			else if (fin.size() == 5) {
				seq.add(f[3]);
				seq.add(f[2]);
				seq.add(f[4]);
			}
			else if (fin.size() == 6) {
				seq.add(f[3]);
				seq.add(f[2]);
				seq.add(f[4]);
				seq.add(f[5]);
			}
			else if (fin.size() == 7) {
				seq.add(f[3]);
				seq.add(f[2]);
				seq.add(f[4]);
				seq.add(f[5]);
				seq.add(f[6]);
			}
			else if (fin.size() == 8) {
				seq.add(f[3]);
				seq.add(f[7]);
				seq.add(f[2]);
				seq.add(f[4]);
				seq.add(f[5]);
				seq.add(f[6]);
			}
			else if (fin.size() == 9) {
				seq.add(f[3]);
				seq.add(f[7]);
				seq.add(f[2]);
				seq.add(f[4]);
				seq.add(f[5]);
				seq.add(f[8]);
				seq.add(f[6]);
			}
		}
		
	    Object[] print = seq.toArray();
		String[] p = Arrays.copyOf(print, print.length, String[].class); //turns final organized array list into readable data
		
		System.out.println("");
		
		if (seq.size() == 1) {
			System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
		}
		else if (seq.size() == 2) {
			System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
			System.out.println("Combine your " + p[0] + " " + item + " with " + p[1] + ".");
		}
		else if (seq.size() == 3) {
			System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("Finally combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
		}
		else if (seq.size() == 4) {
			System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Finally combine your " + item + " with the " + p[3] + " book.");
		}
		else if (seq.size() == 5) {
			System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			System.out.println("Finally combine your " + item + " with your " + p[3] + " and " + p[4] + " book.");
		}
		else if (seq.size() == 6) {
			System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			System.out.println("Afterwards combine your " + item + " with your " + p[3] + " and " + p[4] + " book.");
			System.out.println("Finally combine your " + item + " with the " + p[5] + " book.");
		}
		else if (seq.size() == 7) {
			System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			System.out.println("Then combine your " + p[5] + " book with your " + p[6] + " book.");
			System.out.println("Afterwards combine your " + p[3] + " and " + p[4] + "book with your " + p[5] + " and " + p[6] + " book.");
			System.out.println("Finally combine your " + item + " and your very enchanted book.");
		}
		else if (seq.size() == 8) {
			System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your" + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Now combine your" + p[3] + " book with your " + p[4] + " book.");
			System.out.println("Then combine your" + p[5] + " book with your " + p[6] + " book.");
			System.out.println("Afterwards combine your " + p[3] + " and " + p[4] + " book with your " + p[5] + " and " + p[6] + " book.");
			System.out.println("Next combine your " + item + " and your very enchanted book.");
			System.out.println("Finally combine your " + item + " and the " + p[7] + " book.");	
		}
		else if (seq.size() == 8) {
		System.out.println("Combine " + item + " with " + p[0] + " in an anvil.");
		System.out.println("Next combine your" + p[1] + " book with your " + p[2] + " book.");
		System.out.println("After that, combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
		System.out.println("Now combine your" + p[3] + " book with your " + p[4] + " book.");
		System.out.println("Then combine your" + p[5] + " book with your " + p[6] + " book.");
		System.out.println("Afterwards combine your " + p[3] + " and " + p[4] + " book with your " + p[5] + " and " + p[6] + " book.");
		System.out.println("Next combine your " + item + " and your very enchanted book.");
		System.out.println("After that, combine the " + p[7] + " book with the " + p[8] + " book");
		System.out.println("Finally combine your " + item + " with your " + p[7] + " and " + p[8] + " book.");
		}
		
		
		System.out.println();
		System.out.print("Press enter to exit.");
		
		
		Scanner ex = new Scanner(System.in);

	    String exitKey = ex.nextLine(); 
	}
	
	public void setCompute(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9) {
		compute.add(e1);
		if (!(e2.equalsIgnoreCase("error"))) {
			compute.add(e2);
		}
		if (!(e3.equalsIgnoreCase("error"))) {
			compute.add(e3);
		}
		if (!(e4.equalsIgnoreCase("error"))) {
			compute.add(e4);
		}
		if (!(e5.equalsIgnoreCase("error"))) {
			compute.add(e5);
		}
		if (!(e6.equalsIgnoreCase("error"))) {
			compute.add(e6);
		}
		if (!(e7.equalsIgnoreCase("error"))) {
			compute.add(e7);
		}
		if (!(e8.equalsIgnoreCase("error"))) {
			compute.add(e8);
		}
		if (!(e9.equalsIgnoreCase("error"))) {
			compute.add(e9);
		}
	}
	
	public void list() {
		for(int l = 0; l < e.length; l++) {
			System.out.println(e[l]);
		}
	}
	
	public void procedure(String[] arr) {
		
		if (Arrays.asList(arr).contains(tempEn)) {
			compute.add(tempEn);
		}
		else {
			System.out.println("This is not a proper enchantment. Please input a correct one.");
		}
		boolean stop = false;
		
		while(!stop) {
			eq2();
			if (tempEn.equalsIgnoreCase("List")) {
				list();
			}
			else if (Arrays.asList(arr).contains(tempEn)) {
				compute.add(tempEn);
			}
			else if (tempEn.equalsIgnoreCase("Stop")) {
				stop = true;
			}
			else {
				System.out.println("This is not a proper enchantment. Please input a correct one.");
			}
		}
		compute();
	
	}
}
