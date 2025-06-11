///*
// * 
// * __________________  DwellSMART CONFIDENTIAL __________________
// * 
// * (C) DwellSMART Pvt. Ltd. [2015] - All Rights Reserved.
// * 
// * NOTICE: All information contained herein is, and remains the property of DwellSMART Pvt. Ltd. 
// * and its partners, if any. The intellectual and technical concepts contained herein are 
// * proprietary to DwellSMART Pvt. Ltd. and its suppliers and may be covered by Patents,
// * patents in process, and are protected by trade secret or copyright law. 
// * Dissemination of this information or reproduction of this material is strictly forbidden 
// * unless prior written permission is obtained from DwellSMART Pvt. Ltd.
// * October 2015
// */
//package com.dwellsmart.commonUtils;
//
//    import com.google.auth.oauth2.GoogleCredentials ;
//    import com.google.auth.http.HttpCredentialsAdapter ;
//    import com.google.api.client.http.
//    *;
//    import com.google.api.client.http.javanet.NetHttpTransport ;
//    import com.google.api.client.json.JsonFactory ;
//    import com.google.api.client.json.gson.GsonFactory ;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//import java.util.function.BiPredicate;
//import java.util.function.Consumer;
//import java.util.function.Function;
//import java.util.function.Predicate;
//
///**
// *
// * @author aryap
// */
//class Student {
//
//    String name;
//    int marks;
//
//    public Student(String name, int marks) {
//        this.name = name;
//        this.marks = marks;
//    }
//
////    @Override
////    public String toString() {
////        return "Student{" + "name=" + name + ", marks=" + marks + '}';
////    }
//}
//
////class Support implements Function<Student, Student> {
////
////    @Override
////    public Student apply(Student t) {
////
////        return new Student(t.name, t.marks);
////    }
////    
////    
////
////}
//public class Main {
//
//    public static void main(String[] args) {
//        List<Student> st = new ArrayList<>();
//        st.add(new Student("Arya", 89));
//        st.add(new Student("Vanshika", 90));
//        st.add(new Student("Anshul", 73));
//        st.add(new Student("Manish", 88));
//        st.add(new Student("Alok", 92));
//        st.add(new Student("Nikhil", 42));
//
//        List<Integer> l = new ArrayList<>();
//        l.add(2);
//        l.add(3);
//        l.add(1);
//        l.add(9);
//        l.add(5);
//        Predicate<Student> p1 = s -> s.marks % 2 == 0;
//        Predicate<Student> p2 = s -> s.marks >= 90;
//        Consumer<Student> con = s -> System.out.println("Student name: " + s.name + " and marks: " + s.marks);
//        List<Student> top_Graded_Student = new ArrayList<>();
//        Comparator<Integer> c = (i1, i2) -> i1 < i2 ? -1 : (i1 > i2) ? +1 : 0;
//        Collections.sort(l, (i1, i2) -> i1 < i2 ? -1 : (i1 > i2) ? +1 : 0);
//        Function<Student, Student> f1 = (s) -> {
//            System.out.println(s.name);
//            return new Student(s.name, s.marks);
//        };
//        Function<Student, Student> f2 = (s) -> {
//            System.out.print("Adding Student ");
//            return s;
//        };
////        BiPredicate
//        for (Student s : st) {
//
//            if (p1.and(p2).test(s)) {
//                top_Graded_Student.add(f2.andThen(f1).apply(s));
//                con.accept(s);
//            }
//        }
////      top_Graded_Student.forEach(s->System.out.println(s.toString()));
//    }
//
//
//
//    public class FCMHttpV1Sender {
//
//        private static final String FCM_ENDPOINT = "https://fcm.googleapis.com/v1/projects/waveplus-b18e8/messages:send";
//        private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
//        private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//
//        public void sendMessage(String serviceAccountJsonPath, String messageJsonBody) throws Exception {
//
//            GoogleCredentials credentials = GoogleCredentials
//                    .fromStream(new FileInputStream(serviceAccountJsonPath))
//                    .createScoped(List.of("https://www.googleapis.com/auth/firebase.messaging"));
//
//            credentials.refreshIfExpired();
//
//            HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpCredentialsAdapter(credentials));
//            GenericUrl url = new GenericUrl(FCM_ENDPOINT);
//
//            HttpContent content = new ByteArrayContent("application/json", messageJsonBody.getBytes(StandardCharsets.UTF_8));
//            HttpRequest request = requestFactory.buildPostRequest(url, content);
//            HttpResponse response = request.execute();
//
//            System.out.println("Response: " + response.parseAsString());
//        }
//    }
//
//    import com.google.auth.oauth2.GoogleCredentials;
//import com.google.auth.http.HttpCredentialsAdapter;
//import com.google.api.client.http.*;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.gson.GsonFactory;
//
//import java.io.FileInputStream;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
//public class PushNotificationSender {
//
//    private static final String PROJECT_ID = "waveplus-b18e8"; // 🔁 Your Firebase project ID
//    private static final String FCM_ENDPOINT = "https://fcm.googleapis.com/v1/projects/" + PROJECT_ID + "/messages:send";
//    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
//    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//
//    public static void sendPushNotificationToAndroid(List<String> deviceIds, String title, String body) {
//        String serviceAccountPath = CommonUtils.getDwellSmartProperty("pn_service_account_path"); // 🔁 Add this in config
//        try {
//            GoogleCredentials credentials = GoogleCredentials
//                    .fromStream(new FileInputStream(serviceAccountPath))
//                    .createScoped(List.of("https://www.googleapis.com/auth/firebase.messaging"));
//            credentials.refreshIfExpired();
//
//            HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(new HttpCredentialsAdapter(credentials));
//
//            for (String token : deviceIds) {
//                String messageJson = buildMessageJson(token, title, body);
//                HttpRequest request = requestFactory.buildPostRequest(
//                        new GenericUrl(FCM_ENDPOINT),
//                        new ByteArrayContent("application/json", messageJson.getBytes(StandardCharsets.UTF_8))
//                );
//                HttpResponse response = request.execute();
//                System.out.println("Response: " + response.parseAsString());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static String buildMessageJson(String token, String title, String body) {
//        return "{\n" +
//                "  \"message\": {\n" +
//                "    \"token\": \"" + token + "\",\n" +
//                "    \"notification\": {\n" +
//                "      \"title\": \"" + title + "\",\n" +
//                "      \"body\": \"" + body + "\"\n" +
//                "    }\n" +
//                "  }\n" +
//                "}";
//    }
//}
//
//}
