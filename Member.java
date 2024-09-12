import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

class Member {
    private String fullName;
    private String email;
    private String phoneNumber;
    private int age;
    private List<Subscription> subscriptions; 

    // constructor
    public Member(String fullName, String email, String phoneNumber, int age) {
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.subscriptions = new ArrayList<>();
    }


    //getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Subscription> getSubscriptions() {
        return subscriptions;
    }

    //
    public boolean isEqual(Member otherMember){
        if(this.fullName.equals(otherMember.getFullName())&&this.phoneNumber.equals(otherMember.getPhoneNumber())){
            return true;
        }
        return false;
    }

    //add a new subscription 
    public void addSubscription(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    public boolean validDepartmentSubscription(String department){
        for(Subscription subscription : subscriptions){
            if(subscription.getDepartment().getName().equals(department) &&subscription.hasRemainingVisits()){
                return true;
            }

        }
        return false;
    }

    public void subscriptionChange(String department,boolean increase){
        for(Subscription subscription : subscriptions){
            if(subscription.getDepartment().getName().equals(department) &&subscription.hasRemainingVisits()){
                if(increase){
                    subscription.removeVisit();
                }else{
                    subscription.useVisit();
                } 
            }
        }
    }

    public boolean selectSchedule(Department department,Schedule schedule){
        return department.addMember(this, schedule);
    }

    public boolean changeSchedule(Department department,Schedule pastSchedule,Schedule newSchedule){
        
        if(department.hasThisSchedule(pastSchedule)&& department.hasThisSchedule(newSchedule)&& department.isAvailable(newSchedule)&&department.hasThisMember(this, pastSchedule)){
            department.removeMember(this, pastSchedule);
            department.addMember(this, newSchedule);
            return true;
        }
        return false;
    }
}
