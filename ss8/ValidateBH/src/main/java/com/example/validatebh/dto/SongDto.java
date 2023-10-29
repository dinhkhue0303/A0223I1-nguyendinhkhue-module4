package com.example.validatebh.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotNull;

public class SongDto implements Validator {
    private Integer id;
    private String name;
    private String artist;
    private String type;

    public SongDto() {
    }

    public SongDto(Integer id, String name, String artist, String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto)target;
        if("".equals(songDto.getName())){
            errors.rejectValue("name",null,"require input data");
        }else if(songDto.getName().length() > 800){
            errors.rejectValue("name",null,"require input less than or equal to 800 characters");
        }else if(!songDto.getName().matches("^[a-zA-Z0-9]*$")){
            errors.rejectValue("name",null,"not containing special character");
        }
        if("".equals(songDto.getArtist())){
            errors.rejectValue("artist",null,"require input data");
        }else if(songDto.getArtist().length() > 300){
            errors.rejectValue("artist",null,"require input less than or equal to 300 characters");
        }else if(!songDto.getArtist().matches("^[a-zA-Z0-9]*$")){
            errors.rejectValue("artist",null,"not containing special character");
        }
        if("".equals(songDto.getType())){
            errors.rejectValue("type",null,"require input data");
        }else if(songDto.getType().length() > 1000){
            errors.rejectValue("type",null,"require input less than or equal to 1000 characters");
        }else if(!songDto.getType().matches("^[a-zA-Z0-9,]*$")){
            errors.rejectValue("type",null,"not containing special character expect ','");
        }
    }
}
