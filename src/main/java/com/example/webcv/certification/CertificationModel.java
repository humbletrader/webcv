package com.example.webcv.certification;

public class CertificationModel {

    private final Integer certificationId;
    private final String certificationName;

    public CertificationModel(Certification source){
        this.certificationId = source.getId();
        this.certificationName = source.getCertificationName();
    }

    public CertificationModel(Integer id, String name) {
        this.certificationId = id;
        this.certificationName = name;
    }

    public Integer getCertificationId() {
        return certificationId;
    }

    public String getCertificationName() {
        return certificationName;
    }
}
