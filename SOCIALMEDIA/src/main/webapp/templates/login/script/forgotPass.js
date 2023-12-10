/*import { getAuth, sendPasswordResetEmail } from "firebase/auth";*/
import {
  getAuth,
  sendPasswordResetEmail,
} from "/SOCIALMEDIA/templates/firebase/firebase.js";
// JavaScript
// JavaScript
document.querySelector(".btn-primary").addEventListener("click", function (e) {
  const auth = getAuth();
  const email = document.getElementById("email").value;
  e.preventDefault();

  sendPasswordResetEmail(auth, email)
    .then(() => {
      document.getElementById("successMessage").style.display = "block"; // Hiển thị thông báo thành công
      document.getElementById("errorMessage").style.display = "none"; // Ẩn thông báo lỗi
      setTimeout(() => {
        window.location.href = "dangnhap";
      }, 1200);
    })
    .catch((error) => {
      document.getElementById("successMessage").style.display = "none"; // Ẩn thông báo thành công
      document.getElementById("errorMessage").style.display = "block"; // Hiển thị thông báo lỗi
    });
});
