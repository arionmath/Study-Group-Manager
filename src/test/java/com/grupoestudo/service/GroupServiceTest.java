package com.grupoestudo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.grupoestudo.models.GroupModel;
import com.grupoestudo.repositories.GroupRepositorie;

@ExtendWith(MockitoExtension.class)
class GroupServiceTest {
	
	@InjectMocks
	private GroupService groupService;
	
	@Mock
	private GroupRepositorie GP;	

	@Test
	void testSaveGroupFail() {
		//arrange
		final String failedMesage = "Check fields!";
		GroupModel groupModel = new GroupModel();
		groupModel.setName("");
		groupModel.setLinkDiscord("");
		
		//act
		String returnMesage = this.groupService.saveGroup(groupModel);
		
		//confirm
		assertEquals(failedMesage, returnMesage);
	}
	
	@Test
	void testSaveGroupSuccess() {
		//arrange
		final String successMessage = "Group save successful";
		GroupModel groupModel = new GroupModel();
		groupModel.setName("name");
		groupModel.setLinkDiscord("url");		
		
		//act
		String returnMesage = this.groupService.saveGroup(groupModel);
		
		//confirm
		assertEquals(successMessage, returnMesage);
	}	

}
