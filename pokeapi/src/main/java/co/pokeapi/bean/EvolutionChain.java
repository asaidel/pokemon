package co.pokeapi.bean;

public class EvolutionChain extends BaseBean{
	
	private NamedAPIResource babyTriggerItem;
	private ChainLink chain;	
	
	public NamedAPIResource getBabyTriggerItem() {
		return babyTriggerItem;
	}
	public void setBabyTriggerItem(NamedAPIResource babyTriggerItem) {
		this.babyTriggerItem = babyTriggerItem;
	}
	public ChainLink getChain() {
		return chain;
	}
	public void setChain(ChainLink chain) {
		this.chain = chain;
	}	
}
