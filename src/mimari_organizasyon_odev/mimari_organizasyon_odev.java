
package mimari_organizasyon_odev;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class mimari_organizasyon_odev  {

	private _22010310056_Register AR = new _22010310056_Register("AR");
	private _22010310056_Register PC = new _22010310056_Register("PC");
	private _22010310056_Register DR = new _22010310056_Register("DR");
	private _22010310056_Register IR = new _22010310056_Register("IR");

	private _22010310056_Bayraklar S = new _22010310056_Bayraklar("S");
	private _22010310056_Bayraklar IEN = new _22010310056_Bayraklar("IEN");

	public mimari_organizasyon_odev() {
	}

	public void kontrolFonksiyonu(String kontrolF) {
		System.out.println("Denetim fonksiyonu: " + kontrolF);
		String[] signals = kontrolF.split(" ");

			if (_22010310056_Kapılar.Ve(arrayContains(signals, "D0"),arrayContains(signals, "T4")) ){
		        DR.load();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "D1"), arrayContains(signals, "T4"))) {
				DR.load();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "D2"),arrayContains(signals, "T4"))) {
				DR.load();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "D4"), arrayContains(signals, "T4"))) {
				PC.load();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "D5"),arrayContains(signals, "T4"))) {
				AR.increment();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "D5") , arrayContains(signals, "T5")) ){
				PC.load();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "D6"),arrayContains(signals, "T4"))) {
				DR.load();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "D6"),arrayContains(signals, "T5"))) {
				DR.increment();

				
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "R'") ,arrayContains(signals, "T0")) ){
				AR.load();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "R'") , arrayContains(signals, "T1"))) {
				IR.load();
				PC.increment();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "R'"), arrayContains(signals, "T2"))) {
				AR.load();
			} else if (arrayContains(signals, "D7'") && arrayContains(signals, "I")&& arrayContains(signals, "T3")) {
				AR.load();

			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "R"),arrayContains(signals, "T0"))) {
				AR.clear();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "R"),arrayContains(signals, "T1")) ){
				PC.clear();
			} else if (_22010310056_Kapılar.Ve(arrayContains(signals, "R"),arrayContains(signals, "T2"))) {
				PC.increment();
				IEN.setDInput(0);
				
			} else if (arrayContains(signals, "D7") && arrayContains(signals, "I'")&& arrayContains(signals, "T3")&& arrayContains(signals, "B0")) {
				S.setDInput(0);
			} else if (arrayContains(signals, "D7") && arrayContains(signals, "I")&& arrayContains(signals, "T3")&& arrayContains(signals, "B7")) {
				IEN.setDInput(1);
			} else if (arrayContains(signals, "D7") && arrayContains(signals, "I")&& arrayContains(signals, "T3")&& arrayContains(signals, "B6")) {
				IEN.setDInput(0);
			}else {
	            System.out.println("Tanımsız sinyal: " + kontrolF);
	        }

		}
	
	private boolean arrayContains(String[] array, String value) {
		for (String item : array) {
			if (item.equals(value)) {
				return true;
			}
		}
		return false;
	}

	public void dosyaOkuma(String filePath) {
		try {
			File file = new File(filePath);
			Scanner scanner = new Scanner(file);

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				kontrolFonksiyonu(line);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.err.println("Dosya bulunamadı: " + e.getMessage());
			}
		}

	public static void main(String[] args) {
		mimari_organizasyon_odev k = new mimari_organizasyon_odev();
		System.out.println("denetim_fonksiyonlari.txt dosyası okundu.");
		k.dosyaOkuma("denetim_fonksiyonlari.txt");
	}
}
