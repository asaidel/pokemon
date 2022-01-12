package co.pokeapi.bean;

import java.util.List;

public class PokemonBean extends BaseBean{
	
	private String id;
	private String name;
	private List<PokemonType> types;
	private Integer weight;
	private List<PokemonAbility> abilities;
	private NamedAPIResource species;
	 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PokemonType> getTypes() {
		return types;
	}
	public void setTypes(List<PokemonType> types) {
		this.types = types;
	}
	public Integer getWeight() {
		return weight;
	}
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	public List<PokemonAbility> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<PokemonAbility> abilities) {
		this.abilities = abilities;
	}
	public NamedAPIResource getSpecies() {
		return species;
	}
	public void setSpecies(NamedAPIResource species) {
		this.species = species;
	}
}
