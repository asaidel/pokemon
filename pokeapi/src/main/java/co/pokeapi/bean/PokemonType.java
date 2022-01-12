package co.pokeapi.bean;

public class PokemonType extends BaseBean{
	private Integer slot;
	private NamedAPIResource type;
	
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}
	public NamedAPIResource getType() {
		return type;
	}
	public void setType(NamedAPIResource type) {
		this.type = type;
	}
}
