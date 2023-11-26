import {
	auth,
	signInWithEmailAndPassword,

} from "/SOCIALMEDIA/templates/firebase/firebase.js";

console.log(auth);
const emailInput = document.getElementById("form__email");
const passwordInput = document.getElementById("form__pass");
const loginButton = document.querySelector(".login-button");

/*onAuthStateChanged(auth, (user) => {
  if (user) {
	// User is signed in, see docs for a list of available properties
	// https://firebase.google.com/docs/reference/js/auth.user
	const uid = user.uid;
	console.log("uid current user: " + uid);
	// ...
  } else {
	// User is signed out
	console.log("No one here");
  }
});*/

loginButton.addEventListener("click", () => {
	const email = emailInput.value;
	const password = passwordInput.value;
	signInWithEmailAndPassword(auth, email, password)
		.then((userCredential) => {
			const user = userCredential.user;
			return user.getIdToken();
		})
		.then((tokenId) => {
			// Gửi tokenId về server
			console.log(tokenId);

			return fetch("dangnhap", {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(tokenId),
			});
		})
		.then((response) => {
			if (response.ok) {
				window.location.href = "home";
			} else {
				// xử lí trường hợp khi đăng nhập thất bại
			}
		})
		.catch((error) => {
			// Xử lý lỗi khi gửi tokenId về server
			console.error("Error sending token to server:", error);
		});
});
