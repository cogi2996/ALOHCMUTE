import { initializeApp } from "https://www.gstatic.com/firebasejs/10.4.0/firebase-app.js";
import {
	getAuth,
	createUserWithEmailAndPassword,
	signInWithEmailAndPassword,
	onAuthStateChanged,
} from "https://www.gstatic.com/firebasejs/10.4.0/firebase-auth.js";

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

const emailInput = document.getElementById("email");
const passwordInput = document.getElementById("password");
const loginButton = document.getElementById("login-button");
const messageDiv = document.getElementById("message");

onAuthStateChanged(auth, (user) => {
	if (user) {
		// User is signed in, see docs for a list of available properties
		// https://firebase.google.com/docs/reference/js/auth.user
		const uid = user.uid;
		console.log("uid current user: " + uid);
		// ...
	} else {
		// User is signed out
		console.log("No one here");
		// ...
	}
});
loginButton.addEventListener("click", () => {
	const email = emailInput.value;
	const password = passwordInput.value;
	
	signInWithEmailAndPassword(auth, email, password)
		.then((userCredential) => {
			const user = userCredential.user;
			
			const loginData = {
				// đã đăng nhập firebase thành công thì chỉ cần tạo phiên ở server
				uid: user.uid,
			};
			messageDiv.textContent = "Đăng nhập thành công!";
			fetch("http://localhost:8080/POST/xulidangnhap", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(loginData),
			})
			.then(
			()=>{
				window.location.href = "http://localhost:8080/POST/dangnhapthanhcong";
			}
		)
			/*window.location.href = "http://localhost:8080/POST/home.jsp";
			window.location.method = "POST";*/
		})
		
		.then(
			() => {
				const user = auth.currentUser;
				if (user) {

					console.log(user.email);
				}
				else {
					console.log("No one log in");
				}
			}
		)
		.then(
			
		)
		.catch((error) => {

			const errorMessage = error.message;
			console.error("Lỗi đăng nhập:", errorMessage);
			messageDiv.textContent = "Lỗi đăng nhập: " + errorMessage;
		});
});

