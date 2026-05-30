package edu.freelance.booking.Services;

import jakarta.servlet.http.HttpSession;

public class AuthService {
    public static boolean IsAuth(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if (username != null) {
            return true;
        }
        return false;
    }
}
