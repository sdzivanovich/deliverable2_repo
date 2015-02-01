package com.coffeemaker.tests;

import static org.junit.Assert.*;
import org.junit.Test;

import com.laboon.House;
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
                hasCoffee = true;
            
            if (rooms[i].hasSugar())
                hasSugar = true;
        }
        
        assertTrue(hasCoffee);
        assertTrue(hasSugar);
        assertTrue(hasCream);
	}

}
