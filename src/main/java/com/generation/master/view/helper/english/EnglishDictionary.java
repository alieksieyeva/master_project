package com.generation.master.view.helper.english;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.util.ResourceUtils;

import lombok.Getter;

public class EnglishDictionary 
{	
	@Getter
	private Map <String, String> dictionary = new HashMap <String, String>();  
	
	public EnglishDictionary () throws FileNotFoundException 
	{
		File file = ResourceUtils.getFile("classpath:dictionaries/englishDictionary.txt");
		Scanner fileReader = new Scanner(file);
		while(fileReader.hasNextLine())
		{
			String [] parts = fileReader.nextLine().split("!=!");
			dictionary.put(parts[0], parts[1]);
		}
		 fileReader.close();
	}
	
}
