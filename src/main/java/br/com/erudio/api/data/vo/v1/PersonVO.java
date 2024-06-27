package br.com.erudio.api.data.vo.v1;



import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id","firstname","lastname","adress","gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

    private static final long SerialVersionUID = 1L;

    @JsonProperty("id")
    @Mapping("id")
    private long key;
    private String firstName;
    private String lastName;
    private String adress;
    private String gender;

    public PersonVO(){
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

    public long getKey() {
        return key;
    }
    public void setKey(long key) {
        this.key = key;
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
        PersonVO personVO = (PersonVO) o;
        return key == personVO.key && Objects.equals(firstName, personVO.firstName)
                && Objects.equals(lastName, personVO.lastName)
                && Objects.equals(adress, personVO.adress)
                && Objects.equals(gender, personVO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, firstName, lastName, adress, gender);
    }
}
