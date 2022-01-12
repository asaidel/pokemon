package co.pokeapi.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.pokeapi.service.PokemonService;
import net.minidev.json.JSONObject;

@RestController
public class PokemonController {

	@Autowired 
	PokemonService pokemonService;	
		
	@GetMapping("/pokemon/{id}")
	public ResponseEntity<JSONObject> getPokemonDetail(@PathVariable String id) {
		try {
			return new ResponseEntity<>(pokemonService.findDetailById(id), HttpStatus.OK);
		} catch (URISyntaxException | IOException | InterruptedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
	
	@GetMapping({"/pokemon","/pokemon/{limit}{offset}"})
	public ResponseEntity<JSONObject> getPokemons(@RequestParam(required = false) String limit, @RequestParam(required = false) String offset) {
		try {
			return new ResponseEntity<>(pokemonService.getPaginated(limit, offset), HttpStatus.OK);
		} catch (URISyntaxException | IOException | InterruptedException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
