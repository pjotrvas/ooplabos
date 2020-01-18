package hr.fer.oop.lab5.taxi;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FilterPanel extends JPanel {

    private static final String[] DISTANCE_CONDITION = {"<", ">="};

    JCheckBox skipCheckBox;
    JTextField skipTextField;
    JCheckBox leaveCheckBox;
    JTextField leaveTextField;
    JCheckBox paymentType;
    JRadioButton cashButton;
    JRadioButton cardButton;
    JRadioButton unknownButton;
    JCheckBox limitDistance;
    JComboBox<String> distanceCondition;
    JTextField distanceTextField;

    public FilterPanel(){
        super.setLayout(new SpringLayout());

        //first row
        skipCheckBox = new JCheckBox("Skip records?");
        super.add(skipCheckBox);
        super.add(new JLabel("Number of records to skip:"));
        skipTextField = new JTextField(20);
        super.add(skipTextField);

        //second row
        leaveCheckBox = new JCheckBox("Leave records?");
        super.add(leaveCheckBox);
        super.add(new JLabel("Number of records to leave:"));
        leaveTextField = new JTextField(20);
        super.add(leaveTextField);

        //third row
        paymentType = new JCheckBox("Filter by payment type?");
        super.add(paymentType);
        super.add(new JLabel(""));
        JPanel paymentTypePanel = new JPanel();
        paymentTypePanel.setBorder(BorderFactory.createTitledBorder(null, "PaymentType?", TitledBorder.LEADING, TitledBorder.TOP));
        super.add(paymentTypePanel);
        paymentTypePanel.setLayout(new GridLayout(0, 1, 0, 0));

        ButtonGroup paymentTypeGroup = new ButtonGroup();
        cashButton = new JRadioButton("Cash (CHK)");
        paymentTypePanel.add(cashButton);
        paymentTypeGroup.add(cashButton);
        cardButton = new JRadioButton("Card (CRD)");
        paymentTypePanel.add(cardButton);
        paymentTypeGroup.add(cardButton);
        unknownButton = new JRadioButton("Unknown (UNK)");
        paymentTypePanel.add(unknownButton);
        paymentTypeGroup.add(unknownButton);

        //fourth row
        limitDistance = new JCheckBox( "Limit distance?");
        super.add(limitDistance);
        distanceCondition = new JComboBox <>(DISTANCE_CONDITION);
        super.add(distanceCondition);
        distanceTextField = new JTextField(20);
        super.add(distanceTextField);

        SpringUtilities.makeCompactGrid(this, 4, 3, 0,0,5,5);

    }

    public TaxiRideFilter getFilter(){
        TaxiRideFilter filter = new TaxiRideFilter();

        if (skipCheckBox.isSelected()){
            filter.setToSkip(true);
            filter.setNumberToSkip(Integer.parseInt(skipTextField.getText()));
        } else {
            filter.setToSkip(false);
        }

        if (leaveCheckBox.isSelected()){
            filter.setToLeave(true);
            filter.setNumberToSkip(Integer.parseInt(leaveTextField.getText()));
        } else {
            filter.setToLeave(false);
        }

        if (paymentType.isSelected()){
            filter.setToFilterByPaymentType(true);
            if (cashButton.isSelected()){
                filter.setPaymentType("CSH");
            } else if (cardButton.isSelected()){
                filter.setPaymentType("CRD");
            } else {
                filter.setPaymentType("UNK");
            }
        } else {
            filter.setToFilterByPaymentType(false);
        }

        if (limitDistance.isSelected()){
            filter.setToLimitDistance(true);
            filter.setDistanceCondition((String) distanceCondition.getSelectedItem());
            filter.setDistanceToLimit(Double.parseDouble(distanceTextField.getText()));
        } else {
            filter.setToLimitDistance(false);
        }

        return filter;
    }

    public class TaxiRideFilter{

        private boolean toSkip, toLeave, toFilterByPaymentType, toLimitDistance;
        private int numberToSkip, numberToleave;
        private double distanceToLimit;
        private String paymentType, distanceCondition;

        public boolean isToSkip () {
            return toSkip;
        }

        public void setToSkip ( boolean toSkip ) {
            this.toSkip = toSkip;
        }

        public boolean isToLeave () {
            return toLeave;
        }

        public void setToLeave ( boolean toLeave ) {
            this.toLeave = toLeave;
        }

        public boolean isToFilterByPaymentType () {
            return toFilterByPaymentType;
        }

        public void setToFilterByPaymentType ( boolean toFilterByPaymentType ) {
            this.toFilterByPaymentType = toFilterByPaymentType;
        }

        public boolean isToLimitDistance () {
            return toLimitDistance;
        }

        public void setToLimitDistance ( boolean toLimitDistance ) {
            this.toLimitDistance = toLimitDistance;
        }

        public int getNumberToSkip () {
            return numberToSkip;
        }

        public void setNumberToSkip ( int numberToSkip ) {
            this.numberToSkip = numberToSkip;
        }

        public int getNumberToleave () {
            return numberToleave;
        }

        public void setNumberToleave ( int numberToleave ) {
            this.numberToleave = numberToleave;
        }

        public double getDistanceToLimit () {
            return distanceToLimit;
        }

        public void setDistanceToLimit ( double distanceToLimit ) {
            this.distanceToLimit = distanceToLimit;
        }

        public String getPaymentType () {
            return paymentType;
        }

        public void setPaymentType ( String paymentType ) {
            this.paymentType = paymentType;
        }

        public String getDistanceCondition () {
            return distanceCondition;
        }

        public void setDistanceCondition ( String distanceCondition ) {
            this.distanceCondition = distanceCondition;
        }
    }

}
