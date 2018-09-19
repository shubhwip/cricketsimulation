package com.cricketsimulation.runner;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.cricketsimulation.exceptions.InvalidTeamException;
import com.cricketsimulation.exceptions.NoPlayerOnStrikeException;
import com.cricketsimulation.gamestrategy.DefaultGameStrategy;
import com.cricketsimulation.gamestrategy.IGameStrategy;
import com.cricketsimulation.model.Player;
import com.cricketsimulation.model.Team;
import com.cricketsimulation.rules.IRule;
import com.cricketsimulation.rules.PlayerOutRuleImpl;
import com.cricketsimulation.rules.StrikeRuleImpl;
import com.cricketsimulation.runner.DefaultRuleRunner;
import com.cricketsimulation.runner.IRuleRunner;

public class RuleRunnerTest {

	Team team;
	List<Player> players;
	IGameStrategy gameStrategy;
	IRuleRunner ruleRunner;

	@Before
	public void setup() {
		team = new Team("Bengaluru", "Chennai", 4, 40, 4);
		gameStrategy = new DefaultGameStrategy();
		ruleRunner = new DefaultRuleRunner(gameStrategy);
	}

	@Test
	public void testWithHighProbablityOfEachPlayerGettingOut() throws NoPlayerOnStrikeException, InvalidTeamException {
		players = new ArrayList<>();
		players.add(
				new Player("Kirat Boli", team, Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 93.0), 0, 0, false));
		players.add(new Player("NS Nodhi", team, Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 93.0), 0, 0, false));
		players.add(new Player("R Rumrah", team, Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 93.0), 0, 0, false));
		players.add(
				new Player("Shashi Henra", team, Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 93.0), 0, 0, false));
		IRule[] rules = new IRule[] { new PlayerOutRuleImpl(), new StrikeRuleImpl() };
		gameStrategy.setRules(rules);
		ruleRunner.applyRules(players);
		for (Player p : players) {
			assertEquals(true, p.isOut());
		}
	}

	@Test(expected = NoPlayerOnStrikeException.class)
	public void testWithNoPlayersInField() throws NoPlayerOnStrikeException, InvalidTeamException {
		players = new ArrayList<>();
		IRule[] rules = new IRule[] { new PlayerOutRuleImpl(), new StrikeRuleImpl() };
		gameStrategy.setRules(rules);
		ruleRunner.applyRules(players);
	}

	@Test(expected = InvalidTeamException.class)
	public void testWithInvalidTeamStructure() throws NoPlayerOnStrikeException, InvalidTeamException {
		Team invalidTeam = new Team("Bengaluru", "Chennai", 0, 40, 4);
		players = new ArrayList<>();
		players.add(new Player("Kirat Boli", invalidTeam, Arrays.asList(12.5, 12.5, 12.5, 12.5, 12.5, 12.5, 12.5, 12.5),
				0, 0, false));
		players.add(new Player("NS Nodhi", invalidTeam, Arrays.asList(12.5, 12.5, 12.5, 12.5, 12.5, 12.5, 12.5, 12.5),
				0, 0, false));
		players.add(new Player("R Rumrah", invalidTeam, Arrays.asList(12.5, 12.5, 12.5, 12.5, 12.5, 12.5, 12.5, 12.5),
				0, 0, false));
		players.add(new Player("Shashi Henra", invalidTeam,
				Arrays.asList(12.5, 12.5, 12.5, 12.5, 12.5, 12.5, 12.5, 12.5), 0, 0, false));
		IRule[] rules = new IRule[] { new PlayerOutRuleImpl(), new StrikeRuleImpl() };
		gameStrategy.setRules(rules);
		ruleRunner.applyRules(players);
	}
}
