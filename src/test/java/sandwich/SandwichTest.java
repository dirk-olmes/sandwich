package sandwich;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class SandwichTest extends Object
{
	@Test
	public void simpleSandwich()
	{
		// @formatter:off
		Sandwich sandwich = SandwichBuilder.withBread("white")
			.withMeat("bacon")
			.noCheese()
			.addVeggie("salad")
			.close()
			.create();
		// @formatter:on

		assertEquals("white", sandwich.getBread());
		assertEquals("bacon", sandwich.getMeat());
		assertNull(sandwich.getCheese());
	}

	@Test
	public void localVariableFromBuilder()
	{
		String veggie = "salad";
		if ((System.currentTimeMillis() % 2) == 0)
		{
			veggie = "lettuce";
		}

		// @formatter:off
		Sandwich sandwich = SandwichBuilder.withBread("white")
			.withMeat("wheat")
			.noCheese()
			.addVeggie(veggie)
			.close()
			.create();
		// @formatter:on

		assertEquals(veggie, sandwich.getVegetables().get(0));
	}
}
