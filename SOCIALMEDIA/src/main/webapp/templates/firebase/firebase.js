import { initializeApp } from "https://www.gstatic.com/firebasejs/10.5.2/firebase-app.js";
import {
  getAuth,
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  onAuthStateChanged,
} from "https://www.gstatic.com/firebasejs/10.5.2/firebase-auth.js";

import {
  getStorage,
  ref,
  uploadBytes,
  getDownloadURL,
  uploadBytesResumable,
} from "https://www.gstatic.com/firebasejs/10.5.2/firebase-storage.js";

import {
  getDatabase,
  set,
  onValue,
  push,
  get,
  child,
} from "https://www.gstatic.com/firebasejs/10.5.2/firebase-database.js";
// Your web app's Firebase configuration
const firebaseConfig = {
  apiKey: "AIzaSyAjQ-EW74NHNWM18cww2D5A28ED3_AaKyo",
  authDomain: "strange-song-394808.firebaseapp.com",
  projectId: "strange-song-394808",
  storageBucket: "strange-song-394808.appspot.com",
  messagingSenderId: "1023545526596",
  appId: "1:1023545526596:web:fac90eccaeaa4bdfb16f11",
};

// Initialize Firebase
const app = initializeApp(firebaseConfig);
// Initialize Firebase Authentication and get a reference to the service
const auth = getAuth(app);
// khởi tạo storage firebase
const storage = getStorage(app);
// khởi tạo realtime-database
const db = getDatabase(app);
export {
  app,
  auth,
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  onAuthStateChanged,
  storage,
  ref,
  uploadBytes,
  getDownloadURL,
  uploadBytesResumable,
  db,
  getAuth 
};
