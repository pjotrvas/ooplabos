package hr.fer.oop.lab5.taxi;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TableFrame extends JFrame {

    private GenericTablePanel tablePanel;
    private JTextField loadField;
    private JTextArea logArea;
    private JFrame filterFrame;
    private FilterPanel filterPanel;
    private JButton loadButton, applyFilterButton;

    public TableFrame(){

        JToolBar toolBar = new JToolBar();
        super.add(toolBar, BorderLayout.NORTH);

        JButton exitButton = new JButton("Exit");
        toolBar.add(exitButton);
        exitButton.addActionListener(actionEvent -> System.exit(0));

        loadField = new JTextField(30);
        toolBar.add(loadField);
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        loadButton = new JButton("Load file");
        loadButton.addActionListener(e -> {
            logArea.append("Loading records from \"" + loadField.getText() + "\"\n");
            loadButton.setEnabled(false);
            applyFilterButton.setEnabled(false);

            Runnable loadTask = () -> {
                Stream<String> lines;
                try{
                    lines = Files.lines(Paths.get(loadField.getText()));
                    //reset the counter when loading
                    TaxiRideRecord.resetCounter();
                    List<TaxiRideRecord> records = lines.map(line -> new TaxiRideRecord(line)).collect(Collectors.toList());
                    SwingUtilities.invokeLater(() -> {
                        tablePanel.update(records);
                        logArea.append("Loaded " + records.size() + "records\n");
                    });
                } catch (Exception ex){
                    SwingUtilities.invokeLater(() -> {
                        logArea.append("Cannot open file\n");
                    });
                }finally {
                    SwingUtilities.invokeLater(() -> {
                        loadButton.setEnabled(true);
                        applyFilterButton.setEnabled(true);
                    });
                }
            };
            new Thread(loadTask).start();
        });

        toolBar.add(loadButton);
        toolBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        JButton defineFilterButton = new JButton("Define filter");
        defineFilterButton.addActionListener(e -> {
            if (filterFrame.isVisible()){
                filterFrame.setVisible(false);
            } else {
                filterFrame.setVisible(true);
            }
        });

        toolBar.add(defineFilterButton);

        applyFilterButton = new JButton("Apply filter");
        applyFilterButton.addActionListener(e -> {
            loadButton.setEnabled(false);
            applyFilterButton.setEnabled(false);

            FilterPanel.TaxiRideFilter filter = filterPanel.getFilter();
            if (filter.isToLeave() || filter.isToFilterByPaymentType() || filter.isToLimitDistance()) {
                logArea.append("Applying defined filter\n");
            }

            List <TaxiRideRecord> records = tablePanel.getRecords();

            Runnable filterTask = () -> {
                Stream <TaxiRideRecord> stream = records.stream();

                if (filter.isToSkip()) {
                    stream = stream.skip(filter.getNumberToSkip());
                    SwingUtilities.invokeLater(() -> {
                        logArea.append("Skipping first " + filter.getNumberToSkip() + "records\n");
                    });
                }

                if (filter.isToLeave()) {
                    stream = stream.limit(filter.getNumberToleave());
                    SwingUtilities.invokeLater(() -> {
                        logArea.append("Leaving first " + filter.getNumberToleave() + "records\n");
                    });
                }

                if (filter.isToFilterByPaymentType()) {
                    stream = stream.filter(record -> record.getPaymentType().equals(filter.getPaymentType()));
                    SwingUtilities.invokeLater(() -> {
                        logArea.append("Keeping records with " + filter.getPaymentType() + " payment type\n");
                    });
                }

                List <TaxiRideRecord> filteredRecords = stream.collect(Collectors.toList());
                SwingUtilities.invokeLater(() -> {
                    tablePanel.update(filteredRecords);

                    loadButton.setEnabled(true);
                    applyFilterButton.setEnabled(true);
                });
            };

            new Thread(filterTask).start();
        });

        toolBar.add(applyFilterButton);

        //add the empty table
        tablePanel = new GenericTablePanel<>(TaxiRideRecord.class);
        tablePanel.setPreferredSize(new Dimension(1920, 700));
        super.add(tablePanel, BorderLayout.CENTER);

        //creates the log panel
        ScrollPane logPane = new ScrollPane();
        logArea = new JTextArea();
        logPane.add(logArea);
        super.add(logPane, BorderLayout.SOUTH);

        //filter frame
        filterFrame = new JFrame();
        filterFrame.setBounds(100, 100, 500, 400);
        filterFrame.add(filterPanel = new FilterPanel());
        filterFrame.pack();

    }


    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            TableFrame window = new TableFrame();
            window.setLocation(20, 20);
            window.setVisible(true);
            window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            window.setTitle("Taxi Record Viewer");
            window.pack();
        });
    }
}
