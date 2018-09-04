package com.bdzjn.udd.ebookrepository.config;

import com.bdzjn.udd.ebookrepository.model.User;
import com.bdzjn.udd.ebookrepository.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
public class RequestInterceptor implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!request.getMethod().equals("OPTIONS")) {
            long id = Long.parseLong(request.getHeader("X-USER"));

            Optional<User> user = userRepository.findById(id);

            user.ifPresent(user1 -> request.setAttribute("USER", user1));

            return user.isPresent();
        }
        return true;
    }
}
