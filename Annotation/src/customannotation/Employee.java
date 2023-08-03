package customannotation;

@ClassPreamble(
        author = "Nguyen Quang Phu",
        date = "03/08/2023",
        currentRevision = 1,
        lastModify = "03/08/2023",
        lastModifyBy = "Phu Nguyen",
        reviwer = {"Nguyen Quang Phu, Phu Nguyen"}
)
@JsonSerializable
public class Employee {
    @JsonElement
    private String id;
    @JsonElement
    private String firstName;
    @JsonElement
    private String lastName;
    @JsonElement
    private String email;
    @JsonElement
    private String address;
    @JsonElement
    private float salary;

    public Employee() {

    }

    public Employee(String id, String firstName, String lastName,
                    String email, String address, float salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.salary = salary;
    }

    @Init
    private void initNames() {
        this.firstName = this.firstName.substring(0,1).toUpperCase() +
                this.firstName.substring(1);
        this.lastName = this.lastName.substring(0,1).toUpperCase() +
                this.lastName.substring(1);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}

