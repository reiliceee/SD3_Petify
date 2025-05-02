package com.arise.petify.service;

import com.arise.petify.model.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.auth.UserRecord.CreateRequest;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

@Service
public class FirebaseUserService {

    public String saveUser(User user) {
        Firestore db = FirestoreClient.getFirestore();

        // Create Firebase Auth user
        CreateRequest request = new CreateRequest()
            .setEmail(user.getEmail())
            .setPassword(user.getPassword());

        try {
            UserRecord userRecord = FirebaseAuth.getInstance().createUser(request);
            System.out.println("✅ Successfully created user in Auth: " + userRecord.getUid());
            
            if ("admin@gmail.com".equalsIgnoreCase(user.getEmail())) {
                return "Cannot register as admin.";
            }
            
            // Save user data to Firestore
            ApiFuture<WriteResult> future = db.collection("users")
                    .document(user.getEmail())
                    .set(user);

            return "User saved at: " + future.get().getUpdateTime();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving user: " + e.getMessage();
        }
        
    }
}