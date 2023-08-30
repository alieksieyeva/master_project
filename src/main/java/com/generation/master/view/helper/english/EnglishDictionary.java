package com.generation.master.view.helper.english;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import lombok.Getter;
import lombok.Setter;

public class EnglishDictionary 
{	
	@Getter
	private Map <String, String> dictionary = new HashMap <String, String>();  
	
	public EnglishDictionary () throws FileNotFoundException 
	{
		File file = new File("dictionaries\\englishDictionary.txt");
		Scanner fileReader = new Scanner(file);
		while(fileReader.hasNextLine())
		{
			String [] parts = fileReader.nextLine().split("!=!");
			dictionary.put(parts[0], parts[1]);
		}
		 fileReader.close();
	}
	
}
