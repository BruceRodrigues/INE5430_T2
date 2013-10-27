package queenActions;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class shouldIMove extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
		// TODO: There MUST be a better way to get agent IDs!
		Agent a = ts.getAg();
		int aId = Character.getNumericValue(
			a.getASLSrc().charAt(a.getASLSrc().length() - 5));
		int bId = Character.getNumericValue(
			args[0].toString().charAt(args[0].toString().length() - 1));
		
		a.getLogger().info(args[1].toString());
		
		return true;
    }
}

