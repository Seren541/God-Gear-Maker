package pack;

import java.util.Arrays;
import java.util.Scanner;

public class ItemType {
		
	String[] se = {"Sharpness", "Smite", "Bane of Arthropods", "Looting", "Unbreaking", "Mending", "Sweeping Edge", "Knockback", "Fire Aspect", "Curse of Vanishing"};
	String[] ae = {"Sharpness", "Smite", "Bane of Arthropods", "Unbreaking", "Mending", "Efficiency", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] te = {"Efficiency", "Unbreaking", "Mending", "Silk Touch", "Fortune", "Curse of Vanishing"};
	String[] hee = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Respiration", "Aqua Affinity", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] ce = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] le = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing"};
	String[] be = {"Protection", "Fire Protection", "Blast Protection", "ProjectileProtection", "Thorns", "Depth Strider", "Unbreaking", "Mending", "Curse of Binding", "Curse of Vanishing", "Soul Speed", "Frost Walker",
			"Feather Falling"};
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
	
	public ItemType(String TempEn, String Item) {
		
		mTempEn = TempEn;
		mItem = Item;
		
	}
	
	public void item() {
		
	Main main = new Main();
	
	if(mItem.equalsIgnoreCase("Sword")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(se[0], se[3], se[4], se[5], se[6], se[7], se[8], "none", "none", mItem);
		}		
		else {
			procedure(se);
		}
	}
	else if(mItem.equalsIgnoreCase("Axe")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(ae[0], ae[3], ae[4], ae[5], ae[7], "none", "none", "none", "none", mItem);
		}		
		else {
			procedure(ae);
		}
	}
	else if(mItem.equalsIgnoreCase("Pick") || mItem.equalsIgnoreCase("Pickaxe") || mItem.equalsIgnoreCase("Hoe")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(te[0], te[1], te[2], te[3], "none", "none", "none", "none", "none", mItem);	
			}		
		else {
			procedure(te);
		}
	}
	else if(mItem.equalsIgnoreCase("Fortune Pickaxe") || mItem.equalsIgnoreCase("Hoe")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(te[0], te[1], te[2], te[4], "none", "none", "none", "none", "none", mItem);	
			}		
		else {
			procedure(te);
		}
	}
	else if(mItem.equalsIgnoreCase("Helmet")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(hee[0], hee[4], hee[5], hee[6], hee[7], hee[8], "none",  "none", "none", mItem);
			}		
		else {
			procedure(hee);
		}
	}
	else if(mItem.equalsIgnoreCase("Chestplate")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(ce[0], ce[4], ce[5], ce[6], "none", "none", "none", "none", "none", mItem);
		}		
		else {
			procedure(ce);
		}
	}
	else if(mItem.equalsIgnoreCase("Leggings")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(le[0], le[4], le[5], le[6], "none", "none", "none", "none", "none", mItem);
		}		
		else {
			procedure(le);
		}
	}
	else if(mItem.equalsIgnoreCase("Boots")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(be[0], be[4], be[5], be[6], be[7], be[10], be[12], "none", "none", mItem);
		}		
		else {
			procedure(be);
		}
	}	
	else if(mItem.equalsIgnoreCase("Bow")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(boe[0], boe[1], boe[2], boe[3], boe[4], "none", "none", "none", "none", mItem);
		}		
		else {
			procedure(boe);
		}
	}
	else if(mItem.equalsIgnoreCase("Shears")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(she[0], she[1], she[2], "none", "none", "none", "none", "none", "none",  mItem);
		}		
		else {
			procedure(she);
		}
	}	
	else if(mItem.equalsIgnoreCase("Crossbow")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(cbe[0], cbe[1], cbe[2], cbe[3], "none", "none", "none", "none", "none", mItem);
		}		
		else {
			procedure(cbe);
		}
	}
	else if(mItem.equalsIgnoreCase("Head") || mItem.equalsIgnoreCase("Player Head") || mItem.equalsIgnoreCase("Pumpkin")) {
		if (mTempEn.equalsIgnoreCase("God")) {
			System.out.println("Don't do anything.");
			main.end();
		}
		else {
			procedure(he);
		}
	}
	else if(mItem.equalsIgnoreCase("Elytra")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(ee[0], ee[1], "none", "none", "none", "none", "none", "none", "none", mItem);
		}		
		else {
			procedure(ee);
		}
	}
	else if(mItem.equalsIgnoreCase("Trident")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(tre[0], tre[1], tre[2], tre[3], tre[4], "none", "none", "none", "none", mItem);
		}		
		else {
			procedure(tre);
		}
	}
	else if(mItem.equalsIgnoreCase("Flint and Steel") || mItem.equalsIgnoreCase("Carrot on a Stick") || mItem.equalsIgnoreCase("Warped Fungus on a Stick") || mItem.equalsIgnoreCase("Shield")) {

		if (mTempEn.equalsIgnoreCase("God")) {
			main.setCompute(oe[0], oe[1], "none", "none", "none", "none", "none", "none", "none", mItem);
		}		
		else {
			procedure(oe);
		}
	}
	}
	
	
	public void procedure(String[] arr) {
		
		Main main = new Main();
		
		if (Arrays.asList(arr).contains(mTempEn)) {
			main.compute.add(mTempEn);
		}
		else {
			System.out.println("This is not a proper enchantment. Please input a correct one.");
		}
		boolean stop = false;
		
		while(!stop) {
			eq2();
			if (mTempEn.equalsIgnoreCase("List")) {
				main.list();
			}
			else if (mTempEn.equalsIgnoreCase("Stop")) {
				stop = true;
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
		
		System.out.println("Input another enchantment if you would like one. All enchantments will be assummed to be maximum.");
		System.out.println("Type 'List' to get a list to copy and paste from (you must get the exact phrase or it won't register).");
		System.out.println("Type 'Stop' to end adding new enchantments");
		
		Scanner in2 = new Scanner(System.in);  //Input enchantment.
		
		mTempEn = in2.nextLine(); 
	}

}
