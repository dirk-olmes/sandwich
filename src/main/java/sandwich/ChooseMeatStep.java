package sandwich;

public interface ChooseMeatStep
{
	ChooseCheeseStep withCheese(final String cheese);

	AddVeggiesStep noCheese();
}
