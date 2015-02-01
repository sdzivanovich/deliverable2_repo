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
	// verifies that the hasAllItems method returns false if the player
	// has not acquired any items.
	public void playerDoesNotHaveItemsIfNoneHaveBeenAcquired()
	{
		Player subject = new Player();
		assertFalse(subject.hasAllItems());
	}
	
	@Test
	// verifies that the hasAllItems method returns false if the player
	// has acquired some items, but not every item.
	public void playerDoesNotHaveAllItemsIfOnlySomeHaveBeenAcquired()
	{
		Player subject = new Player();
		subject.getCoffee();
		assertFalse(subject.hasAllItems());
	}
	
	@Test
	// Verifies that the drink method returns false if called while
	// the player does not have all of the items.
	public void playerLosesIfDrinkingWithNoItems() 
	{
		Player subject = new Player();
		assertFalse(subject.drink());
	}
	
	@Test
	// Verifies that the drink method returns false if called while
	// the player only has some, but not all, of the items
	public void playerLosesIfDrinkingWithOnlySomeItems()
	{
	    Player subject = new Player();
	    subject.getSugar();
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
