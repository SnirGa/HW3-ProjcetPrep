package Domain.ManagementSystem;

import java.util.ArrayList;

public class UserComplaint {
    int complaintId;
    String description;
    ArrayList<String> replies;
    ArrayList<SystemManager> systemManagers;
    ArrayList<Fan> fans;

    public UserComplaint(int complaintId, String description) {
        this.complaintId = complaintId;
        this.description = description;
        this.replies = new ArrayList<>();
        this.systemManagers = new ArrayList<>();
        this.fans = new ArrayList<>();
    }

    public void addReply(String reply){
        this.replies.add(reply);
    }
    public int getComplaintId() {
        return complaintId;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getReply() {
        return replies;
    }

    public ArrayList<SystemManager> getSystemManagers() {
        return systemManagers;
    }

    public ArrayList<Fan> getFans() {
        return fans;
    }

    public void setComplaintId(int complaintId) {
        this.complaintId = complaintId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReply(ArrayList<String> reply) {
        this.replies = reply;
    }

    public void setSystemManagers(ArrayList<SystemManager> systemManagers) {
        this.systemManagers = systemManagers;
    }

    public void setFans(ArrayList<Fan> fans) {
        this.fans = fans;
    }
}
