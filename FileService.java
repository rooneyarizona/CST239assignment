package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author Alastair Sagar
 * Imports JSON data from file to add to inventory
 *
 */

public class FileService {
	private InventoryManager im = new InventoryManager();
	public List<SalableProduct> inventory;

	public FileService() {
		this.inventory = new ArrayList<>();
	}

	public void importJsonFile(String jsonFile) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File file = new File(jsonFile);
			JsonNode rootNode = mapper.readTree(file);

			for (JsonNode node : rootNode) {
				if (node.has("power")) {
					Weapon weapon = mapper.treeToValue(node, Weapon.class);
					inventory.add(weapon);
				} else if (node.has("durability")) {
					Armor armor = mapper.treeToValue(node, Armor.class);
					inventory.add(armor);
				} else if (node.has("boost")) {
					Health health = mapper.treeToValue(node, Health.class);
					inventory.add(health);
				}
			}
		} catch (IOException e) {
			System.out.println("There is an error with file input. Please contact Alastair Sagar!");
			System.exit(1);
		}
	}

	public void addProduct(String jsonString) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode jsonNode = mapper.readTree(jsonString);

			if (jsonNode.has("power")) {
				Weapon weapon = mapper.treeToValue(jsonNode, Weapon.class);
				inventory.add(weapon);
			} else if (jsonNode.has("durability")) {
				Armor armor = mapper.treeToValue(jsonNode, Armor.class);
				inventory.add(armor);
			} else if (jsonNode.has("boost")) {
				Health health = mapper.treeToValue(jsonNode, Health.class);
				inventory.add(health);
			}

		} catch (IOException e) {
			System.out.println("Error Adding JSON Object. Please contact Alastair Sagar");
			System.exit(1);
		}
	}

	public void printInventory() {
		Collections.sort(inventory, new NameSort());
		for (SalableProduct inventory : inventory) {
			System.out.println("There are " + inventory.getQuantity() + " " + inventory.getName() + "s that cost $"
					+ inventory.getPrice() + " each");
		}

	}

	public List<SalableProduct> getInventory() {
		return inventory;

	}

}
