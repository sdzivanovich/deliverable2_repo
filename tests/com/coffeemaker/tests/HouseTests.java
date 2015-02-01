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

}
