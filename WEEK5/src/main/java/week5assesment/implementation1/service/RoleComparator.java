package week5assesment.implementation1.service;

import week5assesment.implementation1.model.Person;

import java.util.Comparator;

public class RoleComparator implements Comparator {

    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p2.getRole().ordinal(),p1.getRole().ordinal());
    }

}
