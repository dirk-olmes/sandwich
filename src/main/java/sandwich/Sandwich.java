package sandwich;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Sandwich
{
	public static Sandwich make(String bread, Function<ChooseBreadStep, CloseStep> configuration)
	{
		return configuration.andThen(CloseStep::create).apply(new Builder(bread));
	}

	private static class Builder implements ChooseBreadStep, ChooseMeatStep, ChooseCheeseStep, AddVeggiesStep, CloseStep
	{
		final String bread;

		String meat;

		String cheese;

		final List<String> vegetables = new ArrayList<>();

		Builder(String bread)
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

	private final String bread;
	private final String meat;
	private final String cheese;
	private final List<String> vegetables;

	private Sandwich(Builder builder)
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
