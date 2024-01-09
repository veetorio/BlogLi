package com.example.liblog.dto.so;


import lombok.Data;

@Data
public class SoUser {
    private String dataSearchName;
    private String dataSearchPassword;

    public String getDataSearchName() {
        return dataSearchName;
    }

    public void setDataSearchName(String dataSearchName) {
        this.dataSearchName = dataSearchName;
    }

    public String getDataSearchPassword() {
        return dataSearchPassword;
    }

    public void setDataSearchPassword(String dataSearchPassword) {
        this.dataSearchPassword = dataSearchPassword;
    }
}
