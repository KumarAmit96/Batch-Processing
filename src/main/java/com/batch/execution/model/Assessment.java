package com.batch.execution.model;


public class Assessment {

    Long id;
    String assessment;
    Long questionerId;
    String remark;
    String addedBy;

    public Assessment(Long id, String assessment, Long questionerId, String remark, String addedBy) {
        this.id = id;
        this.assessment = assessment;
        this.questionerId = questionerId;
        this.remark = remark;
        this.addedBy = addedBy;
    }

    public Assessment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

    public Long getQuestionerId() {
        return questionerId;
    }

    public void setQuestionerId(Long questionerId) {
        this.questionerId = questionerId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    @Override
    public String toString() {
        return "Assessment{" +
                "id=" + id +
                ", assessment='" + assessment + '\'' +
                ", questionerId=" + questionerId +
                ", remark='" + remark + '\'' +
                ", addedBy='" + addedBy + '\'' +
                '}';
    }
}
