package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UBController {

	public UBController() {
		super();
	}

	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		int i = 0;
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();

			String[] universityLine = linha.split("},");
			int tamanho = universityLine.length;

			while (i < tamanho) {
				String[] newSplit = universityLine[i].split("\"");

				String name = "Name: " + newSplit[13];
				if (newSplit[13].contains("name")) {
					name = "Name: " + newSplit[15];
				}

				String website = "Website: " + newSplit[7];
				if (newSplit[7].contains("web")) {
					website = "Website: " + newSplit[9];
				}

				System.out.println(name + " ," + website);
				i = i + 1;
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido");
		}
	}
}
