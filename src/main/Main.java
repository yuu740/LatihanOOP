package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {


	public Main() {
		Character c1 = new BaseChar("Lesley", 50, 100);
		Character c2 = new BaseChar("Carmilia", 70, 120);
		Character c3 = new SpecialChar("Eudora", 80, 150, "Halilintar");
		Character c4 = new SpecialChar("Dino", 90, 150, "Semburan Api", "Defense");
		ArrayList<Character> clist = new ArrayList<>();
		ArrayList<History> hlist = new ArrayList<>();
		clist.add(c1);
		clist.add(c2);
		clist.add(c3);
		clist.add(c4);
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int c = 0;
		do {
			menu();
			try {
				c = s.nextInt();
				if (c < 1 || c > 5) {
					System.out.println("gak ada di opsi");
					continue;
				}
				switch(c) {
				case 1:
					int baseCharCount = 1;
					int specialCharCount = 1;
					int skillCount = 1;
					for (Character ch : clist) {
						if (ch instanceof BaseChar) {
							System.out.println("Karakter " + baseCharCount++ + " : " + ch.getId()+  " | " +ch.getName() + " | DP : " + ch.getDmg() + " | HP : " + ch.getHp());
						}
						if (ch instanceof SpecialChar) {
							SpecialChar sc = (SpecialChar) ch;
							System.out.println("Special Karakter " + specialCharCount++ + " : " + sc.getId()+  " | " +sc.getName() + " | DP : " + sc.getDmg() + " | HP : " + sc.getHp());
							for (int i = 0; i < sc.getSkill().size();i++) {
								System.out.println(sc.getName() + " Skill " + (i+1) + " : " + sc.getSkill().get(i));
							}	
						}
					}
					break;
				case 2:
					String name;
					String yn;
					int hp;
					int dp;
					int skillC = 0;
					System.out.print("Masukkan Nama Karakter : ");
					s.nextLine();
					name = s.nextLine();
					System.out.print("Apakah special karakter? (Y/N) : " );
					yn = s.nextLine().toUpperCase();
					System.out.println("Health Point : ");
					hp = s.nextInt();
					System.out.println("DP : ");
					dp = s.nextInt();
					if (yn.equals("Y")) {
						System.out.println("Ada berapa skill? ");
						skillC = s.nextInt();
						s.nextLine();
						String[] skill = new String[skillC];
						for (int i = 0; i < skillC; i++) {
							System.out.println("Skill " + (i+1) + " : ");
							skill[i] = s.nextLine();
						}
						SpecialChar sp = new SpecialChar(name, dp, hp, skill);
						clist.add(sp);
						System.out.println("Karakter berhasil dibuat!");
					}
					else {
						BaseChar bc = new BaseChar(name, dp, hp);
						clist.add(bc);
						System.out.println("Karakter berhasil dibuat!");
					}
					break;
				case 3:
					int count = 0;
					int count1 = 0, count2 = 0;
					for (Character character : clist) {
						System.out.println((count+1)+". " +character.getName());
						count++;
					}
					System.out.println("Pick First Fighter [0 = random] : ");
					count1= s.nextInt() - 1;
					s.nextLine();
					System.out.println("Pick Second Fighter [0 = random] : ");
					count2 = s.nextInt() - 1;
					s.nextLine();
					
					if(count1 == -1) count1 = r.nextInt(clist.size());
					if (count2 == -1) count2 = r.nextInt(clist.size());
					
					if (count1 < 0 || count1 >= clist.size() || count2 < 0 || count2 >= clist.size() || count1 == count2) {
			            System.out.println("Invalid fighter selection. Please try again.");
			            break;
			        }
					
					Character f1 = clist.get(count1);
					Character f2 = clist.get(count2);
					hlist.add(new History(f1.getName(), f2.getName()));
					System.out.println(f1.getName() + " vs " + f2.getName() + " has been recorded");
					
					System.out.println("Current History List:");
				    for (History fight : hlist) {
				        System.out.println(fight.getId() + " : " + fight.getFighter1() + " vs " + fight.getFighter2());
				    }
					break;
				case 4:
					if(hlist.isEmpty()) {
						System.out.println("No fight have been recorded");
					}
					else {
						System.out.println("View Arena Battle (sorted by latest)");
						for (int i = hlist.size() - 1; i>=0; i--) {
							History fight = hlist.get(i);
							System.out.println(fight.getId() +" : "+ fight.getFighter1() + " vs " + fight.getFighter2());
						}
					}
					break;
				case 5:
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Harus isi dengan angka");
				s.next();
			}
			
		} while(c != 5);
		
	}
	
	public void menu() {
		System.out.println("1. Display all character");
		System.out.println("2. Create Character");
		System.out.println("3. Battle Arena");
		System.out.println("4. View Fight History");
		System.out.println("5. Exit");
	}
	public static void main(String[] args) {
		
		new Main();
		
			
				
		
	}

}
