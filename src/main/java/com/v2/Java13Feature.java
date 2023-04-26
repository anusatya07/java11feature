package com.v2;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Java13Feature {

	/**
	 * JEP 355: Preview Feature
	 * 
	 * @throws ParserConfigurationException
	 */
	@SuppressWarnings("preview")
	public static void main(String[] args) throws ParserConfigurationException {

		// 1.
		String textBlock = """
				Hi
				Hello
				Yes""";

		String str = "Hi\nHello\nYes";

		System.out.println("Text Block String:\n" + textBlock);
		System.out.println("Normal String Literal:\n" + str);

		System.out.println("Text Block and String Literal equals() Comparison: " + (textBlock.equals(str)));
		System.out.println("Text Block and String Literal == Comparison: " + (textBlock == str));
		// 2.
		String textBlockHTML = """
				<html>
				<head>
					<link href='/css/style.css' rel='stylesheet' />
				</head>
				<body>
				                      <h1>Hello World</h1>
				              </body>
				              </html>""";

		String textBlockJSON = """
				{
					"name":"Pankaj",
					"website":"JournalDev"
				}""";

		// java 13 onwards
		DocumentBuilder db = DocumentBuilderFactory.newDefaultNSInstance().newDocumentBuilder();

		// before java 13
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newDefaultInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db1 = dbf.newDocumentBuilder();
	}

	/***
	 * New methods are to be used with Text Block Strings
	 * 
	 * @param args
	 */
	@SuppressWarnings("preview")
	public String createHTMLTAG() {
		String output = """
				Name: %s
				Phone: %d
				Salary: $%.2f
				""".formatted("Pankaj", 123456789, 2000.5555);

		System.out.println(output);

		String htmlTextBlock = "<html>   \n" + "\t<body>\t\t \n" + "\t\t<p>Hello</p>  \t \n" + "\t</body> \n"
				+ "</html>";
		System.out.println(htmlTextBlock.replace(" ", "*"));
		System.out.println(htmlTextBlock.stripIndent().replace(" ", "*"));

		String str1 = "Hi\t\nHello' \" /u0022 Pankaj\r";
		System.out.println(str1);
		System.out.println(str1.translateEscapes());
		return str1;
	}

	@SuppressWarnings("preview")
	public String createSwitchCase() {
		int choice = 2;

		switch (choice) {
		case 1:
			System.out.println(choice);
			break;
		case 2:
			System.out.println(choice);
			break;
		case 3:
			System.out.println(choice);
			break;
		default:
			System.out.println("integer is greater than 3");
		}

		// from java 13 onwards - multi-label case statements
		switch (choice) {
		case 1, 2, 3:
			System.out.println(choice);
			break;
		default:
			System.out.println("integer is greater than 3");
		}

		// switch expressions, use yield to return, in Java 12 it was break
		int x = switch (choice) {
		case 1, 2, 3:
			yield choice;
		default:
			yield -1;
		};
		System.out.println("x = " + x);
		return null;

	}

	enum Day {
		SUN, MON, TUE
	};

	@SuppressWarnings("preview")
	public String getDay(Day d) {
		String day = switch (d) {
		case SUN -> "Sunday";
		case MON -> "Monday";
		case TUE -> "Tuesday";
		};
		return day;
	}

}
