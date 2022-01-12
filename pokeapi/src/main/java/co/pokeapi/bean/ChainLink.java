package co.pokeapi.bean;

import java.util.List;

public class ChainLink extends BaseBean{
	
	private Boolean isBaby;
	private NamedAPIResource species;
	private List<ChainLink> evolvesTo;
	
	public Boolean getIsBaby() {
		return isBaby;
	}
	public void setIsBaby(Boolean isBaby) {
		this.isBaby = isBaby;
	}
	public NamedAPIResource getSpecies() {
		return species;
	}
	public void setSpecies(NamedAPIResource species) {
		this.species = species;
	}
	public List<ChainLink> getEvolvesTo() {
		return evolvesTo;
	}
	public void setEvolvesTo(List<ChainLink> evolvesTo) {
		this.evolvesTo = evolvesTo;
	}
	
}
