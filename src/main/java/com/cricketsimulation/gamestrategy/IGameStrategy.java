package com.cricketsimulation.gamestrategy;

import java.util.List;

import com.cricketsimulation.model.Player;
import com.cricketsimulation.model.State;
import com.cricketsimulation.rules.IRule;

/**
 * IGameStrategy is interface containing gameStrategy methods.
 * 
 * @author Shubham Jain
 * @version 1.0
 *
 */
public interface IGameStrategy {

	/**
	 * @return returns the rules for game
	 */
	IRule[] getRules();

	/**
	 * @param rules
	 *            rules which will be applied for game
	 */
	void setRules(IRule[] rules);

	/**
	 * @param currentState
	 *            current state in the match
	 * @param players
	 *            players currently in batting
	 * @return runs
	 */
	int getNextRuns(State currentState, List<Player> players);

}
