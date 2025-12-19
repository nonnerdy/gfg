package org.biswajit.javaeight;

import java.util.List;
import java.util.Objects;

public class ImmutableEmployee {
    private final String name;
    private final int age;
    private final List<String> skills;
    private final Address address;

    public ImmutableEmployee(String name,int age,List<String> skills,Address address){
        this.name = name;
        this.age = age;
        this.skills = List.copyOf(skills);
        this.address = new Address(address);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "ImmutableEmployee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof ImmutableEmployee that)) return false;
        return age == that.age
                && Objects.equals(name,this.name)
                && Objects.equals(skills,that.skills)
                && Objects.equals(address.getCity(),that.address.getCity())
                && Objects.equals(address.getStreet(),that.address.getStreet());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, skills, address);
    }
}
