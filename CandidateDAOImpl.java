package sachin_voting_swing;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;

	public class CandidateDAOImpl implements CandidateDAO{
		public void addCandidate(String name) {
	        try (Connection con = DBConnection.getConnection()) {

	            String sql = "INSERT INTO candidates(name) VALUES(?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, name);
	            ps.executeUpdate();

	            System.out.println("✅ Candidate added successfully");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void viewCandidates() {
	        try (Connection con = DBConnection.getConnection()) {

	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM candidates");

	            System.out.println("\nID\tName");
	            while (rs.next()) {
	                System.out.println(rs.getInt(1) + "\t" + rs.getString(2));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public void vote(int candidateId) {
	        try (Connection con = DBConnection.getConnection()) {

	            String sql = "UPDATE candidates SET votes = votes + 1 WHERE candidate_id=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, candidateId);

	            int rows = ps.executeUpdate();
	            if (rows > 0)
	                System.out.println("🗳 Vote cast successfully");
	            else
	                System.out.println("❌ Invalid Candidate ID");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }


	    @Override
	    public void viewResults() {
	        try (Connection con = DBConnection.getConnection()) {

	            Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery("SELECT * FROM candidates ORDER BY votes DESC");

	            while (rs.next()) {
	                System.out.println(rs.getString("name") + " - " + rs.getInt("votes"));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
