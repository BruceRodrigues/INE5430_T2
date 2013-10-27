// Internal action code for project IA8Queens.mas2j

package queenActions;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

import java.util.*;

public class flipACoin extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
		Random r = new Random();
		return r.nextInt(100) >  50;
    }
}

