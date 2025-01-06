package ru.netology.SpringBootDemo;

//реализация метода getProfile
public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
