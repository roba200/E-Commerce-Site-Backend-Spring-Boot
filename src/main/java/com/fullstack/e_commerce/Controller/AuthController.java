package com.fullstack.e_commerce.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.fullstack.e_commerce.Entity.User;
import com.fullstack.e_commerce.JwtUtil.JwtUtil;
import com.fullstack.e_commerce.Repository.UserRepository;
import com.fullstack.e_commerce.Service.UserService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthController {

    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPasswordHash(), user.getRole());
        return ResponseEntity.ok(newUser);
    }
   
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User dbUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (passwordEncoder.matches(user.getPasswordHash(), dbUser.getPasswordHash())) {
            String token = jwtUtil.generateToken(dbUser.getEmail());
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(@RequestParam Long userId, @RequestBody User userDetails) {
        User updatedUser = userService.updateProfile(userId, userDetails.getFirstName(), userDetails.getLastName());
        return ResponseEntity.ok(updatedUser);
    }
}
