package it.bitsrl.megan.dtos;

public class PasswordDTO {

    private String accessKey;

    public PasswordDTO(){}

    public PasswordDTO(String accessKey){
        this.accessKey = accessKey;
    }

    public String getAccessKey(){
        return this.accessKey;
    }
}
