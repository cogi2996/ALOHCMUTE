/*import {
	storage,
	ref,
	uploadBytesResumable,
	getDownloadURL,
	onAuthStateChanged,
	auth,
	getAuth
} from "/SOCIALMEDIA/templates/firebase/firebase.js";*/

import { uploadImage } from "/SOCIALMEDIA/templates/user/script/uploadFile.js";
const preview = document.querySelector(".img-account-profile");
const inputImage = document.getElementById("image");
inputImage.addEventListener("change", function(event) {
	const file = event.target.files[0];
	if (file) {
		const reader = new FileReader();

		reader.onload = function(e) {
			preview.src = e.target.result;
		};

		reader.readAsDataURL(file);
	}
});

document
	.getElementById("updateForm")
	.addEventListener("submit", function(event) {
		event.preventDefault(); // Ngăn chặn hành động mặc định của form
		// Tạo một đối tượng FormData từ form
		const formData = new FormData(this);
		console.log(this);
		console.log("here" + formData.firstName);

		if (!inputImage.files[0]) {
			formData.append("avatar", preview.src);
			// console.log(inputImage.src);

			var object = {};
			formData.forEach((value, key) => (object[key] = value));
			var json = JSON.stringify(object);
			// Gửi dữ liệu bằng fetch
			fetch("/SOCIALMEDIA/api/v1/user", {
				method: "PUT",
				body: json,
			})
				.then((response) => {
					return response.json();
				})
				.then((data) => {
					window.location.href = `/SOCIALMEDIA/profile?userID=${data}`;
				})
				.catch((error) => {
					// Xử lí lỗi (nếu có)
					console.error("Error:", error);
				});
		} else {
			uploadImage(inputImage.files[0])
				.then((data) => {
					formData.append("avatar", data);
					for (const [key, value] of formData) {
						console.log(`${key}: ${value}\n`);
					}
				})
				.then(() => {
					var object = {};
					formData.forEach((value, key) => (object[key] = value));
					var json = JSON.stringify(object);
					// Gửi dữ liệu bằng fetch
					fetch("/SOCIALMEDIA/api/v1/user", {
						method: "PUT",
						body: json,
					})
						.then((response) => {
							return response.json();
						})
						.then((data) => {
							window.location.href = `/SOCIALMEDIA/profile?userID=${data}`;
						})
						.catch((error) => {
							// Xử lí lỗi (nếu có)
							console.error("Error:", error);
						});
				});
		}
		//.files[0]
	});
