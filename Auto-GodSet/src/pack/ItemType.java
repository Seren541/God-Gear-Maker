package pack;

import java.util.Arrays;
import java.util.Scanner;

public class ItemType {
		
	String[] se = {"Sharpness", "Smite", "Bane of Arthropods", "Looting", "Unbreaking", "Mending", "Sweeping Edge", "Knockback", "Fire Aspect", "Curse of Vanishing"};
	String[] ae = {"Sharpness", "Smite", "Bane of Arthropods", "Unbreaking", "Mending", "Efficiency", "Silk Touch5", "Fortune6", "Curse of Vanishing"};
	String[] te = {"Efficiency", "Unbreaking", "Mending", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] t2e = {"Efficiency", "Unbreaking", "Mending", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] hee = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Respiration", "Aqua Affinity", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] ce = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] le = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] be = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Depth Strider", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing", "Soul Speed", 
			"Frost Walker", "Feather Falling"};
	String[] boe = {"Unbreaking", "Flame", "Infinity1", "Power", "Punch", "Mending2", "Curse of Vanishing"};
	String[] she = {"Efficiency", "Unbreaking", "Mending", "Curse of Vanishing"};
	String[] fe = {"Luck of the Sea", "Mending", "Unbreaing", "Lure", "Curse of Vanishing"};
	String[] cbe = {"Unbreaking", "Mending", "Piercing1", "Quick Charge", "Multishot2", "Curse of Vanishing"};
	String[] he = {"Curse of Binding", "Curse of Vanishing"};
	String[] ee = {"Unbreaking", "Mending", "Curse of Vanishing", "Curse of Binding"};
	String[] tre = {"Unbreaking", "Mending", "Impaling", "Loyalty", "Channeling", "Riptide", "Curse of Vanishing"};
	String[] oe = {"Unbreaking", "Mending", "Curse of Vanishing"};
	
	String mTempEn;
	String mItem;
	
	Main main = new Main();
	
	public ItemType(String TempEn, String Item) {
		
		mTempEn = TempEn;
		mItem = Item;
		
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
		boolean s1 = false;
		boolean s2 = false;
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
				God(arr);
			}
			else if (mTempEn.equalsIgnoreCase("Commands")) {
				commands();
			}
			else if (Arrays.asList(arr).contains(mTempEn)) {
				
				main.compute.add(mTempEn);
			}
			else {
				System.out.println("This is not a proper enchantment. Please input a correct one.");
			}
		}
		
		main.compute(mItem);
	
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
				main.setCompute(cbe[0], cbe[1], cbe[2], cbe[3], "none", "none", "none", "none", "none", "Crossbow");
			}
			else if (ag == he) {
				System.out.println("Don't do anything.");
				main.end();
			}
			else if (ag == ee) {
				main.setCompute(ee[0], ee[1], "none", "none", "none", "none", "none", "none", "none", "Elytra");
			}
			else if (ag == oe) {
				main.setCompute(oe[0], oe[1], "none", "none", "none", "none", "none", "none", "none", mItem);
			}
			else if (ag == tre) {
				main.setCompute(tre[0], tre[1], tre[2], tre[3], tre[4], "none", "none", "none", "none", "Trident");
			}
			else if (ag == she) {
				main.setCompute(she[0], she[1], she[2], "none", "none", "none", "none", "none", "none",  "Shears");
			}
			else if (ag == boe) {
				main.setCompute(boe[0], boe[1], boe[2], boe[3], boe[4], "none", "none", "none", "none", "Bow");
			}
			else if (ag == be) {
				main.setCompute(be[0], be[4], be[5], be[6], be[7], be[10], be[12], "none", "none", "Boots");
			}
			else if (ag == le) {
				main.setCompute(le[0], le[4], le[5], le[6], "none", "none", "none", "none", "none", "Leggings");
			}
			else if (ag == ce) {
				main.setCompute(ce[0], ce[4], ce[5], ce[6], "none", "none", "none", "none", "none", "Chestplate");
			}
			else if (ag == hee) {
				main.setCompute(hee[0], hee[4], hee[5], hee[6], hee[7], hee[8], "none",  "none", "none", "Helmet");
			}
			else if (ag == te) {
				main.setCompute(te[0], te[1], te[2], te[4], "none", "none", "none", "none", "none", mItem);	
			}
			else if (ag == t2e) {
				main.setCompute(t2e[0], t2e[1], t2e[2], t2e[3], "none", "none", "none", "none", "none", mItem);	
			}
			else if (ag == ae) {
				main.setCompute(ae[0], ae[3], ae[4], ae[5], ae[7], "none", "none", "none", "none", "Axe");
			}
			else if (ag == se) {
				main.setCompute(se[0], se[3], se[4], se[5], se[6], se[7], se[8], "none", "none", "Sword");
			}
		}

		public void arrayList(String[] a) {
			for(int l = 0; l < a.length; l++) {
				System.out.println(a[l]);
			}
		}
}
