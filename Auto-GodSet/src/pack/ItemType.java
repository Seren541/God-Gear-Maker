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
	
	Main main = new Main();
	ArrayList<String> compute = new ArrayList<>();

	
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
			else if (mTempEn.equalsIgnoreCase("Commands")) {
				commands();
			}
			else if (Arrays.asList(arr).contains(mTempEn)) {
				ic = true;
				isCompatible();
				if(ic) {
					compute.add(mTempEn);
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
		main.compute(mItem, mSet, mName, compute);
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
	}
		public void God(String[] ag) {
			if (ag == cbe) {
				setCompute(cbe[0], cbe[1], cbe[2], cbe[3], "none", "none", "none", "none", "none", "Crossbow", mSet, mName);
			}
			else if (ag == he) {
				System.out.println("Don't do anything.");
				main.end(mSet, mName);
			}
			else if (ag == ee) {
				setCompute(ee[0], ee[1], "none", "none", "none", "none", "none", "none", "none", "Elytra", mSet, mName);
			}
			else if (ag == oe) {
				setCompute(oe[0], oe[1], "none", "none", "none", "none", "none", "none", "none", mItem, mSet, mName);
			}
			else if (ag == tre) {
				setCompute(tre[0], tre[1], tre[2], tre[3], tre[4], "none", "none", "none", "none", "Trident", mSet, mName);
			}
			else if (ag == she) {
				setCompute(she[0], she[1], she[2], "none", "none", "none", "none", "none", "none",  "Shears", mSet, mName);
			}
			else if (ag == boe) {
				setCompute(boe[0], boe[1], boe[2], boe[3], boe[4], "none", "none", "none", "none", "Bow", mSet, mName);
			}
			else if (ag == be) {
				setCompute(be[0], be[4], be[5], be[6], be[7], be[10], be[12], "none", "none", "Boots", mSet, mName);
			}
			else if (ag == le) {
				setCompute(le[0], le[4], le[5], le[6], "none", "none", "none", "none", "none", "Leggings", mSet, mName);
			}
			else if (ag == ce) {
				setCompute(ce[0], ce[4], ce[5], ce[6], "none", "none", "none", "none", "none", "Chestplate", mSet, mName);
			}
			else if (ag == hee) {
				setCompute(hee[0], hee[4], hee[5], hee[6], hee[7], hee[8], "none",  "none", "none", "Helmet", mSet, mName);
			}
			else if (ag == te) {
				setCompute(te[0], te[1], te[2], te[3], "none", "none", "none", "none", "none", mItem, mSet, mName);	
			}
			else if (ag == t2e) {
				setCompute(t2e[0], t2e[1], t2e[2], t2e[4], "none", "none", "none", "none", "none", mItem, mSet, mName);	
			}
			else if (ag == ae) {
				setCompute(ae[0], ae[3], ae[4], ae[5], ae[7], "none", "none", "none", "none", "Axe", mSet, mName);
			}
			else if (ag == se) {
				setCompute(se[0], se[3], se[4], se[5], se[6], se[7], se[8], "none", "none", "Sword", mSet, mName);
			}
		}
		
		public void setCompute(String e1, String e2, String e3, String e4, String e5, String e6, String e7, String e8, String e9, String sItem, boolean iSet, String iName) {
			compute.clear();			
			if (!(e1.equalsIgnoreCase("none"))) {
				compute.add(e1);
			}
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
			main.compute(sItem, iSet, iName, compute);	
			
			//This registers all god items to run instantly.
		}
		public void arrayList(String[] a) {
			for(int l = 0; l < a.length; l++) {
				System.out.println(a[l]);
			}
		}
}
