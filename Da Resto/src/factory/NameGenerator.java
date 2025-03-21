package factory;


import java.util.Random;

import mediator.Mediator;

public class NameGenerator {
	private static final String alphabetList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static StringBuilder sb;
	
	public static String generate(Mediator mediator) {
		
		String newName = generateString();
		while(true) {
			if(mediator.checkName(newName)) return newName;
			else newName = generateString();
		}
	}
	
	private static String generateString() {
		sb = new StringBuilder(2);
		Random rand = new Random();
		sb.append((alphabetList.charAt(rand.nextInt(26))));
		sb.append((alphabetList.charAt(rand.nextInt(26))));
		return sb.toString();
	}

}
