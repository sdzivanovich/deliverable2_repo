package com.coffeemaker.tests;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.laboon.House;
import com.laboon.Player;
import com.laboon.Room;

public class HouseTests 
{

	@Test
	// Verifies the generateRooms method returns an array with
	// the specified number of rooms
	public void generateRoomsReturnsCorrectNumberOfRooms() 
	{
		House subject = new House(5);
		
		int numRooms = 10;
		Room[] rooms = subject.generateRooms(numRooms);
		
		assertNotNull(rooms);
		assertEquals(numRooms, rooms.length);
	}
	
	@Test
	// Verify northernmost generated Room has no door leading North.
	public void northernMostGeneratedRoomHasNoNorthDoor()
	{
	    House subject = new House(3);
	    Room[] rooms = subject.generateRooms(3);
	    
	    assertFalse(rooms[rooms.length - 1].northExit());
	}
	
	@Test
	// Verify southernmost generated Room has no door leading South. 
	public void southernMostRoomHasNoSouthDoor()
	{
	    House subject = new House(3);
        Room[] rooms = subject.generateRooms(3);
        
        assertFalse(rooms[0].southExit());
	}
	
	@Test
	// Verify generateRooms produces a winnable set of rooms. 
	// i.e., the set of rooms contain coffee, sugar, and cream. 
	public void generatedRoomsHaveCoffeeSugarAndCream()
	{
	    House subject = new House(3);
        Room[] rooms = subject.generateRooms(3);
        
        boolean hasSugar = false;
        boolean hasCream = false;
        boolean hasCoffee = false;
        
        for (int i = 0; i < rooms.length; ++i)
        {
            if (rooms[i].hasCoffee())
                hasCoffee = true;
            
            if (rooms[i].hasCream())
                hasCream = true;
            
            if (rooms[i].hasSugar())
                hasSugar = true;
        }
        
        assertTrue(hasCoffee);
        assertTrue(hasSugar);
        assertTrue(hasCream);
	}
	
	@Test
	// Verify that the House will query the Room for items when
	// the look method is called. 
	public void houseQueriesRoomForItems()
	{
	    House subject = new House(5);
	    
	    Player player = new Player();
	    Room room = mock(Room.class);
	    
	    when(room.hasItem()).thenReturn(true);
	    when(room.hasCoffee()).thenReturn(false);
	    when(room.hasSugar()).thenReturn(false);
	    when(room.hasCream()).thenReturn(false);
	    
	    subject.look(player, room);
	    
	    verify(room).hasItem();
	    verify(room).hasCoffee();
	    verify(room).hasSugar();
	    verify(room).hasCream();	    
	}
	
	@Test
	// Verify that the House will call the correspond getItem method
	// on the player when looking at a room that contains the items.
	public void playerGetsItemsFromRoomAfterLooking()
	{
	    House subject = new House(5);	   
	    Player player = mock(Player.class);
	    Room room = new Room(true, true, true, false, false);
        
        subject.look(player, room);
        
        verify(player).getCoffee();
        verify(player).getSugar();
        verify(player).getCream();
	}
	
	@Test 
	// Verify the getRoomDescription method returns the current room
	// description.
	public void getCurrentRoomInfoReturnsCurrentRoomDescription()
	{
	    Room room = mock(Room.class);
	    
	    String description = "a dummy description";
	    when(room.getDescription()).thenReturn(description);
	    
	    Room[] rooms = { room };
	    House subject = new House(rooms);
	    
	    assertEquals(description, subject.getCurrentRoomInfo());
	}
	
	@Test 
	// Verify that moveNorth when the current room has no North door
	// does not change the current room. 
	public void moveNorthDoesNotChangeRoomWhenRoomHasNoNorthernDoor()
	{
	    Room room = mock(Room.class);
        
        String description = "a dummy description";
        when(room.getDescription()).thenReturn(description);
        when(room.northExit()).thenReturn(false);
        
        Room[] rooms = { room };
        House subject = new House(rooms);
        
        assertEquals(description, subject.getCurrentRoomInfo());
        subject.moveNorth();
        assertEquals(description, subject.getCurrentRoomInfo());
	}

}
