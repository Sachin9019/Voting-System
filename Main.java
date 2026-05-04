package sachin_voting_swing;


import java.util.ArrayList;
class Main {

class Candidate {
    int id;
    String name;
    int votes;

    Candidate(int id, String name) {
        this.id = id;
        this.name = name;
        this.votes = 0;
    }
}

public class CandidateService {

    private ArrayList<Candidate> candidates = new ArrayList<>();
    private int idCounter = 1;

    public void addCandidate(String name) {
        candidates.add(new Candidate(idCounter++, name));
        System.out.println("✅ Candidate added successfully!");
    }

    public void viewCandidates() {
        if (candidates.isEmpty()) {
            System.out.println("No candidates available.");
            return;
        }

        for (Candidate c : candidates) {
            System.out.println("ID: " + c.id + " | Name: " + c.name);
        }
    }

    public void castVote(int id) {
        for (Candidate c : candidates) {
            if (c.id == id) {
                c.votes++;
                System.out.println("✅ Vote casted successfully!");
                return;
            }
        }
        System.out.println("❌ Candidate not found!");
    }

    public void viewResults() {
        for (Candidate c : candidates) {
            System.out.println(c.name + " -> Votes: " + c.votes);
        }
    }
}
}