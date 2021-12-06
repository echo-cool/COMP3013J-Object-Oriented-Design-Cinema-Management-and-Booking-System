package com.application.models;


/**
* @generated
*/
public class Movie {
    
    /**
    * @generated
    */
    private Integer id;
    
    /**
    * @generated
    */
    private String name;
    
    /**
    * @generated
    */
    private Integer duration;


    public Movie(String name,int duration){
        this.duration=duration;
        this.name=name;
    }
    
    
    /**
    * @generated
    */
    public Integer getId() {
        return this.id;
    }
    
    /**
    * @generated
    */
    public void setId(Integer id) {
        this.id = id;
    }
    
    /**
    * @generated
    */
    public String getName() {
        return this.name;
    }
    
    /**
    * @generated
    */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
    * @generated
    */
    public Integer getDuration() {
        return this.duration;
    }
    
    /**
    * @generated
    */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    

    //                          Operations                                  
    

    
}
