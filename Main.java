package pack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

	//sets all valid enchantments/items
	
	ArrayList<String> fin = new ArrayList<>();
	ArrayList<String> seq = new ArrayList<>();
	ArrayList<String> inst = new ArrayList<>();
	
	String item = "error2";
	String name;
	boolean notCreated;
	boolean notFound;
	
	int[] m = {4,4,4,4,4,3,3,3,1,5,5,5,2,2,3,5,1,3,3,5,2,1,1,3,3,2,1,1,1,5,3,3,1,1,4,3,3,3};
	int[] i = {1,1,1,2,1,4,2,2,2,1,1,1,1,2,2,1,4,1,2,1,2,2,4,2,2,2,2,4,4,2,2,1,4,2,1,1,4,2};
	
	boolean set = false;
	int seti = 0;
	
	//This is just data about the enchantments that I need to store to calculate cost.
	
	String tempEn = "error";

	int[] tempFin;
	
	public void setUp() {
		
		//TODO: turn all the if blocks into arrays
		//TODO: Add editable levels
			
		System.out.println("What would you like to enchant? Do not include material in answer.");
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
		//this part figures out which item you are trying to enchant (calls itemQuery())
		
		ItemType select = new ItemType(tempEn, item, set, name);
		
		select.item();
		
		//calls the other class to do the dirty work
				
	}
	
	public void itemQuery() {
		
		Scanner in1 = new Scanner(System.in);  //Input item.
		
		item = in1.nextLine(); 
	}
	
	
	public void compute(String xItem, boolean rSet, String rName, ArrayList compute, ArrayList<Integer> cust) {
		
		String tempNum;
		int tempNumInt;
		
		Object[] conv = compute.toArray();
		String[] convert = Arrays.copyOf(conv, conv.length, String[].class);
		//ArrayList to array for more compatibility
		
		if(!(cust.isEmpty())) {
			for(int rep = 0; rep < e2.length; rep++) {
				for(int l = 0; l < compute.size(); l++) {
				
					if (e2[rep].equalsIgnoreCase(convert[l])) {
						if(!(cust.get(l).intValue() == 0))
						m[rep] = cust.get(l).intValue();
					}
				}
			}
		}
		
		//Customizes enchantment levels at user's request
		
		for(int l = 0; l < e.length; l++) {
			tempNumInt = m[l] * i[l];
			tempNum = String.valueOf(tempNumInt);
			e[l] = e[l]+tempNum;
		}
		//multiplier x item level = xp required to use the book as a sacrifice at base level
		//used to determine order
		
		for(int r = 0; r < e2.length; r++) {
			for(int l = 0; l < compute.size(); l++) {
			
				if (e2[r].equalsIgnoreCase(convert[l])) {
					fin.add(e[r]);
				}
			}
		}
		//this part organizes it by the non-numerical order I listed at the top, so the recipe is consistent
		
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
	    
	    //this part orders it by the multipliers
	    

	    
	    Object[] fina = fin.toArray();
		String[] f = Arrays.copyOf(fina, fina.length, String[].class);
	
		//finally we get our usable string[] to calculate order
		
		for(int l2 = 0; l2 < f.length; l2++) {
			f[l2] = f[l2].replaceAll("[0-9]","");
		}
		//takes out the numbers
		
		if (fin.size() == 1) {
			seq.add(f[0]);
		}
		
		else if (fin.size() > 1 && fin.size() < 10){
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
		else {
		System.out.println("You have inputed too many enchantments");
		}
		//order they need to be added them
		
	    Object[] print = seq.toArray();
		String[] p = Arrays.copyOf(print, print.length, String[].class); //turns final organized array list into readable data
		
		System.out.println("");

		if (seq.size() == 1) {
			inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
		}
		else if (seq.size() == 2) {
			inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
			inst.add("Combine your " + p[0] + " " + xItem + " with " + p[1] + ".");
		}
		else if (seq.size() == 3) {
			inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
			inst.add("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			inst.add("Finally combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
		}
		else if (seq.size() == 4) {
			inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
			inst.add("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			inst.add("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
			inst.add("Finally combine your " + xItem + " with the " + p[3] + " book.");
		}
		else if (seq.size() == 5) {
			inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
			inst.add("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			inst.add("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
			inst.add("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			inst.add("Finally combine your " + xItem + " with your " + p[3] + " and " + p[4] + " book.");
		}
		else if (seq.size() == 6) {
			inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
			inst.add("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			inst.add("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
			inst.add("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			inst.add("Afterwards combine your " + xItem + " with your " + p[3] + " and " + p[4] + " book.");
			inst.add("Finally combine your " + xItem + " with the " + p[5] + " book.");
		}
		else if (seq.size() == 7) {
			inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
			inst.add("Next combine your " + p[1] + " book with your " + p[2] + " book.");
			inst.add("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
			inst.add("Now combine your " + p[3] + " book with your " + p[4] + " book.");
			inst.add("Then combine your " + p[5] + " book with your " + p[6] + " book.");
			inst.add("Afterwards combine your " + p[3] + " and " + p[4] + " book with your " + p[5] + " and " + p[6] + " book.");
			inst.add("Finally combine your " + xItem + " and the book with four enchantments");
		}
		else if (seq.size() == 8) {
			inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
			inst.add("Next combine your" + p[1] + " book with your " + p[2] + " book.");
			inst.add("After that, combine your " + p[0] + " " + item + " with your " + p[1] + " and " + p[2] + " book.");
			inst.add("Now combine your" + p[3] + " book with your " + p[4] + " book.");
			inst.add("Then combine your" + p[5] + " book with your " + p[6] + " book.");
			inst.add("Afterwards combine your " + p[3] + " and " + p[4] + " book with your " + p[5] + " and " + p[6] + " book.");
			inst.add("Next combine your " + xItem + " and your very enchanted book.");
			inst.add("Finally combine your " + xItem + " and the " + p[7] + " book.");	
		}
		else if (seq.size() == 8) {
		inst.add("Combine " + xItem + " with " + p[0] + " in an anvil.");
		inst.add("Next combine your" + p[1] + " book with your " + p[2] + " book.");
		inst.add("After that, combine your " + p[0] + " " + xItem + " with your " + p[1] + " and " + p[2] + " book.");
		inst.add("Now combine your" + p[3] + " book with your " + p[4] + " book.");
		inst.add("Then combine your" + p[5] + " book with your " + p[6] + " book.");
		inst.add("Afterwards combine your " + p[3] + " and " + p[4] + " book with your " + p[5] + " and " + p[6] + " book.");
		inst.add("Next combine your " + xItem + " and your very enchanted book.");
		inst.add("After that, combine the " + p[7] + " book with the " + p[8] + " book");
		inst.add("Finally combine your " + xItem + " with your " + p[7] + " and " + p[8] + " book.");
		}

		//turns it into a readible recipe. Used to be more optimized, but this is clearer to read and edit.
		
	    for(int y = 0; y < inst.size(); y++) {
	    	System.out.println(inst.get(y));
	    }
		end(rSet, rName);
	}
	
	public void fin (String item, String ench1, String opEnch) {
		if (!(opEnch.equalsIgnoreCase("none"))) {
			System.out.println("Finally combine your " + item + " and the " + ench1 + " book.");	
		}
		else {
			System.out.println("Finally combine your " + item + " with your " + ench1 + " and " + opEnch + " book.");
		}
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
	
	public void end(boolean isSet, String isName) {
		System.out.println();
		System.out.println("Type 'Export' to export to your list. Otherwise press enter to exit.");
		
		notCreated = true;
		notFound = true;
		
		name = isName;
		
		Scanner ex = new Scanner(System.in);

	    String exitKey = ex.nextLine(); 

	    if (exitKey.equalsIgnoreCase("Export")) {
	    	
	    	if(isSet == false) {
			int i = 0;
			while (notCreated) {
				i++;
				name = "Instructions" + i + ".txt";
				fileCreate(name);
				}
	    	}
	    	
			try {
		        FileWriter myWriter = new FileWriter(name, true);
		        if(isSet == true) {
		        	myWriter.write("\r\n");
		        }
			    for(int p = 0; p < inst.size(); p++) {
			    	myWriter.write(inst.get(p) + "\r\n");
			    }
		        myWriter.close();
		        System.out.println("Successfully wrote to the file.");
		      } catch (IOException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
			
			System.out.println("");
	        System.out.println("Type 'Restart' to restart with the same export file");
		    System.out.println("Press enter to exit");
		    
			Scanner resta = new Scanner(System.in);

		    String restart = resta.nextLine(); 
		   
		    if(restart.equalsIgnoreCase("Restart")) {
			set = true;
	    	restart();
	    	}
	    	else {}
	    }
	    
	}
	public void fileCreate(String p) {
		//Create File
		try {
        File myObj = new File(p);
        if (myObj.createNewFile()) {
          System.out.println("File created: " + myObj.getName());
          notCreated = false;
        } else {
        	//file exists
        }
      } 
		catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
	}
	
	public void restart() {
		fin.clear();
		seq.clear();
		inst.clear();
		setUp();
		
	}
	

}