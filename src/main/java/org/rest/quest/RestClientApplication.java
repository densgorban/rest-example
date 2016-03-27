package org.rest.quest;

import org.rest.quest.domain.Puzzle;
import org.rest.quest.domain.init.wrapper.MottoWrapper;
import org.rest.quest.wall.*;
import org.springframework.http.HttpEntity;

import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class RestClientApplication {

    private static final Logger logger = Logger.getLogger(RestClientApplication.class.getSimpleName());

    public static void main(String[] args) throws UnknownHostException {
        MottoHelper.TEAM_ID = 9;
        MottoHelper.HOST_URL = "http://192.168.88.64:8080/";

        if (System.getProperty("url") != null) {
            MottoHelper.HOST_URL = System.getProperty("url");
            System.out.println("url received: " + System.getProperty("url"));
        }

//        registrationHelper
//        RegistrationHelper registrationHelper = new RegistrationHelper();
//        registrationHelper.registerTeam(HOST_URL, "Apple", "Forever young");

        //1st wall
        /*List<MottoWrapper> mottoList = new ArrayList<>();
        IntStream.range(0, 220).forEach(i -> {
            MottoWrapper motto = MottoHelper.getKeyword( null, i);
            mottoList.add(motto);
            System.out.println(motto);
        });
*//*Sort*//*
        Collections.sort(mottoList,
                (o1, o2) -> MottoHelper.compareKeyword(null, o1, o2));
*/
//        MottoWrapper keyMotto = mottoList.get(0); /*Protect, serve, progress*/

        String key = "Protect, serve, progress";
        /*todo: do it in binary search*/
        int i1=0;
        int i2=0;
        List<Integer> dirr =  new ArrayList<>();
        IntStream.rangeClosed(0, 2080).forEach(i -> {
            HttpEntity<Puzzle> pazzle = MottoHelper.getPazzle(key, i);
            if (pazzle.getHeaders().get("direction-one-to-go").equals("0")) {
                dirr.add(i);
            }
            if (pazzle.getHeaders().get("direction-two-to-go").equals("0")) {
                dirr.add(i);
            }
            if(dirr.size() == 2)
                return;
        });

        int id = (dirr.get(1) + dirr.get(0))/2;
        HttpEntity<Puzzle> keyPuzzle = MottoHelper.getPazzle(key, id);
        String puzzleString = keyPuzzle.getBody().getPuzzle();
        String solutionString = keyPuzzle.getBody().getSolution();

//        String keyword = mottoHelper.getKeyword(HOST_URL, null, TEAM_ID, 0/*, 221*//*);
        //2st wall
        /*int secondPuzzle = new PuzzleHelper().readPuzzleHeader(HOST_URL, keyword, TEAM_ID,  0, "");
        keyword = PuzzleService.getPuzzle(4);
        //3rd wall
        new UserResolver().readUser(HOST_URL, "keyword", 0);
        //4st wall
        WinnerResolver.sendWinnerUrl(HOST_URL, keyword, TEAM_ID);
        logger.info("we are winners");*/
    }

}
