package sachin_voting_swing;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class VotingGUI extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField nameField, voteField;
    private JTextArea outputArea;
    private CandidateService service = new CandidateService();

    public VotingGUI() {
        setTitle("Voting System");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Components
        nameField = new JTextField(15);
        voteField = new JTextField(5);
        outputArea = new JTextArea(15, 40);

        JButton addBtn = new JButton("Add Candidate");
        JButton viewBtn = new JButton("View Candidates");
        JButton voteBtn = new JButton("Vote");
        JButton resultBtn = new JButton("View Results");

        add(new JLabel("Name:"));
        add(nameField);
        add(addBtn);

        add(new JLabel("Candidate ID:"));
        add(voteField);
        add(voteBtn);

        add(viewBtn);
        add(resultBtn);

        add(new JScrollPane(outputArea));

        // Actions
        addBtn.addActionListener(e -> addCandidate());
        viewBtn.addActionListener(e -> viewCandidates());
        voteBtn.addActionListener(e -> castVote());
        resultBtn.addActionListener(e -> viewResults());
    }

    private void addCandidate() {
        String name = nameField.getText();
        service.addCandidate(name);
        outputArea.setText("Candidate Added!");
    }

    private void viewCandidates() {
        try (Connection con = DBConnection.getConnection()) {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM candidates");

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt("candidate_id"))
                  .append(" - ")
                  .append(rs.getString("name"))
                  .append("\n");
            }

            outputArea.setText(sb.toString());

        } catch (Exception e) {
            outputArea.setText("Error loading candidates");
            e.printStackTrace();
        }
    }

    private void castVote() {
        try {
            int id = Integer.parseInt(voteField.getText());
            service.castVote(id);
            outputArea.setText("Vote Casted!");
        } catch (Exception e) {
            outputArea.setText("Invalid ID!");
        }
    }

    private void viewResults() {
        try (Connection con = DBConnection.getConnection()) {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM candidates ORDER BY votes DESC");

            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString("name"))
                  .append(" - Votes: ")
                  .append(rs.getInt("votes"))
                  .append("\n");
            }

            outputArea.setText(sb.toString());

        } catch (Exception e) {
            outputArea.setText("Error loading results");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        VotingGUI gui = new VotingGUI();
        gui.setVisible(true);
    }
}
