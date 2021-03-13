package pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ItemType {
		
	String[] se = {"Sharpness", "Smite", "Bane of Arthropods", "Looting", "Unbreaking", "Mending", "Sweeping Edge", "Knockback", "Fire Aspect", "Curse of Vanishing"};
	String[] ae = {"Sharpness", "Smite", "Bane of Arthropods", "Unbreaking", "Mending", "Efficiency", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] te = {"Efficiency", "Unbreaking", "Mending", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] t2e = {"Efficiency", "Unbreaking", "Mending", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] hee = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Respiration", "Aqua Affinity", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] ce = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] le = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] be = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Depth Strider", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing", "Soul Speed", 
			"Frost Walker", "Feather Falling"};
	String[] boe = {"Unbreaking", "Flame", "Infinity", "Power", "Punch", "Mending", "Curse of Vanishing"};
	String[] she = {"Efficiency", "Unbreaking", "Mending", "Curse of Vanishing"};
	String[] fe = {"Luck of the Sea", "Mending", "Unbreaing", "Lure", "Curse of Vanishing"};
	String[] cbe = {"Unbreaking", "Mending", "Piercing", "Quick Charge", "Multishot", "Curse of Vanishing"};
	String[] he = {"Curse of Binding", "Curse of Vanishing"};
	String[] ee = {"Unbreaking", "Mending", "Curse of Vanishing", "Curse of Binding"};
	String[] tre = {"Unbreaking", "Mending", "Impaling", "Loyalty", "Channeling", "Riptide", "Curse of Vanishing"};
	String[] oe = {"Unbreaking", "Mending", "Curse of Vanishing"};
	
	String mTempEn;
	String mItem;
	boolean mSet;
	String mName;
	
	boolean ic = true;
	boolean custom = false;
	int lvl = 0;
	
	Main main = new Main();
	ArrayList<String> compute = new ArrayList<>();
	ArrayList<Integer> customEnchants = new ArrayList<>();

	
	public ItemType(String TempEn, String Item, boolean set, String name) {
		
		mTempEn = TempEn;
		mItem = Item;
		mSet = set;
		mName = name;
		
	}
	
	public void item() {
	
	
	//TODO: Change setCompute() to use integers that rely on String[] e
	
	if(mItem.equalsIgnoreCase("Sword")) {
			procedure(se);
	}
	else if(mItem.equalsIgnoreCase("Axe")) {
			procedure(ae);
	}
	else if(mItem.equalsIgnoreCase("Pick") || mItem.equalsIgnoreCase("Pickaxe") || mItem.equalsIgnoreCase("Hoe") || mItem.equalsIgnoreCase("Shovel")) {
			procedure(te);
	}
	else if(mItem.equalsIgnoreCase("Fortune Pickaxe") || mItem.equalsIgnoreCase("Hoe")) {
			procedure(t2e);
	}
	else if(mItem.equalsIgnoreCase("Helmet")) {
			procedure(hee);
	}
	else if(mItem.equalsIgnoreCase("Chestplate")) {
			procedure(ce);
	}
	else if(mItem.equalsIgnoreCase("Leggings")) {
			procedure(le);
	}
	else if(mItem.equalsIgnoreCase("Boots")) {
			procedure(be);
	}	
	else if(mItem.equalsIgnoreCase("Bow")) {
			procedure(boe);
	}
	else if(mItem.equalsIgnoreCase("Shears")) {
			procedure(she);
	}	
	else if(mItem.equalsIgnoreCase("Crossbow")) {	
			procedure(cbe);
	}
	else if(mItem.equalsIgnoreCase("Head") || mItem.equalsIgnoreCase("Player Head") || mItem.equalsIgnoreCase("Pumpkin")) {
			procedure(he);
	}
	else if(mItem.equalsIgnoreCase("Elytra")) {	
			procedure(ee);
	}
	else if(mItem.equalsIgnoreCase("Trident")) {
			procedure(tre);
	}
	else if(mItem.equalsIgnoreCase("Flint and Steel") || mItem.equalsIgnoreCase("Carrot on a Stick") || mItem.equalsIgnoreCase("Warped Fungus on a Stick") || mItem.equalsIgnoreCase("Shield")) {
			procedure(oe);
	}
	}
	
	
	public void procedure(String[] arr) {
		
		Main main = new Main();
		
		boolean stop = false;
		boolean notGod = true;
		
		while(!stop) {
			eq2();
			if (mTempEn.equalsIgnoreCase("List")) {
				arrayList(arr);
			}
			else if (mTempEn.equalsIgnoreCase("Stop")) {
				stop = true;
			}
			else if (mTempEn.equalsIgnoreCase("God")) {
				stop = true;
				notGod = false;
				God(arr);
			}
			if(mTempEn.equalsIgnoreCase("Custom")) {
				custom = true;
			}
			else if (mTempEn.equalsIgnoreCase("Commands")) {
				commands();
			}
			else if (Arrays.asList(arr).contains(mTempEn)) {
				ic = true;
				isCompatible();
				if(ic) {
				compute.add(mTempEn);
					if(custom) {
					System.out.println("What level would you like this enchantment to be?");
						Scanner ce = new Scanner(System.in);  //Input enchantment.
						lvl = ce.nextInt();
					customEnchants.add(lvl);
				}
			}
				else {
					System.out.println("This enchantment is incompatible/a duplicate of a previous one");
				}
			}
			else {
				System.out.println("This is not a proper enchantment. Please input a correct one.");
			}
		
		
		
		}
		if (notGod) {
		main.compute(mItem, mSet, mName, compute, customEnchants);
		}
	}
	
	public void isCompatible() {
		if(compute.contains(mTempEn)) {
			ic = false;
		}
		else if (mTempEn.equalsIgnoreCase("Protection") || mTempEn.equalsIgnoreCase("Blast Protection") || mTempEn.equalsIgnoreCase("Fire Protection") || mTempEn.equalsIgnoreCase("Projectile Protection")) {
			if(compute.contains("Blast Protection") || compute.contains("Fire Protection") || compute.contains("Projectile Protection") || compute.contains("Protection")) {
			ic = false;
			}
		}
		else if (mTempEn.equalsIgnoreCase("Infinity") || mTempEn.equalsIgnoreCase("Mending")) {
			if(compute.contains("Mending") || compute.contains("Infinity")) {
			ic = false;
			}
		}
		else if (mTempEn.equalsIgnoreCase("Riptide")) {
			if(compute.contains("Channeling") || compute.contains("Loyalty")) {
			ic = false;
			}
		}
		else if (mTempEn.equalsIgnoreCase("Channeling") || mTempEn.equalsIgnoreCase("Loyalty")) {
			if(compute.contains("Riptide")) {
			ic = false;
			}
		}
		else if (mTempEn.equalsIgnoreCase("Piercing") || mTempEn.equalsIgnoreCase("Multishot")) {
			if(compute.contains("Piercing") || compute.contains("Multishot")) {
			ic = false;
			}
		}
		else if (mTempEn.equalsIgnoreCase("Silk Touch") || mTempEn.equalsIgnoreCase("Fortune")) {
			if(compute.contains("Silk Touch") || compute.contains("Fortune")) {
			ic = false;
			}
		}
		else if (mTempEn.equalsIgnoreCase("Depth Strider") || mTempEn.equalsIgnoreCase("Frost Walker")) {
			if(compute.contains("Depth Strider") || compute.contains("Frost Walker")) {
			ic = false;
			}
		}
		else if (mTempEn.equalsIgnoreCase("Bane of Arthropods") || mTempEn.equalsIgnoreCase("Smite") || mTempEn.equalsIgnoreCase("Sharpness")) {
			if(compute.contains("Bane of Arthropods") || compute.contains("Smite") || compute.contains("Sharpness")) {
			ic = false;
			}
		}
		
	}
	
	public void eq2() {
		
		System.out.println("Type the name of an enchantment to add one to your item. Type 'Commands' to see commands.");
		
		Scanner in2 = new Scanner(System.in);  //Input enchantment.
		
		mTempEn = in2.nextLine(); 
	}
	
	public void commands() {
		System.out.println("Type 'God' to recieve the god enchantments for that item");
		System.out.println("Type 'List' to get a list to copy and paste from (you must get the exact phrase or it won't register).");
		System.out.println("Type 'Stop' to end adding new enchantments");
		System.out.println("Type 'custom' to use custom levels for your enchantments.");

	}
		public void God(String[] ag) {
			if (ag == cbe) {
				int[] undefGod = {0, 1, 2, 3};
				computeAdd(cbe, undefGod);
				send("Crossbow", mSet, mName);
			}
			else if (ag == he) {
				System.out.println("Don't do anything.");
				main.end(mSet, mName);
			}
			else if (ag == ee) {
				int[] undefGod = {0, 1};
				computeAdd(ee, undefGod);
				send("Elytra", mSet, mName);
			}
			else if (ag == oe) {
				int[] undefGod = {0, 1};
				computeAdd(oe, undefGod);
				send(mItem, mSet, mName);			
				}
			else if (ag == tre) {
				int[] undefGod = {0, 1, 2, 3, 4};
				computeAdd(tre, undefGod);	
				send("Trident", mSet, mName);		
				}
			else if (ag == she) {
				int[] undefGod = {0, 1, 2};
				computeAdd(she, undefGod);	
				send("Shears", mSet, mName);	
			}
			else if (ag == boe) {
				int[] undefGod = {0, 1, 2, 3, 4};
				computeAdd(boe, undefGod);		
				send("Bow", mSet, mName);		
				}
			else if (ag == be) {
				int[] undefGod = {0, 4, 5, 6, 7, 10, 12};
				computeAdd(be, undefGod);
				send("Boots", mSet, mName);
			}
			else if (ag == le) {
				int[] undefGod = {0, 4, 5, 6};
				computeAdd(le, undefGod);
				send("Leggings", mSet, mName);
			}
			else if (ag == ce) {
				int[] undefGod = {0, 4, 5, 6};
				computeAdd(ce, undefGod);
				send("Chestplate", mSet, mName);
			}
			else if (ag == hee) {
				int[] undefGod = {0, 4, 5, 6, 7, 8};
				computeAdd(hee, undefGod);
				send("Helmet", mSet, mName);
			}
			else if (ag == te) {
				int[] undefGod = {0, 1, 2, 3};
				computeAdd(te, undefGod);
				send(mItem, mSet, mName);	
			}
			else if (ag == t2e) {		
				int[] undefGod = {0, 1, 2, 4};
				computeAdd(t2e, undefGod);	
				send(mItem, mSet, mName);			
			}
			else if (ag == ae) {
				int[] undefGod = {0, 3, 4, 5, 7};
				computeAdd(ae, undefGod);
				send("Axe", mSet, mName);
			}
			else if (ag == se) {
				int[] undefGod = {0, 3, 4, 5, 6, 7, 8};
				computeAdd(se, undefGod);
				send("Sword", mSet, mName);
			}
		}
		
		public void computeAdd(String[] encs, int[] i) {
			compute.clear();	
		    for(int y = 0; y < i.length; y++) {
		    	compute.add(encs[i[y]]);
		    	System.out.println(encs[i[y]]);
		    	}
		    }
		
		public void send(String sItem, boolean iSet, String iName) {
			main.compute(sItem, iSet, iName, compute, customEnchants);	
			
			//This registers all god items to run instantly.
		}
		public void arrayList(String[] a) {
			for(int l = 0; l < a.length; l++) {
				System.out.println(a[l]);
			}
		}
}
