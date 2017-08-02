package sandwich;

import java.util.Collections;
import java.util.List;

public class Sandwich
{
	private final String bread;
	private final String meat;
	private final String cheese;
	private final List<String> vegetables;

	Sandwich(SandwichBuilder builder)
	{
		super();
		bread = builder.bread;
		meat = builder.meat;
		cheese = builder.cheese;
		vegetables = Collections.unmodifiableList(builder.vegetables);
	}

	public String getBread()
	{
		return bread;
	}

	public String getMeat()
	{
		return meat;
	}

	public String getCheese()
	{
		return cheese;
	}

	public List<String> getVegetables()
	{
		return vegetables;
	}
}
