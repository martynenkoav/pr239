/**
 * Created by Анастасия on 05.03.2017.
 */
public class Student extends Man {
    int yearOfStudy;
    void setYearOfStudy(int yearOfStudy){
        this.yearOfStudy=yearOfStudy;
    }
    void IncyearOfStudy(){
        this.yearOfStudy++;
    }
    Student(){
        male=false;
        age=18;
        weight=60;
        name="Ivan";
        yearOfStudy=1;
    }
    Student(String name, int age, boolean male, double weight, int yearOfStudy){
        this.name=name;
        this.age=age;
        this.male=male;
        this.weight=weight;
        this.yearOfStudy=yearOfStudy;
    }
    @Override
    public String toString() {
        return name + ':' +
                age +
                "/" + (male?"female":"male") +
                " (" + weight +
                ')' + yearOfStudy;
    }
    Student myClone(){
        return new Student(name,age,male,weight,yearOfStudy);
    }
}
