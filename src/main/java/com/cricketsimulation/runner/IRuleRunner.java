package com.cricketsimulation.runner;

import java.util.List;

import com.cricketsimulation.exceptions.InvalidTeamException;
import com.cricketsimulation.exceptions.NoPlayerOnStrikeException;
import com.cricketsimulation.model.Player;

/**
 * 
 * <h1>IRuleRunner class defines contract for apply all the rules</h1>
 * 
 * @author Shubham Jain
 * @version 1.0
 *
 */
public interface IRuleRunner {
	/**
	 * applyRules will be called in order to apply cricket rules to perform match
	 * simulation
	 * 
	 * @param players
	 * @return updated list of players
	 */
	public List<Player> applyRules(List<Player> players) throws NoPlayerOnStrikeException, InvalidTeamException;
}
