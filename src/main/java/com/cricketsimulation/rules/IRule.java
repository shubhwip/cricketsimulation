package com.cricketsimulation.rules;

import java.util.List;

import com.cricketsimulation.model.Player;
import com.cricketsimulation.model.State;

/**
 * <h1>IRule</h1>
 * 
 * @author Shubham Jain
 * @version 1.0
 */
public interface IRule {
	/**
	 * @return returns the next state after applying rule
	 */
	State nextState(State currentState, List<Player> players);
}
