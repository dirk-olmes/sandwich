package sandwich;

public interface ChooseBreadStep
{
	ChooseMeatStep withMeat(final String meat);

	AddVeggiesStep vegan();
}
