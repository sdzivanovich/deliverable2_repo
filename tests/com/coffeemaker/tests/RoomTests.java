package com.coffeemaker.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.laboon.Room;

public class RoomTests 
{

	@Test
	// Verifies that the hasCoffee method returns true if the 
	// room was initialized to have coffee.
	public void roomHasCoffeeIfInitializedWithCoffee() 
	{
		Room subject = new Room(true, false, false, false, false);
		assertTrue(subject.hasCoffee());
	}
	
	@Test
	// Verifies that the hasCream method returns true if the 
	// room was initialized to have cream.
	public void roomHasCreamIfInitializedWithCream() 
	{
		Room subject = new Room(false, true, false, false, false);
		assertTrue(subject.hasCream());
	}
	
	@Test
	// Verifies that the hasSugar method returns true if the 
	// room was initialized to have sugar.
	public void roomHasSugarIfInitializedWithSugar() 
	{
		Room subject = new Room(false, false, true, false, false);
		assertTrue(subject.hasSugar());
	}
	
	@Test
	// Verifies that the northExit method returns true if the 
	// room was initialized to have a northExit.
	public void roomHasNorthExitIfInitializedWithNorthExit() 
	{
		Room subject = new Room(false, false, false, true, false);
		assertTrue(subject.northExit());
	}
	
	@Test
	// Verifies that the southExit method returns true if the 
	// room was initialized to have a southExit.
	public void roomHasSouthExitIfInitializedWithSouthExit() 
	{
		Room subject = new Room(false, false, false, false, true);
		assertTrue(subject.southExit());
	}
	
	@Test
	// Verifies getDescription does not return null.
	public void roomDescriptionIsNonNull()
	{
		Room subject = new Room(false, false, false, false, false);
		assertNotNull(subject.getDescription());
	}
	

}
