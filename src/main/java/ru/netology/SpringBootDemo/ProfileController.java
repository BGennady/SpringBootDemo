package ru.netology.SpringBootDemo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//клас обработчик (контролер)
@RestController
@ConfigurationProperties("profile")
//самостоятельная строка, которая указывает,
// что базовый путь для всех методов в этом контроллере начинается с корня (/)
@RequestMapping("/")
public class ProfileController {
    private SystemProfile profile;

    public ProfileController(SystemProfile profile) {
        this.profile = profile;
    }

    @GetMapping("profile")
    public String getProfile() {
        return profile.getProfile();
    }
}
