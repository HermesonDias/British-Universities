package view;

import java.io.IOException;

import controller.UBController;

public class Principal {

	public static void main(String[] args) {
		
		UBController ubcont = new UBController();
		String path = "C:\\TEMP";
		String nome = "hol.json";
		
		try {
			ubcont.readFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
