// base code for student budget assessment
// Students do not need to use this code in their assessment, fine to junk it and do something different!

// user can enter in wages and loans and calculate total income
//
// To see GUI, run with java and select Box Url from Codio top line menu
//
// Layout - Uses GridBag layout in a straightforward way, every component has a (column, row) position in the UI grid
// Not the prettiest layout, but relatively straightforward
// Students who use IntelliJ or Eclipse may want to use the UI designers in these IDEs , instead of GridBagLayout

// Ehud Reiter Aug 204

//package Budget;

// Swing imports
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

// class definition
public class BudgetBase extends JPanel {                                    // based on Swing JPanel

    // high level UI stuff
    JFrame topLevelFrame;                                                   // top-level JFrame
    GridBagConstraints layoutConstraints = new GridBagConstraints();        // used to control layout

    // widgets which may have listeners and/or values
    private JButton calculateButton;                                        // Calculate button
    private JButton exitButton;                                             // Exit button
    private JTextField wagesField;                                          // Wages text field
    private JTextField loansField;                                          // Loans text field
    private JTextField otherField;                                          // Other field 
    private JTextField totalIncomeField;                                    // Total Income field
    private JTextField totalIncomeAfterIncomeTaxField;                      // Total Income after scottish income tax
    private JTextField rentField;                                           // Amount spent on rent
    private JTextField foodField;                                           // Amount spent on food
    private JTextField restaurantsField;                                    // Amount spent on restaurants.
    private JTextField totalAmountSpentField;                               // Total amount spent

    // constructor - create UI  (dont need to change this)
    public BudgetBase(JFrame frame) {
        topLevelFrame = frame;                      // keep track of top-level frame
        setLayout(new GridBagLayout());             // use GridBag layout
        initComponents();                           // initalise components
    }

    // initialise componenents
    // Note that this method is quite long.  Can be shortened by putting Action Listener stuff in a separate method
    // will be generated automatically by IntelliJ, Eclipse, etc
    private void initComponents() { 

        // Top row (0) - "INCOME" label
        JLabel incomeLabel = new JLabel("INCOME");
        addComponent(incomeLabel, 0, 0);

        // Row 1 - Wages label followed by wages textbox
        JLabel wagesLabel = new JLabel("Wages");
        addComponent(wagesLabel, 1, 0);
        

        // Row 2 - Loans label followed by loans textbox
        JLabel loansLabel = new JLabel("Loans");
        addComponent(loansLabel, 2, 0);

        // Row 3 - Other label followed by "other" textbox
        JLabel otherLabel = new JLabel("Other");
        addComponent(otherLabel,3, 0);

        // Row 4 - rent label followed by rent textbox
        JLabel rentLabel = new JLabel("Rent");
        addComponent(rentLabel, 4, 0);

        // Row 5 - food label followed by food textbox
        JLabel foodLabel = new JLabel("Food");
        addComponent(foodLabel, 5, 0);

        // Row 6 - restaurants label followed by restaurants textbox
        JLabel restaurantsLabel = new JLabel("Restaurants");
        addComponent(restaurantsLabel, 6, 0);



        // set up text field for entering wages
        // Could create method to do below (since this is done several times)
        wagesField = new JTextField("", 10);                                // blank initially, with 10 columns
        wagesField.setHorizontalAlignment(JTextField.RIGHT) ;               // number is at right end of field
        addComponent(wagesField, 1, 1); 

        // set up text box for entering loans
        loansField = new JTextField("", 10);                                // blank initially, with 10 columns
        loansField.setHorizontalAlignment(JTextField.RIGHT) ;               // number is at right end of field
        addComponent(loansField, 2, 1); 

        otherField = new JTextField("", 10);
        otherField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(otherField, 3, 1);

        rentField = new JTextField("", 10);
        rentField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(rentField, 4, 1);

        foodField = new JTextField("", 10);
        foodField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(foodField, 5, 1);

        restaurantsField = new JTextField("", 10);
        restaurantsField.setHorizontalAlignment(JTextField.RIGHT);
        addComponent(restaurantsField, 6, 1);
        

        

        // Row 7 - total Income label followed by total income field
        JLabel totalIncomeLabel = new JLabel("Total Income");
        addComponent(totalIncomeLabel, 7, 0);

        // Row 8 - total total Income After Income Tax Label followed by total Income After Income Tax field
        JLabel totalIncomeAfterIncomeTaxLabel = new JLabel("Total income after income tax");
        addComponent(totalIncomeAfterIncomeTaxLabel, 8, 0);


        // Row 9 - total amount spent label followed by textbox
        JLabel totalAmountSpentLabel = new JLabel("Total Amount Spent");
        addComponent(totalAmountSpentLabel, 9, 0);



        // set up text box for displaying total income.  Users cam view, but cannot directly edit it
        totalIncomeField = new JTextField("0", 10);                         // 0 initially, with 10 columns
        totalIncomeField.setHorizontalAlignment(JTextField.RIGHT) ;         // number is at right end of field
        totalIncomeField.setEditable(false);                                // user cannot directly edit this field (ie, it is read-only)
        addComponent(totalIncomeField, 7, 1); 
        
        
        // set up text box for displaying total income.  Users cam view, but cannot directly edit it
        totalIncomeAfterIncomeTaxField = new JTextField("0", 10);                       // 0 initially, with 10 columns
        totalIncomeAfterIncomeTaxField.setHorizontalAlignment(JTextField.RIGHT) ;       // number is at right end of field
        totalIncomeAfterIncomeTaxField.setEditable(false);                              // user cannot directly edit this field (ie, it is read-only)
        addComponent(totalIncomeAfterIncomeTaxField, 8, 1); 


        totalAmountSpentField = new JTextField("0", 10);
        totalAmountSpentField.setHorizontalAlignment(JTextField.RIGHT);
        totalAmountSpentField.setEditable(false);
        addComponent(totalAmountSpentField, 9, 1);

        // Row 10 - Calculate Button
        calculateButton = new JButton("Calculate");
        addComponent(calculateButton, 10, 0);  

        // Row 11 - Exit Button
        exitButton = new JButton("Exit");
        addComponent(exitButton, 11, 0);  

        // set up  listeners (in a spearate method)
        initListeners();
    }

