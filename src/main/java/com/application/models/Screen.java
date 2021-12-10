package com.application.models;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/9-17:00
 * @Project: comp3013j_assignment
 * @Package: com.application.models
 * @Description:
 **/
public class Screen {
    private String name; //the name of the screen
    private Integer capacity; // the capacity of the screen

    public Screen(String name, Integer capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public boolean equals(Object o) {
        //Check if two screen object contains the same information
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Screen screen = (Screen) o;

        if (name != null ? !name.equals(screen.name) : screen.name != null) return false;
        return capacity != null ? capacity.equals(screen.capacity) : screen.capacity == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        return result;
    }
}
