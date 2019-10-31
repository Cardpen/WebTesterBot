package Drivers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ItemStorage {
	List<Item> brokenItems = new ArrayList<Item>();

	Set<Item> items = new HashSet<Item>();
	Set<Item> equipped = new HashSet<Item>();
	Set<Item> weapon = new HashSet<Item>();
	Set<Item> bludge = new HashSet<Item>();
	Set<Item> pierce = new HashSet<Item>();
	Set<Item> slash = new HashSet<Item>();
	Set<Item> helm = new HashSet<Item>();
	Set<Item> armor = new HashSet<Item>();
	Set<Item> chest = new HashSet<Item>();
	Set<Item> pants = new HashSet<Item>();
	Set<Item> boots = new HashSet<Item>();
	Set<Item> shield = new HashSet<Item>();
	Set<Item> arm = new HashSet<Item>();
	Set<Item> shirt = new HashSet<Item>();
	Set<Item> misc = new HashSet<Item>();
	
	Gson gson;
	String invString;
	
	public ItemStorage() {
		gson = new Gson();
		String itemTags = "";
		try {
			itemTags = new String(Files.readAllBytes(Paths.get("libraries/itemTags.txt")));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		Access.itemTags = gson.fromJson(itemTags, new TypeToken<Map<String, Item>>(){}.getType());
		
	}
}
