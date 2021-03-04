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
	
	String[] t = {"Sword", "Axe", "Fortune Pickaxe", "Pickaxe", "Pick", "Shovel", "Hoe", "Helmet", 
			"Chestplate", "Leggings", "Boots", "Bow", "Shears", "Crossbow", "Head", "Player Head",
			"Pumpkin", "Elytra", "Trident", "Flint and Steel", "Carrot on a Stick",
			"Warped Fungus on a Stick", "Shield"};


	
	public ArrayList<String> compute = new ArrayList<>();
	ArrayList<String> fin = new ArrayList<>();
	ArrayList<String> seq = new ArrayList<>();
	
	String item = "error2";
	
	int[] m = {4,4,4,4,4,3,3,3,1,5,5,5,2,2,3,5,1,3,3,5,2,1,1,3,3,2,1,1,1,5,3,3,1,1,4,3,3,3};
	int[] i = {1,1,1,2,1,4,2,2,2,1,1,1,1,2,2,1,4,1,2,1,2,2,4,2,2,2,2,4,4,2,2,1,4,2,1,1,4,2};
	
	//This is just data about the enchantments that I need to store to calculate cost.
	
	String tempEn = "error";

	int[] tempFin;
	
	public void setUp() {
			
		System.out.println("If you don't know the correct formatting for an item, type 'List'");
		boolean checking = true;
		while (checking) {
		itemQuery();
		if (item.equalsIgnoreCase("List")) {
			itemList();
		}
		else if (Arrays.asList(t).contains(item)) {
			checking = false;
		}
		else {
			System.out.println("This is not a proper item. Please input a correct one. Type List to get a list.");
		}
		}
		
		ItemType select = new ItemType(tempEn, item);
		
		select.item();
				
	}
	
	public void itemQuery() {

		System.out.println("What would you like to enchant? Do not include material in answer.");
		
		Scanner in1 = new Scanner(System.in);  //Input item.
		
		item = in1.nextLine(); 
	}
	
	
	public void compute(String xItem) {
		
		//TODO: I'll add more stuff today like compatibility warnings, less spam,
		//and if I'm really feeling it, export to a txt file
		
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
					fin.add(e[r]);
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
	
		
		for(int l2 = 0; l2 < f.length; l2++) {
			f[l2] = f[l2].replaceAll("[0-9]","");
		}
		
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
			System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
		}
		else if (seq.size() == 2) {
			System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
			System.out.println("Combine your " + p[0] + " " + xItem + " with " + p[1] + ".");
		}
		else if (seq.size() == 3) {
			System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("Finally combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
		}
		else if (seq.size() == 4) {
			System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Finally combine your " + xItem + " with the " + p[3] + " book.");
		}
		else if (seq.size() == 5) {
			System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			System.out.println("Finally combine your " + xItem + " with your " + p[3] + " and " + p[4] + " book.");
		}
		else if (seq.size() == 6) {
			System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			System.out.println("Afterwards combine your " + xItem + " with your " + p[3] + " and " + p[4] + " book.");
			System.out.println("Finally combine your " + xItem + " with the " + p[5] + " book.");
		}
		else if (seq.size() == 7) {
			System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			System.out.println("Then combine your " + p[5] + " book with your " + p[6] + " book.");
			System.out.println("Afterwards combine your " + p[3] + " and " + p[4] + " book with your " + p[5] + " and " + p[6] + " book.");
			System.out.println("Finally combine your " + xItem + " and the book with four enchantments");
		}
		else if (seq.size() == 8) {
			System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
			System.out.println("Next combine your" + p[1] + " book with your " + p[2] + " book.");
			System.out.println("After that, combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
			System.out.println("Now combine your" + p[3] + " book with your " + p[4] + " book.");
			System.out.println("Then combine your" + p[5] + " book with your " + p[6] + " book.");
			System.out.println("Afterwards combine your " + p[3] + " and " + p[4] + " book with your " + p[5] + " and " + p[6] + " book.");
			System.out.println("Next combine your " + xItem + " and your very enchanted book.");
			System.out.println("Finally combine your " + xItem + " and the " + p[7] + " book.");	
		}
		else if (seq.size() == 8) {
		System.out.println("Combine " + xItem + " with " + p[0] + " in an anvil.");
		System.out.println("Next combine your" + p[1] + " book with your " + p[2] + " book.");
		System.out.println("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
		System.out.println("Now combine your" + p[3] + " book with your " + p[4] + " book.");
		System.out.println("Then combine your" + p[5] + " book with your " + p[6] + " book.");
		System.out.println("Afterwards combine your " + p[3] + " and " + p[4] + " book with your " + p[5] + " and " + p[6] + " book.");
		System.out.println("Next combine your " + xItem + " and your very enchanted book.");
		System.out.println("After that, combine the " + p[7] + " book with the " + p[8] + " book");
		System.out.println("Finally combine your " + xItem + " with your " + p[7] + " and " + p[8] + " book.");
		}

		end();
	}
	
	public void fin (String item, String ench1, String opEnch) {
		if (!(opEnch.equalsIgnoreCase("none"))) {
			System.out.println("Finally combine your " + item + " and the " + ench1 + " book.");	
		}
		else {
			System.out.println("Finally combine your " + item + " with your " + ench1 + " and " + opEnch + " book.");
		}
	}
	
	public void setCompute(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String sItem) {
		compute.clear();
		
		compute.add(e1);
		if (!(e2.equalsIgnoreCase("none"))) {
			compute.add(e2);
		}
		if (!(e3.equalsIgnoreCase("none"))) {
			compute.add(e3);
		}
		if (!(e4.equalsIgnoreCase("none"))) {
			compute.add(e4);
		}
		if (!(e5.equalsIgnoreCase("none"))) {
			compute.add(e5);
		}
		if (!(e6.equalsIgnoreCase("none"))) {
			compute.add(e6);
		}
		if (!(e7.equalsIgnoreCase("none"))) {
			compute.add(e7);
		}
		if (!(e8.equalsIgnoreCase("none"))) {
			compute.add(e8);
		}
		if (!(e9.equalsIgnoreCase("none"))) {
			compute.add(e9);
		}
		compute(sItem);	
		
		//This registers all god items to run instantly.
	}
	
	public void list() {
		for(int l = 0; l < e.length; l++) {
			System.out.println(e[l]);
		}
	}
	
	public void itemList() {
		for(int l = 0; l < t.length; l++) {
			System.out.println(t[l]);
		}
	}
	
	public void end() {
		System.out.println();
		System.out.print("Press enter to exit.");
		
		
		Scanner ex = new Scanner(System.in);

	    String exitKey = ex.nextLine(); 
	}

}
