package org.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Objects;

@Entity
public class InsurancePolicy {

    public InsurancePolicy(String name, PolicyStatus policyStatus, Date startingDate, Date endingDate) {
        this.name = name;
        this.policyStatus = policyStatus;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.creationDate = new Date();
        this.updateDate = new Date();
    }

    public InsurancePolicy() {
        this.creationDate = new Date();
        this.updateDate = new Date();
    }

    public InsurancePolicy(
            Integer id,
            String name,
            PolicyStatus policyStatus,
            Date startingDate,
            Date endingDate,
            Date creationDate,
            Date updateDate) {
        this.id = id;
        this.name = name;
        this.policyStatus = policyStatus;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
    }

    public InsurancePolicy(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("policyStatus") PolicyStatus policyStatus,
            @JsonProperty("startingDate") Date startingDate,
            @JsonProperty("endingDate") Date endingDate,
            @JsonProperty("creationDate") Date creationDate) {
        this.id = id;
        this.name = name;
        this.policyStatus = policyStatus;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.creationDate = creationDate;
        this.updateDate = new Date();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    @NotBlank
    @Column()
    private String name;

    @NotNull
    @Column()
    private PolicyStatus policyStatus;

    @NotNull
    @Column()
    private Date startingDate;

    @NotNull
    @Column()
    private Date endingDate;

    @NotNull
    @Column()
    private final Date creationDate;

    @NotNull
    @Column()
    private final Date updateDate;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PolicyStatus getPolicyStatus() {
        return policyStatus;
    }

    public void setPolicyStatus(PolicyStatus policyStatus) {
        this.policyStatus = policyStatus;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof InsurancePolicy that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && policyStatus == that.policyStatus && Objects.equals(startingDate, that.startingDate) && Objects.equals(endingDate, that.endingDate) && Objects.equals(creationDate, that.creationDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, policyStatus, startingDate, endingDate, creationDate, updateDate);
    }
}



