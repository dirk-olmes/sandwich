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
		Sandwich sandwich = Sandwich.make("white", cfg -> cfg
			.withMeat("bacon")
			.noCheese()
			.addVeggie("salad")
			.close()
		);
		// @formatter:on

		assertEquals("white", sandwich.getBread());
		assertEquals("bacon", sandwich.getMeat());
		assertNull(sandwich.getCheese());
	}

	@Test
	public void lambdaAccess()
	{
		String veggie = "salad";
		if ((System.currentTimeMillis() % 2) == 0)
		{
			veggie = "lettuce";
		}

		final String evilHackToCircumventLambdaScoping = veggie;

		// @formatter:off
		Sandwich sandwich = Sandwich.make("white", cfg -> cfg
			.withMeat("wheat")
			.noCheese()
			.addVeggie(evilHackToCircumventLambdaScoping)
			.close()
		);
		// @formatter:on

		assertEquals(veggie, sandwich.getVegetables().get(0));
	}
}
