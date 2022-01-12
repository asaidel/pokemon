package co.pokeapi.bean;

public class PokemonAbility extends BaseBean{
	private Boolean isHidden;
	private Integer slot;
	private NamedAPIResource ability;
	
	public Boolean getIsHidden() {
		return isHidden;
	}
	public void setIsHidden(Boolean isHidden) {
		this.isHidden = isHidden;
	}
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}
	public NamedAPIResource getAbility() {
		return ability;
	}
	public void setAbility(NamedAPIResource ability) {
		this.ability = ability;
	}
}
