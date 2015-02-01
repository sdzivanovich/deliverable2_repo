package com.coffeemaker.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.laboon.Player;

public class PlayerTests 
{

	@Test
	// Verifies that the hasAllItems method returns true after each of
	// the individual items have been required.
	public void playerHasAllItemsAfterGettingEachItem() 
	{
		Player subject = new Player();
		
		subject.getCoffee();
		subject.getCream();
		subject.getSugar();
		
		assertTrue(subject.hasAllItems());
	}
	
	@Test
	// Verifies that the drink method returns false if called while
	// the player does not have all of the items.
	public void playerLosesIfDrinkingWithoutAllItems() 
	{
		Player subject = new Player();
		assertFalse(subject.hasAllItems());
		assertFalse(subject.drink());
	}
	
	@Test
	// Verifies that the drink method returns true if called while
	// the player has all three items.
	public void playerWinsIfDrinkingWithAllItems()
	{
		Player subject = new Player();
		
		subject.getCoffee();
		subject.getCream();
		subject.getSugar();
		
		assertTrue(subject.hasAllItems());
	}

}
