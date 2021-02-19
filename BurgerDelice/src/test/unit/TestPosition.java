package test.unit;

import static org.junit.Assert.assertEquals;

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
	private Customer testerCustomer2;
	private List<Block> takenBlocks;

	@Before
	public void preparePosition() {
		this.manageCustomer = new MoveCharacters();
		this.testerCustomer1 = new Customer(new Block(1,1),01,false);
		this.testerCustomer2 = new Customer(new Block(1,0),01,false);
		this.takenBlocks = new ArrayList<Block>();
		this.takenBlocks.add(testerCustomer1.getPosition());
		this.takenBlocks.add(testerCustomer2.getPosition());
	}
	
	@Test
	public void testPosition() {
		Block blockbefore = testerCustomer2.getPosition();
		manageCustomer.moveBotCollisionFree(testerCustomer2.getPosition(), takenBlocks);
		assertEquals(blockbefore, testerCustomer2.getPosition());
		
	}
}
