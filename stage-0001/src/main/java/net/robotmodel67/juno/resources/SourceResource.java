package net.robotmodel67.juno.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.robotmodel67.juno.models.Source;
import net.robotmodel67.juno.models.User;
import net.robotmodel67.juno.repos.SourceRepository;
import net.robotmodel67.juno.repos.UserRepository;

@RestController
@RequestMapping(path = "/resources/sources")
public class SourceResource {

	@Autowired
	private SourceRepository repository; 
	
	@GetMapping(path ="")
	public List<Source> list(){
		return repository.findAll(); 
	}

	@GetMapping(path = "/{id}")
	public Source findOne(@PathVariable long id) {
		Source source = repository.findById(id).get(); 
		return source;
	}
	
	
	@PostMapping(path = "/search")
	public List<Source> getUserByLegacy(@RequestBody Source source) {
		List<Source> result = repository.findSourcesByLegacyId(source.getLegacyId());
		return result;
	}

	@GetMapping(path = "legacy/{id}")
	public List<Source> getUserByLegacy(@PathVariable Long id) {
		List<Source> result = repository.findSourcesByLegacyId(id);
		return result;
	}
	
}
