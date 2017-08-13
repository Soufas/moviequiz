package com.geekbunny.moviequiz;

/**
 * Created by seif on 16/07/2017.
 */

public class Config {
    //URL to our login.php file
    public static final String LOGIN_URL = "http://bunnyandcat/login_quiz.php";
    public static String USER_ID = "";
    public static String USER_NAME = "";
    public static String RESULTS="NULL";
    public static int id_room;
    public static int user_place;
    public static String mQuestions[] = new String[5];
    public static String mChoices[][]=new String[5][4];
    public static String mCorrect[]=new String[5];
    public static String mChoice1[]=new String[5];
    public static String mChoice2[]=new String[5];

    //Keys for email and password as defined in our $_POST['key'] in login.php
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";


    //If server response is equal to this that means login is successful
    public static final String LOGIN_SUCCESS = "success";

    //Keys for Sharedpreferences
    //This would be the name of our shared preferences
    public static final String SHARED_PREF_NAME = "moviequiz";

    //This would be used to store the email of current logged in user
    public static final String EMAIL_SHARED_PREF = "email";

    //We will use this to store the boolean in sharedpreference to track user is loggedin or not
    public static final String LOGGEDIN_SHARED_PREF = "loggedin";
}
