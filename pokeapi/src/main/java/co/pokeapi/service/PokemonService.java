package co.pokeapi.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.pokeapi.util.HttpClientUtil;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@Service
public class PokemonService {
	
	@Value( "${address}" )
	private String uri;
	
	public JSONObject getPaginated(String limit, String offset) throws URISyntaxException, IOException, InterruptedException {
		
		Map<?, ?> pokemap = HttpClientUtil.httpGetRequest(uri,"");
		
		List<Map<?,?>> results = (List<Map<?,?>>) pokemap.get("results");		
		JSONArray array = new JSONArray();
		
		for (Map<?,?> r : results) {
			String url = (String) r.get("url");
		//	int begin = url.lastIndexOf("n/");
			
			JSONObject p = findById(url.substring(34));
			array.add(p);
		}
		
		JSONObject j = new JSONObject();
		j.put("results", array);
			
		return j;
	}	
	
	private JSONObject findById(String id) throws URISyntaxException, IOException, InterruptedException {
		
		Map<?, ?> pokemap = HttpClientUtil.httpGetRequest(this.uri, id);
				
		//pokemap.forEach((k, v) -> System.out.println((k + ":" + v)));
		
		JSONObject j = new JSONObject();
		
		j.put("id", pokemap.get("id"));
		j.put("name", pokemap.get("name"));
		j.put("weight", pokemap.get("weight"));	
		j.put("type", pokemap.get("types"));		
		j.put("abilities", pokemap.get("abilities"));		
		j.put("species", pokemap.get("species"));
			
		return j;
	}

	public JSONObject findDetailById(String id) throws URISyntaxException, IOException, InterruptedException {
		JSONObject j = findById(id);
		
		Map<?, ?> species = (Map<?, ?>) j.get("species");		
		String url = (String) species.get("url");		
		JSONObject pokeSpecies = findByUrl(url);
		
		Map<?, ?> evoChain = (Map<?, ?>) pokeSpecies.get("evolution_chain");		
		String urlEvo = (String) evoChain.get("url");		
		JSONObject evolution = findByUrl(urlEvo);
		
		j.put("evolution", evolution);
		
		return j;
	}

	private static JSONObject findByUrl(String url) throws URISyntaxException, IOException, InterruptedException {
		Map<?, ?> pokemap = HttpClientUtil.httpGetRequest(url,"");
		JSONObject j = new JSONObject((Map<String, ?>) pokemap);
		return j;
	}
}
