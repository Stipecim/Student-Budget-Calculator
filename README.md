# Student-Budget-Calculator
This is student budget calculator

## What I have done
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