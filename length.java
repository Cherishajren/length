import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Character;
import java.text.DecimalFormat;

public class length {
	public static void main(String[] args) {
		try {
			// read file content from file
			StringBuffer sb = new StringBuffer("");

			FileReader reader = new FileReader(
					"c:\\Users\\Cherish\\Desktop\\input.txt");
			BufferedReader br = new BufferedReader(reader);

			FileWriter writer = new FileWriter(
					"c:\\Users\\Cherish\\Desktop\\output.txt");
			BufferedWriter bw = new BufferedWriter(writer);

			String str[] = new String[6];
			String parts[] = new String[5];
			String unit[] = new String[6];
			String coe[] = new String[6];
			double coefficient[] = new double[6];
			DecimalFormat df = new DecimalFormat("0.00");

			bw.write("cherishajren@gmail.com" + "\r\n" + "\r\n");

			for (int i = 0; i < 6; i++) {
				str[i] = br.readLine();
				parts = str[i].split(" ");
				unit[i] = parts[1];
				coe[i] = parts[3];
				coefficient[i] = Double.parseDouble(coe[i]);
				//System.err.println(unit[i]);

				//System.err.println(coe[i]);
			}

			String alg[] = new String[11];
			String algebraic[] = new String[10];

			int k = 0;
			while (k < 11) {
				alg[k] = br.readLine();
				k++;
			}

			for (int i = 0; i < 10; i++) {
				algebraic[i] = alg[i + 1];
				// System.out.println(i+algebraic[i]);
			}

			br.close();
			reader.close();

			String falg[] = new String[10];

			for (int i = 0; i < algebraic.length; i++) {

				falg = algebraic[i].split(" ");
				double num[] = new double[3];
				int n = 0;
				char ch[] = new char[2];
				ch[0] = ch[1] = '@';
				int c = 0;
				// System.out.println(Double.parseDouble(falg[j]));
				for (int l = 0; l < falg.length; l++) {
					if (Character.isLetter(falg[l].charAt(0))) {
						if (falg[l].indexOf(unit[0]) != -1) {
							num[n] = Double.parseDouble(falg[l - 1])
									* coefficient[0];
							// System.out.println(num[n]);
							n++;
						}
						if (falg[l].indexOf(unit[1]) != -1) {
							num[n] = Double.parseDouble(falg[l - 1])
									* coefficient[1];
							// System.out.println(num[n]);
							n++;
						}
						if (falg[l].indexOf(unit[2]) != -1) {
							num[n] = Double.parseDouble(falg[l - 1])
									* coefficient[2];
							// System.out.println(num[n]);
							n++;
						}
						if (falg[l].equals("feet") || falg[l].equals("foot")) {
							num[n] = Double.parseDouble(falg[l - 1])
									* coefficient[3];
							// System.out.println(num[n]);
							n++;
						}
						if (falg[l].indexOf(unit[4]) != -1) {
							num[n] = Double.parseDouble(falg[l - 1])
									* coefficient[4];
							// System.out.println(num[n]);
							n++;
						}
						if (falg[l].indexOf(unit[5]) != -1) {
							num[n] = Double.parseDouble(falg[l - 1])
									* coefficient[5];
							// System.out.println(num[n]);
							n++;
						}
					} else if (falg[l].charAt(0) == '+'
							|| falg[l].charAt(0) == '-') {
						ch[c] = falg[l].charAt(0);
						// System.out.println(ch[c]);
						c++;
					}

				}
				/*
				 * System.out.println(num[0]); System.out.println(num[1]);
				 * System.out.println(num[2]); System.err.println(num.length);
				 * System.out.println(ch[0]); System.out.println(ch[1]);
				 * System.err.println(ch.length);
				 */

				if (ch[0] == '+') {
					num[1] = num[0] + num[1];
					if (ch[1] == '+') {
						num[2] = num[1] + num[2];
					} else if (ch[1] == '-') {
						num[2] = num[1] - num[2];
					} else if (ch[1] == '@') {
						num[2] = num[1];
					}
				} else if (ch[0] == '-') {
					num[1] = num[0] - num[1];
					if (ch[1] == '+') {
						num[2] = num[1] + num[2];
					} else if (ch[1] == '-') {
						num[2] = num[1] - num[2];
					} else if (ch[1] == '@') {
						num[2] = num[1];
					}
				} else if (ch[0] == '@') {
					num[2] = num[0];
				}
				//System.out.println(df.format(num[2]));
				//System.out.println(",,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");

				bw.write(df.format(num[2]) + " " + "m" + "\r\n");

			}
			bw.close();
			writer.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
