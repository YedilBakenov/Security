package com.example.springSecurityG124;

import com.example.springSecurityG124.dto.ItemDTO;
import com.example.springSecurityG124.mapper.ItemMapper;
import com.example.springSecurityG124.model.Item;
import com.example.springSecurityG124.service.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringTests {
	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private ItemService itemService;
	@Test
	void compareDtoAndModel(){
		Item item = new Item();
		item.setPrice(10000);
		item.setName("Mouse Optical");
		item.setDescription("Computer options");

		ItemDTO itemDTO = itemMapper.toItemDTO(item);
		Assertions.assertEquals(item.getDescription(), itemDTO.getDescription());
		Assertions.assertEquals(item.getPrice(), itemDTO.getPrice());
		Assertions.assertEquals(item.getName(), itemDTO.getItemName());

	 }

	 @Test
	void examinationDB(){
		Item item = new Item();
		item.setName("Keybord");
		item.setPrice(20000);
		ItemDTO itemDTO = itemMapper.toItemDTO(item);
		itemService.addItem(itemDTO);
		itemService.deleteItem(itemDTO.getId());
	 }
}