    // set up listeners
    // initially just for buttons, can add listeners for text fields
    private void initListeners() {

        // exitButton - exit program when pressed
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // calculateButton - call calculateTotalIncome() when pressed
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalIncome();
                calculateIncomeAfterScottishIncomeTax();
                calculateExpenditure();
            }
        });
        // wagewsField - call calculateTotalIncome() when pressed
        wagesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateTotalIncome();
                calculateIncomeAfterScottishIncomeTax();
            }
        });

    }

    // add a component at specified row and column in UI.  (0,0) is top-left corner
    private void addComponent(Component component, int gridrow, int gridcol) {
        layoutConstraints.fill = GridBagConstraints.HORIZONTAL;                     // always use horixontsl filll
        layoutConstraints.gridx = gridcol;
        layoutConstraints.gridy = gridrow;
        add(component, layoutConstraints);

    }

    // updates tatalAmountSpentField after (eg, when Calculate is pressed)
    // sums total expenditure for food, rent, restaurants(after VAT)
    private double calculateExpenditure() {

        double totalAmount = 0.0;

        double rent = getTextFieldValue(rentField);
        double food = getTextFieldValue(foodField);
        double restaurants = getTextFieldValue(restaurantsField);

        
        if (Double.isNaN(rent) || Double.isNaN(food) || Double.isNaN(restaurants)) {
            totalAmountSpentField.setText("");                                         // clear total amount spent field 
            totalAmount = 0.0;
            return totalAmount;                                                        // exit method and do nothing
        }


        if (restaurants > 0) restaurants = (restaurants * 0.2) + restaurants;          // after VAT deduction
        totalAmount = rent + food + restaurants;


        totalAmountSpentField.setText(String.format("%.2f",totalAmount));
        return totalAmount;
    }

    // update totalIncomeAfterIncomeTaxField (eg, when Calculate is pressed)
    // this algotirthm is based on information here https://www.mygov.scot/scottish-income-tax/current-income-tax-rates
    /**
     * Algorithm:
     *  if annual income exceedes Personal allowence calculate tax for each band 
     *  until reaches band where persons annual income. Add all taxed bands.
     *  If annual income is higher 100000 than for every 2£ of income take 1£
     *  of Personal allowance.
     */
    private double calculateIncomeAfterScottishIncomeTax() {

        final double top = 125140;
        final double advanced = 75000;
        final double higher = 43662;
        final double intermediate = 29526;
        final double basic = 16537;
        final double starter = 12570;

        double tax = 0;

        double wages = getTextFieldValue(wagesField);
        double loans = getTextFieldValue(loansField);
        double other = getTextFieldValue(otherField);
        
        double annualIncome = wages + other;

        double totalIncomeAfterIncomeTax = 0;

        if (Double.isNaN(wages) || Double.isNaN(loans) || Double.isNaN(other)) {
            totalIncomeAfterIncomeTaxField.setText("");                                      // clear total income after income tax field
            wages = 0.0;
            return wages;                                                                   // exit method and do nothing
        }

        // if bellow starter(Personal allowence) which is 12570
        // this to remove unecessary overhead of going through other conditionals
        if (annualIncome <= starter) {

            totalIncomeAfterIncomeTax = annualIncome - tax + loans;
            totalIncomeAfterIncomeTaxField.setText(String.format("%.2f",totalIncomeAfterIncomeTax));
            return totalIncomeAfterIncomeTax;
        }

        
        if (annualIncome > starter) {
            tax += (Math.min(annualIncome, basic) - starter) * 0.19;
        }

        if (annualIncome > basic) {
            tax += (Math.min(annualIncome, intermediate) - basic) * 0.20;
        }

        if (annualIncome > intermediate) {
            tax += (Math.min(annualIncome, higher) - intermediate) * 0.21;
        }

        if (annualIncome > higher) {
            tax += (Math.min(annualIncome, advanced) - higher) * 0.42;
        }

        if (annualIncome > advanced) {
            tax += (Math.min(annualIncome, top) - advanced) * 0.45;
        }

        if (annualIncome > top) {
            tax += (annualIncome - top) * 0.48;
        }

        if (annualIncome > 100000) {
            double lostAllowance = Math.min(12570, (annualIncome - 100000) / 2);

            tax += lostAllowance * 0.45;
        }

        totalIncomeAfterIncomeTax = annualIncome - tax + loans;
        totalIncomeAfterIncomeTaxField.setText(String.format("%.2f",totalIncomeAfterIncomeTax));
        return totalIncomeAfterIncomeTax;
    }

    // update totalIncomeField (eg, when Calculate is pressed)
    // use double to hold numbers, so user can type fractional amounts such as 134.50
    public double calculateTotalIncome() {

        // get values from income text fields.  valie is NaN if an error occurs
        double wages = getTextFieldValue(wagesField);
        double loans = getTextFieldValue(loansField);
        double other = getTextFieldValue(otherField);

        // clear total field and return if any value is NaN (error)
        if (Double.isNaN(wages) || Double.isNaN(loans) || Double.isNaN(other)) {
            totalIncomeField.setText("");                                                   // clear total income field
            wages = 0.0;
            return wages;                                                                   // exit method and do nothing
        }

        // otherwise calculate total income and update text field
        double totalIncome = wages + loans + other;
        totalIncomeField.setText(String.format("%.2f",totalIncome));                        // format with 2 digits after the .
        return totalIncome;
    }

    // return the value if a text field as a double
    // --return 0 if field is blank
    // --return NaN if field is not a number
    private double getTextFieldValue(JTextField field) {

        // get value as String from field
        String fieldString = field.getText();                                       // get text from text field

        if (fieldString.isBlank()) {                                                // if text field is blank, return 0
            return 0;
        }

        else {  // if text field is not blank, parse it into a double
            //return Double.parseDouble(fieldString);
            try {
                return Double.parseDouble(fieldString);                                             // parse field number into a double
             } catch (java.lang.NumberFormatException ex) {                                         // catch invalid number exception
                JOptionPane.showMessageDialog(topLevelFrame, "Please enter a valid number");        // show error message
                return Double.NaN;                                                                  // return NaN to show that field is not a number
            }
        }
    }


// below is standard code to set up Swing, which students shouldnt need to edit much
    // standard mathod to show UI
    private static void createAndShowGUI() {
 
        //Create and set up the window.
        JFrame frame = new JFrame("Budget Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        BudgetBase newContentPane = new BudgetBase(frame);
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    // standard main class to set up Swing UI
    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }
        });
    }


}