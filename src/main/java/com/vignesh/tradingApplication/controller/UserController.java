package com.vignesh.tradingApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.vignesh.tradingApplication.model.UserTable;
import com.vignesh.tradingApplication.service.UserNotFoundException;
import com.vignesh.tradingApplication.service.UserService;

import io.micrometer.core.ipc.http.HttpSender.Request;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("/home")
    public ModelAndView index1() {
		return new ModelAndView("index");
    	
    }
    @RequestMapping("/reg")
    public ModelAndView register() {
		return new ModelAndView("UserRegister");
    	
    }
    @RequestMapping("/log")
    public ModelAndView login() {
		return new ModelAndView("Login");
    	
    }
    @RequestMapping("/valid")
    public ModelAndView verify(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
    	//System.out.println(username+" " +email+" "+ password);
    String service=userService.verify(username, email, password);
    
    
    if(service!=null) {
    	
    	ModelAndView mav=new ModelAndView("Trading");
    	mav.addObject(service);
    	return mav;
    }else {
    	ModelAndView mav=new ModelAndView("Login");
    	//mav.addObject(service);
    	return mav;
    	
    }
    }

    //@GetMapping("/userlist")
    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
//    public ResponseEntity<List<UserTable>> getAllUsers() {
//        List<UserTable> users = userService.getAllUsers();
//        return new ResponseEntity<>(users, HttpStatus.OK);
//    }
    public ModelAndView getAllUsers() {
    	Iterable<UserTable> list = userService.getAllUsers();
   	ModelAndView mav=new ModelAndView("userlist");
    	//mav.addObject("Alllist",userService.getAllUsers());
    	//model.addAttribute("list",list);
   	      mav.addObject("list", list);
    	
    	return mav;
    	
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTable> getUserById(@PathVariable("id") Integer id) {
        Optional<UserTable> user = userService.getUserById(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

   // @PostMapping("/add")
    @RequestMapping("/add")
   // public ResponseEntity<UserTable> createUser(@RequestBody UserTable user) {
//    	UserTable createdUser = userService.createUser(user);
//        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//    }
    public ModelAndView createUser(@ModelAttribute UserTable user) {
    	ModelAndView mav=new ModelAndView("Login");
    	mav.addObject(userService.createUser(user));
    	return mav;
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserTable> updateUser(@PathVariable("id") Integer id, @RequestBody UserTable userDetails) throws UserNotFoundException {
    	UserTable updatedUser = userService.updateUser(id, userDetails);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
