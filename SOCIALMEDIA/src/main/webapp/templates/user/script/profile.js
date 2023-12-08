// có cái auth để biết thông tin hiện tại của user
import { db, auth, onAuthStateChanged } from "/SOCIALMEDIA/templates/firebase/firebase.js";


const urlParams = new URLSearchParams(window.location.search);
const userID = urlParams.get("userID");
console.log(userID);
// lấy ra uid của user từ user credental
let currentUser = null;
onAuthStateChanged(auth, (user) => {
  if (user) {
    currentUser = user;
    console.log("uid current user1: " + user.uid);
  } else {
    // User is signed out
    currentUser = null;
    console.log("No one here");
  }
});
getInfoUser(userID);
// fetch lấy thông tin cá nhân của user
function getInfoUser(user) {
  fetch(`/SOCIALMEDIA/api/v1/informationUser?userID=${userID} `, {
    method: "GET",
    headers: { "Content-Type": "application/json" },
  }).then((data) => {
    console.log(data);
  });
}
// hiển thị thông tin cá nhân của user
