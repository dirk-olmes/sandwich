package sandwich;

import java.util.ArrayList;
import java.util.List;

class SandwichBuilder implements ChooseBreadStep, ChooseMeatStep, ChooseCheeseStep, AddVeggiesStep, CloseStep
{
	public static ChooseBreadStep withBread(String bread)
	{
		return new SandwichBuilder(bread);
	}

	String bread;
	String meat;
	String cheese;
	final List<String> vegetables = new ArrayList<>();

	private SandwichBuilder(String bread)
	{
		this.bread = bread;
	}

	@Override
	public ChooseMeatStep withMeat(String m)
	{
		this.meat = m;
		return this;
	}

	@Override
	public AddVeggiesStep vegan()
	{
		return this;
	}

	@Override
	public ChooseCheeseStep withCheese(String c)
	{
		this.cheese = c;
		return this;
	}

	@Override
	public AddVeggiesStep noCheese()
	{
		return this;
	}

	@Override
	public AddVeggiesStep addVeggie(String vegetable)
	{
		this.vegetables.add(vegetable);
		return this;
	}

	@Override
	public CloseStep noVeggies()
	{
		return this;
	}

	@Override
	public CloseStep close()
	{
		return this;
	}

	@Override
	public Sandwich create()
	{
		return new Sandwich(this);
	}

}
