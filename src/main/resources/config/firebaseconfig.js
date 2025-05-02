// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyAayKcszCq4csfOy32X10a-5Enih4EAdpE",
  authDomain: "sd3petify.firebaseapp.com",
  databaseURL: "https://sd3petify-default-rtdb.asia-southeast1.firebasedatabase.app",
  projectId: "sd3petify",
  storageBucket: "sd3petify.firebasestorage.app",
  messagingSenderId: "941548674417",
  appId: "1:941548674417:web:31161ef8b9332d39a8aad0",
  measurementId: "G-C2XCM6Z35Y"
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
// Export for use in other scripts
export { database, ref, set };
  