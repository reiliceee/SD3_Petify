package com.arise.petify.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.cloud.StorageClient;
   
@RestController
@RequestMapping("/api")
public class AdminDataController {

    @GetMapping("/pets")
    public ResponseEntity<List<Map<String, Object>>> getPets() throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        List<QueryDocumentSnapshot> docs = db.collection("pets").get().get().getDocuments();
        List<Map<String, Object>> pets = docs.stream().map(QueryDocumentSnapshot::getData).toList();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Map<String, Object>>> getProducts() throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        List<QueryDocumentSnapshot> docs = db.collection("products").get().get().getDocuments();

        List<Map<String, Object>> products = docs.stream().map(doc -> {
            Map<String, Object> data = new HashMap<>(doc.getData());
            data.put("id", doc.getId());  // include Firestore document ID
            return data;
        }).toList();

        return ResponseEntity.ok(products);
}


    @GetMapping("/appointments")
    public ResponseEntity<List<Map<String, Object>>> getAppointments() throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        List<QueryDocumentSnapshot> docs = db.collection("appointments").get().get().getDocuments();
        List<Map<String, Object>> appts = docs.stream().map(QueryDocumentSnapshot::getData).toList();
        return ResponseEntity.ok(appts);
    }

    @PostMapping("/calendar-status")
    public ResponseEntity<String> setCalendarStatus(@RequestBody Map<String, String> body) throws Exception {
        String date = body.get("date");
        String status = body.get("status");

        Firestore db = FirestoreClient.getFirestore();
        db.collection("calendarStatus").document(date).set(Map.of("status", status));
        return ResponseEntity.ok("Status set");
    }

    @GetMapping("/calendar-status")
    public ResponseEntity<Map<String, String>> getCalendarStatuses() throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        List<QueryDocumentSnapshot> docs = db.collection("calendarStatus").get().get().getDocuments();
        Map<String, String> statuses = new HashMap<>();
        for (var doc : docs) {
            statuses.put(doc.getId(), doc.getString("status"));
        }
        return ResponseEntity.ok(statuses);
    }

    @PostMapping("/pets")
    public ResponseEntity<String> addPet(@RequestBody Map<String, Object> petData) throws Exception {
        Firestore db = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = db.collection("pets").get();
        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        int newId = documents.size() + 1;

        Map<String, Object> formattedPet = Map.of(
            "petName", petData.get("name"),
            "petType", petData.get("type"),
            "petBreed", petData.get("breed"),
            "petGender", petData.get("gender"),
            "petAge", petData.get("age"),
            "petImage", petData.get("petImage"), // ✅ key here must match frontend
            "petPrice", petData.get("price"),
            "petDescription", petData.get("description")
        );

        db.collection("pets").document(String.valueOf(newId)).set(formattedPet);
        return ResponseEntity.ok("Pet added successfully");
    }

    @PostMapping("/products")
        public ResponseEntity<String> addProduct(@RequestBody Map<String, Object> productData) throws Exception {
            Firestore db = FirestoreClient.getFirestore();

            ApiFuture<QuerySnapshot> future = db.collection("products").get();
            List<QueryDocumentSnapshot> documents = future.get().getDocuments();
            int newId = documents.size() + 1;

            Map<String, Object> formattedProduct = Map.of(
                "productName", productData.get("productName"),
                "productType", productData.get("productType"),
                "productQuantity", productData.get("productQuantity"),
                "productPrice", productData.get("productPrice"),
                "productImage", productData.get("productImage")
            );

            db.collection("products").document(String.valueOf(newId)).set(formattedProduct);
            return ResponseEntity.ok("Product added successfully");
        }

    // DELETE product
    @DeleteMapping("/products/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable String id) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("products").document(id).delete();
        return ResponseEntity.ok("Product deleted successfully");
    }

    // PUT (Update) product
    @PutMapping("/products/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id, @RequestBody Map<String, Object> productData) throws Exception {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("products").document(id).set(productData);  // overwrites the document
        return ResponseEntity.ok("Product updated successfully");
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<String> deletePet(@PathVariable String id) {
        Firestore db = FirestoreClient.getFirestore();
        db.collection("pets").document(id).delete();
        return ResponseEntity.ok("Pet deleted");
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<String> updatePet(@PathVariable String id, @RequestBody Map<String, Object> petData) throws Exception{
        Firestore db = FirestoreClient.getFirestore();
        db.collection("pets").document(id).set(petData);  // overwrites the document
        return ResponseEntity.ok("Pet updated successfully");
}

}
