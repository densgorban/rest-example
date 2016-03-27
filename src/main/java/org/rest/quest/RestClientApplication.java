package org.rest.quest;

import org.rest.quest.domain.init.wrapper.MottoWrapper;
import org.rest.quest.service.PuzzleService;
import org.rest.quest.wall.*;

import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class RestClientApplication {

    private static final Logger logger = Logger.getLogger(RestClientApplication.class.getSimpleName());
    private static String HOST_URL = "http://192.168.88.64:8080/";
    private static int teamId = 9;
    ;

    public static void main(String[] args) throws UnknownHostException {

        if (System.getProperty("url") != null) {
            HOST_URL = System.getProperty("url");
            System.out.println("url received: " + System.getProperty("url"));
        }

//        registrationHelper
//        RegistrationHelper registrationHelper = new RegistrationHelper();
//        registrationHelper.registerTeam(HOST_URL, "Apple", "Forever young");

        //1st wall
        MottoHelper mottoHelper = new MottoHelper();
        List<MottoWrapper> mottoList = new ArrayList<MottoWrapper>();
        IntStream.range(0, 220).forEach(i -> {
            MottoWrapper motto = mottoHelper.getKeyword(HOST_URL, null, teamId, i);
            mottoList.add(motto);
            System.out.println(motto);
        });
/*Sort*/
        Collections.sort(mottoList,
                (o1, o2) -> MottoHelper.compareKeyword(HOST_URL, null, teamId, o1, o2));

        System.out.println(mottoList.get(0));

//        String keyword = mottoHelper.getKeyword(HOST_URL, null, teamId, 0/*, 221*//*);
        //2st wall
        /*int secondPuzzle = new PuzzleHelper().readPuzzleHeader(HOST_URL, keyword, teamId,  0, "");
        keyword = PuzzleService.getPuzzle(4);
        //3rd wall
        new UserResolver().readUser(HOST_URL, "keyword", 0);
        //4st wall
        WinnerResolver.sendWinnerUrl(HOST_URL, keyword, teamId);
        logger.info("we are winners");*/
    }

}
