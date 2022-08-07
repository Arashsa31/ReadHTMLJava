import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

/**
 * @author Arash
 *
 */
public class ReadHTML {

	public static void main(String[] args) throws Exception {
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Eneter a stock symbol");
		String symbol = keyboard.nextLine();

		URL website = new URL("https://finance.yahoo.com/quote/" + symbol); // + "?p=" + "&.tsrc=fin-srch");
		Scanner iStream = new Scanner(new InputStreamReader(website.openStream()));
		String word = null;

		while (iStream.hasNextLine()) {
			word = iStream.next();
			if (word.contains("regularMarketPrice"))
				break;
		}

		iStream.next();
		iStream.next();
		String target = iStream.next();
		System.out.println("$" + target.substring(7, target.length() - 1));

		iStream.close();
	}
}
