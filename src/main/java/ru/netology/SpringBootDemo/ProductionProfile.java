package ru.netology.SpringBootDemo;

//реализация метода getProfile
public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
