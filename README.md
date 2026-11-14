# Student-Budget-Calculator
This is student budget calculator

## What I have done
### Basic System
- **Income calculator:**
```
    Added JTextField for GUI:
        - otherField;
        - totalIncomeAfterIncomeTaxField;
    Added functionality:
        - calculateIncomeAfterScottishIncomeTax

```
- **Spending calculator:**
```
    Added JtextField for GUI:
        - rentField;
        - foodField;
        - restaurantsField;
    Added functionality:
        - calculateExpenditure
```
- **Remaining balance:**
```
    Added JTextField for GUI:
        - remainingBalanceField;
    Added functionality:
        - calculateRemainingBalance
        - remainingBalanceField.actionListener          // action triggered after JTextField update       
```
- **User input validation**
```
    Inside getTextField() exception handling added:
        - Dialog Message title and type of message 
```

### Extensions

- **Time Periods**
```
    Added new type and components:
        - timePeriod enum
        - JRadioButton weeklyButton, monthlyButton, yerlyButton
        - ButtonGroup periodGroup
    Added functionality to calculateIncomeAfterScottishIncomeTax:
        - Inside multiply chosen timePeriod with wages and other income recieved in that time period
        - after income divide that timePeriod again with annual income after tax
```
- **Automatic calculations**
```
    Added functionality:
        - addDocumentListenerForAutomaticCalculations added to every input field
        - calculateAll

    Added other:
        - from SwingUtilities.invokelater() putting task inside que due to documentDocument processing event 
```