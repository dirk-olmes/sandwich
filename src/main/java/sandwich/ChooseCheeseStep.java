package sandwich;

public interface ChooseCheeseStep
{
	AddVeggiesStep addVeggie(final String vegetable);

	CloseStep noVeggies();
}
