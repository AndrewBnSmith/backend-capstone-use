package com.example.demo.controller;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Goal;
import com.example.demo.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1/")
public class GoalController {
	@Autowired
	private GoalRepository goalRepository;
	
	// get all goals
	@GetMapping("/goals")
	public List<Goal> getAllGoals(){
		return goalRepository.findAll();
	}
	
	//get goal count
	@GetMapping("/count_goals")
	public long getAllGoalsCount(){
		return goalRepository.count();
	}
	
	//create goal
	@PostMapping("/goals")
	public Goal createGoal(@RequestBody Goal goal) {
		return goalRepository.save(goal);
	}
	
	//get by id
	@GetMapping("/goals/{id}")
	public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
		Goal goal = goalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Goal does not exist with id :" + id));
		return ResponseEntity.ok(goal);
	}
	
	//update goal
	@PutMapping("/goals/{id}")
	public ResponseEntity<Goal> updateGoal(@PathVariable Long id , @RequestBody Goal goalDetails) {
		Goal goal = goalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Goal not found with id :" + id));
		goal.setName(goalDetails.getName());
		Goal updatedGoal = goalRepository.save(goal);
		return ResponseEntity.ok(updatedGoal);
	}
	
	//delete
	@DeleteMapping("/goals/{id}")
	public ResponseEntity <Map<String, Boolean>> deleteGoal(@PathVariable Long id){
		Goal goal = goalRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Goal not found with id :" + id));
		goalRepository.delete(goal);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
