package ru.geekbrains.javaCoreBase.homeWork.lesson6;

public class Animal {
    protected String className;
    protected String name;
    protected double limitRun;
    protected double limitSwim;
    protected double limitJump;

    public Animal(String name, String className, double limitRun, double limitSwim, double limitJump) {
        this.name = name;
        this.className = className;
        this.limitRun = limitRun;
        this.limitSwim = limitSwim;
        this.limitJump = limitJump;
    }

    public double getLimitRun() {
        return limitRun;
    }

    public double getLimitSwim() {
        return limitSwim;
    }

    public double getLimitJump() {
        return limitJump;
    }

    public void setLimitRun(double limitRun) {
        if (limitRun >= 0)
            this.limitRun = limitRun;
    }

    public void setLimitSwim(double limitSwim) {
        if (limitSwim >= 0)
            this.limitSwim = limitSwim;
    }

    public void setLimitJump(double limitJump) {
        if (limitJump >= 0)
            this.limitJump = limitJump;
    }

    public boolean run(double distance){
        if (distance <= limitRun){
            System.out.println(className + " '" + name + "' пробежал " + distance + "м.");
            return true;
        } else {
            System.out.println(className + " '" + name + "' не пробежал " + distance + "м.");
            return false;
        }
    }

    public boolean swim(double distance){
        if (distance <= limitSwim){
            System.out.println(className + " '" + name + "' проплыл " + distance + "м.");
            return true;
        } else {
            System.out.println(className + " '" + name + "' не проплыл " + distance + "м.");
            return false;
        }
    }

    public boolean jump(double high){
        if (high <= limitJump){
            System.out.println(className + " '" + name + "' прыгнул на высоту " + high + "м.");
            return true;
        } else {
            System.out.println(className + " '" + name + "' не допрыгнул на высоту " + high + "м.");
            return false;
        }
    }

    @Override
    public String toString() {
        return className + " '" + name + "' бег " + limitRun +"м. плавание " + limitSwim + "м., прыжки " + limitJump + "м.";
    }


}
