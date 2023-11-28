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

/*loginButton.addEventListener("click", () => {
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
*/

loginButton.addEventListener("click", () => {
	const email = emailInput.value;
	const password = passwordInput.value;
	signInWithEmailAndPassword(auth, email, password)
		.then((userCredential) => {
			return userCredential.user.getIdToken();
		})
		.then((tokenId) => {
			// Gửi tokenId về server
			console.log(tokenId);

			// Thêm token vào header Authorization
			const headers = {
				"Content-Type": "application/json",
				Authorization: `Bearer ${tokenId}`, // Thêm token vào header Authorization
			};

			// Gửi yêu cầu đến server với token trong header
			return fetch("dangnhap", {
				method: "POST",
				headers: headers,
				// Không cần gửi token qua phần thân của yêu cầu
			});
		})
		.then((response) => {
			if (response.ok) {
				// Xác thực thành công, chuyển hướng đến trang home
				window.location.href = "home"; // Thay đổi URL thành trang home của bạn
			} else {
				// Xác thực thất bại, yêu cầu đăng nhập lại
				alert("Authentication failed. Please login again.");
				// Hoặc bạn có thể thực hiện các hành động khác để yêu cầu đăng nhập lại
			}
		})
		.catch((error) => {
			// Xử lý lỗi khi gửi tokenId về server
			console.error("Error sending token to server:", error);
		});
});