// Import the functions you need from the SDKs you need
import { initializeApp } from "https://www.gstatic.com/firebasejs/10.4.0/firebase-app.js";
import {
  getDatabase,
  ref,
  set,
  onValue,
  push,
  get,
  child,
} from "https://www.gstatic.com/firebasejs/10.4.0/firebase-database.js";

import {
  getAuth,
  signOut,
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
// Initialize Realtime Database and get a reference to the service
const database = getDatabase(app);

const auth = getAuth(app);

export { app };

const MessSubmit = document.querySelectorAll(".comment-submit");
const MessInput = document.querySelector(".comment-input");
const username = document.querySelector(".user-name");
const userid = document.querySelector(".user-id");
const curUser = {
  username: null,
  uid: null,
};
onAuthStateChanged(auth, (user) => {
  if (user) {
    // User is signed in, see docs for a list of available properties
    // https://firebase.google.com/docs/reference/js/auth.user
    curUser.uid = user.uid;
    console.log("uid current user: " + curUser.uid);
    // ...
  } else {
    // User is signed out
    console.log("No one here");
    // ...
  }
});
MessSubmit.forEach(function (mess) {
  updateComment(mess.closest(".post").dataset.postId, mess);
  mess.addEventListener("submit", function (e) {
    e.preventDefault();
    const postId = this.closest(".post").dataset.postId; // Đặt postID tùy theo bài viết bạn muốn thêm comment vào
    //console.log(this.closest(".post"));
    console.log("post id : " + postId);
    const mess = this.closest(".post").querySelector(".comment-input").value;
    // Kiểm tra nếu tin nhắn không trống
    if (mess.trim() !== "") {
      console.log("Tiến hành ghi lên firebase");
      const newCommentRef = push(ref(database, `posts/${postId}/comments`)); // Tạo một reference mới cho comment
      const newComment = {
        text: mess,
        user_id: userid.textContent,
        user_name: this.dataset.postUsername,
      };
      set(newCommentRef, newComment)
        .then(() => {
          console.log("Comment written successfully!");
          MessInput.value = ""; // Xóa nội dung khung nhập liệu sau khi gửi
        })
        .catch((error) => {
          console.error("Error writing comment: ", error);
        });

      // let html = `<div class=\"comment-item\"><strong>Comment:</strong> ${MessInput.value}</div> </div>`;
      // const commentList = document.querySelector(".comment-list");
      // commentList.insertAdjacentHTML("afterend", html);
      // Đăng ký sự kiện onValue để lắng nghe sự thay đổi trong node "comments"
      // --> sự kiện load comment
    }
  });
});

// Cập nhật Commnet khi có ai đó comment --( postID, that -- là element con trong post )
function updateComment(postID, that) {
  onValue(ref(database, `posts/${postID}/comments`), (snapshot) => {
    const renderMess = function (commentsData) {
      console.log("Tiến hành onvalue");
      that.closest(".post").querySelector(".comment-list").innerHTML = "";
      console.log(that.closest(".post").querySelector(".comment-list"));

      for (const commentKey in commentsData) {
        const { text, user_id, user_name } = commentsData[commentKey];
        let html = `<div class=\"comment-item\"><strong>${user_name} :</strong> ${text}</div> </div>`;
        const commentList = that
          .closest(".post")
          .querySelector(".comment-list");
        commentList.insertAdjacentHTML("beforeend", html);
      }
    };
    // Lấy dữ liệu từ snapshot sử dụng .val()
    const commentsData = snapshot.val();
    // Kiểm tra và xử lý dữ liệu tại đây
    // Ví dụ: duyệt qua các comment và render lại giao diện
    renderMess(commentsData);
  });
}

// load comment lúc mới vào

function LoadData(post_id, listComment) {
  const dbRef = ref(database);
  get(child(dbRef, `posts/${post_id}/comments`))
    .then((snapshot) => {
      if (snapshot.exists()) {
        console.log("Snap shot exist");
        const commentsData = snapshot.val();
        listComment.innerHTML = "";
        for (const commentKey in commentsData) {
          const { text, user_id, user_name } = commentsData[commentKey];
          let html = `<div class=\"comment-item\"><strong>${user_name}:</strong> ${text}</div> </div>`;
          listComment.insertAdjacentHTML("beforeend", html);
        }
      } else {
        console.log("No data available");
      }
    })
    .catch((error) => {
      console.error(error);
    });
}
const btnComment = document.querySelectorAll(".btn-comment");
btnComment.forEach(function (btn) {
  btn.addEventListener("click", function (e) {
    e.preventDefault();
    const comment = this.closest(`.post`).querySelector(".comment");
    comment.classList.toggle("hidden");
    // load data comment
    const post_id = this.closest(".post").dataset.postId;
    console.log("BTN COMMENT _ POST ID: " + post_id);
    const listComment = this.closest(".post").querySelector(".comment-list");
    LoadData(post_id, listComment);
  });
});
