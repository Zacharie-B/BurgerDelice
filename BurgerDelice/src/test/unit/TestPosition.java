package test.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import engine.map.Block;
import engine.mobile.Customer;
import engine.process.MoveCharacters;

public class TestPosition {
	
	private MoveCharacters manageCustomer;
	private Customer testerCustomer1;
	private Customer testerCustomerBot;
	private Customer testerCustomerTop;
	private Customer testerCustomerLeft;
	private Customer testerCustomerRight;
	private List<Block> takenBlocks;

	@Before
	public void preparePosition() {
		manageCustomer = new MoveCharacters();
		testerCustomer1 = new Customer(new Block(1,1),01,false);
		testerCustomerBot = new Customer(new Block(1,0),02,false);
		testerCustomerTop = new Customer(new Block(1,2),03,false);
		testerCustomerLeft = new Customer(new Block(2,1),04,false);
		testerCustomerRight = new Customer(new Block(0,1),05,false);
		
		takenBlocks = new ArrayList<Block>();
	}
	
	@Test
	public void testBotPosition() {
		manageCustomer.moveBotCollisionFree(testerCustomerBot.getPosition(), takenBlocks);
		assertEquals(testerCustomer1.getPosition().getLine(), testerCustomerBot.getPosition().getLine());
		
		assertNotEquals(testerCustomer1.getPosition().getColumn(), testerCustomerBot.getPosition().getColumn());
		System.out.println(testerCustomer1.getPosition().toString() + " et " + testerCustomerBot.getPosition().toString());
	}
	
	@Test
	public void testTopPosition() {
		manageCustomer.moveTopCollisionFree(testerCustomerTop.getPosition(), takenBlocks);
		assertEquals(testerCustomer1.getPosition().getLine(), testerCustomerTop.getPosition().getLine());
		
		assertNotEquals(testerCustomer1.getPosition().getColumn(), testerCustomerTop.getPosition().getColumn());
		System.out.println(testerCustomer1.getPosition().toString() + " et " + testerCustomerTop.getPosition().toString());
	}
	
	@Test
	public void testLeftPosition() {
		manageCustomer.moveLeftCollisionFree(testerCustomerLeft.getPosition(), takenBlocks);
		assertEquals(testerCustomer1.getPosition().getColumn(), testerCustomerLeft.getPosition().getColumn());
		
		assertNotEquals(testerCustomer1.getPosition().getLine(), testerCustomerLeft.getPosition().getLine());
		System.out.println(testerCustomer1.getPosition().toString() + " et " + testerCustomerLeft.getPosition().toString());
	}
	
	@Test
	public void testRightPosition() {
		manageCustomer.moveRightCollisionFree(testerCustomerRight.getPosition(), takenBlocks);
		assertEquals(testerCustomer1.getPosition().getColumn(), testerCustomerRight.getPosition().getColumn());
		
		assertNotEquals(testerCustomer1.getPosition().getLine(), testerCustomerRight.getPosition().getLine());
		System.out.println(testerCustomer1.getPosition().toString() + " et " + testerCustomerRight.getPosition().toString());
	}
}
