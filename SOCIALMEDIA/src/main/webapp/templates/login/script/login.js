import {
  app,
  auth,
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  onAuthStateChanged,
} from "/SOCIALMEDIA/templates/firebase/firebase.js";

const emailInput = document.getElementById("form__email");
const passwordInput = document.getElementById("form__pass");
const loginButton = document.querySelector(".login-button");
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
      // messageDiv.textContent = "Đăng nhập thành công!";
      console.log("Đăng nhập thành công");

      // fetch("http://localhost:8080/POST/xulidangnhap", {
      //   method: "POST",
      //   headers: {
      //     "Content-Type": "application/json",
      //   },
      //   body: JSON.stringify(loginData),
      // }).then(() => {
      //   window.location.href = "http://localhost:8080/POST/dangnhapthanhcong";
      // });
    })
    .then(() => {
      const user = auth.currentUser;
      if (user) {
        console.log(user.email);
      } else {
        console.log("No one log in");
      }
    })
    .catch((error) => {
      const errorMessage = error.message;
      console.log(errorMessage);

      // console.error("Lỗi đăng nhập:", errorMessage);
      // messageDiv.textContent = "Lỗi đăng nhập: " + errorMessage;
    });
});
