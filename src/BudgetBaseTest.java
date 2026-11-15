import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.*;

import java.util.*;;

/**
 * Unit test for simple App.
 */
public class BudgetBaseTest 
{
    BudgetBase bb;

    public BudgetBaseTest() {
        JFrame frame = new JFrame();
        bb = new BudgetBase(frame);
    }

    @Test
    public void shouldTotal()
    {
        
        bb.setWagesField("1500");

        assertEquals("1500", bb.getWagesField());

    }

    @Test 
    public void shouldUndoChanges() {
        bb.setWagesField("100");
        bb.setLoansField("200");
        bb.setRentField("300");

        bb.clickUndoButton();
        assertEquals("", bb.getRentField());

        bb.clickUndoButton();
        assertEquals("", bb.getLoansField());

        bb.clickUndoButton();
        assertEquals("", bb.getWagesField());
    }

    @Test
    public void shouldLimitUndoOmitLastState() {                

        // Perform 100 changes
        for (int i = 1; i <= 100; i++) {
            bb.setWagesField(i % 2 == 0 ? "" : "1");                                // first iteration wagesField is "1" second iteration wagesfield has ""
        }

        ArrayList<Object> lastSavedState = bb.getSavedStates().peekLast();          // on 100th iteration last item on stack should be "" instead of "1"

        System.out.print(bb.getSavedStates().size());
        System.out.print(bb.getSavedStates().peekLast());

        // Second change should remain (first change deleted)
        assertEquals("", lastSavedState.get(0));

    }
}
