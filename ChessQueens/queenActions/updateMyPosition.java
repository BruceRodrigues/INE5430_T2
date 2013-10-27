// Internal action code for project ChessQueens.mas2j

package queenActions;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class updateMyPosition extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        ts.getAg().getLogger().info("executing internal action 'queenActions.updateMyPosition'");
        
        // everything ok, so returns true
        return true;
    }
}

