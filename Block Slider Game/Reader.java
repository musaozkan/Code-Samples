
import java.io.*;
import java.util.*;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Reader {
	public static String fileName = "CSE1242_spring2022_project_level";
	public static int levelNumber = 5;
	public static String str = "";
	static ArrayList<Block> listOfBlocks = new ArrayList<Block>();
	static ArrayList<String> listOfWords = new ArrayList<String>();
	static ArrayList<String> listOfNames = new ArrayList<String>();
	static ArrayList<Integer> listOfIds = new ArrayList<Integer>();
	static ArrayList<String> listOfAspectInfos = new ArrayList<String>();

	public Reader() {

	}

	public static void main(String[] args) {
		try {
			File txt = new File("levels\\" + fileName + levelNumber + ".txt");
			Scanner input = new Scanner(txt);
			while (input.hasNext()) {
				str += input.next();
				str += " ";
			}
			input.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		str = str.replace(",", " ");
		str = str.replace("  ", " ");
		Scanner input = new Scanner(str);
		while (input.hasNext()) {
			listOfWords.add(input.next());
		}
		for (int i = 0; i < 48; i++) {
			if (i % 3 == 0) {
				listOfIds.add(Integer.parseInt(listOfWords.get(i)));
			} else if (i % 3 == 1) {
				listOfNames.add(listOfWords.get(i));
			} else {
				listOfAspectInfos.add(listOfWords.get(i));
			}
		}
		for (int i = 0; i < listOfIds.size(); i++) {
			System.out.println(listOfAspectInfos.get(i));
		}

		for (int i = 0; i < 16; i++) {
			if ((listOfNames.get(i).equals("Starter")) || listOfNames.get(i).equals("Pipe")
					|| (listOfNames.get(i).equals("PipeStatic")) || (listOfNames.get(i).equals("End"))) {
				Pipe pipe = new Pipe(listOfIds.get(i), listOfNames.get(i), listOfAspectInfos.get(i));
				listOfBlocks.add(pipe);
			} else if (listOfNames.get(i).equals("Empty")) {
				Empty empty = new Empty(listOfIds.get(i), listOfNames.get(i), listOfAspectInfos.get(i));
				listOfBlocks.add(empty);
			}
		}
	}
}
