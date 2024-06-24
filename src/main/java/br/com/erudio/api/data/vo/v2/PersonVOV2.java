package br.com.erudio.api.data.vo.v2;



import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonVOV2 implements Serializable {

    private static final long SerialVersionUID = 1L;


    private long id;
    private String firstName;
    private String lastName;
    private String adress;
    private String gender;
    private Date birthDay;

    public PersonVOV2(){
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }



    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVOV2 that = (PersonVOV2) o;
        return id == that.id && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(adress, that.adress) && Objects.equals(gender, that.gender) && Objects.equals(birthDay, that.birthDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, adress, gender, birthDay);
    }
}
